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

        int numInt;
        boolean flag = true;
        while (flag) {
        String num = String.valueOf(JOptionPane.showInputDialog("Enter amount of people in the guest list"));
        numInt = Integer.parseInt(num);

/*
            if (num.matches("\\d+")) {

                numInt = Integer.parseInt(num);
                flag = false;

                Controller controller = new Controller(numInt);
            }
            if (num.equals("null")) {
                flag = false;
            }
        }
        */
        Controller controller = new Controller(numInt);
        flag = false;
    }
}
}
