package com.murilops.kotlin.blu.services

import com.murilops.kotlin.blu.models.AccountModel
import java.io.FileWriter

private const val CSV_HEADER = "Conta,Depósitos,Total de Bônus,Valor Final"

fun saveToCsv(accounts: ArrayList<AccountModel>, bonusCalc: ArrayList<Double>, depositCalc: ArrayList<Double>,
              accountTotal: ArrayList<Double>) {
    var fileWriter: FileWriter? = null

    try {
        fileWriter = FileWriter("extrato.csv")

        fileWriter.append(CSV_HEADER)
        fileWriter.append('\n')

        for (index in accounts.indices) {
            fileWriter.append(accounts[index].accountId)
            fileWriter.append(',')
            fileWriter.append(depositCalc[index].toString())
            fileWriter.append(',')
            fileWriter.append(bonusCalc[index].toString())
            fileWriter.append(',')
            fileWriter.append(accountTotal[index].toString())
            fileWriter.append('\n')
        }

        println("Write CSV successfully!")

        fileWriter.close()

    } catch (e: Exception) {

        println("Writing CSV error!")

        e.printStackTrace()
    }
}