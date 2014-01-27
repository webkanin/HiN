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

    Rectangle boundingBox;

    boolean goingUp = false;
    boolean goingDown = false;

    public PlayerPaddle(int x, int y){
        this.x = x;
        this.y = y;

        boundingBox = new Rectangle(x, y, width, height);
        boundingBox.setBounds(x, y, width, height);              //sets up bounds of a rectangle

    }

    public void tick(Game game){
        boundingBox.setBounds(x, y, width, height);

        if(goingUp && y >= 0){
            y--;
        }

        if(goingDown && y < game.getHeight() - height){
            y++;
        }


    }

    public void render(Graphics g){
          g.setColor(Color.BLUE);
        g.fillRect(x, y, width, height);
    }

}
