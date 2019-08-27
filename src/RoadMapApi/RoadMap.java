package RoadMapApi;

import java.util.ArrayList;
import java.util.HashMap;

public class RoadMap {

    private HashMap<String, City> cities = new HashMap<>();
    private HashMap<String, Road> roads = new HashMap<>();

    public RoadMap() {
    }

    public void addCity(String name, Double x, Double y) throws WrongInputDataException {
        if (cities.containsKey(name)) {
            throw new WrongInputDataException("City " + name + " already exist");
        } else {
            cities.put(name, new City(name, new Coordinates(x, y)));
        }
    }

    public void addRoad(String name, Double length, String firstCity, String secondCity) throws WrongInputDataException {
        Road newRoad = new Road(name, length, firstCity, secondCity);

        if (roads.containsKey(name)) throw new WrongInputDataException("Road " + name + " already exists");
        for (String city : newRoad.getCities()) {
            if(!cities.containsKey(city)) throw new WrongInputDataException("City " + city + " does not exists");
        }

        for (String city : newRoad.getCities()) {
            cities.get(city).addRoad(newRoad);
        }
        roads.put(name, newRoad);
    }

    public void deleteRoad(String name) throws WrongInputDataException {
        if (!roads.containsKey(name)) throw new WrongInputDataException("Road " + name + " does not exists");

        for (String city : roads.get(name).getCities()) {
            cities.get(city).deleteRoad(name);
        }
        roads.remove(name);
    }

    public City getCity(String name) throws WrongInputDataException {
        if(!cities.containsKey(name)) throw new WrongInputDataException("City " + name + " does not exists");

        return cities.get(name);
    }

    public ArrayList<Road> getRoadList (String name) throws WrongInputDataException {
        if(!cities.containsKey(name)) throw new WrongInputDataException("City " + name + " does not exists");

        return cities.get(name).getConnections();
    }
}
