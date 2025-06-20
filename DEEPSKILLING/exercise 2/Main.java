interface Drawable {
    void sketch();
}

class Circle implements Drawable {
    public void sketch() {
        System.out.println("Drawing Circle...");
    }
}

class Square implements Drawable {
    public void sketch() {
        System.out.println("Drawing Square...");
    }
}

class ShapeMaker {
    public Drawable makeShape(String shape) {
        if ("circle".equalsIgnoreCase(shape)) return new Circle();
        else if ("square".equalsIgnoreCase(shape)) return new Square();
        return null;
    }
}

public class Main {
    public static void main(String[] args) {
        ShapeMaker maker = new ShapeMaker();
        Drawable d1 = maker.makeShape("circle");
        if (d1 != null) d1.sketch();

        Drawable d2 = maker.makeShape("square");
        if (d2 != null) d2.sketch();
    }
}
