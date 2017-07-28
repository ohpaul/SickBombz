package SickBombz;//Created by Paul on 6/19/2017.
//Created by Paul on 6/19/2017.

import javax.swing.*;
import java.io.*;
import java.util.*;
import java.lang.*;
import java.math.*;
import java.awt.*;
import java.awt.event.*;

public class LeafTotemResult extends JFrame implements ActionListener{
    public LeafTotemResult(boolean right, Character c, Board b, int u){
        JButton next = new JButton("Back to game");

        if (!right){
            add(new JLabel("Wrong!"), "North");
            add(new JLabel("Nothing Happens..."), "Center");
        }
        else{
            add(new JLabel("Correct!"), "North");
            add(new JLabel("Extra Life!"), "Center");
            c.addHealth(b,u);
        }
        add(next, "South");

        next.addActionListener(this);

        setVisible(true);
        pack ();
        setTitle ("Leaf Totem"); //title at the top
        setSize(300,100); //size of the frame
        setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE); //close when pressed close
        setResizable(false); //cannot resize
        setLocationRelativeTo (null); //centers the window
    }

    public void actionPerformed(ActionEvent e){
        this.dispose();
    }
}