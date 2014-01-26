package programmering2.aa_testing.pong;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;

/**
 * Created with IntelliJ IDEA.
 * User: Marko Sundic
 * Student nr. 530 614
 */
public class Game extends Canvas implements Runnable {
    private static final long serialVersionUIS = 1L;



    JFrame frame;         //Windows of the game
    public final int WIDTH = 400;       //Width of window
    public final int HEIGHT = WIDTH / 16 * 9;     //Height of windows
    public final Dimension gameSize = new Dimension(WIDTH, HEIGHT);    //Condense WIDTH & HEIGHT into 1 variablo e
    public final String TITLE = "Pong InDev";

    BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_BGR);

    boolean gameRunning = false;      //whether the game is running

    public void run(){

        while(gameRunning){
            tick();
            render();

        }

    }

    public synchronized void start(){
        gameRunning = true;
        new Thread(this).start();
    }

    public synchronized void stop(){
        gameRunning = false;
        System.exit(0);
    }

    public Game(){
        frame = new JFrame(TITLE);

        setMinimumSize(gameSize); //kunne også skrevet this.setMinimumSize
        setPreferredSize(gameSize);
        setMaximumSize(gameSize);

        frame.add(this, BorderLayout.CENTER);        //in the game container add "this" the "canvas", inside of it, it will set it to center of JFrame.
        frame.pack();              //means it will pack everything into JFrame

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //Safe close of window
        frame.setVisible(true);  //makes the frame visible
        frame.setResizable(false);  //makes it possible or not to resize the frame
        frame.setTitle(TITLE);
        frame.setLocationRelativeTo(null);  //sets the location of the frame realive to nothing (centers it on the screen)


    }

    public static void main(String[] args){
       Game game = new Game();  //kan også skrives Game game = new Game();
        game.start();

    }

    public void tick(){

    }

    public void render(){
        BufferStrategy bs = getBufferStrategy();

        if (bs == null){
            createBufferStrategy(3);
            return;
        }

        Graphics g = bs.getDrawGraphics();


        g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
        g.setColor(Color.RED);
        g.fillRect(0, 0, getWidth(), getHeight());

        g.dispose();
        bs.show();

    }


}
