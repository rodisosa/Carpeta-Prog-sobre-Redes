package pantalla;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import elementos.Mono;
import elementos.Sprites;
import entrada.Teclado;
import utiles.Config;
import utiles.Imagen;
import utiles.Recursos;
import utiles.Render;
import utiles.Texto;

public class PantallaLocalFinal extends PantallaLocal {
	
	Imagen fondo;
	Teclado entradas = new Teclado(this);
	int avance = 50, opc = 1, ganador;
	float tiempo = 0;
	Texto  gan, opciones[] = new Texto[2];
	String textos[] = {"Volver a Jugar","Menu Principal"},  
		   ganador1 = "El ganador es el Jugador 1",
		   ganador2 = "El ganador es el Jugador 2",
	       empate = "Empate";
	
	public PantallaLocalFinal(int ganador) {
		this.ganador = ganador;
	}

	@Override
	public void show() {
		//Sprites.load(); //------------------------------------------------
		entradas.startInput();
		Gdx.input.setInputProcessor(entradas);
		fondo = new Imagen (Recursos.FONDO_FINAL);
		crearTexto();		
	}

	@Override
	public void render(float delta) {
		tiempo += delta;
		Render.begin();
		fondo.dibujar();
		dibujarGanador();
		for (int i=0; i<opciones.length; i++) {	
			opciones[i].dibujar();
		}
		Render.end();
		update();
	}
	
	public  void update(){
		 
		if (entradas.isAbajo()){ 	
			esperaEntrada();			
			if (tiempo>0.5f){ 
				tiempo=0;
				opc++;			
				if (opc>opciones.length){
					opc = 1;
				}
			}
		}
		
		if (entradas.isArriba()){
			esperaEntrada();
			if(tiempo>0.5f){
				tiempo = 0;
				opc--;
				if(opc<1){
					opc = opciones.length;
				}
			}
		}
		
		for (int i=0; i<opciones.length; i++) {
			if (i==(opc-1)) opciones[i].setColor(Color.BROWN);
			else opciones[i].setColor(Color.GOLD);
		}
		
		if (entradas.isEnter()){
			esperaEntrada();
			tiempo = 0;
			switch (opc){
				case 1: Render.app.setScreen(new PantallaLocal());
					break;
				case 2: Render.app.setScreen(new PantallaMenu());
					break;
			}
		}
	}
	
	public void dibujarGanador() {
		if (ganador==1) {
			Sprites.monoMarronEst.draw(Render.sb);
			Sprites.monoMarronEst.setPosition((Config.ANCHO / 2) - (Mono.getAncho() / 2), (Config.ALTO / 2) - (Mono.getAlto() / 2));
			
			gan.setTexto(ganador1);
			gan.setPosicion( ( Config.ANCHO / 2 ) - ( gan.getAncho() / 2 ) , (Config.ALTO - gan.getAlto()) - 10);
		} else if (ganador==2){
			Sprites.monoGrisEst.draw(Render.sb);
			Sprites.monoGrisEst.setPosition((Config.ANCHO / 2) - (Mono.getAncho() / 2), (Config.ALTO / 2) - (Mono.getAlto() / 2));
			
			gan.setTexto(ganador2);
			gan.setPosicion( ( Config.ANCHO / 2 ) - ( gan.getAncho() / 2 ) , (Config.ALTO - gan.getAlto()) - 10);
		} else {
			Sprites.monoMarronEst.draw(Render.sb);
			Sprites.monoMarronEst.setPosition(((Config.ANCHO / 2) - (Mono.getAncho() - 10)) - (Mono.getAncho() / 2), (Config.ALTO / 2) - (Mono.getAlto() / 2));
			
			Sprites.monoGrisEst.draw(Render.sb);
			Sprites.monoGrisEst.setPosition(((Config.ANCHO / 2) + Mono.getAncho()) - (Mono.getAncho() / 2), (Config.ALTO / 2) - (Mono.getAlto() / 2));
			
			gan.setTexto(empate);
			gan.setPosicion( ( Config.ANCHO / 2 ) - ( gan.getAncho() / 2 ) , (Config.ALTO - gan.getAlto()) - 10);
		}
		gan.dibujar();
	}
	
	public void crearTexto() {
		gan = new Texto(Recursos.FUENTE_MENU, 45, Color.WHITE, true);
		for (int i=0; i<opciones.length; i++) {	
			opciones[i] = new Texto(Recursos.FUENTE_MENU, 45, Color.WHITE, true);
			opciones[i].setTexto(textos[i]);
			opciones[i].setPosicion( ( Config.ANCHO / 2 ) - ( opciones[i].getAncho() / 2 ) , ( ( Config.ALTO / 2) - ( opciones[0].getAlto() + avance) ) - ( ( opciones[i].getAlto() * i ) + ( avance * i ) ) );	
		}
	}
	
	private void esperaEntrada() {
        synchronized (entradas){
            try {
                entradas.wait(100);
            } catch (InterruptedException e) {
            	e.printStackTrace();
            }
        }
    }

	@Override
	public void resize(int width, int height) {}

	@Override
	public void pause() {}

	@Override
	public void resume() {}

	@Override
	public void hide() {}

	@Override
	public void dispose() {
		Render.dispose();
		dispose();
	}
}
