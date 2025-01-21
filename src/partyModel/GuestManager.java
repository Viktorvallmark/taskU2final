package partyModel;

/* Author: Viktor Vallmark
 * Computer id: aq2560
 * Program: Datateknik
 *
 *
 *
 * */

import javax.swing.*;

public class GuestManager {
  /*
   * Keep ONLY the following instance variables for the class:
   * - number of guests currently stored in the list/array
   * (not the total possible number of guests (use .length for this))
   * - one array for the list with guests where
   * the guests are objects of class Guest
   */
  private int nbrOfGuests = 0;
  private Guest[] guestList;

  /*
   * Create a constructor with one parameter which is
   * the max number of elements (guests) in the list/array.
   * Create the array with the max number of elements.
   * Check that the max number of Guests is larger than 0.
   * If max number of guests is not larger than 0 ask the user to give a new
   * value until you get a value that is larger than 0.
   */

  public GuestManager(int maxNbrOfGuests) {
    boolean flag = true;
    if (maxNbrOfGuests > 0) {

      guestList = new Guest[maxNbrOfGuests];

    }else {
      //TODO: Implement something similar with the while loop from MainProgram
      while(flag){
        String temp = String.valueOf(JOptionPane.showInputDialog("Can't enter guest list length below 1"));
        if (temp.matches("-?\0?\\d+")){
          int tempInt = Integer.parseInt(temp);
            if (!temp.equals("null") && (tempInt != 0)) {

                guestList = new Guest[tempInt];

            }
            flag = false;
        }
      }
    }
  }

  /*
   * A method that returns the number of guests stored in
   * the guest list.
   */
  public int getNbrOfGuests() {
    return nbrOfGuests;
  }

  /*
   * Create a method to add a guest to the list with all the parameters
   * matching instance variables of Guest and Address.
   * In the method create a new Guest-object and let classes Guest and Address
   * take care of issues with values of the parameters.
   * Add the new Guest-object to the array at the first empty element (here is
   * where you use the instance variable for number of guests stored in the list).
   * If there are no more empty elements call a private method in GuestManager to
   * increase the size of the array and then add the new Guest-object. Do not
   * forget to update the value of the instance variable for number of guests in
   * the list.
   */

  public void addGuest(
      String firstName,
      String lastName,
      int age,
      String street,
      String city,
      String zipCode,
      Countries country) {
    Guest temp = new Guest(firstName, lastName, age, street, city, zipCode, country);
    if (nbrOfGuests == guestList.length) {
      increaseGuestList();
    }
    guestList[nbrOfGuests] = temp;
    nbrOfGuests++;
  }

  /*
   * Create method to delete a guest by giving the index in the array
   * for the object (guest) to delete as a parameter to the method.
   * This method should call the private method moveElementsToleft to remove
   * the empty element in between other objects (may not be necessary
   * if the guest removed was the last guest in the list).
   * Remember to update the value of the instance variable for
   * number of guests in the list.
   */
  public boolean deleteGuest(int index) {

    if (index >= guestList.length) {
      return false;
    } else if (guestList[index] == null) {
      moveElementsToLeft(index);
    } else {
      guestList[index] = null;
      moveElementsToLeft(index);
      nbrOfGuests--;
      return true;
    }

    return false;
  }

  private void moveElementsToLeft(int index) {
    /*
     * Add code to remove empty element places that
     * is not att the end of the array. Start at
     * the parameter index that is the empty element
     * whose gap we want to fill.
     *
     * You are not allowed to take a short cut by using class Array or similar
     * from a Java-library.
     */
    for (int i = index; i < guestList.length - 1; i++) {
      guestList[i] = guestList[i+1];
    }
    guestList[guestList.length-1] = null;
  }

  private void increaseGuestList() {
    /*
     * Write code that creates a new array of Guest-objects
     * that is 10 elements larger that the current array instance variable .
     *
     * Copy the current array to the larger array and after that is done
     * point the instance variable to the new array.
     *
     * You are not allowed to take a short cut by using class Array or similar
     * from a Java-library.
     */

    Guest[] newArr = new Guest[guestList.length + 10];

    for (int i = 0; i < guestList.length; i++) {
      newArr[i] = guestList[i];
    }
    this.guestList = newArr;

  }

  /*
   * A method that returns the Guest-object at the given
   * index n the parameter.
   */
  public Guest getGuestAt(int index) {
    /*
     * Add code to check that the parameter index
     * has a value within the range of the array.
     * If index is not in valid range return null.
     * Yes, some checks are done in the Controller-object
     * in this program but we do not want this class to depend
     * on other classes for this, so sometimes we write redundant
     * error handling in different ways to have more robust classes or code.
     */

    if ((index < guestList.length) && (index >= 0)) {
      return guestList[index];
    } else {
      return null;
    }
  }

  public String[] getInfoStrings() {
    /*
     * Write code that returns an array of strings where each element
     * represents information about one guest in the list by calling every
     * Guest-object's toString method.
     *
     * The number of elements in the array should be equal to the
     * number of guests currently stored in the list.
     * (no strings should be created for empty places at the end of the array
     * st)
     */
    String[] infoStrings = new String[guestList.length];
    for (int i = 0; i < guestList.length; i++) {

      if (guestList[i] != null) {

        infoStrings[i] = guestList[i].toString();
      }
    }

    return infoStrings;
  }

  public String getStatistics() {
    /*
     * Write code that calculates the following statistics and returns these as
     * a formatted String using line breaks for each statistic.
     * - total number of guests
     * - number of adults where an adult guest is someone over the age of 13
     * - number of children where a child is someone age 13 or younger
     * - the name and age of the oldest guest
     * - the name and age of the youngest guest
     *
     * If there are no guests in the guest list return a string that
     * informs the user of this.
     */

    int adultGuest = 0;
    int childGuest = 0;
    int indexOldest = 0;
    int indexYoung = 0;

    if (guestList[0] == null){
      return "No guests in the guest list!";
    }else {
      for (int i = 0; i < guestList.length; i++) {
        if (guestList[i] != null) {
          if (guestList[i].getAge() > 13) {
            adultGuest++;
          } else {
            childGuest++;
          }
          if (guestList[i].getAge() > guestList[indexOldest].getAge()) {
            indexOldest = i;
          }

          if (guestList[i].getAge() < guestList[indexYoung].getAge()) {
            indexYoung = i;
          }
        }else {

        }
      }
    }

    // This return statement is just used for the code template. Erase and
    // replace with code for calculating the statistics as asked for above.
    return ("Number of guests: "
        + nbrOfGuests
        + "\n"
        + "Number of adults: "
        + adultGuest
        + "\n"
        + "Number of children: "
        + childGuest
        + "\n"
        + "Oldest guest: "
        + getGuestAt(indexOldest).getFirstName() +" "+ getGuestAt(indexOldest).getLastName()+" of age "+getGuestAt(indexOldest).getAge()
        + "\n"
        + "Youngest guest: "
        + getGuestAt(indexYoung).getFirstName()+" "+ getGuestAt(indexOldest).getLastName()+" of age "+getGuestAt(indexOldest).getAge());
  }
}
