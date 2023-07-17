package live_session;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * test class for the Shape interface
 * @author kamar baraka
 * @since 17/07/2023*/

class ShapeTest {

    @Test
    public void shapeTest(){

        /*construct objects of the rectangle and circle class*/
        Rectangle rect = new Rectangle(15.2, 4.5);
        Circle circle = new Circle(6.2);

        /*print the details and area of each*/
        rect.display();
        System.out.println(rect.area());

        circle.display();
        System.out.println(circle.area());

        /*perform tests for each*/
        assertAll(() -> {
            assertEquals(68, (int)rect.area(), "expected 68.4, but got "+ rect.area());
            assertEquals(120, (int)circle.area(), "expected 68.4, but got "+ circle.area());
        });
    }
}