package SickBombz;//Created by Paul on 6/5/2017.
//Created by Paul on 6/5/2017.

import java.io.*;
import java.util.*;
import java.lang.*;
import java.math.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.lang.*;

public class Credits extends JFrame implements ActionListener{
    public Credits(){
    	//create components
        JLayeredPane all = new JLayeredPane();

        JLabel m = new JLabel("Maxx Wu", SwingConstants.CENTER);
        JLabel p = new JLabel("Paul Oh", SwingConstants.CENTER);
        JLabel s = new JLabel("Saiyam Patel", SwingConstants.CENTER);

        DrawArea title = new DrawArea(300, 80, "credits.png");
        DrawArea mainImg = new DrawArea(1000, 500, "mainImg.jpg");

        JButton menu = new JButton("Menu");
        menu.addActionListener(this); //add action listener to menu button

        m.setFont(new Font(m.getFont().getName(), Font.PLAIN, 50));
        p.setFont(new Font(p.getFont().getName(), Font.PLAIN, 50));
        s.setFont(new Font(s.getFont().getName(), Font.PLAIN, 50));
        //set location and size of components
        menu.setBounds(400, 380, 200, 50);
        mainImg.setBounds(0, 0, 1000, 500);
        title.setBounds(350, 30, 300, 80);
        m.setBounds(0, 130, 1000, 70);
        p.setBounds(0, 210, 1000, 70);
        s.setBounds(0, 290, 1000, 70);
        //add components to LayeredPane
        all.add(menu, 1, 0);
        all.add(mainImg, 0, 0);
        all.add(title, 1, 0);
        all.add(m, 1, 0);
        all.add(p, 1, 0);
        all.add(s, 1, 0);
        add(all);
        //properties
        pack ();
        setTitle ("Sick Bombz"); //title at the top
        setSize(1000,500); //size of the frame
        setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE); //close when pressed close
        setResizable(false); //cannot resize
        setLocationRelativeTo (null); //centers the window
    }

    public void actionPerformed(ActionEvent e)
    {
        this.dispose(); //close the frame when the user presses menu
    }
}