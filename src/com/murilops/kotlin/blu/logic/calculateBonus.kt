package com.murilops.kotlin.blu.logic

import com.murilops.kotlin.blu.models.AccountModel

private var bonusValues = arrayOf<Double>(0.1, 0.05, 0.01)


public fun bonusToApply(model: AccountModel): Double {
    var bonus = 0.0

    var lastIdChar = model.id.last()

    if (lastIdChar in '1'..'3') {
        bonus = bonusValues[0]
    }
    if (lastIdChar in '4'..'8') {
        bonus = bonusValues[1]
    }
    if (lastIdChar == '0') {
        bonus = bonusValues[2]
    }

    println("Valor bonus ${(bonus * 100).toInt()}%")
    return bonus
}