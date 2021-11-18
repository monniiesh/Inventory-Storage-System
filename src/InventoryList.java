//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: P07 Inventory List
// Course: CS 300 Spring 2021
//
// Author: Monniiesh Velmurugan
// Email: mvelmurugan@wisc.edu
// Lecturer: Mouna Kacem
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
//
//
//
///////////////////////////////////////////////////////////////////////////////
import java.util.NoSuchElementException;

/**
 * It has all the methods of the InventoryList method
 */
public class InventoryList {

    private LinkedBox head;
    private LinkedBox tail;
    private int size;
    private int yellowCount;
    private int blueCount;
    private int brownCount;

    /**
     * returns the size of inventory list.
     * @return size the size of the inventory list
     */
    public int size() {
        return size;
    }

    /**
     * returns the no. of yellow boxes
     * @return yellowCount no. of yellow boxes
     */
    public int getYellowCount() {
        return yellowCount;
    }

    /**
     * returns the no. of blue boxes
     * @return yellowCount no. of blue boxes
     */
    public int getBlueCount() {
        return blueCount;
    }

    /**
     * returns the no. of brown boxes
     * @return yellowCount np. of brown boxes
     */
    public int getBrownCount() {
        return brownCount;
    }

    /**
     * Checks if the Inventory method is empty
     * @return true if the list is empty, false otherwise
     */
    public boolean isEmpty() {
        if (head == null && tail == null && size == 0) {
            return true;
        }
        return false;
    }

    /**
     * Clears the entire inventory list.
     */
    public void clear() {
        head = null;
        tail = null;
        size = 0;
        yellowCount = 0;
        blueCount = 0;
        brownCount = 0;
    }

    /**
     * Adds brown box to the end of inventory list
     * @param brownBox the Brown box to be added
     */
    public void addBrown(Box brownBox) {
        if (brownBox.getColor() != Color.BROWN) {
            throw new IllegalArgumentException("Error : The box provided is not brown.");
        }

        LinkedBox linkedBox = new LinkedBox(brownBox);

        if (head == null) {
            head = linkedBox;
            tail = linkedBox;
        } else {
            tail.setNext(linkedBox);
            tail = linkedBox;
        }

        size++;
        brownCount++;
    }

    /**
     * Adds yellow box to the start of inventory list
     * @param yellowBox the yellow box to be added
     */
    public void addYellow(Box yellowBox) {
        if (yellowBox.getColor() != Color.YELLOW) {
            throw new IllegalArgumentException("Error : The box provided is not yellow.");
        }

        if (head == null) {
            LinkedBox linkedBox = new LinkedBox(yellowBox);
            head = linkedBox;
            tail = linkedBox;
        } else {
            LinkedBox linkedBox = new LinkedBox(yellowBox, head);
            head = linkedBox;

        }

        size++;
        yellowCount++;
    }

    /**
     * Adds blue box at the position of yellowCount.
     * @param blueBox the blue box to be added
     */
    public void addBlue(Box blueBox) {

        if (blueBox.getColor() != Color.BLUE) {
            throw new IllegalArgumentException("Error : The box provided is not yellow.");
        }

        LinkedBox linkedBox = new LinkedBox(blueBox);

        if (head == null) {
            head = linkedBox;
            tail = linkedBox;

        } else {
            if (getYellowCount() == 0){
                linkedBox.setNext(head);
                head = linkedBox;
            }
            else if (tail.getBox().getColor() == Color.YELLOW) {
                tail.setNext(linkedBox);
                tail = linkedBox;

            } else if (head.getBox().getColor() == Color.BROWN) {
                LinkedBox temp = head;
                head = linkedBox;
                head.setNext(temp);

            } else {
                LinkedBox current = head;
                LinkedBox temp = head;
                int count = 0;

                while (current != null && count != getYellowCount()) {
                    temp = current;
                    current = current.getNext();
                    count++;

                }
                temp.setNext(linkedBox);
                linkedBox.setNext(current);

                if (linkedBox.getNext() == null) {
                    tail = linkedBox;
                }
            }
        }

        size++;
        blueCount++;

    }

    /**
     * Returns the box from the inventory list for the specified index
     * @param index The index of box to be removed.
     * @return the box ot be found, null if not found
     */
    public Box get(int index) {
        if (index < 0 || index >= size()) {
            throw new IllegalArgumentException("Error : Index out of bound.");
        }
        LinkedBox current = head;
        int count = 0;

        while (current != null) {
            if (count == index) {
                return current.getBox();
            }
            current = current.getNext();
            count++;
        }
        return null;
    }

    /**
     * Removes the yellow box from the start of the inventory list.
     * @return yellowBox the box which was removed
     */
    public Box removeYellow() {
        if (getYellowCount() == 0) {
            throw new NoSuchElementException("No Yellow Boxes Exist.");
        }
        if (head.getBox().getColor() == Color.YELLOW) {
            Box temp = head.getBox();
            if (head != tail) {
                head = head.getNext();
            } else {
                head = null;
                tail = null;
            }
            size--;
            yellowCount--;
            return temp;
        }
        System.out.println("Error : Yellow box is not available at the head of the inventory.");
        return null;
    }

    /**
     * Removes the brown box from the end of the inventory list.
     * @return brownBox the box which was removed
     */
    public Box removeBrown() {
        if (getBrownCount() == 0) {
            throw new NoSuchElementException("No Brown Boxes Exist.");
        }
        if (tail.getBox().getColor() == Color.BROWN) {
            Box temp = tail.getBox();
            if (head != tail) {
                LinkedBox current = head;
                while (current.getNext() != tail) {
                    current = current.getNext();
                }
                tail = current;
                tail.setNext(null);
            } else {
                head = null;
                tail = null;
            }
            size--;
            brownCount--;
            return temp;
        }
        System.out.println("Error : Brown box is not available at the head of the inventory.");
        return null;
    }

    /**
     * Removes the box for a given inventory no.
     * @return box the box which was removed
     */
    public Box removeBox(int inventoryNumber) {

        LinkedBox current = head;
        LinkedBox temp = null;
        while (current != null) {
            if (current.getBox().getInventoryNumber() == inventoryNumber) {
                if (current == head) {
                    head = head.getNext();
                    if (current == tail) {
                        tail = null;
                    }
                } else {
                    temp.setNext(current.getNext());
                    if (current == tail) {
                        tail = temp;
                    }
                }
                if (current.getBox().getColor() == Color.BLUE) {
                    blueCount--;
                }
                if (current.getBox().getColor() == Color.BROWN) {
                    brownCount--;
                }
                if (current.getBox().getColor() == Color.YELLOW) {
                    yellowCount--;
                }
                size--;
                return current.getBox();
            } else {
                temp = current;
                current = current.getNext();
            }
        }
        throw new NoSuchElementException("Error : No box with the provided inventory " +
                "number exist.");
    }

    /**
     * Override method to print the inventory list.
     * @return output the inventory list in string format to be printed.
     */
    public String toString() {
        LinkedBox current = head;
        String output = "";
        if (isEmpty()) {
            return output;
        }
        while (current != null) {
            output += current.toString();
            current = current.getNext();
        }
        return output;
    }
}

















