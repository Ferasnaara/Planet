package com.example.planet;

public class Planet {
    private String Name;
    private String Size;
    private String Orbit;
    private double distance;
    public Planet(String name, String size, String orbit, String distance) {
    }

    public Planet(String Name, String Size, String Orbit, double distance) {
        this.Name = Name;
        this.Size = Size;
        this.Orbit = Orbit;
        this.distance=distance ;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public String getSize() {
        return Size;
    }

    public void setSize(String Size) {
        this.Size = Size;
    }

    public String getOrbit() {
        return Orbit;
    }

    public void setOrbit(String Orbit) {
        this.Orbit = Orbit;
    }

    public double getdistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "name='" + Name + '\'' +
                ", Size='" + Size + '\'' +
                ", Orbit='" + Orbit + '\'' +
                ", distance='" + distance + '\'' +
                '}';
    }
}


