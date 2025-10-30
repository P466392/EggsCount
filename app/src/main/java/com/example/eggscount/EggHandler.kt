package com.example.eggscount

class EggHandler {

    fun calculateEggs(totalEggs: Int): EggResult{
        val gross = totalEggs / 144
        val remainderAfterGross = totalEggs % 144
        val dozens = remainderAfterGross / 12
        val eggs = remainderAfterGross % 12

        return EggResult(gross, dozens, eggs)
    }

    data class EggResult(val gross: Int, val dozens: Int, val eggs: Int)
}