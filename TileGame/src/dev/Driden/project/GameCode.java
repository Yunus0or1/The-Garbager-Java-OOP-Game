 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.Driden.project;

import KeyInput.KeyManager;
import KeyInput.MouseManager;
import States.EndState;
import States.GameState;
import States.MenuStates;
import States.State;
import java.awt.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.*;

import dev.Driden.project.gfx.ImageLoader;
import dev.Driden.project.display.Display;
import dev.Driden.project.gfx.Assets;
import dev.Driden.project.gfx.GameCamera;
import dev.Driden.project.gfx.SpriteSheet;

/**
 *
 * @author Yunus
 */
public class GameCode implements Runnable  {
    
    private Display display;
    
    private int width,height;
    
    public String title;
    
    private boolean running = true;
    
    private SpriteSheet sheet;
    
    private BufferStrategy bs;
    
    private Graphics g;
    
    private BufferedImage testimage;//
    
    private Thread thread;
   
    //state::d
    public State gamestate;
    
    public State menustate;
    
   public State endstate ;
    
    //keycode
    
    private KeyManager keyManager;
    private MouseManager  mouseManager ;
    
    //Camera 
    
    private GameCamera gameCamera ;
    
    //Handler
    
    public Handler handler ;
   
    
    public GameCode(String title, int width , int height){
         
        this.width=width;
        this.height = height;
        this.title = title ;
        keyManager = new KeyManager();
        mouseManager = new MouseManager();
    }
    
    
    private void init()
    {
       display = new Display(title,width,height);
       display.getFrame().addKeyListener(keyManager);
       display.getFrame().addMouseListener(mouseManager);
       display.getFrame().addMouseMotionListener(mouseManager);
       display.getCanvas().addMouseListener(mouseManager);
       display.getCanvas().addMouseMotionListener(mouseManager);
       
       
       Assets.init();
       
       
       handler = new Handler (this);
       
       gameCamera = new GameCamera (handler,0,0);
       
       handler = new Handler (this);
       
       gamestate = new GameState(handler);
       
       menustate = new MenuStates(handler);
       
       endstate = new EndState(handler);
       
       State.setState(menustate); //change this thing later to start the game with image change gamestate to menustate
               
    }
    
    private void tick(){
        
       keyManager.tick();
       
       if(State.getState()!=null)
           State.getState().tick();
    }
    
    
    
    private void render(){
       
        bs = display.getCanvas().getBufferStrategy();
        
        if (bs==null){
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        
        g = bs.getDrawGraphics();
        
        //clear screen
        g.clearRect(0,0,width,height);
        
        //State Rendering
        
        if(State.getState()!=null)
           State.getState().render(g);
              
        bs.show();
        
        g.dispose();
    }
    
    
    public void run(){
        
        init();
        
        int fps = 60;
        double timepertick = 1000000000/ fps;
        double delta = 0;
        long now;
        long lasttime = System.nanoTime();
        
        
        while(running){
            now = System.nanoTime();
            delta += (now-lasttime )/timepertick;
            lasttime = now;
            
            if(delta >=1){
            tick();
            render();
            delta--;
            }
            
        }
        stop();  
    }
    
    public synchronized void start (){
         
        if (running)
            return ;
        running = true ;
        thread = new Thread(this) ;
        thread.start();
    }
    
    public synchronized void stop (){
        if(!running )
            return ;
        
        running = false ;
        
        
         try {
             thread.join();
             
         }catch(InterruptedException e){
           e.printStackTrace();
      
         }
    }
    
    
    // Getters-Setters
    
    public KeyManager getKeyManager()
    {
        return keyManager;
    }

    public MouseManager getMouseManager() {
        return mouseManager;
    }

    
  
    public int getWidth (){
        return width ;
    }
    
    public int getHeight (){
        return height ;
    }
    
    public GameCamera getGameCamera (){
        
        return gameCamera ;
    }
    
    
    
    
    
    
    //Launcher code remove if you want
    public static void main(String[] args)
    {
        GameCode game = new GameCode("The Garbager ",500,500);
        
        game.run();
    }
    //Remove until here
}
