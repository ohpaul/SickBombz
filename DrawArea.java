package SickBombz;

import java.awt.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.*;
import java.io.*;
import java.lang.*;

//DrawArea class; special type of JPanel subclass that draws an image onto the JPanel
public class DrawArea extends JPanel {
    BufferedImage img; //image that is being displayed
    int width;
    int height;

    //constructor of DrawArea, needs width, height, and file name of the image
    public DrawArea (int width, int height, String name) {
        this.setPreferredSize (new Dimension(width, height)); //sets the size accordingly
        img = loadImage(name); // load images //initializes the image by using the loadImage method
        this.width = width;
        this.height = height;
    }

    //method to load images by reading a file, this method can be used by other objects as well to load images
    public static BufferedImage loadImage (String name){ //name of the file
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File ("Graphics\\" + name)); //reads the image from the file
        }
        catch(IOException e){} //input exception
        return img; //returns the image found, null if nothing found
    }

    public void paintComponent (Graphics g) {
        g.drawImage(img,0,0, width, height,null); // Draw square with current location and size
    }
}