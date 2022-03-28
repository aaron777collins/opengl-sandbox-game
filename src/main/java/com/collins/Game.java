package com.collins;

import java.awt.Dimension;
import java.util.ArrayList;

import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLJPanel;
import com.collins.display.BasicFrame;
import com.collins.entities.Entity;
import com.collins.entities.Square;
import com.collins.input.GameKeyListener;

import javax.swing.JFrame;

public final class Game {

    public Dimension WINDOW_DIMENSIONS = new Dimension(1600, 800);

    public Game game;
    private GLJPanel gljpanel;
    public boolean running = false;
    public ArrayList<Entity> entities;
    public GameKeyListener gameKeyListener;

    public boolean renderTime = false;
    float FPS = 60;
    float UPS = 60;

    public void init() {
        final GLProfile profile = GLProfile.get(GLProfile.GL2);
        final GLCapabilities capabilities = new GLCapabilities(profile);
        
        gljpanel = new GLJPanel(capabilities);
        
        BasicFrame basicFrame = new BasicFrame(game);
        gljpanel.addGLEventListener(basicFrame);

        gljpanel.setSize(WINDOW_DIMENSIONS);
        gljpanel.setPreferredSize(WINDOW_DIMENSIONS);

        gameKeyListener = new GameKeyListener(this);
        gljpanel.addKeyListener(gameKeyListener);

        final JFrame frame = new JFrame("Sandbox"); 

        frame.getContentPane().add(gljpanel);
        frame.setSize(frame.getContentPane().getPreferredSize());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        
        frame.setVisible(true);
        running = true;
        entities = new ArrayList<Entity>();
        entities.add(new Square(0.2f, 0.2f, 0.2f, 0.2f, 0.01f));
    }

    public void gameLoop() {

        long initialTime = System.nanoTime();
        final double timeU = 1000000000 / UPS;
        final double timeF = 1000000000 / FPS;
        double deltaU = 0, deltaF = 0;
        int frames = 0, ticks = 0;
        long timer = System.currentTimeMillis();

        while (running) {

            long currentTime = System.nanoTime();
            deltaU += (currentTime - initialTime) / timeU;
            deltaF += (currentTime - initialTime) / timeF;
            initialTime = currentTime;

            if (deltaU >= 1) {
                //getInput();
                update();
                ticks++;
                deltaU--;
            }

            if (deltaF >= 1) {
                render();
                frames++;
                deltaF--;
            }

            if (System.currentTimeMillis() - timer > 1000) {
                if (renderTime) {
                    System.out.println(String.format("UPS: %s, FPS: %s", ticks, frames));
                }
                frames = 0;
                ticks = 0;
                timer += 1000;
            }
        }

    }

    public void render() {
        gljpanel.display();
    }

    public void update() {
        for (Entity entity : entities) {
            entity.update(game);
        }
    }

    public Game() {
        game = this;
        init();
        gameLoop();
    }
    
    public static void main(String[] args) {
        new Game();
    }
}
