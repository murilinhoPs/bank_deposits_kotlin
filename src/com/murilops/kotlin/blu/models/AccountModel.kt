package com.murilops.kotlin.blu.models

class AccountModel {
    var accountId: String = " "
    var cash: Double = 0.0
    var deposit = arrayOf<Double>(0.0)

    constructor(accountId: String, cash: Double, deposit: Array<Double>) {
        this.accountId = accountId
        this.cash = cash
        this.deposit = deposit
    }

    override fun toString(): String {
        var depositValues: String? = null
        deposit.forEach { depositValues = it.toString() }

        return "[accountId= $accountId cash= $cash + deposit= $depositValues ]"
    }
}