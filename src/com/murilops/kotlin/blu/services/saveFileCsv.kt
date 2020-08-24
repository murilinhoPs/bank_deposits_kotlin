package com.murilops.kotlin.blu.services

import com.murilops.kotlin.blu.models.AccountModel
import java.io.FileWriter

private const val CSV_HEADER = "Conta,Depósitos,Total de Bônus,Valor Final"

fun saveToCsv(accounts: ArrayList<AccountModel>, bonusCalc: Double, depositCalc: Double, accountTotal: Double) {
    var fileWriter: FileWriter? = null

    try {
        fileWriter = FileWriter("extrato.csv")

        fileWriter.append(CSV_HEADER)
        fileWriter.append('\n')

        for (account in accounts) {
            fileWriter.append(account.accountId)
            fileWriter.append(',')
            fileWriter.append(depositCalc.toString())
            fileWriter.append(',')
            fileWriter.append(depositCalc.toString())
            fileWriter.append(',')
            fileWriter.append(accountTotal.toString())
            fileWriter.append('\n')
        }

        println("Write CSV successfully!")

        fileWriter.close()

    } catch (e: Exception) {

        println("Writing CSV error!")

        e.printStackTrace()
    }
}