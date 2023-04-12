package model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;

public class Jogador {

    private int x, y;
    private int dx, dy;
    private Image imagem;
    private int altura, largura;

    public Jogador() {
        this.x = 100;
        this.y = 100;
    }

    public void load() {
        ImageIcon referencia = new ImageIcon("resources\\spaceship2.png");
        imagem = referencia.getImage();

        altura = imagem.getHeight(null);
        largura = imagem.getWidth(null);
    }

    public void update(){
        x += dx;
        y += dy;
    }

    public void keyPressed(KeyEvent tecla) {
        int codigo = tecla.getKeyCode();

        if(codigo == KeyEvent.VK_UP || codigo == KeyEvent.VK_W) dy =- 3;
        if(codigo == KeyEvent.VK_DOWN || codigo == KeyEvent.VK_S) dy = 3;
        if(codigo == KeyEvent.VK_LEFT || codigo == KeyEvent.VK_A) dx = -3;
        if(codigo == KeyEvent.VK_RIGHT || codigo == KeyEvent.VK_D) dx = 3;
    }

    public void keyReleased(KeyEvent tecla) {
        int codigo = tecla.getKeyCode();
        if(codigo == KeyEvent.VK_UP || codigo == KeyEvent.VK_W) dy = 0;
        if(codigo == KeyEvent.VK_DOWN || codigo == KeyEvent.VK_S) dy = 0;
        if(codigo == KeyEvent.VK_LEFT || codigo == KeyEvent.VK_A) dx = 0;
        if(codigo == KeyEvent.VK_RIGHT || codigo == KeyEvent.VK_D) dx = 0;
    }

    public Image getImagem() {
        return imagem;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
