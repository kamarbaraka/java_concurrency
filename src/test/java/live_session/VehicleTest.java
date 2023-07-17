package live_session;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VehicleTest {

    @Test
    public void vehicleTest(){
        Vehicle vehicle1 = new Vehicle();
        vehicle1.setManufacturer("mercedes");
        vehicle1.setYear(2018);
        vehicle1.accelerate();
        vehicle1.brake();

        Car car = new Car();
        car.setManufacturer("toyota");
        car.setYear(2020);
        car.setNumDoors(4);
        car.accelerate();
        car.brake();

        assertAll(() -> {
            assertEquals("toyota", car.getManufacturer());
            assertEquals("mercedes", vehicle1.getManufacturer());
                }
        );
    }

}