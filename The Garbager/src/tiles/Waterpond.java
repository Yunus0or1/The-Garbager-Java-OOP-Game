/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiles;

import dev.Driden.project.gfx.Assets;
import java.awt.image.BufferedImage;

/**
 *
 * @author Yunus
 */
class Waterpond extends Tile {

    public Waterpond( int id) {
        super(Assets.clean_water_pond, id);
    }
    
    
    
      public boolean isSolid (){
        return true ;
    }
    
    
}

