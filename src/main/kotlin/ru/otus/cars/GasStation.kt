package ru.otus.cars


fun fillCar(car: Car, liters: Int) {
    try {
        car.tankMouth.open()
        when (val mouth = car.tankMouth) {
            is TankMouth.PETROL -> mouth.fuelPetrol(liters)
            is TankMouth.LPG -> mouth.fuelLPG(liters)
        }
        car.tankMouth.close()
    } catch (e: Exception) {
        println("При попытке заправиться возникли проблемы: ${e.message}")
    }
}
