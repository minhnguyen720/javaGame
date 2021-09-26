package srcGame.beginGame.gfx;

import java.awt.image.BufferedImage;

public class Animation {
    // index: image 1, image 2, image 3...
    // speed = every second switch
    // timer = when to switch index
    private int speed, index;
    private long lastTime, timer;
    private BufferedImage[] frames;

    public Animation(int speed, BufferedImage[] frames) {
        this.speed = speed;
        this.frames = frames;
        index = 0;
        timer = 0;
        lastTime = System.currentTimeMillis();
    }

    public void tick() {
        timer += System.currentTimeMillis() - lastTime;
        lastTime = System.currentTimeMillis();

        if (timer > speed) {
            index++;
            timer = 0; // reset everything
            if (index >= frames.length)
                index = 0; // whenever animation end, restart it
        }
    }

    public BufferedImage getCurrentFrame() {
        return frames[index];
    }
}
