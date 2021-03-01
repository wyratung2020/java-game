package dev.codenmore.tilegame.state;

import dev.codenmore.tilegame.Game;
import dev.codenmore.tilegame.entity.handler;
import java.awt.Graphics;

/**
 *
 * @author asus
 */
public abstract class State {
    private static State currentState= null;

    public static State getCurrentState() {
        return currentState;
    }

    public static void setCurrentState(State currentState) {
        State.currentState = currentState;
    }

   protected handler handler;
   public State(handler handler){
       this.handler=handler;
       
   }
    
    public abstract void update();
    public abstract void render(Graphics g);
    
    
    
}
