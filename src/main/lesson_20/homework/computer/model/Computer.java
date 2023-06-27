package main.lesson_20.homework.computer.model;

import java.util.Objects;

public class Computer {

    public static final int BARCODE_LENGTH = 13;
    protected final long barCode;
    protected String cpu;
    protected int ram;
    protected int ssd;
    protected String brand;

    public Computer(long barCode, String cpu, int ram, int ssd, String brand) {
        this.barCode = checkBarCode(barCode);
        this.cpu = cpu;
        this.ram = ram;
        this.ssd = ssd;
        this.brand = brand;
    }

    public long getBarCode() {
        return barCode;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getSsd() {
        return ssd;
    }

    public void setSsd(int ssd) {
        this.ssd = ssd;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    private long checkBarCode(long barCode) {
        String stringBarCode = String.valueOf(barCode);
        if (stringBarCode.length() == BARCODE_LENGTH) {
            return barCode;
        } else {
            return -1;
        }
    }

    @Override
    public String toString() {
        return "Computer{" +
                "barCode=" + barCode +
                ", cpu='" + cpu + '\'' +
                ", ram=" + ram +
                ", ssd=" + ssd +
                ", brand='" + brand + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Computer)) {
            return false;
        }
        Computer computer = (Computer) object;
        return barCode == computer.barCode;
    }

    @Override
    public int hashCode() {
        return Objects.hash(barCode);
    }
}
