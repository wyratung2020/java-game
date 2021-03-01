package dev.codenmore.tilegame.state;

import dev.codenmore.tilegame.entity.handler;
import dev.codenmore.tilegame.gfx.ImageLoader;
import java.awt.Graphics;

/**
 *
 * @author asus
 */
public class GameOver extends State {

    public GameOver(handler handler) {
        super(handler);
        
    }

    @Override
    public void update() {
        if(handler.getKeyboard().space){
            handler.getGame().setNewState();
            State.setCurrentState(handler.getGame().gameState);
        }
    }

    @Override
    public void render(Graphics g) {
               g.drawImage(ImageLoader.loadImage("/res/image/GameOver.png"),0,0,800,600, null);
               g.drawString("Press space to try again!", 300, 500);

    }

    
    
}
