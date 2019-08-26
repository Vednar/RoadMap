public class Road {

    private String name;
    private Double length;

    public Road(String name, Double length) {
        this.name = name;
        this.length = length;
    }

    public String getName() {
        return name;
    }

    public Double getLength() {
        return length;
    }

    @Override
    public String toString() {
        return "Road{" +
                "name='" + name + '\'' +
                ", length=" + length +
                '}';
    }
}
