/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Items;

import dev.Driden.project.Handler;
import dev.Driden.project.gfx.Assets;
import static dev.Driden.project.gfx.Assets.dustbin_1;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

/**
 *
 * @author Yunus
 */
public class Item {
    
    //Handler 
    
    public static Item [] items = new Item[256];
    
    public static Item dustbin = new Item (Assets.dustbin_1 ,"dustbin",0);
   
   
    
    
    
    
    //class
    
    public static final int ITEMWIDTH = 32 , ITEMHEIGHT =32 ;
    
    protected Handler handler ;
    protected BufferedImage  texture ;
    protected String name;
    protected  int id;
    
    protected Rectangle bounds;
    
    protected int x,y,count;
    
    protected boolean pickedUP = false ;
    
    public Item(BufferedImage texture,String name,int id){
        this.texture = texture ;
        this.name = name ;
        this.id = id;
        count = 1;
        
        
        bounds = new Rectangle (x,y,ITEMWIDTH,ITEMHEIGHT);
        items[id] =this ;
    }
    
    public void tick(){
        
        if(handler.getWorld().getEntityManager().getPlayer().getCollisionBounds(0f, 0f).intersects(bounds)){
          pickedUP = true ;
          handler.getWorld().getEntityManager().getPlayer().getInventory().addItem(this);
        }
        
    }
    
    public void render (Graphics g){
        if(handler == null)
            return ;
        render(g,(int)(x-handler.getGameCamera().getxOffset()),(int)(y-handler.getGameCamera().getyOffset()) );
    }
    
    
    public void render (Graphics g,int x , int y ){
        
        g.drawImage(texture,x,y,ITEMWIDTH,ITEMHEIGHT,null);
    }
    
    public Item createNew(int x,int y){
        Item i = new Item(texture,name ,id);
        i.setPosition(x,y);
        return i;
    }
    
    public void setPosition(int x , int y ){
        this.x = x ;
        this.y = y;
        
        bounds.x = x ;
        bounds.y = y ;
    }

    
    //Getters - Setters
    
    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public BufferedImage getTexture() {
        return texture;
    }

    public void setTexture(BufferedImage texture) {
        this.texture = texture;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public boolean isPickedUP() {
        return pickedUP;
    }
    
    
}
