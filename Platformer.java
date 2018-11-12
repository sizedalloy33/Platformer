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

    gravityTimer = new javax.swing.Timer(70, this);
    gravityTimer.start();

    addKeyListener(this);

  }

  public void gravity ()
  {
    if (velocityY < 100)
    {
      velocityY = velocityY + 1;
    }
  }
  public void move(char direction)
  {
    if (direction == 'L' && velocityX > -50)
    {
      velocityX = velocityX - 10;
    }
    else if (direction == 'R' && velocityX < 50)
    {
      velocityX = velocityX + 10;
    }
    else if (direction == 'S')
    {
      if (velocityX > 0)
      {
        velocityX--;
      }
      else if (velocityX < 0)
      {
        velocityX++;
      }
    }
  }

  public void paintComponent (Graphics g)
  {
  super.paintComponent(g);
  m.draw(g);
    requestFocus();
  }

  public void keyPressed (KeyEvent e)
  {
    if (e.getKeyChar() == 'w')
    {
      velocityY = -12;

    }
    else if (e.getKeyChar() == 'd')
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
    repaint();

  }


  public void keyReleased (KeyEvent e)
  {

  }


  public void keyTyped (KeyEvent e)
  {

  }

  public void actionPerformed (ActionEvent e)
  {
    if (e.getSource() == timer)
    {
      m.setPosition(m.getX() + velocityX, m.getY() + velocityY);
      move('S');
    }
    if(e.getSource() == gravityTimer)
    {
      gravity();
    }

    repaint();
  }
}
