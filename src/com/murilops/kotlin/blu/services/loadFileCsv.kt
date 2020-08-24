package com.murilops.kotlin.blu.services

import com.murilops.kotlin.blu.models.AccountModel
import java.io.BufferedReader
import java.io.FileReader
import java.util.ArrayList

private val CONTA = 0
private val VALOR = 1

var accountsFromCsv = ArrayList<AccountModel>()
var finalAccountsFromCsv = ArrayList<AccountModel>()

fun readFromCsv() {
    var fileReader: BufferedReader? = null
    var resultList = ArrayList<AccountModel>()


    try {
        var line: String?

        fileReader = BufferedReader(FileReader("infos.csv"))

        fileReader.readLine()

        line = fileReader.readLine()
        while (line != null) {
            val tokens = line.split(",")
            if (tokens.isNotEmpty()) {

                val account = AccountModel(
                        tokens[CONTA], 0.0, arrayOf((tokens[VALOR]).toDouble()))

                accountsFromCsv.add(account)
            }
            line = fileReader.readLine()
        }


        for (account in accountsFromCsv) {
            println(account.accountId + " " + account.deposit[0])

            finalAccountsFromCsv.add(account)

            var filteredList = accountsFromCsv.filter { it.accountId == account.accountId }

            // Se tiver mais que 2 elementos, quer dizer que tem um com o mesmo accountId
            if(filteredList.size >= 2) {
                resultList = ArrayList(filteredList)
                finalAccountsFromCsv.removeAll(filteredList)
            }
        }

        var soma = 0.0
        var newAccountId = ""

        for(list in resultList){

            var depositValues: Double = 0.0
            list.deposit.forEach { depositValues = it }

            soma += depositValues // soma os valores depositados
            newAccountId = list.accountId // pega o id
        }
        println("$soma e $newAccountId")

        finalAccountsFromCsv.add(0, AccountModel(newAccountId, 0.0, arrayOf(soma)))

    } catch (e: Exception) {
        println("Reading CSV Error!")
        e.printStackTrace()
    }
}