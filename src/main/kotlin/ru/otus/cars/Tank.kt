package ru.otus.cars

interface FuelSource {
    /**
     * Получение уровня топлива в % от полного бака
     */
    fun getLevel(): Int
}

interface FuelReceiver {
    /**
     * Заливка топлива
     */
    fun receiveFuel(liters: Int)
}

class Tank(private val volume: Int): FuelSource, FuelReceiver {
    private var currentFuel: Int = 0

    override fun getLevel(): Int = (currentFuel * 100)/volume

    override fun receiveFuel(liters: Int) {
        currentFuel += liters

        if (currentFuel > volume) {
            currentFuel = volume

            throw IllegalArgumentException("Бак переполнился")
        }
    }
}
