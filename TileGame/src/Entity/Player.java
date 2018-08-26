/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;


import Items.Inventory;
import dev.Driden.project.GameCode;
import dev.Driden.project.Handler;
import dev.Driden.project.gfx.Animation;
import dev.Driden.project.gfx.Assets;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

/**
 *
 * @author Yunus
 */
public class Player extends Creature {

     
    //Animations
    private Animation  animDown,animUp,animLeft,animRight ;
    
    // Attack Time
    
    private long lastAttackTimer ,attackCoolDown = 1 ,attackTimer = attackCoolDown;
    
    
    //Inventory
    
    private Inventory inventory ;
    
    public Player(Handler handler,float x, float y) {
        
        super(handler, x, y,Creature.DEFAULT_CREATURE_WIDTH,Creature.DEFAULT_CREATURE_HEIGHT);
        
        bounds.x = 20;
        bounds.y = 35 ;
        bounds.width =50  ;
        bounds.height = 50;
        
        //Animation
        animDown  = new Animation(500,Assets.player_down);
        animUp  = new Animation(500,Assets.player_up);
        animLeft  = new Animation(500,Assets.player_left);
        animRight  = new Animation(500,Assets.player_right);
        
      inventory = new Inventory(handler);
    }

   
    public void tick() {
        animDown.tick();
        animUp.tick();
        animLeft.tick();
        animRight.tick();
        
        getInput();
        move();
        handler.getGameCamera().centerOnEntity(this);
        
        //Attack
        checkAttacks();
        
        //Invenntory
        
        inventory.tick();
        
         
    }
    
    public void checkAttacks(){
        
        attackTimer += System.currentTimeMillis()-lastAttackTimer;
        lastAttackTimer = System.currentTimeMillis();
        if(attackTimer < attackCoolDown)
            return ;
        
        
        
        Rectangle cb = getCollisionBounds(0,0);
        Rectangle ar = new Rectangle ();
        int arSize = 20 ;
        
        ar.width = arSize ;
        ar.height = arSize;
        
        if(handler.getKeyManager().aUp){
            ar.x = cb.x+  cb.width/2 - arSize/2;
            ar.y = cb.y-  arSize;
        }else if(handler.getKeyManager().aDown){
            ar.x = cb.x+  cb.width/2 - arSize/2;
            ar.y = cb.y+  cb.height ;
        }
        else if(handler.getKeyManager().aLeft){
            ar.x = cb.x-  arSize;
            ar.y = cb.y + cb.height/2 - arSize /2;
        }
        else if(handler.getKeyManager().aRight){
            ar.x = cb.x +  cb.width;
            ar.y = cb.y + cb.height/2 - arSize /2;
        }else {
            return ;
        }
        
        attackTimer = 0 ;
        
        for(Entity e : handler.getWorld().getEntityManager().getEntities()){
            if(e.equals(this))
                continue;
            if(e.getCollisionBounds(0,0).intersects(ar)){
                e.hurt(1);
                return ;
            }
        }
    }
    
    public void die(){
        System.out.println("You loose");
    }
    
    
    private  void getInput (){
        xMove = 0 ;
        yMove = 0;
        
        if(handler.getKeyManager().up)
            yMove = -speed ;
        if(handler.getKeyManager().down)
            yMove = speed ;
        if(handler.getKeyManager().right)
            xMove = speed ;
        if(handler.getKeyManager().left)
            xMove = -speed ;
    }

    
    public void render(Graphics g) {
        g.drawImage(getCurrentAnimationFrame(), (int) (x-handler.getGameCamera().getxOffset()), (int) (y-handler.getGameCamera().getyOffset()), 90, 90 , null);
        
        inventory.render(g);


          // g.setColor(Color.red);
      // g.fillRect((int) (x+ bounds.x -handler.getGameCamera().getxOffset())
        //,(int) (y+ bounds.y -handler.getGameCamera().getyOffset()),
       // bounds.width,bounds.height
       // );
        
        
        
        
    }
    
    private BufferedImage getCurrentAnimationFrame(){
        
       if(xMove < 0 ){
           return animLeft.getCurrentFrame();
       }else if(xMove >0 ){
           return animRight.getCurrentFrame();
       }else if(yMove < 0 ){
           return animUp.getCurrentFrame();
       }else if(yMove>0) {
           return animDown.getCurrentFrame();
       }else 
           return Assets.player_11;
               
    }

    public Inventory getInventory() {
        return inventory;
    }
    
   
}
