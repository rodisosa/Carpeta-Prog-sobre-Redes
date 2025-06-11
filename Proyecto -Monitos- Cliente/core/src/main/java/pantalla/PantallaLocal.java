package pantalla;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;

import elementos.Banana;
import elementos.Fruta;
import elementos.Manzana;
import elementos.Mono;
import elementos.Pera;
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
	int tem=120, ganador;
	
	Imagen fondo;
	
	public Mono mono1, mono2;
	private int nroJ = 1; 
	
	public static Array<Fruta> arrayFrutas;
	private Fruta fruta;
	
	@Override
	public void show() {
		entradas.startInput();
		Gdx.input.setInputProcessor(entradas);
		fondo = new Imagen (Recursos.FONDO_JUEGO);
		arrayFrutas = new Array<>();
		crearMono();
		crearTexto();
		crearFruta();
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
			crearFruta();
		}
		
		if(tem==0) {
			if(mono1.puntos > mono2.puntos) ganador=1;
			else if(mono1.puntos < mono2.puntos) ganador=2;
			else ganador=0;
			Render.app.setScreen(new PantallaLocalFinal(ganador));
		}
		
		Render.begin();
	
		fondo.dibujar();
		mono1.dibujar();
		mono2.dibujar();	
		dibujarFrutas();
		dibujarTexto();
		
		Render.end();
		
	}
	
	public void crearFruta() {
		int random = MathUtils.random(1, 10);
		if(random > 9) fruta = new Banana(Banana.getNroB(), MathUtils.random(0, Config.ANCHO - Banana.getAncho()),Banana.getVelocidadCaida(),0,0);
		else if (random <= 9 && random > 5) fruta = new Pera(Pera.getNroP(), MathUtils.random(0, Config.ANCHO - Pera.getAncho()),Pera.getVelocidadCaida(),0,0);
		else fruta = new Manzana(Manzana.getNroM(), MathUtils.random(0, Config.ANCHO - Manzana.getAncho()),Manzana.getVelocidadCaida(),0,0);
		arrayFrutas.add(fruta);
		fruta.colision = new Rectangle();
	}
	
	public void dibujarTexto() {
		jugador1.dibujar();
		jugador2.dibujar();
		temporizador.dibujar();
		puntos1.dibujar();
		puntos2.dibujar();
	}
	
	@SuppressWarnings("static-access")
	private void dibujarFrutas() {
		
		for(int i = arrayFrutas.size - 1; i >= 0; i--) {
			fruta = arrayFrutas.get(i);		
			fruta.setPosY(fruta.getPosY() - fruta.Velocidad());
			if(fruta.getNroF() == Manzana.getNroM()) {
				fruta.colision.set(fruta.getPosX(), fruta.getPosY(), Manzana.getAncho(), Manzana.getAlto());
			} else if (fruta.getNroF() == Pera.getNroP()) {
				fruta.colision.set(fruta.getPosX(), fruta.getPosY(), Pera.getAncho(), Pera.getAlto());
			} else if (fruta.getNroF() == Banana.getNroB()) {
				fruta.colision.set(fruta.getPosX(), fruta.getPosY(), Banana.getAncho(), Banana.getAlto());
			}
				
			if(fruta.getPosY() < -(fruta.getAlto())) {
				arrayFrutas.removeIndex(i);
			} else if(mono1.colision.overlaps(fruta.colision)) {
				if (fruta.getNroF() == Manzana.getNroM()) mono1.puntos += Manzana.getPuntos();
				else if (fruta.getNroF() == Pera.getNroP()) mono1.puntos += Pera.getPuntos();
				else mono1.puntos += Banana.getPuntos();
				arrayFrutas.removeIndex(i);
			} else if(mono2.colision.overlaps(fruta.colision)) {
				if (fruta.getNroF()== Manzana.getNroM()) mono2.puntos += Manzana.getPuntos();
				else if (fruta.getNroF() == Pera.getNroP()) mono2.puntos += Pera.getPuntos();
				else mono2.puntos += Banana.getPuntos();
				arrayFrutas.removeIndex(i);
			}
			
		}
		
		for(Fruta fruta : arrayFrutas) {
				fruta.dibujar(fruta.getNroF());
		}
	}
	
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
			
		mono1.colision.set(mono1.getPosX(), 0, Mono.getAncho(),	Mono.getAlto());
		mono2.colision.set(mono2.getPosX(), 0, Mono.getAncho(), Mono.getAlto());
		
		puntos1.setTexto(Integer.toString(mono1.puntos));
		puntos2.setTexto(Integer.toString(mono2.puntos));
		puntos2.setPosicion( (Config.ANCHO - puntos2.getAncho()) - 10 , (Config.ALTO - puntos2.getAlto()) - 10);	
	}
	
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
