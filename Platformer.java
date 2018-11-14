import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;
import java.util.*;
import usefulstuff.*;


public class Platformer
{

    public static void main (String[] args)
    {
	JFrame j = new JFrame ("Platformer");
	j.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
	j.getContentPane ().add (new PlatformerPanel (), BorderLayout.CENTER);
  j.setSize (800, 500);
  j.setVisible (true);
    }
}

class PlatformerPanel extends JPanel implements KeyListener, ActionListener
{
  private javax.swing.Timer timer;
  private javax.swing.Timer gravityTimer;
  UFO m;        //this is just so we can test some things
  int velocityX, velocityY;
  int maxVelocityU, maxVelocityD, maxVelocityL, maxVelocityR;
  int direction;
  int step;
  boolean onBlock;

  Block_1 block;

  public PlatformerPanel ()
  {
    m = new UFO();
    m.setPosition(300, 50);
    m.setColor (Color.red);
    m.setSize(50);
    direction = 0;

    velocityX = 0;
    velocityY = 0;
    maxVelocityU = -100;
    maxVelocityD = 100;
    maxVelocityL = 100;
    maxVelocityR = -100;

    timer = new javax.swing.Timer(20, this);
    timer.start();

    gravityTimer = new javax.swing.Timer(50, this);
    gravityTimer.start();

    step = 2;

    block = new Block_1 ();
	  block.setHeight (50);
	  block.setPosition (100, 150);

    onBlock = false;

    addKeyListener(this);

  }

  public void gravity ()
  {
    if (velocityY < 20)
    {
      velocityY = velocityY + 1;
    }
  }
  public void wall(int y, int x)
  {
    if (m.getY() >= y - 40 && m.getY() <= y && m.getX() >= x - 30 && m.getX() <= x + 50 && velocityY > 0)
    {
      onBlock = true;
    }
    else
    {
      onBlock = false;
    }
  }
  public void move(char direction)
  {
    if (direction == 'L')
    {
      velocityX = -10;
    }
    else if (direction == 'R')
    {
      velocityX = 10;
    }
    else if (direction == 'S')
    {
        velocityX = 0;
    }
  }

  public void paintComponent (Graphics g)
  {
  super.paintComponent(g);
  m.draw(g);
  block.draw(g);
    requestFocus();
  }

  public void keyPressed (KeyEvent e)
  {
    if (e.getKeyChar() == 'w')
    {
      velocityY = -6;

    }
    if (e.getKeyChar() == 'd')
    {
      move('R');
    }
    else if (e.getKeyChar() == 'a')
    {
      move('L');
    }
    else if (e.getKeyChar() == 's')
    {

    }



  }


  public void keyReleased (KeyEvent e)
  {
    if (e.getKeyChar() != 'w')
    {
      move('S');
    }

  }


  public void keyTyped (KeyEvent e)
  {

  }

  public void actionPerformed (ActionEvent e)
  {
    if (e.getSource() == timer)
    {

      if (m.getY() < 410 && onBlock == false)
      {
      m.setPosition(m.getX() + velocityX, m.getY() + velocityY);
      }
      else if (velocityY < 0 && onBlock == false)
      {
        m.setPosition(m.getX() + velocityX, m.getY() + velocityY);
      }
      else if (onBlock == true)
      {
        m.setPosition(m.getX() + velocityX, m.getY());
      }
      else
      {
        m.setPosition(m.getX() + velocityX, 410);
      }

    }
    if(e.getSource() == gravityTimer)
    {
      wall (block.getY(), block.getX());
      gravity();
    }

    repaint();
  }
   	
  public void mouseClicked (MouseEvent e)	
  {	
  if (play.contains (e.getX(), e.getY()))	
  {	
  step = 2;	
  }	
  }	
  	
  public void mousePressed (MouseEvent e)	
  {	
  	
  }	
  	
  public void mouseReleased (MouseEvent e)	
  {	
  }	
  public void mouseEntered (MouseEvent e)	
  {	
  }	
  	
  public void mouseExited (MouseEvent e)	
  {	
  }
}
