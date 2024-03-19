package ir.mebank.loan.core.module.adapter

import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.jetbrains.anko.AnkoContext
import ir.mebank.loan.core.publicFun.BankDeposit
import ir.mebank.loan.core.publicFun.RecyBankDepositUI

class AdapterRecyclerBankDeposits(var list: ArrayList<BankDeposit>) :
    RecyclerView.Adapter<AdapterRecyclerBankDeposits.BankDepositsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BankDepositsViewHolder {
        return BankDepositsViewHolder(RecyBankDepositUI().createView(AnkoContext.create(parent.context, parent)))
    }

    override fun onBindViewHolder(holder: BankDepositsViewHolder, position: Int) {
        val item = list[position]

        holder.loan_row.text = item.loan_row.toString() + ""
        holder.bank_name.text = item.bank_name
        holder.account_number.text = item.account_number.toString() + ""
        holder.opening_date.text = item.opening_date.toString() + ""
        holder.creditor_turnover.text = item.creditor_turnover.toString() + ""
        holder.six_month_average.text = item.six_month_average.toString() + ""
        holder.current_balance.text = item.current_balance.toString() + ""
        holder.number_checks_returned.text = item.number_checks_returned.toString() + ""
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class BankDepositsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var loan_row: TextView
        var bank_name: TextView
        var account_number: TextView
        var opening_date: TextView
        var creditor_turnover: TextView
        var six_month_average: TextView
        var current_balance: TextView
        var number_checks_returned: TextView

        init {
            loan_row = itemView.findViewById(RecyBankDepositUI.loan_row)
            bank_name = itemView.findViewById(RecyBankDepositUI.bank_name)
            account_number = itemView.findViewById(RecyBankDepositUI.account_number)
            opening_date = itemView.findViewById(RecyBankDepositUI.opening_date)
            creditor_turnover = itemView.findViewById(RecyBankDepositUI.creditor_turnover)
            six_month_average = itemView.findViewById(RecyBankDepositUI.six_month_average)
            current_balance = itemView.findViewById(RecyBankDepositUI.current_balance)
            number_checks_returned = itemView.findViewById(RecyBankDepositUI.number_checks_returned)
        }
    }
}