package pantalla;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;

import entrada.Teclado;
import utiles.Config;
import utiles.Imagen;
import utiles.Recursos;
import utiles.Render;
import utiles.Texto;

public class PantallaMenu implements Screen{
	Imagen fondo;
	Texto opciones[] = new Texto[3];
	int opc = 1;
	String textos[] = {"LOCAL","ONLINE", "SALIR"};
	public float tiempo = 0;
	Teclado entradas = new Teclado(this);

	@Override
	public void show() {
		entradas.startInput();
		fondo = new Imagen (Recursos.FONDO_MENU);
		fondo.setSize(Config.ANCHO, Config.ALTO);	
		Gdx.input.setInputProcessor(entradas);
		int avance = 50;
		
		for (int i=0; i<opciones.length; i++) {	
			opciones[i] = new Texto(Recursos.FUENTE_MENU, 45, Color.WHITE, true);
			opciones[i].setTexto(textos[i]);
			opciones[i].setPosicion( ( Config.ANCHO / 2 ) - ( opciones[i].getAncho() / 2 ) , ( ( Config.ALTO / 2) + ( opciones[0].getAlto() / 2 ) ) - ( ( opciones[i].getAlto() * i ) + ( avance * i ) ) );	
		}
	}

	private void inputwait() {
		synchronized (entradas){
            try {
                entradas.wait(100);
            } catch (InterruptedException e) {
            	e.printStackTrace();
            }
        }
    }
	
	public void labelInput(){
		 
		if (entradas.isAbajo()){
			inputwait();
			if (tiempo>0.5f){
				tiempo = 0;
				opc++;
				if (opc>opciones.length){
					opc = 1;
				}
			}
		}
		
		if (entradas.isArriba()){
			inputwait();
			if (tiempo>0.5f){
				tiempo = 0;
				opc--;
				if (opc<1){
					opc = opciones.length;
				}
			}
		}
		
		for (int i=0; i<opciones.length; i++) {
			if (i==(opc-1)) {
				opciones[i].setColor(Color.BROWN);
			} else {
				opciones[i].setColor(Color.GOLD);
			}
		}
		
		if (entradas.isEnter()){
			inputwait();
			switch (opc){
				case 1:
					tiempo = 0;
					Render.app.setScreen(new PantallaLocal());					
					break;	
				case 2:
					tiempo = 0;
					Render.app.setScreen(new PantallaOnline());
					break;
				case 3:
					Gdx.app.exit();
					break;
			}
		}
	}
	
	@Override
	public void render(float delta) {
		Render.LimpPant();
		Render.begin();
		fondo.dibujar();
		for (int i=0; i<opciones.length; i++) {	
			opciones[i].dibujar();
		}
		tiempo += delta;
		labelInput();
		Render.end();
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}

	@Override
	public void hide() {
	}

	@Override
	public void dispose() {
		dispose();
		Render.dispose();
	}

}
