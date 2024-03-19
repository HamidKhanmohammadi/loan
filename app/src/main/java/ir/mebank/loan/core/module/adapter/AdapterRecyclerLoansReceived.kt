package ir.mebank.loan.core.module.adapter

import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.jetbrains.anko.AnkoContext
import ir.mebank.loan.core.publicFun.LoanReceived
import ir.mebank.loan.core.publicFun.RecyLoanReceivedUI

class AdapterRecyclerLoansReceived(var list: ArrayList<LoanReceived>) : RecyclerView.Adapter<AdapterRecyclerLoansReceived.LoansReceivedViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LoansReceivedViewHolder {
        return LoansReceivedViewHolder(RecyLoanReceivedUI().createView(AnkoContext.create(parent.context, parent)))
    }

    override fun onBindViewHolder(holder: LoansReceivedViewHolder, position: Int) {
        val item = list[position]

        holder.loan_row.text = item.loan_row.toString() + ""
        holder.bank_name.text = item.bank_name
        holder.loan_amount.text = item.loan_amount.toString() + ""
        holder.installments_number.text = item.installments_number.toString() + ""
        holder.remaining_amount.text = item.remaining_amount.toString() + ""
        holder.obtaining_loan_date.text = item.obtaining_loan_date.toString() + ""
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class LoansReceivedViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var loan_row: TextView
        var bank_name: TextView
        var loan_amount: TextView
        var installments_number: TextView
        var remaining_amount: TextView
        var obtaining_loan_date: TextView

        init {
            loan_row = itemView.findViewById(RecyLoanReceivedUI.loan_row)
            bank_name = itemView.findViewById(RecyLoanReceivedUI.bank_name)
            loan_amount = itemView.findViewById(RecyLoanReceivedUI.loan_amount)
            installments_number = itemView.findViewById(RecyLoanReceivedUI.installments_number)
            remaining_amount = itemView.findViewById(RecyLoanReceivedUI.remaining_amount)
            obtaining_loan_date = itemView.findViewById(RecyLoanReceivedUI.obtaining_loan_date)
        }
    }
}