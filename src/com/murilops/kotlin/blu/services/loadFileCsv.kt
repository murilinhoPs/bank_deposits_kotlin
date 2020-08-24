package com.murilops.kotlin.blu.services

import com.murilops.kotlin.blu.models.AccountModel
import java.io.BufferedReader
import java.io.FileReader
import java.util.ArrayList

private val CONTA = 0
private val VALOR = 1

val accountsFromCsv = ArrayList<AccountModel>()
var finalAccountsFromCsv = ArrayList<AccountModel>()

fun readFromCsv() {
    var fileReader: BufferedReader? = null

    try {
        var line: String?

        fileReader = BufferedReader(FileReader("infos.csv"))

        // Read CSV header
        fileReader.readLine()

        // Read the file line by line starting from the second line
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

        val resultList =  accountsFromCsv.distinctBy(AccountModel::accountId)


        // Print the new customer list
        for (account in accountsFromCsv) {
            println(account.accountId + " " + account.deposit[0])

            finalAccountsFromCsv.add(account)
            finalAccountsFromCsv.distinctBy(AccountModel::accountId)

            //var teste2 = accountsFromCsv.filter { it.accountId.contains(account.accountId) }
                    //.forEach {
                //println(it.accountId)
            //}
        }
    } catch (e: Exception) {
        println("Reading CSV Error!")
        e.printStackTrace()
    }
}