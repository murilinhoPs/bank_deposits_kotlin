package com.murilops.kotlin.blu.logic

import com.murilops.kotlin.blu.models.AccountModel
import com.murilops.kotlin.blu.services.saveToCsv

class AccountMath {
    private var accounts = arrayListOf(
            AccountModel("1234-3", 0.0, arrayOf(50.0, 35.0)),
            AccountModel("1235-6", 0.0, arrayOf(100.0)),
            AccountModel("1236-0", 0.0, arrayOf(120.0))
    )


    fun makeAccountOperations() {
        for (account in accounts.indices) {
            val accountBonus = bonusToApply(accounts[account])
            val (bonusCalcAccount, depositCalcAccount) =
                    calculateDeposit(accounts[account].deposit, accountBonus)

            //----------------------------------------------------------//

            val accountTotal = makeDeposit(bonusCalcAccount, depositCalcAccount)

            saveToCsv(accounts, bonusCalcAccount, depositCalcAccount, accountTotal)
        }

    }
}