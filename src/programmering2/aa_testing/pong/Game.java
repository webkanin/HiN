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


    public static PlayerPaddle player;
    public static Ball ball;

    InputHandler IH;

    JFrame frame;         //Windows of the game
    public final int WIDTH = 400;       //Width of window
    public final int HEIGHT = WIDTH / 16 * 9;     //Height of windows
    public final Dimension gameSize = new Dimension(WIDTH, HEIGHT);    //Condense WIDTH & HEIGHT into 1 variablo e
    public final String TITLE = "Pong InDev";


    BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_BGR);

    boolean gameRunning = false;      //whether the game is running

    int timeScore;
    int ballsLeft = 5;

    Thread thread;

    public void run(){

        while(gameRunning){
            tick();
            render();

            try{
                Thread.sleep(7);   //7 ms between each execution of the program. (Makes the racket slower)
            }   catch (Exception e){
                e.printStackTrace();
            }

        }

    }

    public synchronized void start(){
        gameRunning = true;
        thread = new Thread(this);
        thread.start();
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



        IH = new InputHandler(this);
        //frame.addKeyListener(IH);

        player = new PlayerPaddle(380, 60);
        ball = new Ball(getWidth() / 2, getHeight() / 2);


    }

    public static void main(String[] args){
       Game game = new Game();  //kan også skrives Game game = new Game();
        game.start();

    }

    public void tick(){
       player.tick(this);  //this because this referes to "this class".
        ball.tick(this);
    }

    public void render(){
        BufferStrategy bs = getBufferStrategy();

        if (bs == null){
            createBufferStrategy(3);
            return;
        }

        Graphics g = bs.getDrawGraphics();


        g.drawImage(image, 0, 0, getWidth(), getHeight(), null);

        g.setColor(Color.WHITE);
        g.drawString("Best Time: " + timeScore, 50, 200);
        g.drawString("Balls left: " + ballsLeft, 300, 200);

        player.render(g);
        ball.render(g);

       // g.setColor(Color.BLACK);
        //g.fillRect(0, 0, getWidth(), getHeight());

        g.dispose();
        bs.show();

    }


}
