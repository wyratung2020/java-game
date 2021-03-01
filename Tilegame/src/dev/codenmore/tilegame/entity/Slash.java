package dev.codenmore.tilegame.entity;

import dev.codenmore.tilegame.gfx.Animation;
import dev.codenmore.tilegame.gfx.Assets;
import java.awt.Graphics;

/**
 *
 * @author asus
 */
public class Slash extends StaticEntity{
    private Animation animation;
    private Animation animationleft;

    public Animation getAnimation() {
        return animation;
    }
    public Slash(handler handler) {
        super(handler,0,0,32,32);
        animation =new Animation(35,Assets.slash,3);
        animationleft =new Animation(35,Assets.slashleft,3);

    }
    
    @Override
    public void update() {
      animation.update();  
      animationleft.update();  
    }

    @Override
    public void render(Graphics g) {
         g.drawImage(animation.getCurrentFrameDown(), (int) ((int)handler.getPlayer().x-handler.getGamecamera().getXoffset())+32, (int) ((int)handler.getPlayer().y-handler.getGamecamera().getYoffset()),16,32, null);
         g.drawImage(animationleft.getCurrentFrameDown(), (int) ((int)handler.getPlayer().x-handler.getGamecamera().getXoffset())-16, (int) ((int)handler.getPlayer().y-handler.getGamecamera().getYoffset()),16,32, null);
    }

    @Override
    public void die() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}

