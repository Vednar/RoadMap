package RoadMapApi;

import java.util.ArrayList;
import java.util.HashMap;

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

    //TODO: возможно, заимплементить toString
}
