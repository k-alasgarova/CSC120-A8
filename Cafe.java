/**
 * Cafe is a Building that tracks coffee inventory
*/
public class Cafe extends Building implements CafeRequirements {
    /** Number of remaining coffee ounces */
    private int nCoffeeOunces;

    /** Number of remaining sugar packets */
    private int nSugarPackets;

    /** Number of remaining creams */
    private int nCreams;

    /** Number of remaining cups */
    private int nCups;

    /** Constructs Cafe with name, address, floor numbers, initial inventory values 
     * @param name cafe's name
     * @param address cafe's address
     * @param nFloors floor numbers 
     * @param nCoffeeOunces starting coffee ounces
     * @param nSugarPackets starting sugar packets
     * @param nCreams starting creams
     * @param nCups starting cups 
    */
    public Cafe(String name, String address, int nFloors, int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        super(name, address, nFloors);
        this.nCoffeeOunces = nCoffeeOunces;
        this.nSugarPackets = nSugarPackets;
        this.nCreams = nCreams;
        this.nCups = nCups;
    }

    /**
     * Overloaded constructor with one floor by default.
     * @param name cafe name
     * @param address cafe address
     * @param nCoffeeOunces starting coffee ounces
     * @param nSugarPackets starting sugar packets
     * @param nCreams starting creams
     * @param nCups starting cups 
     */
    public Cafe(String name, String address, int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        this(name, address, 1, nCoffeeOunces, nSugarPackets, nCreams, nCups);
    }

    /**
     * Sells a cup of coffee and updates the inventory; if inventory too low, cafe restocks.
     * @param size size od coffee in ounces
     * @param nSugarPackets number of used sugar packets
     * @param nCream number of used creams
     */
    public void sellCoffee(int size, int nSugarPackets, int nCreams) {
        if (this.nCoffeeOunces < size || this.nSugarPackets < nSugarPackets || this.nCreams < nCreams || this.nCups < 1 ) {
            int coffeeNeeded = 0;
            int sugarNeeded = 0;
            int creamsNeeded = 0;
            int cupsNeeded = 0;

            if (this.nCoffeeOunces < size) {
                coffeeNeeded = size - this.nCoffeeOunces;
            }
            if (this.nSugarPackets < nSugarPackets) {
                sugarNeeded = nSugarPackets - this.nSugarPackets;
            }
            if (this.nCreams < nCreams) {
                creamsNeeded = nCreams - this.nCreams;
            }
            if (this.nCups < 1) {
                cupsNeeded = 1 - this.nCups;
            }

            restock(coffeeNeeded, sugarNeeded, creamsNeeded, cupsNeeded);
        }

        this.nCoffeeOunces -= size;
        this.nSugarPackets -= nSugarPackets;
        this.nCreams -= nCreams;
        this.nCups -= 1;

    }

    /**
     * Overloaded sellCoffee method with no sugar or cream.
     * @param size coffee size in ounces
     */
    public void sellCoffee(int size) {
        this.sellCoffee(size, 0, 0);
    }

    /**
     * Overloaded sellCoffee method with sugar but no cream.
     * @param size coffee size in ounces
     * @param nSugarPackets sugar packets used
     */
    public void sellCoffee(int size, int nSugarPackets) {
        this.sellCoffee(size, nSugarPackets, 0);
    }

    /**
     * Restocks cafe's inventory
     * @param nCoffeeOunces coffee ounces to add
     * @param nSugarPackets sugar packets to add
     * @param nCreams creams to add
     * @param nCups cups to add
     */
    private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        this.nCoffeeOunces += nCoffeeOunces;
        this.nSugarPackets += nSugarPackets;
        this.nCreams += nCreams;
        this.nCups += nCups;
    }

    /**
     * Show all available options for a cafe.
     */
    public void showOptions() {
        super.showOptions();
        System.out.print(" + sellCoffee(int)");
        System.out.print(" + sellCoffee(int, int)");
        System.out.print(" + sellCoffee(int, int, int)");
    }
    
    /**
     * Cafes only allow public access to floor 1
     * @param floorNum destination floor
     */
    public void goToFloor(int floorNum) {
        if (floorNum != 1) {
            throw new RuntimeException("Customers may only access the first floor of the cafe.");
        }
        super.goToFloor(floorNum);
    }

    public static void main(String[] args) {
        Cafe c = new Cafe("Compass Cafe", "Smith College", 100, 50, 50, 20);
        c.showOptions();
    }
    
}

