package RoadMapApi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class City {

    private String name;
    private Coordinates coordinates;
    private HashMap<String, Road> connections = new HashMap<>();

    public City(String name, Coordinates coordinates) {
        this.name = name;
        this.coordinates = coordinates;
    }

    public String getName() {
        return name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    void addRoad(Road road) {
        connections.put(road.getName(), road);
    }

    void deleteRoad(String road) {
        connections.remove(road);
    }

    ArrayList<Road> getConnections() {
        return new ArrayList<Road>(connections.values());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof City)) return false;
        City city = (City) o;
        return getName().equals(city.getName()) &&
                getCoordinates().equals(city.getCoordinates()) &&
                Objects.equals(getConnections(), city.getConnections());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getCoordinates(), getConnections());
    }

    @Override
    public String toString() {
        return "City " +
                "name='" + name + '\'' +
                ", " + coordinates.toString();
    }
}
