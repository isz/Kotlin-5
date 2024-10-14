package ru.otus.cars

sealed class TankMouth {
    abstract val fuelReceiver: FuelReceiver
    private var opened: Boolean = false
    abstract val tankType: String

    fun open() {
        opened = true
    }

    fun close() {
        opened = false
    }

    protected fun fillReceiver(liters: Int) {
        if (!opened) {
            throw IllegalStateException("При попытке залить топливо в закрытый $tankType топливо разлилось на землю")
        }

        fuelReceiver.receiveFuel(liters)
    }

    data class PETROL(override val fuelReceiver: FuelReceiver): TankMouth() {
        override val tankType: String = "бак"

        fun fuelPetrol(liters: Int) {
            fillReceiver(liters)
        }
    }

    data class LPG(override val fuelReceiver: FuelReceiver): TankMouth() {
        override val tankType: String = "баллон"

        fun fuelLPG(liters: Int) {
            fillReceiver(liters)
        }
    }
}
