package com.collins.display;

import com.collins.Game;
import com.collins.entities.Entity;
import com.collins.entities.Square;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;

public class BasicFrame implements GLEventListener {

    Game game;

    public BasicFrame(Game game) {
        this.game = game;
    }

    @Override
    public void display(GLAutoDrawable drawable) {
        final GL2 gl = drawable.getGL().getGL2();

        gl.glClearColor(0.0f, 0.0f, 0.0f, 1.0f );
        gl.glClear(GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT);
        gl.glLoadIdentity();

        for (Entity entity : game.entities) {
            entity.draw(gl);
        }

        // gl.glBegin (GL2.GL_LINES);//static field
        // gl.glVertex3f(-0.50f,-0.50f,0);
        // gl.glVertex3f(-0.50f,0.50f,0);
        // gl.glVertex3f(0.50f,0.50f,0);
        // gl.glVertex3f(0.50f,-0.50f,0);
        // gl.glEnd();


        
    }

    @Override
    public void dispose(GLAutoDrawable drawable) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void init(GLAutoDrawable drawable) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void reshape(GLAutoDrawable drawable, int arg1, int arg2, int arg3, int arg4) {
        // TODO Auto-generated method stub
        
    }
    
}