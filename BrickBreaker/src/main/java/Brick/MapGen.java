/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Brick;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class MapGen {
    public int map[][],brickwidth,brickheigth;
    
    public MapGen(int row,int col)
    {
        map=new int[row][col];
        for(int i=0;i <map.length;i++)
        {
            for(int j=0;j< map[0].length;j++)
            {
                map[i][j]=1;
            }
        }
        brickwidth=540/col;
        brickheigth=150/row;
    }
    public void drawin(Graphics2D g)
    {
        for(int i=0;i <map.length;i++)
        {
            for(int j=0;j< map[0].length;j++)
            {
                if(map[i][j]>0)
                {
                    g.setColor(Color.white);
                    g.fillRect(j*brickwidth+100,i*brickheigth+95,brickwidth,brickheigth);
                    
                    g.setStroke(new BasicStroke(3));
                    g.setColor(Color.black);
                    g.drawRect(j*brickwidth+100,i*brickheigth+95,brickwidth,brickheigth);
               }
            }
        }
    }
    
    public void setBrickvalue(int value,int row ,int col)
    {
        map[row][col]= value;
    }
    
}
