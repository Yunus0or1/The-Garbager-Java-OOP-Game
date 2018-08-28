/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Statics;

import Items.Item;
import dev.Driden.project.Handler;
import dev.Driden.project.gfx.Assets;
import java.awt.Color;
import java.awt.Graphics;
import tiles.Tile;

/**
 *
 * @author Yunus
 */
public class Cut_Tree extends StaticEntity {

    public Cut_Tree(Handler handler, float x, float y) {
        super(handler, x, y, Tile.TILEWIDTH, Tile.TILEHIGHT );
        
       // bounds.x = 10 ;
       // bounds.y = (int ) (height / 1.5f);
       // bounds.width = width -20 ;
       // bounds.height = (int ) (height - height /1.5) ;
        bounds.x = 20;
        bounds.y = 0 ;
        bounds.width =80  ;
        bounds.height = 100;
    }

    
    public void tick() {
        
    }
    
    public void die(){
        
        
    }

    
    public void render(Graphics g) {
        g.drawImage(Assets.cut_tree, (int) (x - handler.getGameCamera().getxOffset()), 
                (int) (y -handler.getGameCamera().getyOffset()), null) ;
        
          // g.setColor(Color.red);
      // g.fillRect((int) (x+ bounds.x -handler.getGameCamera().getxOffset())
        //,(int) (y+ bounds.y -handler.getGameCamera().getyOffset()),
       // bounds.width,bounds.height
       // );
    }
    
}
