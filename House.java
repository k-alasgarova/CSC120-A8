import java.util.ArrayList;

/**
 * House is a Building that keeps track of its residents and whether there is a dining room.
 */
public class House extends Building implements HouseRequirements {

  /** Students living in this house */
  private ArrayList<Student> residents;

  /**Whetehr there is a dining room */
  private boolean hasDiningRoom;

  /**Whether the house has an elevator */
  private boolean hasElevator;

  /**
   * Constructs a House with name, address, floor number, elevator, and having a dining hall.
   * 
   * @param name house's name
   * @param address house's address
   * @param nfloors number of floors
   * @param hasDiningRoom if dining room present
   * @param hasElevator if there is an elevator
   */
  public House(String name, String address, int nFloors, boolean hasDiningRoom, boolean hasElevator) {
    super(name, address, nFloors);
    this.residents = new ArrayList<Student>();
    this.hasDiningRoom = hasDiningRoom;
    this.hasElevator = hasElevator;
  }

  /**
   * Overloaded Constructor with default num of floors.
   * @param name house name
   * @param address house address
   * @param hasDiningRoom if there is one
   * @param hasElevator if there is one
   */
  public House(String name, String address, boolean hasDiningRoom, boolean hasElevator) {
    this(name, address, 1, hasDiningRoom, hasElevator);
  }

  /**
   * Returns if the house has the dining room
   * @return true if dining room present or false if not
   */
  public boolean hasDiningRoom(){
    return this.hasDiningRoom;
  }

  /**
   * Returns the number of residents in the house
   * @return residents' number
   */
  public int nResidents() {
    return this. residents.size();
  }

  /**
   * Adds a student to the house
   * @param s the student that moves in
   */
  public void moveIn(Student s){
    this.residents.add(s);
  }

  /** Overloaded moveIn method creating student and moves them in
   * 
   * @param name student name
   * @param id student if
   * @param classYear class year
   */
  public void moveIn(String name, String id, int classYear) {
    Student s = new Student(name, id, classYear);
    this.moveIn(s);
  }

  /**
   * Removes a student from the house and returns that student.
   * @param s the student that moves out
   * @return the student that moved out or null if they were not a resident
   */
  public Student moveOut(Student s) {
    if (this.residents.contains(s)) {
      this.residents.remove(s);
      return s;
    }
    return null;
  }

  /** Overloaded moveOut method
   * @return the student who moved out, or null
   */
  public Student moveOut() {
    if (this.residents.size() > 0) {
        return this.residents.remove(this.residents.size() -1);
    }
    return null;
  }

  /**
   * Return if the student is or not a resident 
   * @param s checking the student
   * @return true if the resident, false if not
   */
  public boolean isResident(Student s) {
    return this.residents.contains(s);
  }

  /** Show all available options for the House*/
  public void showOptions() {
    super.showOptions();
    System.out.println(" + hasDiningRoom()");
    System.out.println(" + nResidents()");
    System.out.println(" + moveIn(Student)");
    System.out.println(" + moveOut(Student)");
    System.out.println(" + isResident(Student)");

  }

  /**
   *  Moves to a floor in the House; non-adjacent floors allowed if there is an elevator
   * @param floorNum destination floor
   */
  public void goToFloor(int floorNum) {
    if (this.activeFloor == -1) {
        throw new RuntimeException("You are not inside this Building. Must call enter() before navigating between floors.");

    }
    if (floorNum < 1 || floorNum > this.nFloors) {
        throw new RuntimeException("Invalid floor number. Valid range for this Building is 1-" + this.nFloors + ".");
    }
    if (!this.hasElevator && Math.abs(floorNum - this.activeFloor) > 1) {
        throw new RuntimeException("This house does not have an elevator.");
    }

    super.goToFloor(floorNum);
  }


  public static void main(String[] args) {
    House h = new House("Northrop", "Smith College", 3, true, true);
    System.out.println(h);
    h.showOptions();
  }

}