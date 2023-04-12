import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import java.util.List;

public class Game extends Canvas implements Runnable, KeyListener, MouseListener {

    public static int WIDTH = 640, HEIGHT = 480;
    public static int scale = 3;
    public static Player player;

    public World world;

    public List<Enemy> enemies = new ArrayList<>();

    public Game() {
        this.addKeyListener(this);
        this.addMouseListener(this);
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));

        new SpriteSheet();

        player = new Player(32,32);
        world = new World();

        enemies.add(new Enemy(40, 32));
    }

    public void tick() {
        player.tick();

        for (int i = 0; i < enemies.size(); i++) {
            enemies.get(i).tick();
        }
    }

    public void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if(bs == null){
            this.createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();
        g.setColor(new Color(0, 135, 13));
        g.fillRect(0,0,WIDTH * scale,HEIGHT * scale);

        player.render(g);

        for (int i = 0; i < enemies.size(); i++) {
            enemies.get(i).render(g);
        }

        world.render(g);

        bs.show();
    }

    public static void main(String[] args) {
        Game game = new Game();
        JFrame frame = new JFrame();

        frame.add(game);
        frame.setTitle("Mini Zelda");

        frame.pack();

        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setVisible(true);

        new Thread(game).start();
    }

    @Override
    public void run() {
        while (true) {
            tick();
            render();
            try {
                Thread.sleep(1000/60);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        var botao = e.getKeyCode();
        if (botao == KeyEvent.VK_RIGHT || botao == KeyEvent.VK_D) {
            player.right = true;
        } else if (botao == KeyEvent.VK_LEFT || botao == KeyEvent.VK_A) {
            player.left = true;
        }

        if (botao == KeyEvent.VK_UP || botao == KeyEvent.VK_W) {
            player.up = true;
        } else if (botao == KeyEvent.VK_DOWN || botao == KeyEvent.VK_S) {
            player.down = true;
        }

        if (botao == KeyEvent.VK_E){
            player.shoot = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        var botao = e.getKeyCode();
        if (botao == KeyEvent.VK_RIGHT || botao == KeyEvent.VK_D) {
            player.right = false;
        } else if (botao == KeyEvent.VK_LEFT || botao == KeyEvent.VK_A) {
            player.left = false;
        }

        if (botao == KeyEvent.VK_UP || botao == KeyEvent.VK_W) {
            player.up = false;
        } else if (botao == KeyEvent.VK_DOWN || botao == KeyEvent.VK_S) {
            player.down = false;
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1){
            player.shoot = true;
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

}
