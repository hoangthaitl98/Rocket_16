package com.vti.entity;

public class CPU {
    private int price;

    public class Processor{
        private int coreAmount;
        private String menufacturer;

        public double getCache() {
            return 4.3;
        }
    }

    public class Ram {
        private int memory;
        private String menufacturer;

        public double getClockSpeed () {
            return 5.5;
        }
    }
}
