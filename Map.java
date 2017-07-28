package SickBombz;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;
import java.io.*;
import javax.swing.*;

public class Map //Map class
{
	//instance variables
	protected Block map[][];
	protected int height, width, bombx, bomby;
	protected boolean bomb = false;
	public Map (int rows, int cols, int width, int height, String fileName) //constructor
	{
		map = new Block [rows][cols]; //2D array of Blocks
		this.width = width;
		this.height = height; 
		BufferedReader reader = null; //read text file 
    	try {
    		reader = new BufferedReader(new FileReader(fileName));
    	}
    	catch(FileNotFoundException f){}
    	String line = new String(); //save content of file as a string
    	try {
    		line = reader.readLine();
    	} catch (IOException e) {}

    	String[] columns = line.split(","); //split string into array of strings at ","
    	
    	
		for (int row = 0; row<columns.length;row++) //go through map
		{
			for (int x = 0; x < columns[0].length(); x++)
			{
				if (columns[row].charAt(x)=='W') //add wall object if char is 'W'
				{
					map[row][x] = new Block ("Wall");
				}
				else if (columns[row].charAt(x)=='G') //ground object
				{
					map[row][x] = new Block ("Ground");
				}
				else if (columns[row].charAt(x)=='T')
				{
					map[row][x] = new Block ("totem");
				}
				else
				{
					map[row][x] = new Block ("Crate");//crate object
				}
			}
		}
    }
	
	public void print (Graphics g)	// displays the map on the screen
	{
	    for (int row = 0 ; row < map.length; row++)// number of rows
	        for (int col = 0 ; col < map[0].length; col++)// length of first row
	        	g.drawImage(map[row][col].img, col*width, row*height, width, height, null); //draw the Block
	}
	
