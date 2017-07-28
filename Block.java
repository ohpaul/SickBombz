package SickBombz;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.*;

public class Block //block class
{
	protected boolean breakable, crossable;
	protected BufferedImage img= null;
	protected char type;
	public Block (String s) //constructor
	{
		if (s.equals("Wall")) //wall block
		{
			breakable = false; //cannot be broken
			try
			{
			img = ImageIO.read(new File ("Graphics\\wall.png")); //image
			}
			catch (IOException e){};
			type = 'W';
			crossable = false; //cannot be crossed
		}
		else if (s.equals("Ground")) //ground object
		{
			breakable = false; //cannot be broken
			try
			{
			img = ImageIO.read(new File ("Graphics\\ground.png"));//image
			}
			catch (IOException e){};
			type = 'G';
			crossable = true; //can be crossed
		}
		else if (s.equals("Crate"))//crate block
		{
			breakable = true;//can be broken
			try
			{
			img = ImageIO.read(new File ("Graphics\\crate.png"));//image
			}
			catch (IOException e){};
			type = 'C';
			crossable = false;//cannot be crossed
		}
		else if (s.equals("expLeft")) //left end explosion block
		{
			try
			{
			img = ImageIO.read(new File ("Graphics\\expLeft.png")); //image
			}
			catch (IOException e){};
			type='E';
		}
		else if (s.equals("expRight")) //right end explosion
		{
			try
			{
			img = ImageIO.read(new File ("Graphics\\expRight.png"));
			}
			catch (IOException e){};
			type='E';
		}
		else if (s.equals("expUp")) //top end explosion
		{
			try
			{
			img = ImageIO.read(new File ("Graphics\\expUp.png"));
			}
			catch (IOException e){};
			type='E';
		}
		else if (s.equals("expDown")) //bottom end explosion
		{
			try
			{
			img = ImageIO.read(new File ("Graphics\\expDown.png"));
			}
			catch (IOException e){};
			type='E';
		}
		else if (s.equals("expMid")) //middle cross explosion
		{
			try
			{
			img = ImageIO.read(new File ("Graphics\\expMid.png"));
			}
			catch (IOException e){};
			type='E';
		}
		else if (s.equals("vertical")) //vertical middle section for explosion
		{
			try
			{
			img = ImageIO.read(new File ("Graphics\\vertical.png"));
			}
			catch (IOException e){};
			type='E';
		}
		else if (s.equals("horizontal")) //horizontal middle section for explosion
		{
			try
			{
			img = ImageIO.read(new File ("Graphics\\horizontal.png"));
			}
			catch (IOException e){};
			type='E';
		}
		else if (s.equals(("addBomb"))) //add bomb item block
		{
			try
			{
			img = ImageIO.read(new File ("Graphics\\bomb.jpg")); //image
			}
			catch (IOException e){};
			crossable = true; //can be crossed
			type ='A';
		}
		else if (s.equals(("powerUp"))) //powerUp item block
		{
			try
			{
			img = ImageIO.read(new File ("Graphics\\powerUp.png")); //image
			}
			catch (IOException e){};
			crossable = true;//can be crossed
			type = 'P';
		}
		else if (s.equals("totem"))
		{
			try
			{
			img = ImageIO.read(new File ("Graphics\\leafTotem.jpg")); //image
			}
			catch (IOException e){};
			crossable = true;//can be crossed
			type = 'T';
		}
	}
}