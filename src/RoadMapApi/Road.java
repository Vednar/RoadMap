package RoadMapApi;

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
        return "RoadMapApi.Road{" +
                "name='" + name + '\'' +
                ", length=" + length +
                ", from=" + cities[0] +
                ", to=" + cities[1] +
                '}';
    }
}
