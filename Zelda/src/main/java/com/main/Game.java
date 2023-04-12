package com.main;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Game extends Canvas implements Runnable {

    boolean isRunning;
    private Thread thread;
    public final int width = 160;
    public final int height = 120;
    public final int scale = 3;
    BufferedImage image;

    public Game() {
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

    public void update(){

    }

    public void render(){
        Graphic.initGraphics(this);
    }

    @Override
    public void run() {
        Frame.calcFrames(this);
    }

}
