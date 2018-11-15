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

class PlatformerPanel extends JPanel implements KeyListener, ActionListener, MouseListener
{
  private javax.swing.Timer timer;
  private javax.swing.Timer gravityTimer;
  UFO m;        //this is just so we can test some things
  int velocityX, velocityY;
  int maxVelocityU, maxVelocityD, maxVelocityL, maxVelocityR;
  int direction;
  int step;
  int mX, mY;

  ImageShape play;

  boolean onBlock, onSide;

  Block_1 block;
  
  enemy d;

  public PlatformerPanel ()
  {
    m = new UFO();
    m.setPosition(300, 50);
    m.setColor (Color.red);
    m.setSize(50);
    direction = 0;
    
    d = new enemy ();	
d.setPosition (450, 50);	
d.setHeight (50);

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

    step = 1;

    block = new Block_1 ();
	  block.setHeight (50);
	  block.setPosition (100, 150);

    onBlock = false;
    onSide = false;

    play = new ImageShape();
    play.setPicture("buttons/play1.png");
    play.setHeight (150);
    play.setPosition (300, 300);

    addKeyListener(this);
    addMouseListener(this);

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
    mX = m.getX();
    mY = m.getY();
    if (mY >= y - 40 && mY <= y && mX >= x - 30 && mX <= x + 50 && velocityY > 0)
    {
      onBlock = true;
      m.setPosition(mX, y - 40);
    }
    else if (mY <= y + 40 && mY >= y && velocityY < 0 && mX >= x - 30 && mX <= x + 50)
    {
      onBlock = true;
      m.setPosition(mX, y + 40);
    }
    else if (mX >= x && mX <= x + 40 && velocityX < 0 && velocityX < 0 && mY < y + 40 && mY > y -40)
    {
      onSide = true;
    }
    else
    {
      onBlock = false;
      onSide = false;
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
    if (step == 1)
    {
	play.draw(g);
    }
    else if (step == 2)
    {
      super.paintComponent(g);
      m.draw(g);
      block.draw(g);
      d.draw(g);
    }
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

      if (m.getY() < 410 && onBlock == false && onSide == false)
      {
      m.setPosition(m.getX() + velocityX, m.getY() + velocityY);
      }
      else if (velocityY < 0 && onBlock == false && onSide == false)
      {
        m.setPosition(m.getX() + velocityX, m.getY() + velocityY);
      }
      else if (onBlock == true)
      {
        m.setPosition(m.getX() + velocityX, m.getY());
      }
      else if (onSide == true)
      {
        m.setPosition(m.getX(), m.getY() + velocityY);
      }
      else
      {
        m.setPosition(m.getX() + velocityX, 410);
      }

    }
    if(e.getSource() == gravityTimer)
    {
      wall (block.getY(), block.getX());
      if(onBlock == false)
      {
        gravity();
      }
      else if (onBlock == true)
      {
        velocityY = 1;
      }
    }

    repaint();
  }

  public void mouseClicked (MouseEvent e)
  {
    if (step == 1 && play.contains (e.getX(), e.getY()))
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
