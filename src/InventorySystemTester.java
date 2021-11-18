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
 * Tester Methods for InventoryList and LinkedBox
 */
public class InventorySystemTester {
    /**
     * Main Method.
     * @param args
     */
    public static void main(String[] args) {
        if (runAllTests() == true){
            System.out.println("All Tests Passed.");
        }

    }
    /**
     * Helper method to display the size and the count of different boxes stored in a list of boxes
     * @param list a reference to an InventoryList object
     * @throws NullPointerException if list is null
     */
    private static void displaySizeCounts(InventoryList list) {
        System.out.println("  Size: " + list.size() +
                ", yellowCount: " + list.getYellowCount() +
                ", blueCount: " + list.getBlueCount() +
                ", brownCount: " + list.getBrownCount());
    }

    /**
     * Demo Method
     */
    public static void demo2(){
        InventoryList list = new InventoryList();

        list.addBlue(new Box(Color.BLUE));
        System.out.println(list); // prints list's content
        displaySizeCounts(list);
        list.addBlue(new Box(Color.BLUE));
        System.out.println(list); // prints list's content
        displaySizeCounts(list);
        list.addBlue(new Box(Color.BLUE));
        System.out.println(list); // prints list's content
        displaySizeCounts(list);
        list.addBrown(new Box(Color.BROWN));
        System.out.println(list); // prints list's content
        displaySizeCounts(list);
        list.addYellow(new Box(Color.YELLOW));
        System.out.println(list); // prints list's content
        displaySizeCounts(list);


    }
    /**
     * Demo method showing how to use the implemented classes in P07 Inventory Storage System
     */
    public static void demo() {
        // Create a new empty InventoryList object
        InventoryList list = new InventoryList();
        System.out.println(list); // prints list's content
        displaySizeCounts(list); // displays list's size and counts
        // Add a blue box to an empty list
        list.addBlue(new Box(Color.BLUE)); // adds BLUE 1
        System.out.println(list); // prints list's content
        list.addYellow(new Box(Color.YELLOW)); // adds YELLOW 2 at the head of the list
        System.out.println(list); // prints list's content
        list.addBlue(new Box(Color.BLUE)); // adds BLUE 3
        System.out.println(list); // prints list's content
        list.addYellow(new Box(Color.YELLOW)); // adds YELLOW 4
        System.out.println(list); // prints list's content
        list.addYellow(new Box(Color.YELLOW)); // adds YELLOW 5 at the head of the list
        System.out.println(list); // prints list's content
        displaySizeCounts(list); // displays list's size and counts
        // Add more boxes to list and display its contents
        list.addBrown(new Box(Color.BROWN)); // adds  BROWN 6 at the end of the list
        System.out.println(list); // prints list's content
        displaySizeCounts(list); // displays list's size and counts
        list.addBrown(new Box(Color.BROWN)); // adds BROWN 7 at the end of the list
        System.out.println(list); // prints list's content
        displaySizeCounts(list); // displays list's size and counts
        list.removeBrown(); // removes BROWN 7 from the list
        System.out.println(list); // prints list's content
        displaySizeCounts(list); // displays list's size and counts
        list.addBlue(new Box(Color.BLUE)); // adds BLUE 8
        System.out.println(list); // prints list's content
        displaySizeCounts(list); // displays list's size and counts
        list.removeBrown(); // removes BROWN 6 from the list
        System.out.println(list); // prints list's content
        displaySizeCounts(list); // displays list's size and counts
        list.removeYellow(); // removes YELLOW 5
        System.out.println(list); // prints list's content
        list.removeBox(3); // removes BLUE 3 from the list
        System.out.println(list); // prints list's content
        displaySizeCounts(list); // displays list's size and counts
        try {
            list.removeBox(25); // tries to remove box #25
        }
        catch(NoSuchElementException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(list); // prints list's content
        displaySizeCounts(list); // displays list's size and counts
        // remove all yellow boxes
        while(list.getYellowCount() != 0) {
            list.removeYellow();
        }
        System.out.println(list); // prints list's content
        displaySizeCounts(list); // displays list's size and counts
        list.removeBox(1); // removes BLUE 1 from the list -> empty list
        System.out.println(list); // prints list's content
        displaySizeCounts(list); // displays list's size and counts
        list.addBrown(new Box(Color.BROWN)); // adds BROWN 9 to the list
        System.out.println(list); // prints list's content
        displaySizeCounts(list); // displays list's size and counts
        list.removeBox(8); // removes BLUE 8 from the list
        System.out.println(list); // prints list's content
        displaySizeCounts(list); // displays list's size and counts
        list.removeBrown(); // removes BROWN 9 from the list
        System.out.println(list); // prints list's content
        displaySizeCounts(list); // displays list's size and counts
        list.addYellow(new Box(Color.YELLOW)); // adds YELLOW 10 to the list
        System.out.println(list); // prints list's content
        displaySizeCounts(list); // displays list's size and counts
        list.removeBox(10); // removes YELLOW 10 from the list
        System.out.println(list); // prints list's content
        displaySizeCounts(list); // displays list's size and counts
    }

    /**
     * Tester method for LinkedBox
     * @return true if the tests are passed, false otherwise
     */
    public static boolean testLinkedBox(){


        Boolean test1 = false;
        Boolean test2 = false;
        Boolean test3 = false;
        Boolean test4 = false;
        Boolean test5;
        Boolean test6;

        {
            Box box = new Box(Color.YELLOW);
            LinkedBox linkedBox = new LinkedBox(box);
        }

        //Get
        {
            Box testBox = new Box(Color.BLUE);
            LinkedBox testLinkedBox = new LinkedBox(testBox);
            if (testLinkedBox.getBox() == testBox) {
                test1 = true;
            } else {
                System.out.println("Error : getBox did not produce the expected output.");
            }
        }

        //getNext
        {
            Box testBox = new Box(Color.BLUE);
            LinkedBox testLinkBox1 = new LinkedBox(new Box(Color.YELLOW));
            LinkedBox testLinkBox2 = new LinkedBox(testBox, testLinkBox1);
            if (testLinkBox2.getNext() == testLinkBox1){
                test2 = true;
            }
            else {
                System.out.println("Error : getNext() did not produce expected output.");
            }
        }

        //setNext
        {
            Box testBox = new Box(Color.BLUE);
            LinkedBox testLinkBox0 = new LinkedBox(new Box(Color.BROWN));
            LinkedBox testLinkBox1 = new LinkedBox(new Box(Color.YELLOW));
            LinkedBox testLinkBox2 = new LinkedBox(testBox, testLinkBox0);
            testLinkBox2.setNext(testLinkBox1);
            if (testLinkBox2.getNext() == testLinkBox1){
                test3 = true;
            }
            else {
                System.out.println("Error : setNext() did not perform the expected operation.");
            }
        }

        //toString
        {
            boolean test4_1 = false;
            boolean test4_2 = false;
            Box box1 = new Box(Color.BLUE);
            Box box2 = new Box(Color.BROWN);
            LinkedBox testLinkedBox1 = new LinkedBox(box1);
            String expectedOutput1 = box1.toString() + " -> END";
            String expectedOutput2 = box2.toString() + " -> ";
            LinkedBox testLinkedBox2 = new LinkedBox(box2, testLinkedBox1);
            if (testLinkedBox1.toString().equals(expectedOutput1)){
                test4_1 = true;
            }
            else{
                System.out.println("ERROR : Expected Output : " + expectedOutput1 +
                        " Actual Output : " + testLinkedBox1);
            }
            if (testLinkedBox2.toString().equals(expectedOutput2)){
                test4_2 = true;
            }
            else{
                System.out.println("ERROR : Expected Output : " + expectedOutput2 +
                        " Actual Output : " + testLinkedBox2);
            }
            if (test4_1 == true && test4_2 == true){
                test4 = true;
            }
        }

        {
            test5 = true;

            Box box = new Box(Color.YELLOW);
            LinkedBox linkedBox = new LinkedBox(box);

            if (!(linkedBox.getBox() == box)){
                System.out.println("Error : Error in initializing of constructor. ");
                test5 = false;
            }

        }
        {
            test6 = true;

            Box box = new Box(Color.YELLOW);
            Box boxNext = new Box(Color.BLUE);

            LinkedBox linkedBoxNext = new LinkedBox(boxNext);
            LinkedBox linkedBox = new LinkedBox(box, linkedBoxNext);

            if (linkedBox.getBox() != box && linkedBox.getNext() != linkedBoxNext){
                System.out.println("Error : Error in initializing of constructor. ");
                test6 = false;
            }

        }

        if (test1 == true && test2 == true && test3 == true && test4 == true && test5 == true && test6 == true){
            System.out.println("All tests passed for LinkedBox.");
            return true;
        }
        return false;
    }

    /**
     * Tester method for clear method of InventoryList
     * @return true if the tests are passed, false otherwise
     */
    public static boolean testClear(){

        InventoryList list = new InventoryList();

        list.addBlue(new Box(Color.BLUE));
        list.addYellow(new Box(Color.YELLOW));
        list.addBrown(new Box(Color.BROWN));

        list.clear();

        if (list.size() != 0 && list.getBlueCount() != 0 && list.getBrownCount() != 0
                && list.getYellowCount() != 0){
            System.out.println("Error : The Inventory has not been cleared.");
        }

        System.out.println("testClear method passed.");
        return true;
    }

    /**
     * Tester method for addBoxes method of InventoryList
     * @return true if the tests are passed, false otherwise
     */
    public static boolean testAddBoxes(){

        boolean test1;
        boolean test2;
        boolean test3;
        boolean test4;
        boolean test5;
        boolean test6;
        boolean test7;
        boolean test8;
        boolean test9;
        boolean test10;

        // test 1
        {
            test1 = true;
            InventoryList list = new InventoryList();

            Box box = new Box(Color.YELLOW);
            list.addYellow(box);
            String expectedOutput = box.toString() + " -> END";
            if (!expectedOutput.equals(list.toString())){
                System.out.println("Error : Expected Output : " + expectedOutput +
                        " Actual Output : " + list.toString());
                test1 = false;
            }
            if (list.getYellowCount() != 1){
                System.out.println("Error : Size has not been updated.");
            }
        }

        // test 2
        {
            test2 = true;
            InventoryList list = new InventoryList();

            Box box1 = new Box(Color.YELLOW);
            Box box2 = new Box(Color.YELLOW);

            list.addYellow(box1);
            list.addYellow(box2);
            String expectedOutput = box2.toString() + " -> " + box1.toString() + " -> END";
            if (!expectedOutput.equals(list.toString())){
                System.out.println("Error : Expected Output : " + expectedOutput +
                        " Actual Output : " + list.toString());
                test2 = false;
            }
            if (list.getYellowCount() != 2){
                System.out.println("Error : Size has not been updated.");
            }
        }

        // test 3
        {
            test3 = true;
            InventoryList list = new InventoryList();

            Box box1 = new Box(Color.BROWN);
            Box box2 = new Box(Color.BROWN);

            list.addBrown(box1);
            list.addBrown(box2);
            String expectedOutput = box1.toString() + " -> " + box2.toString() + " -> END";
            if (!expectedOutput.equals(list.toString())){
                System.out.println("Error : Expected Output : " + expectedOutput +
                        " Actual Output : " + list.toString());
                test3 = false;
            }
            if (list.getBrownCount() != 2){
                System.out.println("Error : Size has not been updated.");
            }
        }

        // test 4
        {
            test4 = true;
            InventoryList list = new InventoryList();

            Box box = new Box(Color.BROWN);
            list.addBrown(box);
            String expectedOutput = box.toString() + " -> END";
            if (!expectedOutput.equals(list.toString())){
                System.out.println("Error : Expected Output : " + expectedOutput +
                        " Actual Output : " + list.toString());
                test4 = false;
            }
            if (list.getBrownCount() != 1){
                System.out.println("Error : Size has not been updated.");
            }
        }

        // test 5
        {
            test5 = true;
            InventoryList list = new InventoryList();
            Box box = new Box(Color.BLUE);
            list.addBlue(box);
            String expectedOutput = box.toString() + " -> END";
            if (!expectedOutput.equals(list.toString())){
                System.out.println("Error : Expected Output : " + expectedOutput +
                        " Actual Output : " + list.toString());
                test5 = false;
            }
            if (list.getBlueCount() != 1){
                System.out.println("Error : Size has not been updated.");
            }
        }

        // test 6
        {
            test6 = true;
            InventoryList list = new InventoryList();

            Box box1 = new Box(Color.BLUE);
            Box box2 = new Box(Color.BLUE);

            list.addBlue(box1);
            list.addBlue(box2);

            String expectedOutput = box2.toString() + " -> " + box1.toString() + " -> END";
            if (!expectedOutput.equals(list.toString())){
                System.out.println("Error : Expected Output : " + expectedOutput +
                        " Actual Output : " + list.toString());
                test6 = false;
            }
            if (list.getBlueCount() != 2){
                System.out.println("Error : Size has not been updated.");
            }
        }

        // test 7
        {
            test7 = false;
            InventoryList list = new InventoryList();
            try{
                list.addBrown(new Box(Color.YELLOW));
                System.out.println("Error : Wrong box was added using wrong method.");
            }
            catch (IllegalArgumentException e){
                test7 = true;
            }
        }

        // test 8
        {
            test8 = false;
            InventoryList list = new InventoryList();
            try{
                list.addBlue(new Box(Color.YELLOW));
                System.out.println("Error : Wrong box was added using wrong method.");
            }
            catch (IllegalArgumentException e){
                test8 = true;
            }
        }

        // test 9
        {
            test9 = false;
            InventoryList list = new InventoryList();
            try{
                list.addYellow(new Box(Color.BLUE));
                System.out.println("Error : Wrong box was added using wrong method.");
            }
            catch (IllegalArgumentException e){
                test9 = true;
            }
        }

        // test 10
        {
            test10 = true;
            InventoryList list = new InventoryList();

            Box box1 = new Box(Color.BLUE);
            Box box2 = new Box(Color.YELLOW);
            Box box3 = new Box(Color.BROWN);
            Box box4 = new Box(Color.BLUE);
            Box box5 = new Box(Color.YELLOW);
            Box box6 = new Box(Color.BROWN);
            Box box7 = new Box(Color.BLUE);

            list.addBlue(box1);
            list.addYellow(box2);
            list.addBrown(box3);
            list.addBlue(box4);
            list.addYellow(box5);
            list.addBrown(box6);
            list.addBlue(box7);

            String expectedOutput = box5.toString() + " -> " + box2.toString() + " -> " +
                    box7.toString() + " -> " + box4.toString() + " -> " + box1.toString() +
                    " -> " + box3.toString() + " -> " + box6.toString() + " -> END";
            if (!expectedOutput.equals(list.toString())){
                System.out.println("Error : Expected Output : " + expectedOutput +
                        " Actual Output : " + list.toString());
                test10 = false;
            }
            if (list.getBrownCount() != 2 && list.getBlueCount() != 3 &&
                    list.getBrownCount() != 2 && list.size() != 7){
                System.out.println("Error : Size has not been updated.");
            }
        }

        if ( test1 == true && test2 == true && test3 == true && test4 == true &&
                test5 == true && test6 == true && test7 == true && test8 == true &&
                test9 == true && test10 == true ){
            System.out.println("testAddBox Passed.");
            return true;
        }
        return false;

    }

    /**
     * Tester method for removeBoxes method of InventoryList
     * @return true if the tests are passed, false otherwise
     */
    public static boolean testRemoveBoxes(){

        boolean test1;
        boolean test2;
        boolean test3;
        boolean test4;
        boolean test5;
        boolean test6;
        boolean test7;
        boolean test8;
        boolean test10;

        // test 1
        {
            test1 = true;
            InventoryList list = new InventoryList();

            Box box = new Box(Color.YELLOW);
            list.addYellow(box);
            list.removeYellow();

            String expectedOutput = "";
            if (!expectedOutput.equals(list.toString())){
                System.out.println("Error : Expected Output : " + expectedOutput +
                        " Actual Output : " + list.toString());
                test1 = false;
            }
            if (list.getYellowCount() != 0 && list.size() != 0){
                System.out.println("Error : Size has not been updated.");
            }
        }

        // test 2
        {
            test2 = true;
            InventoryList list = new InventoryList();

            Box box1 = new Box(Color.YELLOW);
            Box box2 = new Box(Color.YELLOW);

            list.addYellow(box1);
            list.addYellow(box2);
            list.removeYellow();

            String expectedOutput = box1.toString() + " -> END";
            if (!expectedOutput.equals(list.toString())){
                System.out.println("Error : Expected Output : " + expectedOutput +
                        " Actual Output : " + list.toString());
                test2 = false;
            }
            if (list.getYellowCount() != 1 && list.size() != 1){
                System.out.println("Error : Size has not been updated.");
            }
        }

        // test 3
        {
            test3 = true;
            InventoryList list = new InventoryList();

            Box box1 = new Box(Color.BROWN);
            Box box2 = new Box(Color.BROWN);

            list.addBrown(box1);
            list.addBrown(box2);
            list.removeBrown();

            String expectedOutput = box1.toString() +  " -> END";
            if (!expectedOutput.equals(list.toString())){

                System.out.println("Error : Expected Output : " + expectedOutput +
                        " Actual Output : " + list.toString());
                test3 = false;
            }
            if (list.getBrownCount() != 1 && list.size() != 1){
                System.out.println("Error : Size has not been updated.");
            }
        }

        // test 4
        {
            test4 = true;
            InventoryList list = new InventoryList();

            Box box = new Box(Color.BROWN);
            list.addBrown(box);
            list.removeBrown();

            String expectedOutput = "";
            if (!expectedOutput.equals(list.toString())){

                System.out.println("Error : Expected Output : " + expectedOutput +
                        " Actual Output : " + list.toString());
                test4 = false;
            }
            if (list.getBrownCount() != 0 && list.size() != 0){
                System.out.println("Error : Size has not been updated.");
            }
        }

        // test 5
        {
            test5 = true;
            InventoryList list = new InventoryList();

            Box box = new Box(Color.BLUE);
            list.addBlue(box);
            list.removeBox(box.getInventoryNumber());

            String expectedOutput = "";
            if (!expectedOutput.equals(list.toString())){
                System.out.println("Error : Expected Output : " + expectedOutput +
                        " Actual Output : " + list.toString());
                test5 = false;
            }
            if (list.getBlueCount() != 0 && list.size() != 0){
                System.out.println("Error : Size has not been updated.");
            }

        }

        // test 6
        {
            test6 = true;
            InventoryList list = new InventoryList();

            Box box1 = new Box(Color.BLUE);
            Box box2 = new Box(Color.BLUE);


            list.addBlue(box1);
            list.addBlue(box2);
            list.removeBox(box1.getInventoryNumber());
            list.removeBox(box2.getInventoryNumber());

            String expectedOutput = "";
            if (!expectedOutput.equals(list.toString())){
                System.out.println("Error : Expected Output : " + expectedOutput +
                        " Actual Output : " + list.toString());
                test6 = false;
            }
            if (list.getBlueCount() != 0 && list.size() != 0){
                System.out.println("Error : Size has not been updated.");
            }
        }

        // test 7
        {
            test7 = false;
            InventoryList list = new InventoryList();
            try{
                list.removeBox(2);
                System.out.println("Error : Exception was not thrown to remove an item" +
                        " that does not exist.");
            }
            catch (NoSuchElementException e){
                test7 = true;
            }
        }

        // test 8
        {
            test8 = false;
            InventoryList list = new InventoryList();
            list.addBlue(new Box(Color.BLUE));
            list.addYellow(new Box(Color.YELLOW));

            try{
                list.removeBox(35);
                System.out.println("Error : Exception was not thrown to remove an item " +
                        "that does not exist.");
            }
            catch (NoSuchElementException e){
                test8 = true;
            }
        }

        // test 10
        {
            test10 = true;
            InventoryList list = new InventoryList();

            Box box1 = new Box(Color.BLUE);
            Box box2 = new Box(Color.YELLOW);
            Box box3 = new Box(Color.BROWN);
            Box box4 = new Box(Color.BLUE);
            Box box5 = new Box(Color.YELLOW);
            Box box6 = new Box(Color.BROWN);
            Box box7 = new Box(Color.BLUE);

            list.addBlue(box1);
            list.addYellow(box2);
            list.addBrown(box3);
            list.addBlue(box4);
            list.addYellow(box5);
            list.addBrown(box6);
            list.addBlue(box7);

            list.removeBox(box6.getInventoryNumber());
            list.removeBox(box3.getInventoryNumber());
            list.removeBox(box5.getInventoryNumber());
            list.removeBox(box4.getInventoryNumber());
            list.removeBox(box2.getInventoryNumber());

            String expectedOutput1 = box7.toString() + " -> " + box1.toString() + " -> END";

            if (!expectedOutput1.equals(list.toString())){
                System.out.println("Error : Expected Output : " + expectedOutput1 +
                        " Actual Output : " + list.toString());
                test10 = false;
            }

            if (list.getBrownCount() != 0 && list.getBlueCount() != 2
                    && list.getBrownCount() != 0 && list.size() != 2){
                System.out.println("Error : Size has not been updated.");
            }

            list.removeBox(box7.getInventoryNumber());
            list.removeBox(box1.getInventoryNumber());

            String expectedOutput2 = "";
            if (!expectedOutput2.equals(list.toString()) && list.getBrownCount() != 0
                    && list.getBlueCount() != 0 && list.getBrownCount() != 0 && list.size() != 0){
                System.out.println("Error : Expected Output : " + expectedOutput2 + " Actual Output : " + list.toString());
                test10 = false;
            }
        }
        if ( test1 == true && test2 == true && test3 == true && test4 == true && test5 == true
                && test6 == true && test7 == true && test8 == true && test10 == true ){
            System.out.println("testRemoveBox Passed.");
            return true;
        }

        return false;
    }

    /**
     * Tester method for get method of InventoryList
     * @return true if the tests are passed, false otherwise
     */
    public static boolean testGetBoxes(){

        Boolean test1 = true;
        Boolean test2 = true;
        Boolean test3 = true;
        Boolean test4 = true;
        Boolean test5 = true;
        Boolean test6 = true;
        Boolean test7 = false;
        Boolean test8 = false;

        InventoryList list = new InventoryList();
        Box box1 = new Box(Color.BLUE);
        Box box2 = new Box(Color.YELLOW);
        Box box3 = new Box(Color.BROWN);
        Box box4 = new Box(Color.BLUE);
        Box box5 = new Box(Color.YELLOW);
        Box box6 = new Box(Color.BROWN);
        Box box7 = new Box(Color.BLUE);

        list.addBlue(box1);
        list.addYellow(box2);
        list.addBrown(box3);
        list.addBlue(box4);
        list.addYellow(box5);
        list.addBrown(box6);
        list.addBlue(box7);

        if (!(list.get(0) == box5)){
            System.out.println("Error : Box at start index not found appropriately.");
            test1 = false;
        }
        if (!(list.get(6) == box6)){
            System.out.println("Error : Box at end index not found appropriately.");
            test2 = false;
        }
        if (!(list.get(3) == box4)){
            System.out.println("Error : Box at index 3 not found appropriately.");
            test3 = false;
        }

        list.removeBrown();
        list.removeYellow();
        list.removeBox(box4.getInventoryNumber());

        if (!(list.get(0) == box2)){
            System.out.println("Error : Box at start index not found appropriately.");
            test4 = false;
        }

        if (!(list.get(3) == box3)){
            System.out.println("Error : Box at end index not found appropriately.");
            test5 = false;
        }

        if (!(list.get(2) == box1)){
            System.out.println("Error : Box at index 2 not found appropriately.");
            test6= false;
        }

        try {
            list.get(-1);
            System.out.println("Error : Index out of bound error not handled.");
        }
        catch (IllegalArgumentException e){
            test7 = true;
        }

        try{
            list.get(list.size());
            System.out.println("Error : Index out of bound error not handled.");
        }
        catch (IllegalArgumentException e){
            test8 = true;
        }
        if ( test1 == true && test2 == true && test3 == true && test4 == true && test5 == true &&
                test6 == true  && test7 == true  && test8 == true){
            System.out.println("testGet Passed.");
            return true;
        }
        return false;
    }
    /**
     * Tester method to rul all tests
     * @return true if the tests are passed, false otherwise
     */
    public static boolean runAllTests(){
        if (testClear() == true && testGetBoxes() == true && testAddBoxes() == true && testRemoveBoxes() == true){
            return true;
        }
        return false;
    }


}




























