package com.dojan.monitosserver;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import pantalla.PantallaOnline;
import utiles.Config;
import utiles.Render;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class MonitosServer extends Game {
	int y, x;

    @Override
    public void create() {
    	Render.app = this;
        Render.sb = new SpriteBatch(); 
        Config.iniciarCamara();
        this.setScreen(new PantallaOnline());
    }

    @Override
    public void render() {
    	super.render();
    }

    @Override
    public void dispose() {
    	Render.dispose();
    }
}
