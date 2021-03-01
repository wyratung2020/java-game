package dev.codenmore.tilegame.entity;

import dev.codenmore.tilegame.gfx.Animation;
import dev.codenmore.tilegame.gfx.Assets;
import dev.codenmore.tilegame.gfx.ImageLoader;
import java.awt.Graphics;

/**
 *
 * @author asus
 */
public class Chest extends StaticEntity{
    private Animation animation;
    private boolean checkkey=false;

    public boolean isCheckkey() {
        return checkkey;
    }

    public void setCheckkey(boolean checkkey) {
        this.checkkey = checkkey;
    }
    
    public Chest(handler handler, float x, float y) {
        super(handler, x, y,32,32);
        animation =new Animation(150,Assets.chest,8);
        bound.x=0;
        bound.y=0;
        bound.width=32;
        bound.height=32;

    }

    @Override
    public void update() {
      animation.update();  
    }

    @Override
    public void render(Graphics g) {
        if(checkkey){
            g.drawImage(ImageLoader.loadImage("/res/image/chest_open.png"), (int) ((int)x-handler.getGamecamera().getXoffset()), (int) ((int)y-handler.getGamecamera().getYoffset()),32,32, null);
            
        }else  g.drawImage(animation.getCurrentFrameDown(), (int) ((int)x-handler.getGamecamera().getXoffset()), (int) ((int)y-handler.getGamecamera().getYoffset()),32,32, null);
    }

    @Override
    public void die() {
      checkkey=true;
     
      this.isAlive=true;
    }
    
}
