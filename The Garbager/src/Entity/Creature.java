/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import dev.Driden.project.GameCode;
import dev.Driden.project.Handler;
import tiles.Tile;


public abstract class Creature extends Entity {
    
    
    
    
    public static final float DEFAULT_SPEED = 10f;
    
    public static final int DEFAULT_CREATURE_WIDTH =64;
    public static final int DEFAULT_CREATURE_HEIGHT =64;

    
    protected float speed ;
    protected float xMove,yMove ;
    
    public Creature(Handler handler ,float x, float y,int width , int height) {
    
        super(handler,x,y,width,height);
       
        speed  = DEFAULT_SPEED;
        
        xMove = 0 ;
        yMove = 0 ;
        
    }
    
    public void move (){
        if(!chekcEntityCollisions(xMove,0f))
            moveX();
        
        if(!chekcEntityCollisions(0f,yMove))
            moveY();
       
    }
    
    public void moveX (){
        if(xMove > 0){
            
            int tx = (int) (x+xMove + bounds.x + bounds.width)/Tile.TILEWIDTH ;
            
            if(!collisionWithTile (tx ,(int) (y+bounds.y) /Tile.TILEHIGHT) &&
                  !collisionWithTile(tx , (int) (y + bounds.y + bounds.height)/Tile.TILEHIGHT)  
                    ){
                x+=xMove ;
                
            }else {
                x = tx * Tile.TILEWIDTH - bounds.x - bounds.width -1 ;
            }
            
        }else if(xMove<0){
            int tx = (int) (x+xMove + bounds.x )/Tile.TILEWIDTH ;
            
           if(!collisionWithTile (tx ,(int) (y+bounds.y) /Tile.TILEHIGHT) &&
                  !collisionWithTile(tx , (int) (y + bounds.y + bounds.height)/Tile.TILEHIGHT)  
                    ){
                x+=xMove ;
            }else {
                x = tx * Tile.TILEWIDTH +Tile.TILEWIDTH - bounds.x   ;
           }
        }
    }
    
    public void moveY (){
        
        if(yMove < 0){
            
            int ty = (int) (y + yMove + bounds.y )/Tile.TILEHIGHT ;
            
            if(!collisionWithTile ( (int) (x+bounds.x) /Tile.TILEWIDTH , ty ) &&
                  !collisionWithTile((int) (x+bounds.x +bounds.width) /Tile.TILEWIDTH , ty )  
                    ){
                y+=yMove ;
            }else {
               y=  ty * Tile.TILEHIGHT +Tile.TILEHIGHT - bounds.y ;
            }
           
            
        }else if(yMove > 0){
            
             int ty = (int) (y+yMove + bounds.y +bounds.height )/Tile.TILEHIGHT ;
            
            if(!collisionWithTile ((int) (x+bounds.x) /Tile.TILEWIDTH , ty ) &&
                  !collisionWithTile((int) (x+bounds.x +bounds.width) /Tile.TILEWIDTH , ty )  
                    ){
                y+=yMove ;
            }else {
            y = ty * Tile.TILEHIGHT - bounds.y - bounds.height -1 ;
        }
            
        }
    }
    
    protected boolean collisionWithTile (int x, int y){
        
        return handler.getWorld().getTile(x,y).isSolid();
    }
    
    //Getters - Setters
    
    public float getxMove() {
        return xMove;
    }

    public void setxMove(float xMove) {
        this.xMove = xMove;
    }

    public float getyMove() {
        return yMove;
    }

    public void setyMove(float yMove) {
        this.yMove = yMove;
    }
    
    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }
    
    
}
