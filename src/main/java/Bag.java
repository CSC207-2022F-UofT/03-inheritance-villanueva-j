/*
 * This file defines an abstract class named Bag.
 * In this exercise, you will be writing a larger class according to
 * the TODOs we have left you. You may find the readings in chapter
 * 1. Introduction to Java helpful.
 */

public abstract class Bag {
    /*
     * TODO: Create the following private instance variables
     *       - a String named color
     *       - an int named numberOfContents
     *       - an int named capacity
     *       - an array of Strings named contents
     */
    private String color;
    private int numberOfContents;
    private int capacity;
    private String[] contents;


    /**
     * TODO
     * Creates a new Bag with indicated color and capacity. numberOfContents is 0 and contents is an empty String array.
     *
     * @param bag_colour the color of this Bag
     * @param bag_capacity the capacity of this Bag
     */
    public Bag(String bag_colour, int bag_capacity){
        this.color = bag_colour;
        this.capacity = bag_capacity;
        this.numberOfContents = 0;
        this.contents = new String[]{};
    }


    /**
     * TODO
     * @return the color of this Bag
     */
    public String getColor(){
        return color;
    }


    /**
     * TODO
     * @return the number of items in this Bag
     */
    public int getNumberOfContents() {
        return numberOfContents;
    }


    /**
     * TODO
     * @return the capacity of this Bag
     */
    public int getCapacity() {
        return capacity;
    }


    /**
     * TODO
     * Sets the color of this bag to the given color.
     *
     * @param new_color the new color of this Bag
     */
    public void setColor(String new_color){
        color = new_color;
    }


    /**
     * TODO
     * This method takes one String argument representing an item to be added to the Bag. If this.numberOfContents <
     * this.capacity, then the item is added to this Bag. this.contents and this.numberOfContents are adjusted
     * accordingly.
     *
     * @param item an item to be added to Bag.
     * @return true if item was added, false if it was not
     */
    public boolean addItem(String item){
        if (numberOfContents < capacity){
            String[] updated = new String[numberOfContents + 1];
            System.arraycopy(contents, 0, updated, 0, numberOfContents);
            updated[numberOfContents] = item;
            contents = updated;
            numberOfContents += 1;
            return true;
        }
        return false;
    }


    /**
     * TODO
     * Removes the last item added to this Bag, if it exists. Modifies numberOfContents accordingly.
     * If there are no items in this Bag, return null.
     *
     * @return the item removed, or null if no item was removed.
     */
    public String popItem(){
        // check if bag has items in it
        if (!(numberOfContents == 0)){
            String removed = contents[numberOfContents - 1];
            String[] updated = new String[numberOfContents - 1];
            System.arraycopy(contents, 0, updated, 0, numberOfContents - 1);
            contents = updated;
            numberOfContents -= 1;
            return removed;
        }
        // if yes, then remove item in last index
        return null;
        // if no, return null
    }

    /**
     * Increase this bag's capacity by n.
     *
     * @param n the amount to increase this Bag's capacity by
     */
    public void increaseCapacity(int n) {
        // TODO: Implement this method.
        capacity += n;
    }

    /**
     * Return the details of this Bag.
     * This method requires you to have created the private
     * instance variables mentioned above.
     *
     * @return string representation of this Bag
     */
    @Override
    public String toString() {
        return this.color + " Bag (" + this.numberOfContents + " / " +
                this.capacity + ")";
    }

    /*
     * Below we have defined an abstract method.
     * This method takes no arguments and does not return anything.
     * It increases the capacity of this Bag.
     *
     * You will need to implement this method in
     * HandBag.java and CrossbodyBag.java.
     *
     * We recommend you look at HandBag.java first.
     */
    public abstract void enhance();

}