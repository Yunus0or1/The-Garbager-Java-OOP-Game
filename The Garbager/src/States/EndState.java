/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package States;

import dev.Driden.project.Handler;
import dev.Driden.project.gfx.Assets;
import java.awt.Graphics;

/**
 *
 * @author Yunus
 */
public class EndState extends State {

    public EndState(Handler handler) {
        super(handler);
    }

    @Override
    public void tick() {
      
    }

    @Override
    public void render(Graphics g) {
      g.drawImage(Assets.endcover,0,0, 500 , 500 , null);
    }
    
}
