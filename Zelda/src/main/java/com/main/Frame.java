package com.main;

import javax.swing.*;
import java.awt.*;

public class Frame {

    public static void initFrame(Canvas canvas) {
        JFrame frame = new JFrame("Meu jogo");
        frame.add(canvas);
        frame.setResizable(false);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void calcFrames(Game game){
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        int frames = 0;
        double timer = System.currentTimeMillis();

        while (game.isRunning) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            // delta for maior ou igual a 1 segundo, o jogo renderiza novamente
            if (delta >= 1) {
                game.update();
                game.render();
                frames++;
                delta--;
            }
            if (System.currentTimeMillis() - timer >= 1000) {
                System.out.println("FPS: " + frames);
                frames = 0;
                timer += 1000;
            }
        }
        game.stop();
    }
}
