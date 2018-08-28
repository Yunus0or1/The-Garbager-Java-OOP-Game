/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.Driden.project.display;

import java.awt.*;
import javax.swing.JFrame;


/**
 *
 * @author Yunus
 */
public class Display {
    
    private JFrame frame;
    private Canvas canvas;
    
    private String title;
    
    private int width , height;
    
    public Display(String title ,int width, int height){
        this.title = title;
        this.width = width;
        this.height = height;
                
        createDisplay();
        
    }
    
    private void createDisplay(){
        
        frame = new JFrame (title);
        frame.setSize(100,100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        
        canvasnew();
        
        
    }
    
    
    public void canvasnew()
    {
        canvas = new Canvas();
        
        canvas.setPreferredSize(new Dimension (width, height));
        canvas.setMaximumSize  (new Dimension (width, height));
        canvas.setMinimumSize  (new Dimension (width, height));
        canvas.setFocusable(false);
        
        frame.add(canvas);
        frame.pack();
        
    }
    
    
    // Getters - Setters
    
    public Canvas getCanvas()
    {
        return canvas;
    }
    
    public JFrame getFrame()
    {
        return frame;
    }
}
