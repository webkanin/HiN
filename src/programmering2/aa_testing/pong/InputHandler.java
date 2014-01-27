package programmering2.aa_testing.pong;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created with IntelliJ IDEA.
 * User: Marko Sundic
 * Student nr. 530 614
 */


public class InputHandler implements KeyListener{

    public InputHandler (Game game){
        game.addKeyListener(this);
    }



    public void keyPressed(KeyEvent e) {
      int keyCode = e.getKeyCode();

        if(keyCode == e.VK_W){
            Game.player.goingUp = true;
            Game.player.goingDown = false;

        }

        if(keyCode == e.VK_S){
            Game.player.goingUp = false;
            Game.player.goingDown = true;
        }

    }

    public void keyTyped(KeyEvent e) {

    }


    public void keyReleased(KeyEvent e) {

            Game.player.goingUp = false;
            Game.player.goingDown = false;

    }
}
