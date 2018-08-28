/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Worlds;

import Entity.Entity;
import static Entity.Entity.q;
import Statics.EntityManager;
import Entity.Player;
import Items.ItemManager;
import Statics.Cut_Tree;
import Statics.Dirt_Water_Pond;
import Statics.Dirt_Water_River;
import Statics.Dustbin_1;
import Statics.Dustbin_2;
import dev.Driden.project.GameCode;
import dev.Driden.project.Handler;
import dev.Driden.project.gfx.Utils;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import static sun.audio.AudioPlayer.player;
import tiles.Tile;

/**
 *
 * @author Yunus
 */
public class World {
    
    
    protected Handler handler;  
    
    private EntityManager entityManager ;
    
    private int width  ,height ;
    
    private int spawnX, spawnY;
    
    private Player player;
    
    private int [] [] tiles; 
    
    private ItemManager itemManager ;
    
    int p ,q;
   

    public World (Handler handler,String path) 
    {
        
        this.handler = handler ;
 
        //Temporary EntityManager Code for making Tree 
        
        entityManager = new EntityManager(handler,new Player(handler,200,200));
        itemManager = new ItemManager(handler );
        
        

        
        
        
        // Dustbins
        for(int z = 1 ;z<15 ;z++)
        entityManager.addEntity (new Dustbin_2 (handler , z*100 ,4*100));
       
        
        
        for(int z = 24 ;z<35 ;z++)
        entityManager.addEntity (new Dustbin_1 (handler ,z*100 ,5*100));
        
        for(int y = 47 ; y<51;y++)
        for(int z = 45 ;z<51 ;z++)
        entityManager.addEntity (new Dustbin_1 (handler ,z*100 ,y*100));
        
        
        //Dirt_water_pond
        
        entityManager.addEntity (new Dirt_Water_Pond (handler ,49*100 ,7*100));
        
         
      //CUT tree
        for(int z = 23;z<35 ;z++)
        entityManager.addEntity (new Cut_Tree (handler ,z*100 ,14*100));
        
        
        for(int z = 1;z<25 ;z++)
        entityManager.addEntity (new Cut_Tree (handler ,z*100 ,47*100));
         
         
        //dir water river
        
        entityManager.addEntity (new Dirt_Water_River (handler ,6*100 ,22*100));
        
        for(int z = 6;z<12 ;z++)
        entityManager.addEntity (new Dirt_Water_River (handler ,z*100 ,23*100));
        
        
        for(int z = 13;z<28 ;z++)
        entityManager.addEntity (new Dirt_Water_River (handler ,z*100 ,23*100));
        
        
        for(int z = 48;z<49 ;z++)
        entityManager.addEntity (new Dirt_Water_River (handler ,z*100 ,23*100));
        
        for(int z = 48;z<49 ;z++)
        entityManager.addEntity (new Dirt_Water_River (handler ,z*100 ,20*100));
        
        
       

        loadWorld (path);
        
        entityManager.getPlayer().setX(spawnX);
        entityManager.getPlayer().setY(spawnY);
    }    
    
    public void tick (){
            
        itemManager.tick();
        entityManager.tick();
         if (handler.getKeyManager().keyJustPressed(KeyEvent.VK_R)) {
          
            System.out.println("Q in World " + Entity.q);
        }
       
    }
        
    
    public void render(Graphics g){
        
        int xStart = (int)Math.max(0,handler.getGameCamera().getxOffset() / Tile.TILEWIDTH );
        int xEnd = (int) Math.min(width, (handler.getGameCamera().getxOffset() + handler.getWidth()) /Tile.TILEWIDTH +1 ) ;
        int yStart =(int)Math.max(0,handler.getGameCamera().getyOffset() / Tile.TILEHIGHT );
        int yEnd =(int) Math.min(height, (handler.getGameCamera().getyOffset() + handler.getWidth()) /Tile.TILEHIGHT +1 ) ;
        
         
         
        for(int y= yStart ; y< yEnd ; y++)
             for (int x=xStart ; x < xEnd ; x++){
                 
                 // MY Coding
                // System.out.println("x=" + x + "," +"y=" +y);
                 //System.out.println("xTile = " + (int)(x*Tile.TILEHIGHT - handler.getGameCamera().getxOffset())
                 
               //  + " ," + "yTile= " +(int)(y*Tile.TILEHIGHT-handler.getGameCamera().getyOffset()) );
                 
                 int m= (int)(x*Tile.TILEHIGHT - handler.getGameCamera().getxOffset());
                 int n= (int)(x*Tile.TILEHIGHT - handler.getGameCamera().getxOffset());
                 
                 if(m>512 || n> 512)
                     continue ;
                 
                 
                 else /*Upto Here*/ 
                     getTile(x,y).render (g,(int)(x*Tile.TILEHIGHT - handler.getGameCamera().getxOffset()),
                         (int)(y*Tile.TILEHIGHT-handler.getGameCamera().getyOffset()) );
             }
        
        
                
        
        //Entities
        
        itemManager.render(g);
        entityManager.render(g); 
        
        
        
    }
    
    
    
    public Tile getTile (int x , int y ){
        
        if(x<0 || y<0 || x>width || y >height )
            return Tile.grassTile;
        
       Tile t= Tile.tiles[tiles[x][y]];
       
       if(t == null)
            return Tile.grassTile ;
       
        return t ;
    }
    
    
    
    private  void loadWorld (String path){
        
        String file = Utils.loadFileAsString(path);
        String [] tokens = file.split("\\s+");
        
        
        width =  Utils.parseInt (tokens [0]);
        height = Utils.parseInt (tokens [1]);
        spawnX = Utils.parseInt (tokens [2]);
        spawnY = Utils.parseInt (tokens [3]);
       
  
        tiles = new int [width][height]; 
        
        for(int y= 0 ; y<height ; y++)
             for (int x= 0 ; x <width ; x++){
               tiles [x][y] = Utils.parseInt(tokens[(x +width *y) +4]);
               //System.out.println(tiles[x][y]);
             }
        
         
        
    }
    
    
    
    
    
    
    
    
    //Getters - Setters

    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public ItemManager getItemManager() {
        return itemManager;
    }

    public void setItemManager(ItemManager itemManager) {
        this.itemManager = itemManager;
    }

    
    
    
    
    
   
    
    public int getWidth (){
        return width ;
    }
    
    
    public int getHeight (){
        return height ;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }
    
    
    
  
}


