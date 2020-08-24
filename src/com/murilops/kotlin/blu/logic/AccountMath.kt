package com.murilops.kotlin.blu.logic

import com.murilops.kotlin.blu.models.AccountModel

class AccountMath {

    var account1 = AccountModel("1234-3", 0.0, arrayOf<Double>(50.0, 35.0))
    var account2 = AccountModel("1235-6", 0.0, arrayOf<Double>(100.0))
    var account3 = AccountModel("1236-0", 0.0, arrayOf<Double>(120.0))

    fun calculateAccountOperations() {

        //region Account-1
        val account1Bonus = bonusToApply(account1)
        val (bonusCalcAccount1, depositCalcAccount1) =
                calculateDeposit(account1.deposit, account1Bonus)
        //----------------------------------------------------------//
        makeDeposit(bonusCalcAccount1, depositCalcAccount1)
        //endregion

        //region Account-2
        val account2Bonus = bonusToApply(account2)
        val (bonusCalcAccount2, depositCalcAccount2) =
                calculateDeposit(account2.deposit, account1Bonus)
        //----------------------------------------------------------//
        makeDeposit(bonusCalcAccount2, depositCalcAccount2)
        //endregion

        //region Account-3
        val account3Bonus = bonusToApply(account3)
        val (bonusCalcAccount3, depositCalcAccount3) =
                calculateDeposit(account3.deposit, account3Bonus)
        //----------------------------------------------------------//
        makeDeposit(bonusCalcAccount3, depositCalcAccount3)
        //endregion

    }
}