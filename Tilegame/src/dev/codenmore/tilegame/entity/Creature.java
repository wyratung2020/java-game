package dev.codenmore.tilegame.entity;


/**
 * @author asus
 */
public abstract class Creature extends Entity {
    public static final int HEALTH = 4, WIDTH = 32, HEIGHT = 32;
    public static final float SPEED = 1.4f;
    protected int health;
    protected float speed, xMove, yMove;

    public Creature(float x, float y) {
        super(x, y);
        health = HEALTH;
        speed = SPEED;
    }

    public float getxMove() {
        return xMove;
    }

    public void setxMove(float xMove) {
        this.xMove = xMove;
    }

    public float getyMove() {
        return yMove;
    }

    public void setyMove(float yMove) {
        this.yMove = yMove;
    }


    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public Creature(handler handler, float x, float y, int width, int height) {
        super(handler, x, y, width, height);
        health = HEALTH;
        speed = SPEED;
        xMove = 0;
        yMove = 0;
    }


}
