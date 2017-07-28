package SickBombz;//Created by Paul on 4/11/2017.

//appropriate classes for import
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

//Start Frame class which is where you input your name
public class StartFrame extends JFrame implements ActionListener {
    DrawArea mainImg; //main image for start screen, type of JPanel
    DrawArea title;
    DrawArea bomb1;

    private JPanel mainPanel;
    private JLayeredPane lpane; //for adding the main panel

    private JLabel player1Label; //label for player1
    private JLabel player2Label; //label for player2

    private JButton play; //the PLAY button to proceed to game
    private JButton info;
    private JButton cred;

    //each of player text fields
    private JTextField player1Text;
    private JTextField player2Text;
    
    private JComboBox<String> items;//list to select map

    public StartFrame (){ //the constructor for the frame
        //initialize the variables for the text
        player1Label = new JLabel("Player 1 Name: ");
        player2Label = new JLabel("Player 2 Name: ");
        play = new JButton ("PLAY");
        info = new JButton ("Information");
        cred = new JButton ("Credits");
        player1Text = new JTextField(8); //initializing player1's text field
        player2Text = new JTextField(8); //initializing player2's text field

        play.addActionListener(this);//add actionListeners
        info.addActionListener(this);
        cred.addActionListener(this);
        play.setActionCommand("play");
        info.setActionCommand("info");
        cred.setActionCommand("cred");
        
        String list[] = {"arena","bombapalooza","illuminati","maze","pacman","SMP","snake", "spiral"};//list of map names
		items = new JComboBox<String>(list);

        lpane = new JLayeredPane(); //initialize the layered pane which

        //main panel initialization
        mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout()); //grid bag layout for the user input places
        GridBagConstraints c = new GridBagConstraints(); //setting grid layout

        mainImg = new DrawArea(750, 500, "mainImg.jpg"); //initialize the image

        Icon icon = new ImageIcon("Graphics\\" + "mainImg.jpg");
        JLabel label = new JLabel(icon);
        title = new DrawArea (400, 70, "title.png");
        bomb1 = new DrawArea (206, 180, "bomb.png");

        //adding everything to main panel
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weighty = 0.2; c.gridx = 1; c.gridy = 1; mainPanel.add(player1Label, c); //labels
        c.weighty = 0.2; c.gridx = 2; c.gridy = 1; mainPanel.add(player1Text, c); //text field
        c.weighty = 0.2; c.gridx = 1; c.gridy = 2; mainPanel.add(player2Label, c); //labels
        c.weighty = 0.2; c.gridx = 2; c.gridy = 2; mainPanel.add(player2Text, c); //text fields
        c.ipady = 20; c.weighty = 0.2; c.gridx = 1; c.gridy = 3; c.gridwidth = 2; mainPanel.add(play, c); //button
        c.ipady = 10; c.weighty = 0; c.gridx = 1; c.gridy = 4; c.gridwidth = 2; mainPanel.add(items, c);
        c.ipady = 10; c.weighty = 0; c.gridx = 1; c.gridy = 5; c.gridwidth = 2; mainPanel.add(info, c); //button
        c.ipady = 10; c.weighty = 0; c.gridx = 1; c.gridy = 6; c.gridwidth = 2; mainPanel.add(cred, c); //button

        label.setBounds(250, 0, 750, 500);
        player1Label.setBounds(50, 150, 50, 30);
        player1Text.setBounds(100, 150, 50, 30);
        player2Label.setBounds(50, 200, 50, 30);
        player2Text.setBounds(100, 200, 50, 30);
        play.setBounds(50, 270, 100, 60);
        items.setBounds(50, 350, 100, 40);
        info.setBounds(50, 400, 100, 40);
        cred.setBounds(50, 450, 100, 40);

        mainImg.setBounds(250, 0, 750, 500); //image bounds
        title.setBounds(425, 200, 400, 70);
        bomb1.setBounds(650, 30, 206, 180);
        mainPanel.setBounds(0, 100, 250, 300); //panel bounds

        lpane.setBounds(0, 0, 1000, 500); //the layered pane bounds

        lpane.add(mainPanel, "West"); //add the main panel onto the west side
        lpane.add(mainImg, 0, 0);
        lpane.add(title, 1, 0);
        lpane.add(bomb1, 1, 0);
        lpane.add(label, 0, 0);

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
    public void actionPerformed(ActionEvent e)
    {
        String player1Name = player1Text.getText(); //player names entered
        String player2Name = player2Text.getText(); //player names entered
        String mapName = (String)items.getSelectedItem();
        
        String cmd = e.getActionCommand();

        if (cmd.equals("play"))
        {
            Board window = new Board(mapName, player1Name, player2Name);
            window.setVisible (true);
            this.dispose(); //close the frame when the user presses play
        }
        else if (cmd.equals("info")){ //how to play
            Information window = new Information();
            window.setVisible (true);
        }
        else { //creators
            Credits window = new Credits();
            window.setVisible (true);
        }
    }
}