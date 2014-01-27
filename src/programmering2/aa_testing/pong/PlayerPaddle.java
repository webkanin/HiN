package programmering2.aa_testing.pong;
import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: Marko Sundic
 * Student nr. 530 614
 */
public class PlayerPaddle {

    int x;
    int y;
    int width = 15;
    int height = 40;

    boolean goingUp = false;
    boolean goingDown = false;

    public PlayerPaddle(int x, int y){
        this.x = x;
        this.y = y;

    }

    public void tick(Game game){

    }

    public void render(Graphics g){
          g.setColor(Color.BLUE);
        g.fillRect(x, y, width, height);
    }

}
