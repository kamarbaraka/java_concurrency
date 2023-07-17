package live_session

/**
 * a class to simulate a car, which is a vehicle
 * @author kamar baraka
 * @since 17/07/2023
 */
class Car : Vehicle() {
    /**
     * gets the number of doors in the car
     * @return *int* the number 0f doors
     */
    /**
     * sets the number of doors in the car */
    @JvmField
    var numDoors = 0

    /**
     * open the car doors  */
    fun openDoors() {
        println("Opening car doors")
    }
}
