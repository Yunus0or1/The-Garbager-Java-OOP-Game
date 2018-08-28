/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import States.State;
import dev.Driden.project.GameCode;
import dev.Driden.project.Handler;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author Yunus
 */
public abstract class Entity {

    //protected GameCode game ;
    public static int q = 0;

    protected Handler handler;

    protected float x, y;

    protected float xMove, yMove;

    protected int width, height;

    protected Rectangle bounds;

    protected boolean active = true;

    protected int health;
    public static final int DEFAULT_HEATH = 10;

    public Entity(Handler handler, float x, float y, int width, int height) {

        this.handler = handler;
        this.x = x;
        this.y = y;

        this.height = height;
        this.width = width;
        health = DEFAULT_HEATH;

        bounds = new Rectangle(0, 0, width, height);

    }

    public abstract void tick();

    public abstract void render(Graphics g);

    public abstract void die();

    public void hurt(int amt) {
        health -= amt;
        if (health <= 0) {
            active = false;
            die();
            q++;
            System.out.println("Q in Entity " + q);

            if (q == 56) {
                State.setState(handler.getGame().endstate);
            }

        }
    }

    public boolean chekcEntityCollisions(float xOffset, float yOffset) {

        for (Entity e : handler.getWorld().getEntityManager().getEntities()) {
            if (e.equals(this)) {
                continue;
            }
            if (e.getCollisionBounds(0f, 0f).intersects(getCollisionBounds(xOffset, yOffset))) {

                return true;
            }
        }
        return false;
    }

    public Rectangle getCollisionBounds(float xOffset, float yOffset) {
        return new Rectangle((int) (x + bounds.x + xOffset),
                (int) (y + bounds.y + yOffset), bounds.width, bounds.height);

    }

    //Getters-Setters
    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }
}
