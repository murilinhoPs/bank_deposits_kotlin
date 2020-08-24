package com.murilops.kotlin.blu.models

class AccountModel  {
    var id:String = " "
    var cash:Double = 0.0
    var deposit = arrayOf<Double>(0.0)
    var bonus = "First property bonus"

    constructor(accountId: String, cash: Double, deposit: Array<Double>) {
        this.id = accountId
        this.cash = cash
        this.deposit = deposit
    }
}