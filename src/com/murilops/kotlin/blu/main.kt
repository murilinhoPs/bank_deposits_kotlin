package com.murilops.kotlin.blu

import com.murilops.kotlin.blu.logic.AccountMath
import com.murilops.kotlin.blu.services.readFromCsv


fun main(){
    var accountMath = AccountMath()

    readFromCsv()
    accountMath.makeAccountOperations()
}

