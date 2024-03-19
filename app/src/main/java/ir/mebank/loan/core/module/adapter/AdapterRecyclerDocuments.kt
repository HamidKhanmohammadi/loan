package ir.mebank.loan.core.module.adapter

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.jetbrains.anko.AnkoContext
import ir.mebank.loan.core.module.AssetImageReader
import ir.mebank.loan.core.publicFun.Documents
import ir.mebank.loan.core.publicFun.RecyDocumentsUI

class AdapterRecyclerDocuments(var list: ArrayList<Documents>) : RecyclerView.Adapter<AdapterRecyclerDocuments.DocumentsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DocumentsViewHolder {
        return DocumentsViewHolder(RecyDocumentsUI().createView(AnkoContext.create(parent.context, parent)))
    }

    override fun onBindViewHolder(holder: DocumentsViewHolder, position: Int) {
        val item = list[position]

        val image = AssetImageReader.getImage("male/male_" + item.loan_doc_id + ".jpg")
        holder.loan_doc.setImageDrawable(image)
        holder.pic_name.text = item.pic_name
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class DocumentsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var loan_doc: ImageView
        var pic_name: TextView

        init {
            loan_doc = itemView.findViewById(RecyDocumentsUI.loan_doc)
            pic_name = itemView.findViewById(RecyDocumentsUI.pic_name)
        }
    }
}