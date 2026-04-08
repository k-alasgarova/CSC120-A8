import java.util.Hashtable;


/** 
 * Library is a Building that stores collection of nook titles with a boolean for whether they are available or not
*/
public class Library extends Building implements LibraryRequirements {
  /** Collection of titles + whether available */
  private Hashtable<String, Boolean> collection;

  /** Constructs library with a name, address, number of floors
   * @param name name
   * @param address library's address
   * @param nFloors number of floors
   */
  public Library(String name, String address, int nFloors) {
    super(name, address, nFloors);
    this.collection = new Hashtable<String, Boolean>();
  }

  /**
   * Overloaded constructor with default one floor.
   * @param name library name
   * @param address library address
   */
  public Library(String name, String address) {
    this(name, address, 1);
  }

  /** Adds title to library collection; new ones are available by default
   * @param title title to add
   */
  public void addTitle(String title) {
    this.collection.put(title, true);
  }

  /** 
   * Overloaded addTitle method that allows you to choose availability.
   * @param title title
   * @param available whether available
   */
  public void addTitle(String title, boolean available) {
    this.collection.put(title, available);
  }

  /** Removes title from collection and returns it 
   * @param title title to remove
   * @return removed title or null if not in collection
  */
  public String removeTitle(String title) {
    if (this.collection.containsKey(title)) {
      this.collection.remove(title);
      return title;
    }
    return null;
  }

  /**
   * Checks out title by marking as unavailable
   * @param title title to check out
   */
  public void checkOut(String title) {
    if (this.collection.containsKey(title)) {
      this.collection.replace(title, false);
    }
  }

  /**
   * Overloaded checkOut method for checking out multiple times.
   * @param title title to check out
   * @param times num of times to try
   */
  public void checkOut(String title, int times){
    for (int i = 0; i < times; i++) {
        this.checkOut(title);
    }
  }

  /** 
   * Returns title by marking as available
   * @param title title to return
   */
  public void returnBook(String title) {
    if (this.collection.containsKey(title)) {
      this.collection.replace(title, true);
    }
  }

  /** Returns if the title is in the collection
   * @param title title to check
   * @return true if in the collection, false if not
   */
  public boolean containsTitle(String title) {
    return this.collection.containsKey(title);
  }

  /** 
   * Returns if the title is currently available
   * @param title title to check
   * @return true if there, false if not
   */
  public boolean isAvailable(String title) {
    if (this.collection.containsKey(title)) {
      return this.collection.get(title);
    }
    return false;
  }

  /**
   * Print the full collection with availability status
   */
  public void printCollection() {
    for (String title : this.collection.keySet()) {
      if (this.collection.get(title)){
        System.out.println(title + " : available");
      } else {
        System.out.println(title + " : checked out");
      }
    }
  }

  /**
   * Shows all available options for Library.
   */
  public void showOptions() {
    super.showOptions();
    System.out.println(" + addTitle(String)");
    System.out.println(" + removeTitle(String)");
    System.out.println(" + checkOut(String)");
    System.out.println(" + returnBook(String)");
    System.out.println(" + containsTitle(String)");
    System.out.println(" + isAvailable(String)");
    System.out.println(" + printCollection()");
  }

  /**
   * Moves to a floor in Library; allow direct movement between non-adjacent floors.
   * @param floorNum destination floor
   */
  public void goToFloor(int floorNum) {
    super.goToFloor(floorNum);
  }


  public static void main(String[] args) {
      Library l = new Library("Neilson Library", "Smith College", 4);
      l.addTitle("The Lorax by Dr. Seuss");
      l.printCollection();
      l.showOptions();
  }
  
}