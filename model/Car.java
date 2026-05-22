package model;

import java.time.LocalDate;

public class Car {

    private String brand;
    private String plateNumber;
    private LocalDate releaseDate;
    private Owner owner;

    public Car(String brand, String plateNumber,
               LocalDate releaseDate, Owner owner) {
        this.brand = brand;
        this.plateNumber = plateNumber;
        this.releaseDate = releaseDate;
        this.owner = owner;
    }

    public String getBrand() { return brand; }

    public String getPlateNumber() { return plateNumber; }

    public LocalDate getReleaseDate() { return releaseDate; }

    public Owner getOwner() { return owner; }

    @Override
    public String toString() 
    {
        return "Марка: " + brand + ", Номер: " + plateNumber + ", Власник: " + owner; 
    }
}