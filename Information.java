package SickBombz;//Created by Paul on 6/5/2017.
//Created by Paul on 6/5/2017.

//necessary imports
import java.io.*;
import java.util.*;
import java.lang.*;
import java.math.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.lang.*;

//Information class is a type of JFrame that also implements ActionListener
public class Information extends JFrame implements ActionListener{
    public Information(){
        //initiate variables
        JLayeredPane all = new JLayeredPane(); //the entire panel where stuff is added

        JTextArea textAreaL = new JTextArea(); //left text area for controls
        JTextArea textAreaR = new JTextArea(); //right text area for description
        String left = ""; //to be added to textAreaL
        String right = ""; //to be added to textAreaR

        DrawArea title = new DrawArea(500, 80, "Information.png"); //title
        DrawArea mainImg = new DrawArea(1000, 500, "mainImg.jpg"); //background image

        JButton menu = new JButton("Menu"); //to go back to StartFrame

        //controls displayed on the left side
        left += "Player 2 Controls:\n" +
                "Left: Left Arrow Key\n" +
                "Right: Right Arrow Key\n" +
                "Up: Up Arrow Key\n" +
                "Down: Down Arrow Key\n" +
                "Pant Bombs: Enter\n\n" +
                "Player 1 Controls:\n" +
                "Left: A\n" +
                "Right: D\n" +
                "Up:W\n" +
                "Down: S\n" +
                "Plant Bombs: Space Bar\n";

        //description of the game on the right side
        right += "Player 1 starts at the right bottom corner and Player 2 starts at the top left corner.\n" +
                "The main goal of this game is to kill each other by planting bombs.\n" +
                "Both players can plant bombs and move around using the controls.\n" +
                "The bomb explodes and gives an animation showing how much the explosion extends.\n" +
                "The bomb explodes in 4 seconds. The explosion lasts for 1 second.\n" +
                "If the player is within the explosion range, the player loses 1 life.\n" +
                "When one of the players have 0 lives, the game ends and the opposing player wins.\n" +
                "Loads onto the end screen.\n\n"+
                "There are 3 main different types of blocks.\n" +
                "Wall: You cannot destroy or move past it.\n" +
                "Ground: This is the place where players move around.\n" +
                "Crate: The players cannot move past it, but can be destroyed with bombs.\n" +
                "The crate also stops the bomb explosion from extending further out than the crate.\n" +
                "2 Types of Items:\n" +
                "Add bomb: Player can place 1 more bomb at the same time.\n" +
                "Power Up: Player’s bomb range extends by 1 block in all directions.\n";

        textAreaL.setText(left); //set it as text for left
        textAreaR.setText(right); //set it as text for right

        menu.addActionListener(this);

        //setBounds for all the GUI variables
        menu.setBounds(400, 410, 200, 50);
        mainImg.setBounds(0, 0, 1000, 500);
        title.setBounds(250, 30, 500, 80);
        textAreaL.setBounds(50, 110, 350, 290);
        textAreaR.setBounds(400, 110, 550, 290);

        //add it to the JLayeredPane to see which ones are top of one another
        all.add(menu, 1, 0);
        all.add(mainImg, 0, 0); //background at the back, everything at the front
        all.add(title, 1, 0);
        all.add(textAreaL, 1, 0);
        all.add(textAreaR, 1, 0);

        add(all); //add the JLayeredPane to the frame

        //window settings
        pack ();
        setTitle ("Sick Bombz"); //title at the top
        setSize(1000,500); //size of the frame
        setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE); //close when pressed close
        setResizable(false); //cannot resize
        setLocationRelativeTo (null); //centers the window
    }

    public void actionPerformed(ActionEvent e){ //when menu is clicked
        this.dispose(); //close the frame when the user presses play
    }
}