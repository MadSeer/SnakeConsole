import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class InputButton implements KeyListener {
    public String lastPressedkey;
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        this.lastPressedkey = KeyEvent.getKeyText(e.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
