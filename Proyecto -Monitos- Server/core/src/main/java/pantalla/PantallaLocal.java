package pantalla;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;
import elementos.Fruta;
import elementos.Mono;
import elementos.Sprites;
import utiles.Recursos;
import utiles.Render;
import utiles.Texto;
import utiles.Config;
import utiles.Imagen;
import entrada.Teclado;

public class PantallaLocal implements Screen{

	Teclado entradas = new Teclado(this);
	
	public float tiempo, tiempo1;
	Texto jugador1, jugador2, temporizador, puntos1, puntos2;
	String texto1 = "JUGADOR 1", texto2 = "JUGADOR 2";
	int tem=120;
	
	Imagen fondo;
	
	public Mono mono1, mono2;
	private int nroJ = 1; 
	
	public static Array<Fruta> arrayFrutas;
	private Fruta fruta;
	
	boolean ganador = false;
	
	@Override
	public void show() {
		entradas.startInput();
		Gdx.input.setInputProcessor(entradas);
		fondo = new Imagen (Recursos.FONDO_JUEGO);
		arrayFrutas = new Array<>();
		crearMono();
		crearTexto();
		//crearFruta();
	}

	@Override
	public void render(float delta) {
		tiempo += delta;
		tiempo1 += delta;
		mono1.setTiempo(tiempo1);
		mono2.setTiempo(tiempo1);
		
		
		Render.LimpPant();
		update();
		
		if(tiempo > 1) {
			tiempo = 0;
			tem--;
			//crearFruta();
			}
		
		if(tem==0) {
			if(mono1.puntos > mono2.puntos) ganador=true;
			else ganador=false;
			Render.app.setScreen(new PantallaLocalFinal(ganador));
		}
		
		Render.begin();
	
		fondo.dibujar();
		mono1.dibujar();
		mono2.dibujar();	
		//dibujarFrutas();
		dibujarHud();
		
		Render.end();
	}

	public void dibujarHud() {
		jugador1.dibujar();
		jugador2.dibujar();
		temporizador.dibujar();
		puntos1.dibujar();
		puntos2.dibujar();
	}

	@SuppressWarnings("static-access")
	/*private void dibujarFrutas() {
		
		for(int i = arrayFrutas.size - 1; i >= 0; i--) {
			fruta = arrayFrutas.get(i);
			fruta.setPosY(fruta.getPosY() - Fruta.getVelocidadCaida());
			fruta.colision.set(fruta.getPosX(), fruta.getPosY(), fruta.getAncho(), fruta.getAlto());
			
			if(fruta.getPosY() < -(fruta.getAlto())) {
				arrayFrutas.removeIndex(i);
			} else if(mono1.colision.overlaps(fruta.colision)) {
				if (fruta.nroF == 0) mono1.puntos += 25;
				else if (fruta.nroF == 1) mono1.puntos += 50;
				else mono1.puntos += 100;
				arrayFrutas.removeIndex(i);
			} else if(mono2.colision.overlaps(fruta.colision)) {
				if (fruta.nroF == 0) mono2.puntos += 25;
				else if (fruta.nroF == 1) mono2.puntos += 50;
				else mono2.puntos += 100;
				arrayFrutas.removeIndex(i);
			}
		}
		
		for(Fruta fruta : arrayFrutas) {
			fruta.dibujar();
		}
	}*/

	public void crearTexto() {
		jugador1 = new Texto(Recursos.FUENTE_MENU, 45, Color.GOLD, true);
		jugador1.setTexto(texto1);
		jugador1.setPosicion(10, Config.ALTO);
		
		jugador2 = new Texto(Recursos.FUENTE_MENU, 45, Color.GOLD, true);
		jugador2.setTexto(texto2);
		jugador2.setPosicion((Config.ANCHO - jugador2.getAncho()) - 10, Config.ALTO);
		
		temporizador = new Texto(Recursos.FUENTE_MENU, 45, Color.WHITE, true);
		temporizador.setTexto(Integer.toString(tem));
		temporizador.setPosicion(((Config.ANCHO / 2) - (temporizador.getAncho() / 2)), Config.ALTO);
		
		puntos1 = new Texto(Recursos.FUENTE_MENU, 45, Color.WHITE, true);
		puntos1.setTexto(Integer.toString(mono1.puntos));
		puntos1.setPosicion(10, (Config.ALTO - puntos1.getAlto()) - 10);
		
		puntos2 = new Texto(Recursos.FUENTE_MENU, 45, Color.WHITE, true);
		puntos2.setTexto(Integer.toString(mono1.puntos));
		puntos2.setPosicion( (Config.ANCHO - puntos2.getAncho()) - 10 , (Config.ALTO - puntos2.getAlto()) - 10);
	}
	
	@SuppressWarnings("static-access")
	public void update() {
		
		
		
		temporizador.setTexto(Integer.toString(tem));
		
		if(entradas.isA()) {
			mono1.setPosX(mono1.getPosX()-mono1.getVelocidad());
			mono1.camIzq = true;
			mono1.camDer = false;
		} else mono1.camIzq = false;
		
		if(entradas.isD()) {
			mono1.setPosX(mono1.getPosX()+mono1.getVelocidad());
			mono1.camDer= true;
			mono1.camIzq = false;
		} else mono1.camDer = false;
		
		if(entradas.isIzq()) {
			mono2.setPosX(mono2.getPosX()-mono2.getVelocidad());
			mono2.camIzq = true;
			mono2.camDer = false;
		} else mono2.camIzq = false;
		
		if(entradas.isDer()) {
			mono2.setPosX(mono2.getPosX()+mono2.getVelocidad());
			mono2.camDer= true;
			mono2.camIzq = false;
		} else mono2.camDer = false;
		
		//if(entradas.isA()) mono1.setPosX(mono1.getPosX()-mono1.getVelocidad());
		
		//if(entradas.isD()) mono1.setPosX(mono1.getPosX()+mono1.getVelocidad());
		
		//if(entradas.isIzq()) mono2.setPosX(mono2.getPosX()-mono2.getVelocidad());
		
		//if(entradas.isDer()) mono2.setPosX(mono2.getPosX()+mono2.getVelocidad());
			
		mono1.colision.set(mono1.getPosX(), 0, mono1.getAncho(), mono1.getAlto());
		mono2.colision.set(mono2.getPosX(), 0, mono2.getAncho(), mono2.getAlto());
		
		puntos1.setTexto(Integer.toString(mono1.puntos));
		puntos2.setTexto(Integer.toString(mono2.puntos));
		puntos2.setPosicion( (Config.ANCHO - puntos2.getAncho()) - 10 , (Config.ALTO - puntos2.getAlto()) - 10);
		
	}
	/*
	public void crearFruta() {
		fruta = new Fruta(MathUtils.random(0, 2));
		arrayFrutas.add(fruta);
		fruta.colision = new Rectangle();
	}*/
	
	public void crearMono() {
		Sprites.load();
		
		mono1 = new Mono(nroJ);
		mono2 = new Mono((nroJ==1)?2:1);
		
		mono1.colision = new Rectangle();
		mono2.colision = new Rectangle();
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
		Render.dispose();
		mono1.dispose();
		mono2.dispose();
		
		for(Fruta fruta : arrayFrutas) {
			fruta.dispose();
		}
	}
}
