package ir.mebank.loan.core.module

import okhttp3.*
import java.io.IOException
import java.util.concurrent.TimeUnit

class Endpoint {
  lateinit var url: String
  var timeout: Long = 5_000

  var success: (Call, Response, String?) -> Unit = { call, response, content -> }
  var fail: (Call, IOException) -> Unit = { call, e -> }
}


class Webservice<T : Any>(var endpoint: Endpoint, var resource: String, var output: Class<out T>) {
  var success: (Call, Response, String?, T?) -> Unit = { call, response, content, entity -> }
  var fail: (Call, IOException) -> Unit = { call, e -> }

  inner class Requester {
    var data: Any? = null
    var success: (Call, Response, String?, T?) -> Unit = { call, response, content, entity -> }
    var fail: (Call, IOException) -> Unit = { call, e -> }

    fun run(): Call {
      val client = initializeClient()
      val post = preparePostData(data)
      val request = Request.Builder()
        .url(endpoint.url + resource)
        .post(post)
        .build()

      val call = client.newCall(request)
      processResponse(call)
      return call
    }


    private fun initializeClient(): OkHttpClient {
      val client = OkHttpClient.Builder().apply {
        connectTimeout(endpoint.timeout, TimeUnit.MILLISECONDS)
        writeTimeout(endpoint.timeout, TimeUnit.MILLISECONDS)
        readTimeout(endpoint.timeout, TimeUnit.MILLISECONDS)
      }.build()

      return client
    }


    private fun preparePostData(data: Any?): FormBody {
      val builder = FormBody.Builder()
      if (data != null) {
        val inputJson = Json.toMap(data)

        val it = inputJson.entries.iterator()
        while (it.hasNext()) {
          val pair = it.next() as Map.Entry<String, *>
          builder.add(pair.key, pair.value.toString())
        }
      }

      return builder.build()
    }

    private fun processResponse(call: Call) {
      call.enqueue(object : Callback {
        override fun onResponse(call: Call, response: Response) {
          val content = response.body?.string()

          var result: T? = null
          if (content != null) {
            result = Json.fromJson(content, output)
          }

          runOnUi {
            endpoint.success(call, response, content)
            this@Webservice.success(call, response, content, result)
            success(call, response, content, result)
          }
        }

        override fun onFailure(call: Call, e: IOException) {
          runOnUi {
            endpoint.fail(call, e)
            this@Webservice.fail(call, e)
            fail(call, e)
          }
        }
      })
    }
  }


  fun request(props: MethodBlock<Requester> = {}): Call {
    return Requester().apply(props).run()
  }
}