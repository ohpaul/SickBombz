package SickBombz;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.*;

public class Bomb //bomb class
{
	protected BufferedImage img;
	protected int x, y, height, width, range; //instance variables
	public Bomb (int x, int y, int width, int height, int range)
	{
		try //load image
		{
		img = ImageIO.read(new File ("Graphics\\bomb.png"));
		}
		catch (IOException e){};
		this.x=x; //set coordinates, image, range
		this.y=y;
		this.range=range;
		this.height=height;
		this.width=width;
	}
	public void print (Graphics g) //print the bomb object
	{
		g.drawImage(img,x*width,y*height,width, height, null);
	}
}
