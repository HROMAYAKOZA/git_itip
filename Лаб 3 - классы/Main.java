abstract class GeometricFigure {
    private String name;
    private String color;
    

    public GeometricFigure() {
        this.name = "";
        this.color = "None";
    }

    public GeometricFigure(String name, String color) {
        this.name = name;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public abstract double getVolume();

    public abstract double getSurfaceArea();

    public void displayInfo() {
        System.out.println("Figure: " + name);
        System.out.println("Color: " + color);
        System.out.println("Volume: " + getVolume());
        System.out.println("Surface Area: " + getSurfaceArea());
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setColor(String color) {
        this.color = color;
    }
}

// Дочерний класс Шар
class Sphere extends GeometricFigure {
    private double radius;

    public Sphere(String color, double radius) {
        super("Sphere", color);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double getVolume() {
        return (4.0 / 3.0) * Math.PI * Math.pow(radius, 3);
    }

    @Override
    public double getSurfaceArea() {
        return 4 * Math.PI * Math.pow(radius, 2);
    }
}

// Дочерний класс Параллелепипед
class Parallelepiped extends GeometricFigure {
    private double length;
    private double width;
    private double height;

    public Parallelepiped(String color, double length, double width, double height) {
        super("Parallelepiped", color);
        this.length = length;
        this.width = width;
        this.height = height;
    }

    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public double getVolume() {
        return length * width * height;
    }

    @Override
    public double getSurfaceArea() {
        return 2 * (length * width + width * height + height * length);
    }
}

// Дочерний класс Цилиндр
class Cylinder extends GeometricFigure {
    private double radius;
    private double height;
    private static int numberOfCylinders = 0;


    public Cylinder(String color, double radius, double height) {
        super("Cylinder", color);
        this.radius = radius;
        this.height = height;
        numberOfCylinders++;
    }

    public double getRadius() {
        return radius;
    }

    public double getHeight() {
        return height;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public double getVolume() {
        return Math.PI * Math.pow(radius, 2) * height;
    }

    @Override
    public double getSurfaceArea() {
        return 2 * Math.PI * radius * (radius + height);
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Amount of Cylinders: " + numberOfCylinders);
    }
}

public class Main {
    public static void main(String[] args) {
        Sphere sphere = new Sphere("Red", 5.0);
        Parallelepiped parallelepiped = new Parallelepiped("Blue", 3.0, 4.0, 6.0);
        Cylinder cylinder = new Cylinder("Green", 2.0, 8.0);

        sphere.displayInfo();
        parallelepiped.displayInfo();
        cylinder.displayInfo();
    }
}