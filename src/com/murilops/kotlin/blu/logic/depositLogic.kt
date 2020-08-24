package com.murilops.kotlin.blu.logic

fun calculateDeposit(deposits: Array<Double>, bonus: Double): Pair<Double, Double> {
    var bonusCalc = 0.0
    var depositCalc = 0.0

    for (deposit in deposits.indices) {

        bonusCalc += deposits[deposit] * bonus

        depositCalc += deposits[deposit]
    }

    println("new Calc: $bonusCalc && new Deposit: $depositCalc")

    return Pair(bonusCalc, depositCalc)
}

fun makeDeposit(bonusCalc: Double, depositCalc: Double): Double {
    var finalDeposit = depositCalc + bonusCalc

    println("Final deposit: $finalDeposit")

    return finalDeposit
}