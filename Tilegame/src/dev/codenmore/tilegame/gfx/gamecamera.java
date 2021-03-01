package dev.codenmore.tilegame.gfx;

import dev.codenmore.tilegame.Game;
import dev.codenmore.tilegame.entity.Entity;

/**
 *
 * @author asus
 */
public class gamecamera {
    private float xoffset,yoffset;
    private Game game;
    public gamecamera(Game game,float xoffset, float yoffset) {
        this.game=game;
        this.xoffset = xoffset;
        this.yoffset = yoffset;
    }
    public void centrerEntity(Entity e){
       xoffset=e.getX() - game.getWidth()/2;
       yoffset=e.getY() - game.getHeight()/2;
    }

    public float getXoffset() {
        return xoffset;
    }

    public void setXoffset(float xoffset) {
        this.xoffset = xoffset;
    }

    public float getYoffset() {
        return yoffset;
    }

    public void setYoffset(float yoffset) {
        this.yoffset = yoffset;
    }
    public void move(float xMove,float yMove){
        xoffset += xMove;
        yoffset += yMove;
    }
    
}
