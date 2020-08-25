package com.murilops.kotlin.blu.services

import com.murilops.kotlin.blu.logic.csvToModel
import com.murilops.kotlin.blu.models.AccountModel
import java.io.BufferedReader
import java.io.FileReader
import java.util.ArrayList

private val CONTA = 0
private val VALOR = 1

fun readFromCsv() {
    var fileReader: BufferedReader? = null
    var accountsFromCsv = ArrayList<AccountModel>()

    try {
        var line: String?

        println("Digite o caminho do arquivo para leitura. Absolute path ou Complete path")
        var path = readLine()

        fileReader = BufferedReader(FileReader(path))
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

        csvToModel(accountsFromCsv)
    } catch (e: Exception) {
        println("Reading CSV Error!")
        e.printStackTrace()
    }
}
