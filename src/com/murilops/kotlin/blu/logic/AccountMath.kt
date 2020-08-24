package com.murilops.kotlin.blu.logic

import com.murilops.kotlin.blu.models.AccountModel
import com.murilops.kotlin.blu.services.saveToCsv


class AccountMath {
/*    private var accounts = arrayListOf(
            AccountModel("1234-3", 0.0, arrayOf(50.0, 35.0)),
            AccountModel("1235-6", 0.0, arrayOf(100.0)),
            AccountModel("1236-0", 0.0, arrayOf(120.0))
    )*/

    private var accounts = finalAccountsList

    fun makeAccountOperations() {
        var bonusList = ArrayList<Double>()
        var depositList = ArrayList<Double>()
        var finalDepositsList = ArrayList<Double>()


        for (account in  accounts.indices) {
            val accountBonus = bonusToApply(accounts[account])
            val (bonusCalcAccount, depositCalcAccount) =
                    calculateDeposit(accounts[account].deposit, accountBonus)

            //----------------------------------------------------------//

            val accountTotal = makeDeposit(bonusCalcAccount, depositCalcAccount)

            bonusList.add(bonusCalcAccount)
            depositList.add(depositCalcAccount)
            finalDepositsList.add(accountTotal)
        }
        saveToCsv(accounts, bonusList, depositList, finalDepositsList)
    }
}