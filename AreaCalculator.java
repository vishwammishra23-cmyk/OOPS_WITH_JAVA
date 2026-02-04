class AreaCalculator {

    double area(double side) {
        return side * side;
    }

    double area(double length, double breadth) {
        return length * breadth;
    }

    double area(int radius) {
        return 3.14 * radius * radius;
    }

    public static void main(String[] args) {
        AreaCalculator obj = new AreaCalculator();

        System.out.println("Area of Square: " + obj.area(5));
        System.out.println("Area of Rectangle: " + obj.area(4, 6));
        System.out.println("Area of Circle: " + obj.area(7));
    }
}
