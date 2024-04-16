package miscellousprogram;

// when you make a comments like
// you make your class look more like
// a professional one
/**
 * The Circle class represents a circle with a radius.
 */
public class Circle {
    /**
     * The radius of the circle.
     */
    private double radius;

    /**
     * The default constructor initializes the radius to 0.0.
     */
    public Circle() {
        radius = 0.0;
    }

    /**
     * The parameterized constructor initializes the radius to the specified value.
     * 
     * @param radius The radius of the circle.
     */
    public Circle(double radius) {
        this.radius = radius;
    }

    /**
     * The getRadius method returns the radius of the circle.
     * 
     * @return The radius of the circle.
     */
    public double getRadius() {
        return radius;
    }

    /**
     * The getArea method returns the area of the circle.
     * 
     * @param radius The radius of the circle.
     */
    public void setRadius(double radius) {
        this.radius = radius;
    }

    /**
     * The getArea method returns the area of the circle.
     * 
     * @return The area of the circle.
     */
    public double getArea() {
        return calculateArea();
    }

    /**
     * The getCircumference method returns the circumference of the circle.
     * 
     * @return The circumference of the circle.
     */
    public double getCircumference() {
        return calculateCircumference();
    }

    /**
     * The calculateArea method calculates the area of the circle.
     * 
     * @return The area of the circle.
     */
    private double calculateArea() {
        return Math.PI * radius * radius;
    }

    /**
     * The calculateCircumference method calculates the circumference of the circle.
     * 
     * @return The circumference of the circle.
     */
    private double calculateCircumference() {
        return 2 * Math.PI * radius;
    }

    /**
     * The toString method returns a string representation of the circle.
     * 
     * @return A string representation of the circle
     */
    @Override
    public String toString() {
        return "Circle [radius=" + radius + "]";
    }
}
