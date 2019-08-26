public class City {

    private String name;
    private Coordinates coordinates;

    public City(String name, Coordinates coordinates) { //TODO: добавить проверку валидности и проч
        this.name = name;
        this.coordinates = coordinates;
    }

    public String getName() {
        return name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    //TODO: возможно, заимплементить toString
}
