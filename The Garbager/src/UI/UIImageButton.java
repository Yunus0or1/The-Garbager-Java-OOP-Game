/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import dev.Driden.project.gfx.Assets;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 *
 * @author Yunus
 */
public class UIImageButton extends UIObject{
    
    private BufferedImage [ ] images;
    private ClickListener clicker ;

    public UIImageButton(float x, float y, int width, int height,BufferedImage[] images,ClickListener clicker) {
        
        
        super(x, y, width, height);
        this.images = images ;
        this.clicker =clicker ;
    }
    
    
    @Override
    public void tick() {
      
    }

    @Override
    public void render(Graphics g) {
      
        if(hovering)
            g.drawImage(images[1],0,0, 500 , 500 , null);
        else
            g.drawImage(images[0],0,0 ,500, 500, null);
    }

    @Override
    public void onClick() {
        clicker.onClick();
       
    }
    
}
