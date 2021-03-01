package dev.codenmore.tilegame.entity;


import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author asus
 */
public abstract class   Entity {
    protected handler handler;
    protected float x,y;
    protected int width,height;
    protected Rectangle bound;
    protected int health;
    protected boolean isAlive =true;
    public static final int HEALTH=4,WIDTH=32,HEIGHT=32;

    public boolean isIsAlive() {
        return isAlive;
    }

    public void setIsAlive(boolean isAlive) {
        this.isAlive = isAlive;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
            

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
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
    public void getHit(int amt){
        health -=amt;
        if(health<=0){
            isAlive=false;
            die();
        }
    }
    public abstract void die();
    public Rectangle getCollisionBounds(float xof,float yof){
        return new Rectangle((int)(x+bound.x+xof),(int)(y+bound.y+yof),bound.width,bound.height );
    }
    public boolean EntityCollision(float xof,float yof){
        for(Entity e:handler.getMap().getEntityManager().getEntity()){
            if(e.equals(this)) continue;
            if(e.getCollisionBounds(0f, 0f).intersects(getCollisionBounds(xof, yof)))
            return true;
        }
        return false;
    }
    public boolean MoveEntityCollision(float xof,float yof){
        for(Entity e:handler.getMap().getEntityManager().getMoveentity()){
            if(e.equals(this)) continue;
            if(e.getCollisionBounds(0f, 0f).intersects(getCollisionBounds(xof, yof)))
            return true;
        }
        return false;
    }

    public Entity(handler handler,float x, float y, int width, int height) {
        this.handler=handler;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        bound= new Rectangle(0, 0, width, height);
        this.health=HEALTH;

    }

    public Entity(float x, float y) {
        this.x = x;
        this.y = y;
    }
    public abstract void update();
    public abstract void render(Graphics g);
    
}
