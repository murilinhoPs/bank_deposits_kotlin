package com.murilops.kotlin.blu

import com.murilops.kotlin.blu.logic.AccountMathOperations
import com.murilops.kotlin.blu.services.readFromCsv

fun main() {
    var accountMath = AccountMathOperations()

    readFromCsv()
    accountMath.makeAccountOperations()
}
