package digitalnurture.BuilderPatternExample;

public class Computer {

    // Required fields
    private final String cpu;
    private final String ram;
    private final String storage;

    // Optional fields
    private final String bluetooth;
    private final String integratedGraphicsCard;

    // Private constructor accessed only via builder
    private Computer(Builder builder) {
        this.cpu = builder.cpu;
        this.ram = builder.ram;
        this.storage = builder.storage;
        this.bluetooth = builder.bluetooth;
        this.integratedGraphicsCard = builder.integratedGraphicsCard;
    }

    @Override
    public String toString() {
        return "CPU --> " + cpu +
               " | RAM --> " + ram +
               " | Storage --> " + storage +
               " | Bluetooth --> " + (bluetooth != null ? bluetooth : "disabled") +
               " | Integrated Graphics Card --> " + integratedGraphicsCard;
    }

    // Static Builder Class
    public static class Builder {
        private final String cpu;
        private final String ram;
        private final String storage;

        private String bluetooth;
        private String integratedGraphicsCard = "NVIDIA GTX 1650"; // Default

        // Constructor with required fields
        public Builder(String cpu, String ram, String storage) {
            this.cpu = cpu;
            this.ram = ram;
            this.storage = storage;
        }

        public Builder enableBluetooth(String bluetooth) {
            this.bluetooth = bluetooth;
            return this;
        }

        public Builder setIntegratedGraphicsCard(String card) {
            this.integratedGraphicsCard = card;
            return this;
        }

        public Computer build() {
            return new Computer(this);
        }
    }

    // Main Method for testing
    public static void main(String[] args) {
        Computer businessComputer = new Computer.Builder("Intel", "8 GB", "256 SSD")
                .enableBluetooth("enabled")
                .build();

        System.out.println(businessComputer);

        Computer gamingComputer = new Computer.Builder("NVIDIA", "16 GB", "512 SSD")
                .setIntegratedGraphicsCard("NVIDIA RTX 3060")
                .build();

        System.out.println(gamingComputer);
    }
}
