package srcGame.beginGame.ui;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import srcGame.beginGame.Handler;

public class UIManager {

    private Handler handler;
    private ArrayList<UIObject> objects;

    public UIManager(Handler handler) {
        this.handler = handler;
        objects = new ArrayList<UIObject>();
    }

    public void tick() {
        for (UIObject o : objects)
            o.tick();
    }

    public void render(Graphics g) {
        for (UIObject o : objects)
            o.render(g);
    }

    public void onMouseMove(MouseEvent e) {
        for (UIObject o : objects)
            o.onMouseMove(e);
    }

    public void onMouseReleased(MouseEvent e) {
        for (UIObject o : objects)
            o.onMouseReleased(e);
    }

    public void addUIObject(UIObject o) {
        objects.add(o);
    }

    public void removeUIObject(UIObject o) {
        objects.remove(o);
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public Handler getHandler() {
        return handler;
    }
}
