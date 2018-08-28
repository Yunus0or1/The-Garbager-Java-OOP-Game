/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.Driden.project.gfx;
import dev.Driden.project.GameCode;
import java.awt.Graphics;
import java.awt.image.*;
/**
 *
 * @author Yunus
 */
public class Assets {
    
    private static final int width = 64,height =64;
    public static BufferedImage grass,rock,tree,dirt,block,player_11,test,building1,building2,water,bridge,
            cut_tree,dirt_water_river,dirt_water_pond ,dustbin_1,dustbin_2,factory,factory2,
            clean_water_pond,block_tile,endcover,dustbin ;
            
    public static BufferedImage[] player_down,player_up,player_left,player_right ;
    public static BufferedImage[] btn_start ;
    
    
    public static void init()
    {
        
        
        
        //Item
        
        dustbin = ImageLoader.loadImage("/res/textures/dustbin/d_1.jpg");
        
        //Arrays Initialization
        player_down = new BufferedImage[2];
        player_up = new BufferedImage[2];
        player_right = new BufferedImage[2];
        player_left= new BufferedImage[2];
        btn_start = new BufferedImage[2];
        
        
        //first SUST image
        
        btn_start[0] =ImageLoader.loadImage("/res/textures/cover/syl1.jpg");
        btn_start[1] =ImageLoader.loadImage("/res/textures/cover/syl2.jpg");
        
        
        // Right - left - down - up move
        player_down[0]= ImageLoader.loadImage("/res/textures/player/front_0.png");
        player_down[1]= ImageLoader.loadImage("/res/textures/player/front_1.png");
        player_up[0]= ImageLoader.loadImage("/res/textures/player/back_0.png");
        player_up[1]= ImageLoader.loadImage("/res/textures/player/back_1.png");
        player_right[0]= ImageLoader.loadImage("/res/textures/player/right_0.png");
        player_right[1]= ImageLoader.loadImage("/res/textures/player/right_1.png");
        player_left[0]= ImageLoader.loadImage("/res/textures/player/left_0.png");
        player_left[1]= ImageLoader.loadImage("/res/textures/player/left_1.png");
        player_11=ImageLoader.loadImage("/res/textures/player/front_1.png");  //default move
        
        
        //Other staff
        
        //Importent Tiles that are rendering
        building1 = ImageLoader.loadImage("/res/textures/Building/build_1.png");
        building2 = ImageLoader.loadImage("/res/textures/Building/build_2.png");
        
        endcover = ImageLoader.loadImage("/res/textures/cover/end.jpg");
       
        
        bridge =ImageLoader.loadImage("/res/textures/bridge/b.jpg");
        
        cut_tree = ImageLoader.loadImage("/res/textures/tree/cut_tree_tile.png");
        
        dustbin_1 = ImageLoader.loadImage("/res/textures/dustbin/d_1.jpg");
        
        dustbin_2 = ImageLoader.loadImage("/res/textures/dustbin/d_2.jpg");
         
        factory = ImageLoader.loadImage("/res/textures/factory/factory_tile.png");
        
        factory2 = ImageLoader.loadImage("/res/textures/factory/factory_tile2.png");
        
        clean_water_pond = ImageLoader.loadImage("/res/textures/Water/clean_water_pond.jpg");
        
        dirt_water_river = ImageLoader.loadImage("/res/textures/Water/dirt_water_river.jpg");
        
        dirt_water_pond = ImageLoader.loadImage("/res/textures/Water/dirt_water_pond.jpg");
        
        tree = ImageLoader.loadImage("/res/textures/tree/tree_tile.png");
        
        grass = ImageLoader.loadImage("/res/textures/grass/grass_tile.jpg");
        
        block_tile = ImageLoader.loadImage("/res/textures/grass/grass_tile.jpg");
        
        water = ImageLoader.loadImage("/res/textures/Water/water.jpg");
        
       
        
        
      
        
        
        
       
        
        
        
        //test =ImageLoader.loadImage("/res/textures/player/.png");
        
       
    }
    
   
}
