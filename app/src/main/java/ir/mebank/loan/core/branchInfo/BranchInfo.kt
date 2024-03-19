package ir.mebank.loan.core.branchInfo

class BranchInfo {

    data class  Branches(
        val message :Array<BranchsInfo>
    )

    data class BranchsInfo(
        val id : String,
        val fr_name : String,
        val ciry_id : String
    )
}