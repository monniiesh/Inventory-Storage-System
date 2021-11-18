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

/**
 * The class which has LinkedBox methods
 */
public class LinkedBox {

    private Box box;
    private LinkedBox next;

    /**
     * Constructor method of linkedBox
     * @param box the box which is added
     */
    public LinkedBox (Box box){
        this.box = box;
        next = null;
    }

    /**
     * Constructor method of linkedBox
     * @param box the box which is added
     * @param next the has the position for the next box
     */
    public LinkedBox (Box box, LinkedBox next){
        this.box = box;
        this.next = next;
    }

    /**
     * Returns teh box at the given linked Box
     * @return box the box for the given linked box
     */
    public Box getBox(){
        return box;
    }

    /**
     * Returns the next box of the given box
     * @return box the box for the given linked box
     */
    public LinkedBox getNext(){
        return next;
    }

    /**
     * Sets the next for the given Box
     * @param next
     */
    public void setNext(LinkedBox next){
        this.next = next;
    }

    /**
     * Override method to print the given linked box
     * @return the string format of the given linked box
     */
    public String toString(){

        if (next == null){
            return box.toString() + " -> END";
        }
        return box.toString() + " -> ";
    }

}
