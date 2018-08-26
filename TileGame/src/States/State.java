/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package States;

import dev.Driden.project.GameCode;
import dev.Driden.project.Handler;
import java.awt.Graphics;

/**
 *
 * @author Yunus
 */
public abstract class State {
    
    private static State currentstate= null;
    protected Handler handler ;
    
    public State(Handler handler) {
            this.handler = handler ;
        }
    
    
    
    
    
    public abstract void tick();
    public abstract void render (Graphics g);
    
    
    //Getters-Setters
    
    public static State getState()
    {
        return currentstate;
    }
    
    public static void setState(State state){
        currentstate = state;
    }
}
