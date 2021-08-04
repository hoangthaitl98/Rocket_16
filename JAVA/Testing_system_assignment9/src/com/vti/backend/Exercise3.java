package com.vti.backend;

import com.vti.entity.CPU;
import com.vti.entity.Car;

public class Exercise3 {
    public void question1 () {
        CPU cpu = new CPU();
        CPU.Processor processor = cpu.new Processor();
        CPU.Ram ram = cpu.new Ram();
        System.out.println("Cache processor: " + processor.getCache());
        System.out.println("Ram clock speed: " + ram.getClockSpeed());
    }

    public void question2 () {
        Car car = new Car("Mazda", "8WD");
        Car.Engine engine = car.new Engine();
        engine.setEngineType("Crysler");
        System.out.println(car.toString() + engine.toString());
    }
}
