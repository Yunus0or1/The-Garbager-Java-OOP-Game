 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package States;

import dev.Driden.project.GameCode;
import dev.Driden.project.Handler;
import dev.Driden.project.gfx.Assets;
import java.awt.Graphics;
import UI.ClickListener;
import UI.UIImageButton;
import UI.UIManager;

/**
 *
 * @author Yunus
 */
public class MenuStates extends State {
    
    private UIManager uiManager ;
    
    public MenuStates(Handler handler){
        super(handler);
        uiManager = new UIManager(handler) ;
        handler.getMouseManager().setUIManager(uiManager);
        
        uiManager.addObject(new UIImageButton(400,400,200,200,Assets.btn_start,new ClickListener(){

            
            public void onClick() {
              handler.getMouseManager().setUIManager(null);
                State.setState(handler.getGame().gamestate);
            }
        }));
    }
    
    public void tick()
    {
        
      uiManager.tick();
                
    }
    public void render(Graphics g){
        uiManager.render(g);
    }

   
}

