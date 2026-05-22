package model;

public class Owner {

    private String fullName;

    public Owner(String fullName) { this.fullName = fullName; }

    public String getFullName() { return fullName; }

    @Override
    public String toString() { return fullName; }
}