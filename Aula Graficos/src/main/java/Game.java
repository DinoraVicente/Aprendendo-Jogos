import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class Game extends Canvas implements Runnable {

    boolean isRunning;
    private Thread thread;
    public final int width = 160;
    public final int height = 120;
    public final int scale = 3;

    Spritesheet spritesheet;
    BufferedImage[] player;
    BufferedImage image;
    int frames = 0;
    int maxFrames = 15;
    int curAnimation = 0;
    int maxAnimation = 3;

    public Game() {
        spritesheet = new Spritesheet("/sprite.png");
        player = new BufferedImage[4];
        player[0] = spritesheet.getSpritesheet(0,0,16,16);
        player[1] = spritesheet.getSpritesheet(16,0,16,16);
        player[2] = spritesheet.getSpritesheet(32,0,16,16);
        player[3] = spritesheet.getSpritesheet(48,0,16,16);
        setPreferredSize(new Dimension(width*scale, height*scale));
        Frame.initFrame(this);
        image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
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
        game.start();
    }

    // lógica do jogo
    public void update(){
        frames++;
        if (frames > maxFrames) {
            frames = 0;
            curAnimation++;
            if (curAnimation > maxAnimation) {
                curAnimation = 0;
            }
        }
    }

    // renderização do jogo - gráficos
    public void render(){
        Graphic.initGraphics(this);
    }

    @Override
    public void run() {
        Frame.calcFrames(this);
    }

}
