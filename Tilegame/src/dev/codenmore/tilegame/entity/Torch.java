package dev.codenmore.tilegame.entity;

import dev.codenmore.tilegame.gfx.Animation;
import dev.codenmore.tilegame.gfx.Assets;
import java.awt.Graphics;

/**
 *
 * @author asus
 */
public class Torch extends StaticEntity{
    private Animation animation;
    public Torch(handler handler, float x, float y) {
        super(handler, x, y,32,32);
        animation =new Animation(150,Assets.torch,6);

    }

    @Override
    public void update() {
      animation.update();  
    }

    @Override
    public void render(Graphics g) {
         g.drawImage(animation.getCurrentFrameDown(), (int) ((int)x-handler.getGamecamera().getXoffset()), (int) ((int)y-handler.getGamecamera().getYoffset()),32,32, null);
    }

    @Override
    public void die() {
     this.isAlive=true;
    }

    
    
}

    

