import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

public class Game extends Canvas implements Runnable, KeyListener {

    boolean isRunning;

    private Thread thread;
    public static int width = 160;
    public static int heigth = 120;
    public final int scale = 3;

    public BufferedImage layer = new BufferedImage(width,heigth,BufferedImage.TYPE_INT_RGB);
    public static Player player;
    public static Enemy enemy;

    public static Ball ball;

    public Game() {
        setPreferredSize(new Dimension(width*scale, heigth*scale));
        addKeyListener(this);
        player = new Player(100, heigth-5);
        enemy = new Enemy(100, 0);
        ball = new Ball(100, (heigth/2) - 1);
    }

    public synchronized void start(){
        thread = new Thread(this);
        isRunning = true;
        thread.start();
    }

    public synchronized void stop(){
        isRunning = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        Game game = new Game();
        Frame.initFrame(game);
        game.start();
    }

    public void update(){
        player.update();
        enemy.update();
        ball.update();
    }

    public void render(){
        Graphic.initGraphics(this, player, enemy, ball);
    }

    @Override
    public void run() {
        Frame.calcFrames(this);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        KeyEvents.eventPressed(e, player);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        KeyEvents.eventReleased(e, player);
    }
}
