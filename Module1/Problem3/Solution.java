class Computer {
    private String cpu;
    private String ram;
    private String storage;

    private Computer(Builder builder) {
        cpu = builder.cpu;
        ram = builder.ram;
        storage = builder.storage;
    }

    public void displayConfiguration() {
        System.out.println("CPU: " + cpu);
        System.out.println("RAM: " + ram);
        System.out.println("Storage: " + storage);
    }

    static class Builder {
        private String cpu;
        private String ram;
        private String storage;

        public Builder setCpu(String cpu) {
            this.cpu = cpu;
            return this;
        }

        public Builder setRam(String ram) {
            this.ram = ram;
            return this;
        }

        public Builder setStorage(String storage) {
            this.storage = storage;
            return this;
        }

        public Computer build() {
            return new Computer(this);
        }
    }
}

public class Solution {
    public static void main(String[] args) {
        Computer computer = new Computer.Builder()
                .setCpu("Intel i5")
                .setRam("16 GB")
                .setStorage("512 GB SSD")
                .build();

        computer.displayConfiguration();
    }
}
