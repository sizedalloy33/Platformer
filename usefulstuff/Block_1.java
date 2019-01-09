package usefulstuff;

import java.awt.*;
import javax.swing.*;

public class Block_1
{

    private int w, h;
    private int x, y;

    public Block_1 ()
    {
	    h = 50;
      w = 5;
	    x = 0;
	    y = 0;
    }


    public void draw (Graphics g)
    {
	    g.setColor (Color.black);
	    g.fillRect (x, y, h, w);
    }


    public void setDimentions (int newW, int newH)
    {
      h = newH;
      w = newW;
    }


    public int getWidth ()
    {
	    return w;
    }

    public int getHeight()
    {
      return h;
    }


    public void setPosition (int newx, int newy)
    {
	    x = newx;
      y = newy;
    }


    public int getX ()
    {
	    return x;
    }


    public int getY ()
    {
	    return y;
    }

    public boolean contains (int pointX, int pointY)
    {
      if (x < pointX && pointX < x + w && y < pointY && pointY < y + h)
	      return true;
	    else
	      return false;
    }
    public boolean collide (ImageShape newImage) {
       int newX = newImage.getX(); //new images x
       int newY = newImage.getY(); //new image y
       int newH = newImage.getHeight(); //new image height
       int thisX = this.getX();
       int thisY = this.getY();
       int thisH = this.getHeight();
       if (this.contains(newX, newY)) {
          return true;
       }
       else if (this.contains(newX + newH, newY)) {
          return true;
       }
       else if (this.contains(newX + newH, newY + newH)) {
          return true;
       }
       else if (this.contains(newX, newY + newH)) {
          return true;
       }
       else if (newImage.contains(thisX, thisY)) {
          return true;
       }
       else if (newImage.contains(thisX + thisH, thisY)) {
          return true;
       }
       else if (newImage.contains(thisX + thisH, thisY + thisH)) {
          return true;
       }
       else if (newImage.contains(thisX, thisY + thisH)) {
          return true;
       }
       else {
          return false;
       }
    }
}
