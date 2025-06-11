package com.dojan.monitos;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import pantalla.PantallaCarga;
import pantalla.PantallaOnline;
import pantalla.PantallaLocal;
import pantalla.PantallaLocalFinal;
import pantalla.PantallaMenu;
import utiles.Config;
import utiles.Render;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Monitos extends Game {
	
	int y, x;
    

    @Override
    public void create() {
    	Render.app = this;
        Render.sb = new SpriteBatch();
        
        Config.iniciarCamara();
        //this.setScreen(new PantallaCarga()); 
        //this.setScreen(new PantallaMenu()); 
        //this.setScreen(new PantallaLocal());
        //this.setScreen(new PantallaLocalFinal(0));
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
