import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;
import java.util.*;
import usefulstuff.*;


public class Summative
{
  public static void main (String[] args)
  {
    JFrame j = new JFrame("Summative");
    j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    j.getContentPane().add (new SummativePanal(), BorderLayout.CENTER);
    j.setSize (1000, 1000);
    j.setVisible (true);
  }
}

class SummativePanal extends JPanel implements KeyListener, ActionListener, MouseListener
{
  private javax.swing.Timer timer; //Timer for most things in the game
  private javax.swing.Timer gravityTimer; //Timer for the Gravity of the player
  ImageShape player1; //Player1
  enemy enemy1; //The first enemy
  int p1VelocityX, p1VelocityY; //How far the player moves each tic
  int e1VelocityX, e1VelocityY; //How far the enemy moves each tic
  int e1Direction; //The direction that enemy 1 if facing
  int step; //The step that the game is on
  int p1X, p1Y; //The x and y coordinates of player 1
  int gravitySpeed; //The speed of the gravity timer
  ImageShape play; //The play button
  boolean plOnBlock; //Boolean variable that shows if player 1 is on a block
  Block_1 block; //The block for the players to stand on and interact with
  coin coin1; //The coin for the player to collect
  ArrayList block2; //The array list of platformes for the player to jump on

  public SummativePanal ()
  {
    player1 = new ImageShape();
    player1.setPicture("usefulstuff/standleft.GIF"); //Sets the picture for player 1
    player1.setPosition(300, 300); //Sets the start position of player 1
    player1.setHeight(50); //Sets the size of player 1
    p1VelocityX = 0; //Sets the starting speed of the player
    p1VelocityY = 0; //Sets the starting speed of the player
    gravitySpeed = 20; //Sets the starting speed of the gravity timer

    enemy1 = new enemy();
    enemy1.setPosition(450, 300); //Sets the starting position of enemy 1
    enemy1.setHeight(50); //Sets the size of enemy 1
    e1Direction = 0; //Sets the starting direction of enemy 1
    e1VelocityX = 0; //Sets the starting speed of the enemy
    e1VelocityY = 0; //Sets the starting speed of the enemy

    coin1 = new coin(); //Creating the coin
    timer = new javax.swing.Timer(20, this); //Creates the timer for the game
    //timer.start(); //Starts the timer
    gravityTimer = new javax.swing.Timer(20, this); //Creates the gravity timer
    //gravityTimer.start(); //Starts the gravity timer
    step = 1; //Sets the game step to show the start screen

    block = new Block_1(); //Creates the block
    block.setDimentions(1350, 30); //Sets the dimentions of the block
    block.setPosition (0, 930); //Sets the position of the block

    play = new ImageShape (); //Creates the play button
  	play.setPicture ("buttons/play1.png");
  	play.setHeight (150);
  	play.setPosition (300, 300);

    addKeyListener(this); //Adds the key listener
    addMouseListener(this); //Adds the mouse listener
  }

  public void paintComponent (Graphics g)
  {
    super.paintComponent(g);

    if (step == 1) //Checks if the game step is 1 and if it is then it draws the start screen
    {
      play.draw(g); //Draws the play button
    }
    else if (step == 2) //checks if the game step is 2 and if it is then draw the game
    {
      player1.draw(g); //Draws player 1
      block.draw(g); //Draw the block
      enemy1.draw(g); //Draws enemy 1
      coin1.draw(g); //Draw the coin
      block2[0].draw(g);
      block2[1].draw(g);
    }
    else if (step == 3) //Checks if the game step is 3 and if it is then show the end screen and the replay button
    {
      play.draw(g); //Draws the play button so the player can restart the game
    }
    requestFocus();
  }
  public void keyPressed (KeyEvent e)
  {
    if (e.getKeyChar() == 'w') //Checks if the player presses w
    {
      p1VelocityY = -25; //Sets the players Y velocity to -10
      gravitySpeed = 30; //Sets the speed of the gravity timer to 60
    }
    if (e.getKeyChar() == 'd') //Checks if the player presses d
      p1Move('R'); //Calls the move function
    else if (e.getKeyChar() == 'a') //Checks if the player presses a
      p1Move('L'); //Calls the move function
  }

  public void keyReleased (KeyEvent e)
  {
    if (e.getKeyChar() != 'w') //Checks if the player releases any key that isn't w
      p1Move('S'); //Calls the move function
  }

  public void keyTyped (KeyEvent e)
  {
  }

  public void actionPerformed (ActionEvent e)
  {
    if (e.getSource() == timer) //Checks for when the timer tics
    {
      enemy1.move(30); //Calls the enemys move function
      if (enemy1.getX() >= 1250 || enemy1.getX() <= 0) //Checks if the enemy has collided with the edge of the screen
        enemy1.bounce(); //Calls the enemys bounce function

      player1.setPosition(player1.getX() + p1VelocityX, player1.getY()); //Moves the player along the x axis
      if (player1.collide(enemy1)) //Checks if the player has collided with the enemy
      {
        step = 3; //Sets the game step to 3
        timer.stop(); //Stops the timer
        gravityTimer.stop(); //Stops the gravity timer
        player1.setPosition (300, 50); //Resets the player position
    		enemy1.setPosition (450, 300); //Resets the enemy position
    		enemy1.setAngle (0); //Resets the enemys movement angle
      }
    }

    if (e.getSource() == gravityTimer) //Checks for when the gravity timer tics
    {
      if (player1.collide(block) && p1VelocityY >= 0) //Checks to see if the player is colliding wiht the block or if it is on the bottom of the screen
      {
        p1VelocityY = 0;
        gravitySpeed = 30;
      }
      else
      {
        p1Gravity(); //Calls the gravity function if the player is not on the bottom of the screen
      }
      player1.setPosition(player1.getX(), player1.getY() + (p1VelocityY/2)); //Moves the player along the Y axis
      //gravityTimer.setDelay(gravityTimer);
    }
    repaint();
  }

  public void mouseClicked (MouseEvent e)
  {
    if (play.contains(e.getX(), e.getY())) //Sets the game step to 2 when the play button is clicked
    {
      step = 2;
      timer.start();
      gravityTimer.start();
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


  public void p1Gravity() //Speeds up the player to simulate gravity
  {
    if (p1VelocityY <= 20)
    {
      p1VelocityY++;
    }
    /**else if (gravitySpeed >= 1)
    {
      gravitySpeed--;
    } **/
  }


  public void p1Move (char direction) //Sets the direction that the player is moving in
  {
    if (direction == 'L')
    {
      p1VelocityX = -10;
    }
    else if (direction == 'R')
    {
      p1VelocityX = 10;
    }
    else if (direction == 'S')
    {
      p1VelocityX = 0;
    }
  }
}
