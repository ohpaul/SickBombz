package SickBombz;
import java.awt.*; 
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.Timer;

public class Board extends JFrame implements KeyListener
{
	//instance variables
	Map field;
	Character user2;
	Character user;
	String fileName = "down", fileName2 = "down2";
	GlassPane p;
	ArrayList<Bomb> userBombs = new ArrayList<Bomb>();
	ArrayList<Bomb> user2Bombs = new ArrayList<Bomb>();
	//components for dislpayign player stats
	JTextField player1Bombs = new JTextField();
	JTextField player2Bombs = new JTextField();
	JTextField name1 = new JTextField();
	JTextField name2 = new JTextField();
	JTextField health1 = new JTextField();
	JTextField health2 = new JTextField();
	JTextField range1 = new JTextField();
	JTextField range2 = new JTextField();
	JLabel bombs = new JLabel ("Total bombs: ");
	JLabel bombsb = new JLabel ("Total bombs: ");
	JLabel health = new JLabel ("Health: ");
	JLabel healthb = new JLabel ("Health: ");
	JLabel range = new JLabel ("Bomb range: ");
	JLabel rangeb = new JLabel ("Bomb range: ");
	JLabel img1;
	JLabel img2;
	public Board (String mapName, String name1, String name2) //constructor
	{
		field = new Map (15,20,40,40, mapName + ".txt");//create map form text file
		//based on which map was selected, create characters with appropriate positions, bomb numbers, and range
		if (mapName.equals("bombapalooza"))
		{
			user = new Character (18,13,7,7);
			user2 = new Character (1,1,7,7);
			user.health =1;
			user2.health=1;
		}
		else if (mapName.equals("spiral"))
		{
			user = new Character (17,13,7,7);
			user2 = new Character (2,1,7,7);
		}
		else
		{
			user = new Character (18,13,1,1);
			user2 = new Character (1,1,1,1);
		}
		
		JPanel content = new JPanel();//content pane, set layout and size
		content.setLayout (null); 
		DrawArea board = new DrawArea (807, 629);
		board.setBounds(0,0,807,629);
		content.add(board);
		
		setContentPane (content); //set properties
	    pack ();
	    setTitle ("Sick Bombz");
	    setSize (1000, 629);
	    setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
	    setLocationRelativeTo (null);
	    
	    //load and resize images for the player icons on the stats bar
	    ImageIcon img = new ImageIcon (new ImageIcon ("Graphics\\Down2.png").getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT));
	    img1 = new JLabel (img);
	    img = new ImageIcon (new ImageIcon ("Graphics\\Down.png").getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT));
	    img2 = new JLabel (img);
	    
	    //display user 1 stats
	    this.name1.setEditable(false);
	    this.name1.setText(name1);
	    this.name1.setBounds(850,160,100,30);
	    content.add(this.name1);
	    health.setBounds(850,190,100,30);
	    content.add(health);
	    health1.setText(""+user.health);
	    health1.setBounds(900, 190, 50,30);
	    content.add(health1);
	    health1.setEditable(false);
	    bombs.setBounds(815,220, 180, 30);
	    content.add(bombs);
	    player1Bombs.setText(""+user.totalBombs);
	    player1Bombs.setBounds (900, 220, 50, 30);
	    content.add(player1Bombs);
	    player1Bombs.setEditable(false);
	    range.setBounds(815, 250, 80, 30);
	    content.add(range);
	    range1.setText(""+user.range);
	    range1.setBounds(900,250,50,30);
	    content.add(range1);
	    range1.setEditable(false);
	    img1.setBounds(825, 20, 150, 150);
	    content.add(img1);
	    
	    //display user2 stats
	    this.name2.setEditable(false);
	    this.name2.setText(name2);
	    this.name2.setBounds(850,450,100,30);
	    content.add(this.name2);
	    healthb.setBounds(850,480,100,30);
	    content.add(healthb);
	    health2.setText(""+user2.health);
	    health2.setBounds(900, 480, 50,30);
	    content.add(health2);
	    health2.setEditable(false);
	    bombsb.setBounds(815,510, 80, 30);
	    content.add(bombsb);
	    player2Bombs.setText(""+user2.totalBombs);
	    player2Bombs.setBounds (900, 510, 50, 30);
	    content.add(player2Bombs);
	    player2Bombs.setEditable(false);
	    rangeb.setBounds(815, 540, 80, 30);
	    content.add(rangeb);
	    range2.setText(""+user2.range);
	    range2.setBounds(900,540,50,30);
	    content.add(range2);
	    range2.setEditable(false);
	    img2.setBounds(822, 310, 150, 150);
	    content.add(img2);
	    
	    p = new GlassPane(this); //create glass pane to display the characters
	    setGlassPane(p);
		p.setVisible(true);
	    
	    addKeyListener(this); //key listener for movement and bomb placement
	    setFocusable(true);
	    setFocusTraversalKeysEnabled(false);
	    
        setResizable(false); //cannot resize
	}
	public void keyTyped(KeyEvent e){} //interface requirement
	
	public void keyPressed(KeyEvent e)  //key press listener
	{
		Timer timer = new Timer(); // timer object for bomb detonation and explosion
		Random r = new Random(); //random object for spawning items
		int key = e.getKeyCode ();
		switch (key)
		{
		    case KeyEvent.VK_UP: //move user up
		    	user.move (0, -1, field, userBombs, user2Bombs, this, 1);
		    	fileName="up"; //character face up
		    	break;
		    case KeyEvent.VK_DOWN: //move user down
		    	user.move (0, 1, field, userBombs, user2Bombs, this, 1);
		    	fileName="down"; //character face down
		    	break;
		    case KeyEvent.VK_LEFT: //move user left
		    	user.move (-1, 0, field, userBombs, user2Bombs, this, 1);
		    	fileName="left"; //character face left
		    	break;
		    case KeyEvent.VK_RIGHT: //move user right
		    	user.move (1, 0, field, userBombs, user2Bombs, this, 1);
		    	fileName="right"; //character face right
		    	break;
		    case KeyEvent.VK_ENTER: //user place bomb
		    {
		    	Board b = this;
		    	if(user.currentBomb<user.totalBombs&&!isBomb(user))
		    		// if user has not reached bomb limit and they are not standing on a bomb
		    	{
		    		userBombs.add(new Bomb(user.x, user.y, field.width, field.height,user.range));//add a bomb object to user's list
		    		user.currentBomb++;
		    		timer.schedule(new TimerTask() //timer for 4 seconds
		    			{
		    				public void run()
		    				{
		    					field.explode(userBombs.get(0), user, user2, b, 1, b.name1.getText(), b.name2.getText()); //call explode method
		    					userBombs.remove(0); //remove bomb from user's list
		    					user.currentBomb--;
		    					repaint();
		    					timer.schedule(new TimerTask() //timer for 1 second
		    	    			{
		    	    				public void run()
		    	    				{
		    	    					for (int x=0;x<15;x++) //go through map
		    	    					{
		    	    						for (int y=0; y<20;y++)
		    	    						{
		    	    							int chance = r.nextInt(10); //random number for items
		    	    							if (field.map[x][y].type == 'E') //remove explosion graphics
		    	    								field.map[x][y] = new Block ("Ground");
		    	    							if (field.map[x][y].type== 'R'&&chance<=2) //if a block was broken, 30% to spawn addBomb item
		    	    								field.map[x][y] = new Block ("addBomb");
		    	    							else if (field.map[x][y].type=='R'&&chance>=7)//if a block was broken 30% chance to spawn power up item
		    	    								field.map[x][y] = new Block ("powerUp");
		    	    							else if (field.map[x][y].type=='R'&&chance>2&&chance<7) //remainder 40% becomes ground objects
		    	    								field.map[x][y] = new Block ("Ground");
		    	    						}
		    	    						repaint(); //repaint
		    	    					}
		    	    				}
		    	    			},1000);
		    				}
		    			}, 3*1000);
		    	}
		    }
		    	break;	//same as above for second character
		    case KeyEvent.VK_W:
		    	user2.move (0, -1, field, userBombs, user2Bombs, this, 2);
		    	fileName2="up2";
		    	break;
		    case KeyEvent.VK_S:
		    	user2.move (0, 1, field, userBombs, user2Bombs, this, 2);
		    	fileName2="down2";
		    	break;
		    case KeyEvent.VK_A:
		    	user2.move (-1, 0, field, userBombs, user2Bombs, this, 2);
		    	fileName2="left2";
		    	break;
		    case KeyEvent.VK_D:
		    	user2.move (1, 0, field, userBombs, user2Bombs, this, 2);
		    	fileName2="right2";
		    	break;
		    case KeyEvent.VK_SPACE:
		    	Board b = this;
		    	if (user2.currentBomb<user2.totalBombs&&!isBomb(user2))
		    	{
		    		user2Bombs.add(new Bomb(user2.x, user2.y, field.width, field.height,user2.range));
		    		user2.currentBomb++;
		    		timer.schedule(new TimerTask()
	    			{
	    				public void run()
	    				{
	    					field.explode(user2Bombs.get(0), user, user2, b, 2,  b.name1.getText(), b.name2.getText());
	    					user2Bombs.remove(0);
	    					user2.currentBomb--;
	    					repaint();
	    					timer.schedule(new TimerTask()
	    	    			{
	    	    				public void run()
	    	    				{
	    	    					for (int x=0;x<15;x++)
	    	    					{
	    	    						for (int y=0; y<20;y++)
	    	    						{
	    	    							int chance = r.nextInt(10);
	    	    							if (field.map[x][y].type == 'E')
	    	    								field.map[x][y] = new Block ("Ground");
	    	    							if (field.map[x][y].type=='R'&&chance<=2)
	    	    								field.map[x][y] = new Block ("addBomb");
	    	    							else if (field.map[x][y].type=='R'&&chance>=7)
	    	    								field.map[x][y] = new Block ("powerUp");
	    	    							else if (field.map[x][y].type=='R'&&chance>2&&chance<7)
	    	    								field.map[x][y] = new Block ("Ground");
	    	    						}
	    	    						repaint();
	    	    					}
	    	    				}
	    	    			}, 1000);
	    				}
	    			}, 3*1000);
		    	}
		    	break;
		}
		repaint ();
	}
	
	public void keyReleased(KeyEvent e){} //interface requirement
	
	class DrawArea extends JPanel //DrawArea class
    {
        public DrawArea (int width, int height) //constructor
        {
            this.setPreferredSize (new Dimension (width, height)); // size
        }
        public void paintComponent (Graphics g) //print map and all bombs in both player's list
        {
        	field.print (g);
            for (int x=0;x<userBombs.size();x++)
            	((Bomb)userBombs.get(x)).print(g);
            for (int x=0;x<user2Bombs.size();x++)
            	((Bomb)user2Bombs.get(x)).print(g);
        }
    }
	public boolean isBomb(Character u) //determines if the player is standing on a bomb
	{
		boolean bombBlock = false;
		for (int z=0;z<userBombs.size();z++)
			if (userBombs.get(z).x==u.x&&userBombs.get(z).y==u.y)
				bombBlock = true;
		for (int z=0;z<user2Bombs.size();z++)
			if (user2Bombs.get(z).x==u.x&&user2Bombs.get(z).y==u.y)
				bombBlock = true;
		return bombBlock;
	}
	class GlassPane extends JComponent //glass pane for displaying characters over the map
	{
		JFrame content;
		Graphics g;
		public GlassPane(JFrame frame) //constructor
		{
			content = frame;
		}
		public void paint (Graphics g) 
		{
			this.g = g;
			Container root = content.getContentPane();
		    myPaint(root);
		}
		public void myPaint (Component c) //paint characters based on their direction and position
		{
			BufferedImage img = null;
			try
			{
			img = ImageIO.read(new File ("Graphics\\"+fileName+".png"));
			}
			catch (IOException e){};
			g.drawImage(img, user.x*field.width, user.y*field.height, field.width, field.height, null);
			
			try
			{
			img = ImageIO.read(new File ("Graphics\\"+fileName2+".png"));
			}
			catch (IOException e){};
			g.drawImage(img, user2.x*field.width, user2.y*field.height, field.width, field.height, null);
		}
	}
}
