package dev.codenmore.tilegame.state.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * @author asus
 */
public class Keyboard implements KeyListener {
    private boolean[] key;
    public boolean up, down, left, right, shift, space;

    public void update() {
        up = key[KeyEvent.VK_W];
        down = key[KeyEvent.VK_S];
        left = key[KeyEvent.VK_A];
        right = key[KeyEvent.VK_D];
        shift = key[KeyEvent.VK_SHIFT];
        space = key[KeyEvent.VK_SPACE];
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        key[e.getKeyCode()] = true;
        System.out.println(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        key[e.getKeyCode()] = false;
    }

    public Keyboard() {
        key = new boolean[256];
    }

    public Keyboard(boolean[] key) {
        this.key = key;
    }


}