	public void explode (Bomb bomb, Character user, Character user2, Board b, int u, String name1, String name2) //explode method
	{
		boolean canBreak = true; //boolean variable to determine if the bomb can still break crates (1 max for each direction)
		for (int x=bomb.x-1;x>=bomb.x-bomb.range;x--) //explosion left of the bomb
		{
			if (canBreak) //if it hasn't already destroyed a crate
			{
				if (map[bomb.y][x].type!='W')//if block is not a wall
				{
					if (map[bomb.y][x].type=='G') //if block is ground
					{
						if (x==bomb.x-bomb.range||map[bomb.y][x-1].type=='W')//if it reached its range or hit a wall
							map[bomb.y][x] = new Block ("expLeft"); //display graphic for left end
						else //else, display graphic for horizontal middle explosion
							map[bomb.y][x] = new Block ("horizontal");
						if (user.x==x&&user.y==bomb.y) //check if any player was in the explosion
						{
							user.health--; //reduce health of user
							b.health2.setText(""+user.health);
							if (user.health<=0) //if user has no more health
							{
								EndFrame f = new EndFrame (name1, name2); //call end frame
								f.setVisible(true);
								b.dispose(); //dispose of this board
							}
						}
						if (user2.x==x&&user2.y==bomb.y)
						{
							user2.health--; //reduce health of user 2
							b.health1.setText(""+user2.health);
							if (user2.health<=0)
							{
								EndFrame f = new EndFrame (name2, name1);
								f.setVisible(true);
								b.dispose();
							}
						}
					}
					else if (map[bomb.y][x].type=='C')//if block is a crate
					{
						map[bomb.y][x]=new Block ("expLeft");//display left end graphic
						map[bomb.y][x].type='R'; //set type to 'R' for a chance of spawning items
						canBreak = false; //prevent form extending further
					}
				}
				else//if block is a wall, prevent explosion from extending further
					canBreak=false;
			}
		}
		canBreak = true; //same as above for right side of explosion
		for (int x=bomb.x+1;x<=bomb.x+bomb.range;x++)
		{
			if (canBreak)
			{
				if (map[bomb.y][x].type!='W')
				{
					if (map[bomb.y][x].type=='G')
					{
						if (x==bomb.x+bomb.range||map[bomb.y][x+1].type=='W')
							map[bomb.y][x] = new Block ("expRight");
						else
							map[bomb.y][x] = new Block ("horizontal");
						if (user.x==x&&user.y==bomb.y)
						{
							user.health--;
							b.health2.setText(""+user.health);
							if (user.health<=0)
							{
								EndFrame f = new EndFrame (name1, name2);
								f.setVisible(true);
								b.dispose();
							}
						}
						if (user2.x==x&&user2.y==bomb.y)
						{
							user2.health--;
							b.health1.setText(""+user2.health);
							if (user2.health<=0)
							{
								EndFrame f = new EndFrame (name2, name1);
								f.setVisible(true);
								b.dispose();
							}
						}
					}
					else if (map[bomb.y][x].type=='C')
					{
						map[bomb.y][x]=new Block ("expRight");
						map[bomb.y][x].type='R';
						canBreak = false;
					}
				}
				else
					canBreak=false;
			}
		}
		canBreak = true;//same as above for downward explosion
		for (int y=bomb.y-1;y>=bomb.y-bomb.range;y--)
		{
			if (canBreak)
			{
				if (map[y][bomb.x].type!='W')
				{
					if (map[y][bomb.x].type=='G')
					{
						if (y==bomb.y-bomb.range||map[y-1][bomb.x].type=='W')
							map[y][bomb.x] = new Block ("expUp");
						else
							map[y][bomb.x] = new Block ("vertical");
						if (user.x==bomb.x&&user.y==y)
						{
							user.health--;
							b.health2.setText(""+user.health);
							if (user.health<=0)
							{
								EndFrame f = new EndFrame (name1, name2);
								f.setVisible(true);
								b.dispose();
							}
						}
						if (user2.x==bomb.x&&user2.y==y)
						{
							user2.health--;
							b.health1.setText(""+user2.health);
							if (user2.health<=0)
							{
								EndFrame f = new EndFrame (name2, name1);
								f.setVisible(true);
								b.dispose();
							}
						}
					}
					else if (map[y][bomb.x].type=='C')
					{
						map[y][bomb.x]=new Block ("expUp");
						map[y][bomb.x].type='R';
						canBreak = false;
					}
				}
				else
					canBreak = false;
			}
		}
		canBreak = true; //same as above for upward explosion
		for (int y=bomb.y+1;y<=bomb.y+bomb.range;y++)
		{
			if (canBreak)
			{
				if (map[y][bomb.x].type!='W')
				{
					if (map[y][bomb.x].type=='G')
					{
						if (y==bomb.y+bomb.range||map[y+1][bomb.x].type=='W')
							map[y][bomb.x] = new Block ("expDown");
						else
							map[y][bomb.x] = new Block ("vertical");
						if (user.x==bomb.x&&user.y==y)
						{
							user.health--;
							b.health2.setText(""+user.health);
							if (user.health<=0)
							{
								EndFrame f = new EndFrame (name1, name2);
								f.setVisible(true);
								b.dispose();
							}
						}
						if (user2.x==bomb.x&&user2.y==y)
						{
							user2.health--;
							b.health1.setText(""+user2.health);
							if (user2.health<=0)
							{
								EndFrame f = new EndFrame (name2, name1);
								f.setVisible(true);
								b.dispose();
							}
						}
					}
					else if (map[y][bomb.x].type=='C')
					{
						map[y][bomb.x]=new Block ("expDown");
						map[y][bomb.x].type='R';
						canBreak = false;
					}
				}
				else
					canBreak = false;
			}
		}
		map[bomb.y][bomb.x] = new Block ("expMid");
		if (user.x==bomb.x&&user.y==bomb.y)
		{
			user.health--;
			b.health2.setText(""+user.health);
			if (user.health<=0)
			{
				EndFrame f = new EndFrame (name1, name2);
				f.setVisible(true);
				b.dispose();
			}
		}
		if (user2.x==bomb.x&&user2.y==bomb.y)
		{
			user2.health--;
			b.health1.setText(""+user2.health);
			if (user2.health<=0)
			{
				EndFrame f = new EndFrame (name2, name1);
				f.setVisible(true);
				b.dispose();
			}
		}
	}
}
