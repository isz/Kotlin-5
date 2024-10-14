package ru.otus.cars


fun fillCar(car: Car, liters: Int) {
    try {
        car.tankMouth.open()
        when (car.tankMouth) {
            is TankMouth.PETROL -> (car.tankMouth as TankMouth.PETROL).fuelPetrol(liters)
            is TankMouth.LPG -> (car.tankMouth as TankMouth.LPG).fuelLPG(liters)
        }
        car.tankMouth.close()
    } catch (e: Exception) {
        println("При попытке заправиться возникли проблемы: ${e.message}")
    }
}
