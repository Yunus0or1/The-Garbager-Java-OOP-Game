/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiles;

import dev.Driden.project.gfx.Assets;

/**
 *
 * @author Yunus
 */
public class BuildingTile1 extends Tile {
    
    public BuildingTile1( int id) {
        super(Assets.building1, id);
    }
    
      public boolean isSolid (){
        return true ;
    }
    
    
}
