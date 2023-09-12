/**
 * Class RollTheDice
 * Generate a frame which will store an image of the dice and a button to roll the dice (1 to 6).
 *
 * Credits assets :
 * - Dices image : Mike Zuidgeest on Flaticon (https://www.flaticon.com/authors/mike-zuidgeest)
 * - Dice icon : smashingstocks on Flaticon (https://www.flaticon.com/authors/smashingstocks)
 *
 * @author SOLAN Tao & KOCOGLU Lucas
 * @version N/A
 * @since 2023-09-08
 */

package RollTheDice;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class RollTheDice extends JFrame {

    // Window size
    private final int WINDOW_WIDTH = 275;
    private final int WINDOW_HEIGHT = 166;

    private JButton rollTheDiceButton; // Button to roll the dice
    private ImageIcon[] diceImages; // Array of dices images
    private JLabel diceLabel; // Label to store the image

    /**
     * Constructor of the class RollTheDice
     * It set the frame parameters and load dices images, add an ActionListener and display the frame
     */
    public RollTheDice() {
        // Frame Parameters : Title, window size, close operation and initial location of the window.
        setTitle("Roll the dice !");
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Store the path of images into the array diceImages
        diceImages = new ImageIcon[6]; // Array of six ImageIcon
        for (int i = 0; i < 6; i++) {
            // Images names is set to the dice number (ex: 1 -> dice1.png), images are stored into 'assets/png/diceX.png'
            diceImages[i] = new ImageIcon(getClass().getResource("assets/png/dice" + (i + 1) + ".png"));
        }

        // Settings of labels & buttons
        diceLabel = new JLabel("Please roll", SwingConstants.CENTER);
        diceLabel.setPreferredSize(new Dimension(128, 128));
        rollTheDiceButton = new JButton("Roll the Dice !");

        // Action Listener, when the user click on the rollTheDiceButton, launch rollDice() function.
        rollTheDiceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rollDice();
            }
        });

        // Display the frame
        setLayout(new FlowLayout());
        add(diceLabel);
        add(rollTheDiceButton);
        setVisible(true);
    }

    /**
     * Function rollDice
     * Will instantiate a variable from Random class
     * Store a random number between 1 to 6
     * Set the Image to the diceLabel (and remove its text)
     * And resize the window to match the label size (by default, no needed because WINDOW_WIDTH/WINDOW_HEIGHT)
     *  already at the good size.
     */
    private void rollDice() {
        // Instantiate random variable to generate the dice number
        Random random = new Random();
        int dice1Value = random.nextInt(6);

        // Catch the dice from diceImages(Array) and reshape the image to a 128*128 size.
        diceLabel.setIcon(new ImageIcon(diceImages[dice1Value].getImage().getScaledInstance(128, 128, Image.SCALE_DEFAULT)));
        diceLabel.setText(null);

        // Pack will resize the window to match labels max width/height.
        pack();
    }
}
