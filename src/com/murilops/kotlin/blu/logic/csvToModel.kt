package com.murilops.kotlin.blu.logic

import com.murilops.kotlin.blu.models.AccountModel
import java.util.ArrayList

var finalAccountsList = ArrayList<AccountModel>()

fun csvToModel(accountsFromCsv: ArrayList<AccountModel>){
    var resultList = ArrayList<AccountModel>()

    for (account in accountsFromCsv) {
        finalAccountsList.add(account)

        //filter by equals accountIds
        var filteredList = accountsFromCsv.filter { it.accountId.contains(account.accountId) }

        // if filteredList.size >= 2, then it means that there is a same element with same accountId
        if(filteredList.size >= 2) {
            resultList = ArrayList(filteredList)
            finalAccountsList.removeAll(filteredList)
        }
    }

    var soma = 0.0
    var newAccountId = ""

    for(list in resultList){

        var depositValues: Double = 0.0
        list.deposit.forEach { depositValues = it }

        soma += depositValues
        newAccountId = list.accountId
    }
    println("$soma e $newAccountId")

    finalAccountsList.add(0, AccountModel(newAccountId, 0.0, arrayOf(soma)))
}