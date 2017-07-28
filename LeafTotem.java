package SickBombz;//Created by Paul on 6/19/2017.
//Created by Paul on 6/19/2017.

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.lang.*;

//this is the user's verbal interaction part of the game
public class LeafTotem extends JFrame implements ActionListener{
    //declare variables
    JTextField user; //for the user to type
    String[] s = new String[5]; //the problem sentences
    String[] ans = new String[5]; //the answers to those problems
    int num; //random number to be generated
    public boolean right; //if correct or not
    private Character c;
    private Board b;
    private int u;

    public LeafTotem(boolean right, Character c, Board b, int u){
    	this.c = c;
    	this.b =b;
    	this.u =u;
        //these are the problems and the answers
        //there are 5 problems, thus 5 answers
        s[0] = "This is the best game ever";
        ans[0] = "Uijt jt uif cftu hbnf fwfs";
        s[1] = "What goes down the rabbit hole";
        ans[1] = "Xibu hpft epxo uif sbccju ipmf";
        s[2] = "Mathematics English Computer Science";
        ans[2] = "Nbuifnbujdt Fohmjti Dpnqvufs Tdjfodf";
        s[3] = "Mr Jay is the best teacher ever";
        ans[3] = "Ns Kbz jr uif cftu ufbdifs fwfs";
        s[4] = "Paul Maxx Saiyam are the coolest guys";
        ans[4] = "Qbvm Nbyy Tbjzbn bsf uif dppmftu hvzt";

        num = (int) (Math.random()*5); //random number from 0-4 to select the question
        this.right = right; //set the "right" variable from the Board class to right

        //initialize GUI variables
        JLayeredPane all = new JLayeredPane();
        JLabel title = new JLabel("MINI GAME!");
        JLabel ques = new JLabel("Type each letter of the sentence one alphabet after. Ex. a -> b");
        JLabel prob = new JLabel(s[num]);
        user = new JTextField();
        JButton enter = new JButton("Enter");

        //actionListener for the enter button, when user enters
        enter.addActionListener(this);
        enter.setActionCommand("enter");

        //setBounds for each of the GUI components
        title.setBounds(0, 0, 500, 30);
        ques.setBounds(0, 30, 500, 30);
        prob.setBounds(0, 60, 500, 30);
        user.setBounds(0, 90, 500, 50);
        enter.setBounds(0, 150, 500, 50);
        all.setBounds(0, 0, 500, 300);

        //add all to the JLayered Pane
        all.add(title);
        all.add(ques);
        all.add(prob);
        all.add(user);
        all.add(enter);

        add(all); //add this to the Frame

        //4. Window configuration
        pack ();
        setTitle ("Leaf Totem"); //title at the top
        setSize(500,300); //size of the frame
        setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE); //close when pressed close
        setResizable(false); //cannot resize
        setLocationRelativeTo (null); //centers the window
    }

    public void actionPerformed(ActionEvent e)
    {
        String answer = user.getText();//user's answer
        this.dispose(); //close the frame when the user presses play

        //checks if answer is correct
        if (!answer.equals(ans[num]))
            right = false;

        //the results JFrame is created
        LeafTotemResult l = new LeafTotemResult(right, c, b, u);
        l.setVisible(true);
    }
}