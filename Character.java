package SickBombz;
import java.util.*;

public class Character //character object
{
	protected int x, y, range, currentBomb=0, totalBombs, health = 3; //instance variables
	public Character (int x, int y, int r, int b) //constructor
	{
		this.x=x; //initial position, bomb range, bomb number
		this.y=y;
		range = r;
		totalBombs = b;
	}
	public void move (int dx, int dy, Map field, ArrayList<Bomb> a, ArrayList<Bomb> b, Board B, int user) //move method
	{
		boolean bombBlock = false; 
		//determine if there is a bomb in front 
		for (int z=0;z<a.size();z++)
			if (a.get(z).x==x+dx&&a.get(z).y==y+dy)
				bombBlock = true;
		for (int z=0;z<b.size();z++)
			if (b.get(z).x==x+dx&&b.get(z).y==y+dy)
				bombBlock = true;
		if (field.map[y+dy][x+dx].crossable==true&&!bombBlock) //if block in front is crossable and there is no bomb
		{
		    x += dx; //update position
		    y += dy;
		    if (field.map[y][x].type=='A') //if walked onto a addBomb item
		    {
		    	field.map[y][x] = new Block ("Ground"); //change block to ground
		    	addBomb(B, user); //add a bomb
		    }
		    else if (field.map[y][x].type=='P') //if walked onto a powerUp item
		    {
		    	field.map[y][x] = new Block ("Ground"); //change block to ground
		    	powerUp(B, user); //increase bomb range
		    }
		    else if (field.map[y][x].type=='T') //if walked onto a powerUp item
		    {
		    	field.map[y][x] = new Block ("Wall"); //change block to ground
		    	boolean miniGame = true;
		    	LeafTotem game = new LeafTotem (miniGame, this, B, user);
		    	game.setVisible(true);
		    }
		}
	}
	public void powerUp(Board b, int u) //item effects, modifies range, update stats bar
	{
		range++;
		if (u == 1)
			b.range2.setText(""+range);
		else
			b.range1.setText(""+range);
	}
	public void addBomb(Board b, int u) //adds bomb, update stats bar
	{
		totalBombs++;
		if (u == 1)
			b.player2Bombs.setText(""+totalBombs);
		else
			b.player1Bombs.setText(""+totalBombs);
	}
	public void addHealth(Board b, int u)
	{
		health ++;
		if (u == 1)
			b.health2.setText(""+health);
		else
			b.health1.setText(""+health);
	}
}
