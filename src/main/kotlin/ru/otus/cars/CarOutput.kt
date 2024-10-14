package ru.otus.cars

/**
 * Следит за машиной
 */
interface CarOutput {
    /**
     * Скажи текущую скорость
     */
    fun getCurrentSpeed(): Int

    /**
     * Скажи уровень топлива в % от полного бака
     */
    fun getFuelLevel(): Int
}