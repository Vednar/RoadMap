package RoadMapApi;

import java.util.Arrays;
import java.util.Objects;

public class Road {

    private String name;
    private Double length;
    private String[] cities = new String[2];

    public Road(String name, Double length, String firstCity, String secondCity) {
        this.name = name;
        this.length = length;
        this.cities[0] = firstCity;
        this.cities[1] = secondCity;
    }

    public String getName() {
        return name;
    }

    public Double getLength() {
        return length;
    }

    String[] getCities() {
        return cities;
    }

    @Override
    public String toString() {
        return "Road " +
                "name='" + name + '\'' +
                ", length=" + length +
                ", from=" + cities[0] +
                ", to=" + cities[1];
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Road)) return false;
        Road road = (Road) o;
        return getName().equals(road.getName()) &&
                getLength().equals(road.getLength()) &&
                Arrays.equals(getCities(), road.getCities());
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(getName(), getLength());
        result = 31 * result + Arrays.hashCode(getCities());
        return result;
    }
}
