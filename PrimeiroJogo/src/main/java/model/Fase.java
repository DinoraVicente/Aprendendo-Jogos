package model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Fase extends JPanel implements ActionListener {
    private Image fundo;
    private Jogador jogador;
    private Timer timer;

    public Fase() {
        setFocusable(true);
        setDoubleBuffered(true);

        ImageIcon referencia = new ImageIcon("resources\\background.png");
        fundo = referencia.getImage();

        jogador = new Jogador();
        jogador.load();

        addKeyListener(new TecladoAdapter());

        timer = new Timer(5, this);
        timer.start();
    }

    public void paint (Graphics g) {
        Graphics2D graphics2D = (Graphics2D) g;
        graphics2D.drawImage(fundo, 0, 0, null);
        graphics2D.drawImage(jogador.getImagem(), jogador.getX(), jogador.getY(), this);
        g.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        jogador.update();
        repaint();
    }

    private class TecladoAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            jogador.keyPressed(e);
        }

        @Override
        public void keyReleased(KeyEvent e) {
            jogador.keyReleased(e);
        }
    }
}
