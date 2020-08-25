package com.murilops.kotlin.blu.logic

import com.murilops.kotlin.blu.models.AccountModel
import java.util.ArrayList

var finalAccountsList = ArrayList<AccountModel>()

fun csvToModel(accountsFromCsv: ArrayList<AccountModel>) {
    var resultList = ArrayList<AccountModel>()

    for (account in accountsFromCsv) {
        finalAccountsList.add(account)

        var filteredListByAccountId = accountsFromCsv.filter { it.accountId.contains(account.accountId) }

        // it means that there is a same element with same accountId
        if (filteredListByAccountId.size >= 2) {
            resultList = ArrayList(filteredListByAccountId)

            finalAccountsList.removeAll(filteredListByAccountId)
        }
    }

    var sumFromDepositValues = 0.0
    var maintainAccountId = ""

    for (list in resultList) {

        var depositValues: Double = 0.0
        list.deposit.forEach { depositValues = it }

        sumFromDepositValues += depositValues
        maintainAccountId = list.accountId
    }
    println("$sumFromDepositValues e $maintainAccountId")

    finalAccountsList.add(0, AccountModel(maintainAccountId, 0.0, arrayOf(sumFromDepositValues)))
}
