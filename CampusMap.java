import java.util.ArrayList;

public class CampusMap {

    ArrayList<Building> buildings;

    /* Default constructor, initializes empty ArrayList */
    public CampusMap() {
        buildings = new ArrayList<Building>();
    }

    /**
     * Adds a Building to the map
     * @param b the Building to add
     */
    public void addBuilding(Building b) {
        System.out.println("Adding building...");
        buildings.add(b);
        System.out.println("-->Successfully added " + b.getName() + " to the map.");
    }

    /**
     * Removes a Building from the map
     * @param b the Building to remove
     * @return the removed Building
     */
    public Building removeBuilding(Building b) {
        System.out.println("Removing building...");
        buildings.remove(b);
        System.out.println("-->Successfully removed " + b.getName() + " to the map.");
        return b;
    }

    public String toString() {
        String mapString = "DIRECTORY of BUILDINGS";

        for (int i = 0; i < this.buildings.size(); i ++) {
            mapString += "\n  " + (i+1) + ". "+ this.buildings.get(i).getName() + " (" + this.buildings.get(i).getAddress() + ")";
        }
        return mapString;
    }

    public static void main(String[] args) {
        CampusMap myMap = new CampusMap();
        // Buildings
        Building fordHall = new Building("Ford Hall", "100 Green Street Northampton, MA 01063", 4);
        Building bassHall = new Building("Bass Hall", "4 Tyler Court Northampton, MA 01063", 4);
        Building seelyeHall = new Building("Seelye Hall", "Smith College", 5);
        Building sabinReed = new Building("Sabin-Reed Hall", "Smith College", 2);
        Building burtonHall = new Building("Burton Hall", "Smith College", 3);
        // Houses
        House chase = new House("Chase", "Smith College", true, false);
        House northrop = new House("Northrop", "Smith College", 3, true, true);
        House gardiner = new House("Gardiner", "Smith College", 2, false, false);
        //Libraries
        Library neilson = new Library("Neilson Library", "7 Neilson Drive", 4);
        Library hillyer = new Library("Hillyer Library", "22 Elm Street");
        Library josten = new Library("Josten Performing Arts Library", "Mendenhall Center", 2);
        // Cafes
        Cafe compass = new Cafe("Compas Cafe", "Neilson Library", 1, 100, 50, 50, 20);
        Cafe campusCenterCafe = new Cafe("Campus Center Cafe", "1 Chapin Way", 120,60, 40, 30);
        Cafe oakCafe = new Cafe("Oak Cafe", "Oak Hall", 80, 30, 20, 15);
        
        myMap.addBuilding(fordHall);
        myMap.addBuilding(bassHall);
        myMap.addBuilding(seelyeHall);
        myMap.addBuilding(sabinReed);
        myMap.addBuilding(burtonHall);
        myMap.addBuilding(chase);
        myMap.addBuilding(northrop);
        myMap.addBuilding(gardiner);
        myMap.addBuilding(neilson);
        myMap.addBuilding(hillyer);
        myMap.addBuilding(josten);
        myMap.addBuilding(compass);
        myMap.addBuilding(campusCenterCafe);
        myMap.addBuilding(oakCafe);
        
        System.out.println();
        System.out.println(myMap);
        System.out.println();

        // Overloaded methods demonstration
        northrop.moveIn("Leo", "12345", 2029);
        chase.moveIn("Kamilla", "88890", 2029);
        neilson.addTitle("Anxious People by Fredrik Backman");
        neilson.addTitle("Inferno by Dan Brown", false);
        compass.sellCoffee(12);
        compass.sellCoffee(16, 2);
        compass.sellCoffee(20, 2, 1);



    }
    
}
