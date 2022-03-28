package com.collins.entities;

import com.collins.Game;
import com.jogamp.opengl.GL2;

public class Square implements Entity{

    float x, y, width, height, speed;

    public Square(float x, float y, float width, float height, float speed) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.speed = speed;
    }

    @Override
    public void draw(GL2 gl) {
        gl.glBegin (GL2.GL_QUADS);//static field
        gl.glVertex3f(x,y, 0);
        gl.glVertex3f(x + width,y, 0);
        gl.glVertex3f(x + width,y - height, 0);
        gl.glVertex3f(x,y - height, 0);
        gl.glEnd();
    }

    @Override
    public void update(Game game) {
        //TODO: implement this

        if(game.gameKeyListener.UP) {
            y+=speed;
        }
        if(game.gameKeyListener.DOWN) {
            y-=speed;
        }
        if(game.gameKeyListener.LEFT) {
            x-=speed;
        }
        if(game.gameKeyListener.RIGHT) {
            x+=speed;
        }
    }
}
