/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.Driden.project.gfx;

import Entity.Entity;
import dev.Driden.project.GameCode;
import dev.Driden.project.Handler;
import tiles.Tile;

/**
 *
 * @author Yunus
 */
public class GameCamera {
    
    private float xOffset , yOffset ;
    private Handler handler ;
    
    
    
    public GameCamera(Handler handler ,float xOffset,float yOffset){
        
        
        this.handler  = handler ;
        this.xOffset = xOffset ;
        this.yOffset = yOffset ;
        
    }
    
    public void checkBlankSpace(){
        if(xOffset < 100){
            xOffset = 100 ;
        }
        
        else if (xOffset > 51 /*Eikhane problem ase Cause World class theke width access kora jasse na */
                * Tile.TILEWIDTH -handler.getWidth () ){
           xOffset =51* Tile.TILEWIDTH -handler.getWidth ()  ;
       }
        
        
        
        if(yOffset < 100){
            yOffset =70;
        }
        else if(yOffset > 51 *Tile.TILEHIGHT -handler.getHeight ()){
            yOffset = 51/*Eikhane problem ase Cause World class theke height access kora jasse na */
                    *Tile.TILEHIGHT -handler.getHeight ();
        }
    }
    
    public void centerOnEntity (Entity e){
        
        xOffset = e.getX()- handler.getWidth ()/2 + e.getWidth()/2;
        yOffset = e.getY()- handler.getHeight ()/2 +e.getHeight()/2;
        checkBlankSpace();
    }
    
    public void move(float xAmt , float yAmt){
        xOffset += xAmt ;
        yOffset += yAmt ;
        checkBlankSpace();
    }

    public float getxOffset() {
        return xOffset;
    }

    public void setxOffset(float xOffset) {
        this.xOffset = xOffset;
    }

    public float getyOffset() {
        return yOffset;
    }

    public void setyOffset(float yOffset) {
        this.yOffset = yOffset;
    }
    
}
