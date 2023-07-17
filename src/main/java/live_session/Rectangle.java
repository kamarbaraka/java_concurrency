package live_session;

/**
 * simulation of a rectangle, which is a shape
 * @author kamar baraka
 * @since 17/07/2023*/

public class Rectangle
    implements Shape{

    private double width, height;

    /**
     * construct a rectangle
     * @param width the width of the rectangle
     * @param height the height of the rectangle*/
    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    /**
     * gets the width of the rectangle
     * @return <em>double</em> width of the rectangle*/
    public double getWidth() {
        return width;
    }

    /**
     * gets the height of the rectangle
     * @return <em>double</em> the height of the rectangle*/
    public double getHeight() {
        return height;
    }

    /**
     * calculates the area of the rectangle
     * @return <em>double</em> the area of the rectangle*/
    @Override
    public double area() {
        return width * height;
    }

    /**
     * prints the details of the rectangle*/
    @Override
    public void display() {
        System.out.printf("%s[width= %s, height= %s]%n", this.getClass().getSimpleName(), this.width, this.height);
    }
}
