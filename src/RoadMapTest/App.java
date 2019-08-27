package RoadMapTest;

import RoadMapApi.Road;
import RoadMapApi.RoadMap;
import RoadMapApi.WrongInputDataException;

public class App {

    public static void main(String[] args) {

        RoadMap roadMap = new RoadMap();

        //some manual tests

        //Add new City
        System.out.println("TEST 1: Add new city");
        try {
            roadMap.addCity("Tomsk", 3.1415, 2.7182);
            roadMap.addCity("Novosibirsk", 3.115, 2.7282);
            System.out.println("PASS");
        } catch (WrongInputDataException e) {
            System.out.println(e.getMessage());
        }
        System.out.println();

        //Add existing City
        System.out.println("TEST 2: Add existing city");
        try {
            roadMap.addCity("Tomsk", 12.1, 1.1);
        } catch (WrongInputDataException e) {
            System.out.println(e.getMessage());
            System.out.println("PASS");
        }
        System.out.println();

        //Add road
        System.out.println("TEST 3: Add new road");
        try {
            roadMap.addRoad("66", 340.0, "Tomsk", "Novosibirsk");
            System.out.println("PASS");
        } catch (WrongInputDataException e) {
            System.out.println(e.getMessage());
        }
        System.out.println();

        //Add existing road
        System.out.println("TEST 4: Add existing road");
        try {
            roadMap.addRoad("66", 12.1, "Tomsk", "Novosibirsk");
        } catch (WrongInputDataException e) {
            System.out.println(e.getMessage());
            System.out.println("PASS");
        }
        System.out.println();

        //Add road with wrong city
        System.out.println("TEST 5: Add road with wrong city");
        try {
            roadMap.addRoad("76", 122.1, "Tomsk", "Moscow");
        } catch (WrongInputDataException e) {
            System.out.println(e.getMessage());
            System.out.println("PASS");
        }
        System.out.println();

        //Get city
        System.out.println("TEST 6: Get city");
        try {
            System.out.println(roadMap.getCity("Tomsk").toString());
            System.out.println("PASS");
        } catch (WrongInputDataException e) {
            System.out.println(e.getMessage());
        }
        System.out.println();

        //Get wrong city
        System.out.println("TEST 7: Get wrong city");
        try {
            System.out.println(roadMap.getCity("Moscow").toString());
        } catch (WrongInputDataException e) {
            System.out.println(e.getMessage());
            System.out.println("PASS");
        }
        System.out.println();

        //Get road list
        System.out.println("TEST 8: Get road list");
        try {
            roadMap.addCity("Irkutsk", 3.1455, 2.8543);
            roadMap.addRoad("M19", 1600.2, "Tomsk", "Irkutsk");
            roadMap.addCity("Krasnoyarsk", 3.3564, 2.4893);
            roadMap.addRoad("M34", 1050.12, "Tomsk", "Krasnoyarsk");

            printRoadList(roadMap, "Tomsk");
            printRoadList(roadMap, "Irkutsk");
            System.out.println("PASS");
        } catch (WrongInputDataException e) {
            System.out.println(e.getMessage());
        }
        System.out.println();

        //Delete road
        System.out.println("TEST 9: Delete road");
        try {
            roadMap.deleteRoad("M19");
            printRoadList(roadMap, "Tomsk");
            printRoadList(roadMap, "Irkutsk");
            System.out.println("PASS");
        } catch (WrongInputDataException e) {
            System.out.println(e.getMessage());
        }
        System.out.println();

        //Delete wrong road
        System.out.println("TEST 10: Delete wrong road");
        try {
            roadMap.deleteRoad("M654456564");
        } catch (WrongInputDataException e) {
            System.out.println(e.getMessage());
            System.out.println("PASS");
        }
    }

    public static void printRoadList(RoadMap roadMap, String city) throws WrongInputDataException {
        System.out.print(city + ": ");
        for (Road r : roadMap.getRoadList(city)) {
            System.out.print(r.getName() + " ");
        }
        System.out.println();
    }
}
