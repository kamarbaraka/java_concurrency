package live_session;

/**
 * a class to simulate a car, which is a vehicle
 * @author kamar baraka
 * @since 17/07/2023*/

public class Car
    extends Vehicle{

    private int numDoors;

    /**
     * open the car doors */
    public void openDoors(){
        System.out.println("Opening car doors");
    }

    /**
     * gets the number of doors in the car
     * @return <em>int</em> the number 0f doors*/
    public int getNumDoors() {
        return numDoors;
    }

    /**
     * sets the number of doors in the car*/
    public void setNumDoors(int numDoors) {
        this.numDoors = numDoors;
    }
}
