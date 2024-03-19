package ir.mebank.loan.core.module.adapter

import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.jetbrains.anko.AnkoContext
import ir.mebank.loan.core.publicFun.Property
import ir.mebank.loan.core.publicFun.RecyPropertyUI

class AdapterRecyclerProperty(var list: ArrayList<Property>) : RecyclerView.Adapter<AdapterRecyclerProperty.PropertyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PropertyViewHolder {
        return PropertyViewHolder(RecyPropertyUI().createView(AnkoContext.create(parent.context, parent)))
    }

    override fun onBindViewHolder(holder: PropertyViewHolder, position: Int) {
        val item = list[position]

        holder.loan_row.text = item.loan_row.toString() + ""
        holder.type_asset.text = item.type_asset
        holder.description.text = item.description
        holder.approximate_value.text = item.approximate_value.toString() + ""
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class PropertyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var loan_row: TextView
        var type_asset: TextView
        var description: TextView
        var approximate_value: TextView

        init {
            loan_row = itemView.findViewById(RecyPropertyUI.loan_row)
            type_asset = itemView.findViewById(RecyPropertyUI.type_asset)
            description = itemView.findViewById(RecyPropertyUI.description)
            approximate_value = itemView.findViewById(RecyPropertyUI.approximate_value)
        }
    }
}