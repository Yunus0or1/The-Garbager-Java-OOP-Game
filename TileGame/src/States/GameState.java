/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package States;

import Entity.Player;
import Statics.Cut_Tree;
import Worlds.World;
import dev.Driden.project.GameCode;
import dev.Driden.project.Handler;
import dev.Driden.project.gfx.Assets;
import java.awt.Graphics;
import java.io.FileNotFoundException;
import tiles.Tile;

/**
 *
 * @author Yunus
 */
public  class GameState extends State {
    
   
    private World world ;
    
    private Player player;
  
    
    public GameState(Handler handler) {
        
         super(handler);
        
        
         world = new World(handler ,"E:\\WorkStation\\Java Project\\TileGame\\src\\res\\textures\\Worlds\\world1.txt");
         
         handler.setWorld (world);
         
  
    }
    
    public void tick() {
     
       
       world.tick();
    }

  
    public void render(Graphics g) {
       
       world.render(g);
     
    }

  
    
}
