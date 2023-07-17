package live_session;

/**
 * a simulation of a circle, which is a Shape
 * @author kamar baraka
 * @since 17/07/2023*/

public class Circle
    implements Shape{

    private double radius;

    /**
     * constructs a circle
     * @param radius the radius of the circle*/
    public Circle(double radius) {
        this.radius = radius;
    }

    /**
     * computes the area of this circle
     * @return <em>double</em> the area of the circle*/
    @Override
    public double area() {
        return Math.PI * (radius * radius);
    }

    /**
     * prints the details of the circle*/
    @Override
    public void display() {
        System.out.printf("%s[radius= %s]%n", this.getClass().getSimpleName(), this.radius);
    }
}
