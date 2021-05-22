/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Brick;

import javax.swing.*;
/**
 *
 * @author gamin
 */
public class Main {
    public static void main(String args[])
    {
        JFrame obj=new JFrame();
        Gameplay gp=new Gameplay();
        obj.setBounds(100,10,800,700);
        obj.setTitle("Valo");
        obj.setResizable(false);
        obj.setVisible(true);
        obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        obj.add(gp);
    }
}
