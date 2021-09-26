package srcGame.beginGame.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener {

    private boolean[] keys;

    public boolean up, down, left, right, jump, collisionCheckOn, attackRight, attackLeft;

    public KeyManager() {
        keys = new boolean[256];
    }

    public void tick() {
        up = keys[KeyEvent.VK_UP];
        down = keys[KeyEvent.VK_DOWN];
        left = keys[KeyEvent.VK_LEFT];
        right = keys[KeyEvent.VK_RIGHT];
        jump = keys[KeyEvent.VK_SPACE];

        attackRight = keys[KeyEvent.VK_X];
        attackLeft = keys[KeyEvent.VK_Z];

        // TOOLS
        collisionCheckOn = keys[KeyEvent.VK_F1];
    }

    @Override
    public void keyPressed(KeyEvent e) {
        keys[e.getKeyCode()] = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keys[e.getKeyCode()] = false;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }
}
