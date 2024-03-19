package ir.mebank.loan.core.module

class ProfileResponse {

  data class Response(
    var status: Int,
    var message: String,
    var feeds: Feeds,
    var debugInfo: String
  )

  data class Feeds(
    var profiles: Array<Profiles>
  )

  data class Profiles(
    var firstname: String,
    var lastname: String,
    var gender: String,
    var email: String,
    var imageUrl: String,
    var phone: String
  )
}