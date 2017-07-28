package SickBombz;//Created by Paul on 4/11/2017.

//appropriate classes for import
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.lang.*;

//Start Frame class which is where you input your name
public class EndFrame extends JFrame implements ActionListener {
    DrawArea mainImg; //main image for start screen, type of JPanel
    DrawArea title;
    DrawArea bomb1;

    private JLayeredPane lpane; //for adding the main panel

    private JButton menu;
    private JPanel resultsPanel;

    private JTextArea results;

    public EndFrame (String player1Name, String player2Name){ //the constructor for the frame
        //initialize the variables for the text
        lpane = new JLayeredPane(); //initialize the layered pane which
        menu = new JButton("Menu");
        results = new JTextArea();
        resultsPanel = new JPanel(new GridBagLayout());

        GridBagConstraints c = new GridBagConstraints();

        results.setText(player1Name + " IS THE WINNER!\n" + player2Name + " IS THE LOSER!");
        results.setEditable(false);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weighty = 0.2; c.gridy = 1; c.gridx = 5; resultsPanel.add(results, c); //add the button
        c.weighty = 0.2; c.gridy = 2; c.gridx = 5; resultsPanel.add(menu, c); //add the button

        //main panel initialization
        mainImg = new DrawArea(1000, 500, "endImg.jpg"); //initialize the image
        title = new DrawArea (400, 70, "gameover.png");
        bomb1 = new DrawArea (206, 180, "bomb.png");

        //ActionListener for the button to go back to start frame
        menu.addActionListener(this);
        menu.setActionCommand("Menu");

        //locations and dimensions for each of the GUI variables
        resultsPanel.setOpaque(false);
        resultsPanel.setBounds(360, 210, 300, 200);
        mainImg.setBounds(0, 0, 1000,    500); //image bounds
        title.setBounds(300, 100, 400, 70);
        bomb1.setBounds(730, 30, 206, 180);
        lpane.setBounds(0, 0, 1000, 500); //the layered pane bounds

        lpane.add(mainImg, 0, 0);
        lpane.add(resultsPanel, 1, 0);
        lpane.add(title, 1, 0);
        lpane.add(bomb1, 1, 0);

        add(lpane, "Center"); //add lpane to the middle

        //4. Window configuration
        pack ();
        setTitle ("Sick Bombz"); //title at the top
        setSize(1000,500); //size of the frame
        setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE); //close when pressed close
        setResizable(false); //cannot resize
        setLocationRelativeTo (null); //centers the window
    }

    //when button is pressed
    public void actionPerformed(ActionEvent e){
        this.dispose(); //close the frame when the user presses play

        StartFrame start = new StartFrame(); //create another start frame
        start.setVisible(true);
    }
}