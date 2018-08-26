/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Items;

/**
 *
 * @author Yunus
 */
import dev.Driden.project.Handler;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Inventory {

    private Handler handler;
    private boolean active = false;
    private ArrayList<Item> inventoryItems;

    public Inventory(Handler handler) {
        this.handler = handler;
        inventoryItems = new ArrayList<Item>();
    }

    public void tick() {
        if (handler.getKeyManager().keyJustPressed(KeyEvent.VK_E)) {
            active = !active;
        }
        if (!active) {
            return;
        }

        //test code for Inventory Working
        //  System.out.println("Inventory");
        // for(Item i : inventoryItems){
        //    System.out.println(i.getName() +"  " + i.getCount());
        // }
    }

    public void render(Graphics g) {
        if (!active) {
            return;
        }
    }

    // Inventory methods
    public void addItem(Item item) {
        for (Item i : inventoryItems) {
            if (i.getId() == item.getId()) {
                i.setCount(i.getCount() + item.getCount());
                return;
            }
        }
        inventoryItems.add(item);
    }

    // GETTERS SETTERS
    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

}
