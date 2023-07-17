package live_session;

/**
 * a class to simulate a vehicle
 * @author kamar baraka
 * @since 17/07/2023*/

public class Vehicle {

    private String manufacturer;
    private int year;

    /**
     * accelerate the vehicle*/
    public void accelerate(){
        System.out.println("Vehicle accelerating");
    }

    /**
     * break the vehicle*/
    public void brake(){
        System.out.println("Vehicle braking");
    }

    /**
     * gets the manufacturer of the vehicle
     * @return (String) the vehicle's manufacturer*/
    public String getManufacturer() {
        return manufacturer;
    }

    /**
     * sets the manufacturer of the Vehicle*/
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    /**
     * get the year of manufacture
     * @return <em>int</em> the year of manufacture*/
    public int getYear() {
        return year;
    }

    /**
     * sets the year of manufacture
     * */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     * a string representation of the vehicle object
     * @return <em>String</em> the string representation*/
    @Override
    public String toString() {
        return "Vehicle{" +
                "manufacturer='" + manufacturer + '\'' +
                ", year=" + year +
                '}';
    }
}
