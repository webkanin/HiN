package programmering2.aa_testing.pong;

import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: Marko
 * Date: 27.01.14
 * Time: 22:48
 */
public class Ball {

    int x, y;
    int size = 16;
    int speed = 1;

    int vx, vy;

    Rectangle boundingBox;

    public  Ball(int x, int y){
        this.x = x;
        this.x = y;

        vx =  speed;
        vy = speed;

        boundingBox = new Rectangle(x, y, size,size);
        boundingBox.setBounds(x, y, size, size);
    }

    public void tick(Game game){
        boundingBox.setBounds(x, y, size, size);

        if(x <= 0){
            vx = speed;

        }else if(x >= game.getWidth()){

           vx = -speed;
           // game.timeScore++;
        }

        if(y <= 0){
            vy = speed;
        }else if(y + size >= game.getHeight()){
            vy = -speed;
        }

        x += vx;
        y += vy;

        paddleCollide(game);
    }

    private void paddleCollide(Game game){
        if(boundingBox.intersects(game.player.boundingBox)){
            vx = -speed;
            speed = (speed + 1);
        }
    }

    public void render(Graphics g){
        g.setColor(Color.RED);
        g.fillOval(x, y, size, size);

    }
}
