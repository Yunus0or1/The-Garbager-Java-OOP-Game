/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.Driden.project;

import KeyInput.KeyManager;
import KeyInput.MouseManager;
import Worlds.World;
import dev.Driden.project.gfx.GameCamera;

/**
 *
 * @author Yunus
 */
public class Handler {

    
    
   
    private GameCode game ;
    
    private World world;
    
    public Handler (GameCode game)
    {
        this.game = game ;
    }
    
    public GameCamera getGameCamera(){
        return game.getGameCamera();
    }
    
    public KeyManager getKeyManager()
    {
        return game.getKeyManager();
    }
    
    
    
    public int getWidth (){
        return game.getWidth();
    }
    
     public int getHeight(){
        return game.getHeight();
    }

    public GameCode getGame() {
        return game;
    }

    public MouseManager getMouseManager(){
        return game.getMouseManager();
    }
   

    public void setMouseManager(MouseManager mouseManager) {
        
    }
    
    public void setGame(GameCode game) {
        this.game = game;
    }

    public World getWorld() {
        return world;
    }

    public void setWorld(World world) {
        this.world = world;
    }

   
    
   
    
}
