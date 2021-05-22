/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Brick;

import java.awt.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.*;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Gameplay extends JPanel implements KeyListener ,ActionListener  {
    
    private Boolean play=false;
    private int score=0;
     
    private int tbricks=21;
    
    private Timer timer;
    private int delay=4;
    
    private int playerX=310,ballX=150,ballY=340,balldirX= -1,balldirY= -2;
    private MapGen map;
    
    Gameplay()
    {
        map =new MapGen(3,7);
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        timer= new Timer(delay,this);
        timer.start();
    }
    public void paint(Graphics g)
    { 
        //BG
        g.setColor(Color.black);
        g.fillRect(1,1, 792,692);
        
        map.drawin((Graphics2D)g);
        //border
        g.setColor(Color.blue);
        g.fillRect(0,0, 3,692);
        g.fillRect(0,0, 792,3);
        g.fillRect(783,0, 3,692);
        
        //paddle
        g.setColor(Color.green);
        g.fillRect(playerX,650, 100,8);
        
        //ball
        g.setColor(Color.red);
        g.fillOval(ballX,ballY, 20,20);
         
        g.setColor(Color.green);
        g.setFont(new Font("Arial",Font.BOLD,20));
        g.drawString(""+score,690,20);
        
        if(tbricks==0)
        {
            play=false;
            balldirX=0;
            balldirY=0;
            g.setColor(Color.red);
            g.setFont(new Font("arial",Font.BOLD,30));
            g.drawString("You Won,"+" Scores:"+score, 190, 300);
             g.drawString("Press 'Enter' to restart", 190, 400);
        }
        if(ballY >670)
        {
            play=false;
            balldirX=0;
            balldirY=0;
            g.setColor(Color.red);
            g.setFont(new Font("arial",Font.BOLD,30));
            g.drawString("Game Over,"+" Scores:"+score, 190, 300);
             g.drawString("Press 'Enter' to restart", 190, 400);
        }
        
        g.dispose();
    }
    
    
    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_RIGHT)
        {
            if(playerX >=690)
            {
                playerX=680; 
            }
            else{
                moveRight();
            }
        }
        if(e.getKeyCode()==KeyEvent.VK_LEFT)
        {
            if(playerX <10)
            {
                playerX=10;
            }
            else{
                moveLeft();
            }
        }
        if(e.getKeyCode()==KeyEvent.VK_ENTER)
        {
            if(!play)
            {
                playerX=310;
                ballX=150;
                ballY=340;
                balldirX= -1;
                balldirY= -2;
                score=0;
                tbricks=21;
                map =new MapGen(3,7);
                repaint();
                
            }
        }
    }

   

    @Override
    public void actionPerformed(ActionEvent e) {
        
        timer.start();
        
        if(play)
        {
            if(new Rectangle(ballX,ballY,20,20).intersects(new Rectangle(playerX,650,100,8)))
            {
                balldirY=-balldirY;
            }
                
            A: for(int i=0;i<map.map.length;i++)
            {
                for(int j=0; j<map.map[0].length;j++)
                {
                    if(map.map[i][j]>0)
                    {
                        Rectangle rec=new Rectangle(j*map.brickwidth+100,i*map.brickheigth+95,map.brickwidth,map.brickheigth);
                        Rectangle ball1=new Rectangle(ballX,ballY,20,20);
                        Rectangle brickrec=rec;
                        if(brickrec.intersects(ball1))
                        {
                            map.setBrickvalue(0, i, j);
                            tbricks--;
                            score+=10;
                            
                            if(ballX+19 <=brickrec.x ||ballX+1 >=brickrec.x+brickrec.width)
                            {
                                balldirX= -balldirX;
                            }
                            else
                            {
                                balldirY= -balldirY ;
                            }
                            break A;
                        }
                    }
                }
            }
            ballX+=balldirX;
            ballY+=balldirY;
            if(ballX < 0)
                balldirX=-balldirX;
            if(ballY <0)
                balldirY=-balldirY;
            if(ballX >770)
                balldirX=-balldirX; 
        }
        
        repaint();
    }

     void moveRight() {
       play=true;
       playerX+=20;
    }

     void moveLeft() {
        play=true;
       playerX-=20;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
