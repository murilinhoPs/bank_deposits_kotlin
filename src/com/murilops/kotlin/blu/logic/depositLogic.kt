package com.murilops.kotlin.blu.logic

fun calculateDeposit(deposits: Array<Double>, bonus: Double): Pair<Double, Double> {
    var bonusDepositCalc = 0.0
    var depositCalc = 0.0

    for (deposit in deposits.indices) {

        bonusDepositCalc += deposits[deposit] * bonus

        depositCalc += deposits[deposit]
    }

    println("new Calc: $bonusDepositCalc && new Deposit: $depositCalc")

    return Pair(bonusDepositCalc, depositCalc)
}

fun makeDeposit(bonusCalc: Double, depositCalc: Double): Double {
    var finalDeposit = depositCalc + bonusCalc

    println("Final deposit: $finalDeposit")

    return finalDeposit
}
