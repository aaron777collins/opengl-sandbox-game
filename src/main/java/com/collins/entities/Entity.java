package com.collins.entities;

import com.collins.Game;
import com.jogamp.opengl.GL2;

public interface Entity {

    public void update(Game game);
    public void draw(GL2 gl);
}
