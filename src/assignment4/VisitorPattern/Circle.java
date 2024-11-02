package assignment4.VisitorPattern;

public class Circle implements Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
