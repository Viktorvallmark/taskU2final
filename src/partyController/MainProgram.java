package partyController;

import javax.swing.*;

/* Author: Viktor Vallmark
 * Computer id: aq2560
 * Program: Datateknik
 *
 *
 *
 * */
public class MainProgram {

    public static void main(String[] args) {
        // default value to make compilations
        // possible.
        /*
         * Write code to read the number of guests to start with from the user by
         * using one of
         * - JOptionPane
         * - Scanner and prompt
         */
        int numInt = 0;

        while (numInt <= 0){

            String num = JOptionPane.showInputDialog("Enter amount of people in the guest list").trim();

            numInt = Integer.parseInt(num);
        }

        Controller controller = new Controller(numInt);

    }
}
