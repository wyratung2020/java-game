package dev.codenmore.tilegame.entity;

import dev.codenmore.tilegame.Game;
import dev.codenmore.tilegame.gfx.gamecamera;
import dev.codenmore.tilegame.map.buildmap;
import dev.codenmore.tilegame.state.input.Keyboard;
import dev.codenmore.tilegame.state.input.Mouse;

/**
 *
 * @author asus
 */
public class handler {
    private Game game;
    private buildmap map;
    private Player player;

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public handler(Game game) {
        this.game = game;
    }
    public int getwidth(){
        return game.getWidth();
    }
     public int getheight(){
        return game.getHeight();
    }
     public  gamecamera getGamecamera(){
         return game.getgamecamera();
     }
     public Keyboard getKeyboard(){
         return game.getKeyboard();
     }
    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public buildmap getMap() {
        return map;
    }

    public void setMap(buildmap map) {
        this.map = map;
    }
    public Mouse getMouse(){
      return game.getMouse();
    }
    
    
}
