/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Statics;

import Items.Item;
import dev.Driden.project.Handler;
import dev.Driden.project.gfx.Assets;
import static dev.Driden.project.gfx.Assets.dirt_water_pond;
import java.awt.Color;
import java.awt.Graphics;
import tiles.Tile;

/**
 *
 * @author Yunus
 */
public class Dirt_Water_Pond extends StaticEntity {

    public Dirt_Water_Pond(Handler handler, float x, float y) {
        super(handler, x, y, Tile.TILEWIDTH, Tile.TILEHIGHT );
        
       // bounds.x = 10 ;
       // bounds.y = (int ) (height / 1.5f);
       // bounds.width = width -20 ;
       // bounds.height = (int ) (height - height /1.5) ;
        bounds.x = 20;
        bounds.y = 35 ;
        bounds.width =80  ;
        bounds.height = 80;
    }

    
    public void tick() {
        
    }
    
    public void die(){
        
    }

    
    public void render(Graphics g) {
        g.drawImage(Assets.dirt_water_pond, (int) (x - handler.getGameCamera().getxOffset()), 
                (int) (y -handler.getGameCamera().getyOffset()), null) ;
        
         // g.setColor(Color.red);
      // g.fillRect((int) (x+ bounds.x -handler.getGameCamera().getxOffset())
        //,(int) (y+ bounds.y -handler.getGameCamera().getyOffset()),
       // bounds.width,bounds.height
       // );
    }
    
}
