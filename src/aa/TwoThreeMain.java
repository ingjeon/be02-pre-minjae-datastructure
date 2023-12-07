package aa;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author swapnil
 */
public class TwoThreeMain {
    public static void main(String[] args) throws IOException {
        // Reading input from file
        Scanner sc = new Scanner(new File("src/aa/Data-set/data1.txt"));
        String s;   // To capture line from file

        // Creating a new 2-3 tree
        TwoThreeTree tree = new TwoThreeTree();

        // File Processing starts here
        OUTER:
        while (true) {

            // Read line from file
            s = sc.nextLine();
            // Split commands and values
            String[] tokens = s.split(" ");
            String command = tokens[0];

            switch (command) {
                // Case Insert
                case "I": {
                    // Get value to be inserted
                    int value = Integer.parseInt(tokens[1]);
                    // Try to insert the value and return result                    
                    boolean success = tree.insert(value);
                    if (success) {
                        // If the value was inserted
                        System.out.printf("Key %s inserted\n", value);
                    } else {
                        // If insertion fails
                        System.out.printf("Key %s already exists\n", value);
                    } // end of if else
                    break;
                } // end of case I


                // Case BFSList
                case "B":
                    // Print keys in level Order
                    tree.bfsList();
                    break;

                // Case Height


                // Case number of nodes


                // Case end
                case "E":
                    // Break the loop
                    break OUTER;
                default:
                    break;
            } // switch ends here
        } // end of while loop

        

    } // end of main
}
