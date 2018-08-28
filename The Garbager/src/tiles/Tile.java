/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiles;


import dev.Driden.project.gfx.Assets;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 *
 * @author Yunus
 */

public class Tile {
    
    
    public static Tile[] tiles = new  Tile [256];
    
    public static Tile grassTile = new GrassTile (0);
    public static Tile buildingTile1 = new BuildingTile1(1);
    public static Tile buildingTile2 = new BuildingTile2(2);
    public static Tile treeTile = new TreeTile(3);
    public static Tile waterTile = new WaterTile(4);
    public static Tile waterpond = new Waterpond(5);
    public static Tile bridgeTile = new BridgeTile(6);
    public static Tile factoryTile = new Factory_Tile(7);
    public static Tile factoryTile2 = new Factory_Tile2(8);
    public static Tile blocktile = new BlockTile(9);
    
// Same as grassTile
    
    public static final int TILEHIGHT = 100 , TILEWIDTH = 100 ;
    protected BufferedImage texture ;
    protected final int id ;
    
    
    public Tile(BufferedImage texture,int id) {
        this.texture =texture ;
        this.id = id ;
        tiles [id] = this ;
    }    
    
    
    public void tick(){
        
    }
    
    public void render (Graphics g , int x , int y){
      g.drawImage (texture, x, y ,TILEWIDTH ,TILEHIGHT ,null );
        
        //temporary Code
        
       // g.drawImage (texture , x, y ,128 ,128 ,null );
    }
    
    public boolean isSolid (){
        return false ;
    }
    
    public int getId(){
    
      return id ;
    }
}
