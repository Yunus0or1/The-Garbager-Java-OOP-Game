/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.Driden.project.gfx;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.image.*;

/**
 *
 * @author Yunus
 */
public class ImageLoader {
    
    
    public static BufferedImage loadImage(String path){
        try {
            return ImageIO.read(ImageLoader.class.getResource(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }   
    
}
