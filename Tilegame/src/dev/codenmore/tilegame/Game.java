package dev.codenmore.tilegame;

import dev.codenmore.tilegame.display.Display;
import dev.codenmore.tilegame.entity.handler;
import dev.codenmore.tilegame.gfx.Assets;
import dev.codenmore.tilegame.gfx.ImageLoader;
import dev.codenmore.tilegame.gfx.SpriteSheet;
import dev.codenmore.tilegame.gfx.gamecamera;
import dev.codenmore.tilegame.state.GameOver;
import dev.codenmore.tilegame.state.GameState;
import dev.codenmore.tilegame.state.MenuState;
import dev.codenmore.tilegame.state.State;
import dev.codenmore.tilegame.state.input.Keyboard;
import dev.codenmore.tilegame.state.input.Mouse;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author asus
 */
public class Game implements Runnable {
    private Display display;
    private int width,height;
    public String title;
    private boolean running =false;
    private Thread thread;
    private BufferStrategy bs;
    private Graphics g;
    public State gameState;
    public State menuState;
    public State GameOver;
    private Keyboard keyboard;
    private Mouse mouse;
    private gamecamera gamecamera;
    private handler handler;
    public Game(String title,int width,int height){
        this.width=width;
        this.height=height;
        this.title=title; 
        keyboard=new Keyboard();
        mouse=new Mouse();
        
    }
    public Keyboard getKeyboard(){
        return keyboard;
    }
    public gamecamera getgamecamera(){
        return gamecamera;
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
    private void init() throws IOException{
        display = new Display(title,width,height);
        Assets.init();
        gamecamera= new gamecamera(this,0, 0);
        handler = new handler(this);
        display.getFrame().addKeyListener(keyboard);
        display.getFrame().addMouseListener(mouse);
        display.getFrame().addMouseMotionListener(mouse);
        display.getCanvas().addMouseListener(mouse);
        display.getCanvas().addMouseMotionListener(mouse);
        gameState = new GameState(this.handler);
        menuState = new MenuState(this.handler);
        GameOver = new GameOver(this.handler);
        State.setCurrentState(menuState);
      
    }
    public void setNewState(){
    gameState=new GameState(handler);
}
    public Mouse getMouse() {
        return mouse;
    }
    private void update(){
        keyboard.update();
        if(State.getCurrentState()!=null) State.getCurrentState().update();
       
    }
    private void render(){
        bs = display.getCanvas().getBufferStrategy();
        if(bs == null){
            display.getCanvas().createBufferStrategy(2);
            return;
        }
        g = bs.getDrawGraphics();
        g.clearRect(0, 0, width, height);
        //////
        if(State.getCurrentState()!=null) State.getCurrentState().render(g);
       
        
        //vẽ 
        bs.show();
        Toolkit.getDefaultToolkit().sync();
        g.dispose();
    }
    @Override
    public void run() {
        try {
            init();
        } catch (IOException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }
          int fps = 60;
        double timeperupdate = 1000/fps;
        long lastTime = System.currentTimeMillis();
        while(running){
            if(lastTime+timeperupdate<System.currentTimeMillis()){
                lastTime = System.currentTimeMillis();
                update();
                render();
            }
        } 
            stop();
            }
    public synchronized void start(){
        if(running) return;
        running=true;
        thread= new Thread(this);
        thread.start();
        
    }
    public synchronized  void stop() {
        if(!running) return;
        running=false;
        try {
            thread.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
