/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Items;

import dev.Driden.project.Handler;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Yunus
 */
public class ItemManager {
    
    private Handler handler ;
    private ArrayList<Item> items;
    
    public ItemManager(Handler handler){
        this.handler = handler ;
        items = new ArrayList<Item>();
    }
    
    public void tick(){
                
            Iterator <Item> it = items.iterator();
            while(it.hasNext()){
                Item i = it.next();
                i.tick();
                if(i.isPickedUP())
                    it.remove();
            }
    }
    
    public void render (Graphics g){
        
        for(Item i :items)
            i.render(g);
    }
    public void addItem (Item i)
    {
        i.setHandler (handler);
        items.add(i); 
    }

    
    //Getters - Setters
    
    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }
    
    
}
