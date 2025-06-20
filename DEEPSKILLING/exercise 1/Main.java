public class Main {
    private static Main instanceObj;

    private Main() {
        System.out.println("Singleton instance created.");
    }

    public static Main create() {
        if (instanceObj == null) {
            instanceObj = new Main();
        }
        return instanceObj;
    }

    public void greet() {
        System.out.println("Hello from Singleton!");
    }

    public static void main(String[] args) {
        Main obj = Main.create();
        obj.greet();
    }
}
