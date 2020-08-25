package com.murilops.kotlin.blu.logic

import com.murilops.kotlin.blu.services.saveToCsv

class AccountMathOperations {
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

        for (account in accounts.indices) {
            val accountBonus = bonusToApply(accounts[account])

            val (bonusDepositCalcAccount, depositCalcAccount) =
                    calculateDeposit(accounts[account].deposit, accountBonus)

            val accountTotalCash = makeDeposit(bonusDepositCalcAccount, depositCalcAccount)

            // ----------------------------------------------------------//

            bonusList.add(bonusDepositCalcAccount)
            depositList.add(depositCalcAccount)
            finalDepositsList.add(accountTotalCash)
        }

        saveToCsv(accounts, bonusList, depositList, finalDepositsList)
    }
}
