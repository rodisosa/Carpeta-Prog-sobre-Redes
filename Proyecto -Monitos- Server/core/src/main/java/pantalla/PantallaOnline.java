package pantalla;

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
import red.HiloServidor;

public class PantallaOnline implements Screen{

	//Teclado entradas = new Teclado(this);
	
	private HiloServidor hs;
	
	Texto jugador1, jugador2, temporizador, puntos1, puntos2, textoEsp;
	String textoEspera= "ESPERANDO JUGADORES...",
		   texto1 = "JUGADOR 1", 
		   texto2 = "JUGADOR 2";
	
	Imagen fondo;
	
	public float tiempo, tiempoAnimacion, tiempo2;
	int tem=120;
	
	
	public Mono mono1, mono2;
	private int nroJ = 1; 
	
	public static Array<Fruta> arrayFrutas;
	private Fruta fruta;
	
	boolean ganador = false ;
	public boolean der1 = false, 
				   der2 = false, 
				   izq1 = false, 
				   izq2 = false;
	
	@Override
	public void show() {
		fondo = new Imagen (Recursos.FONDO_JUEGO);

		arrayFrutas = new Array<>();
		crearMono();
		crearTexto();
		//crearFruta();
		
		hs = new HiloServidor(this);
		hs.start();
	}

	@Override
	public void render(float delta) {
		
	if(hs.getCantClientes() < 2) {
			
			Render.begin();
			fondo.dibujar();
			textoEsp.dibujar();
			Render.end();	
		} else {
			tiempo += delta;
			tiempoAnimacion += delta;
			mono1.setTiempo(tiempoAnimacion);
			mono2.setTiempo(tiempoAnimacion);
			
			Render.LimpPant();
			update();
			
			if(tiempo > 1) {
				tiempo = 0;
				tem--;
				crearFruta();
				hs.enviarMensajeATodos("Tiempo-" + tem);
				hs.enviarMensajeCliente2("Actualizar-Mono2-" + mono2.getPosX() + "-" + mono2.camIzq + "-" + mono2.camDer);
				hs.enviarMensajeCliente1("Actualizar-Mono1-" + mono1.getPosX() + "-" + mono1.camIzq + "-" + mono1.camDer);
			}
			
			Render.begin();
			
			fondo.dibujar();
			mono1.dibujar();
			mono2.dibujar();	
			dibujarFrutas();
			dibujarHud();
			
			Render.end();
			
			//hs.enviarMensajeATodos("Actualizar-Mono-" + mono1.getPosX() + "-" + mono2.getPosX());
			hs.enviarMensajeCliente1("Actualizar-Mono2-" + mono2.getPosX() + "-" + mono2.camIzq + "-" + mono2.camDer);
			hs.enviarMensajeCliente2("Actualizar-Mono1-" + mono1.getPosX() + "-" + mono1.camIzq + "-" + mono1.camDer);
		}
	}
	
	public void dibujarHud() {
		jugador1.dibujar();
		jugador2.dibujar();
		temporizador.dibujar();
		puntos1.dibujar();
		puntos2.dibujar();
	}
	
	/*
	@SuppressWarnings("static-access")
	private void dibujarFrutas() {
		
		for(int i = arrayFrutas.size - 1; i >= 0; i--) {
			fruta = arrayFrutas.get(i);
			fruta.setPosY(fruta.getPosY() - Fruta.getVelocidadCaida());
			fruta.colision.set(fruta.getPosX(), fruta.getPosY(), fruta.getAncho(), fruta.getAlto());
			
			//hs.enviarMensajeATodos("Actualizar-Fruta-" + i + "-" + fruta.getPosY());
			
			if(fruta.getPosY() < -(fruta.getAlto())) {
				arrayFrutas.removeIndex(i);
			} else if(mono1.colision.overlaps(fruta.colision)) {
				if (fruta.nroF == 0) mono1.puntos += 25;
				else if (fruta.nroF == 1) mono1.puntos += 50;
				else mono1.puntos += 100;
				hs.enviarMensajeATodos("Actualizar-Puntos1-" + mono1.puntos);
				hs.enviarMensajeATodos("Borrar-Fruta-" + i);
				arrayFrutas.removeIndex(i);
			} else if(mono2.colision.overlaps(fruta.colision)) {
				if (fruta.nroF == 0) mono2.puntos += 25;
				else if (fruta.nroF == 1) mono2.puntos += 50;
				else mono2.puntos += 100;
				hs.enviarMensajeATodos("Actualizar-Puntos2-" + mono2.puntos);
				hs.enviarMensajeATodos("Borrar-Fruta-" + i);
				arrayFrutas.removeIndex(i);
			} 
		}
		
		for(Fruta fruta : arrayFrutas) {
			fruta.dibujar();
			//hs.enviarMensajeATodos("CrearFruta-" + fruta.nroF + "-" + fruta.getPosX() + "-" + fruta.getPosY());
		}
	}*/
	
	
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
			
			//hs.enviarMensajeATodos("Actualizar-Fruta-" + i + "-" + fruta.getPosY());
			
			if(fruta.getPosY() < -(fruta.getAlto())) {
				arrayFrutas.removeIndex(i);
			} else if(mono1.colision.overlaps(fruta.colision)) {
				if (fruta.getNroF() == Manzana.getNroM()) mono1.puntos += Manzana.getPuntos();
				else if (fruta.getNroF() == Pera.getNroP()) mono1.puntos += Pera.getPuntos();
				else mono1.puntos += Banana.getPuntos();
				hs.enviarMensajeATodos("Actualizar-Puntos1-" + mono1.puntos);
				hs.enviarMensajeATodos("Borrar-Fruta-" + i);
				arrayFrutas.removeIndex(i);
			} else if(mono2.colision.overlaps(fruta.colision)) {
				if (fruta.getNroF()== Manzana.getNroM()) mono2.puntos += Manzana.getPuntos();
				else if (fruta.getNroF() == Pera.getNroP()) mono2.puntos += Pera.getPuntos();
				else mono2.puntos += Banana.getPuntos();
				hs.enviarMensajeATodos("Actualizar-Puntos2-" + mono2.puntos);
				hs.enviarMensajeATodos("Borrar-Fruta-" + i);
				arrayFrutas.removeIndex(i);
			}
		}
		
		for(Fruta fruta : arrayFrutas) {
			fruta.dibujar(fruta.getNroF());
			//hs.enviarMensajeATodos("CrearFruta-" + fruta.nroF + "-" + fruta.getPosX() + "-" + fruta.getPosY());
		}
	}
	
	@SuppressWarnings("static-access")
	public void update() {
		if(izq1) {
			mono1.setPosX(mono1.getPosX()-mono1.getVelocidad());
			mono1.camIzq = true;
			mono1.camDer = false;
		} else mono1.camIzq = false;
			
		if(der1) {
			mono1.setPosX(mono1.getPosX()+mono1.getVelocidad());
			mono1.camDer= true;
			mono1.camIzq = false;
		} else mono1.camDer = false;
		
		if(izq2) {
			mono2.setPosX(mono2.getPosX()-mono2.getVelocidad());
			mono2.camIzq = true;
			mono2.camDer = false;
		} else mono2.camIzq = false;
		
		if(der2) {
			mono2.setPosX(mono2.getPosX()+mono2.getVelocidad());
			mono2.camDer= true;
			mono2.camIzq = false;
		} else mono2.camDer = false;
		
		
		temporizador.setTexto(Integer.toString(tem));
		
		mono1.colision.set(mono1.getPosX(), 0, mono1.getAncho(), mono1.getAlto());
		mono2.colision.set(mono2.getPosX(), 0, mono2.getAncho(), mono2.getAlto());
		
		puntos1.setTexto(Integer.toString(mono1.puntos));
		puntos2.setTexto(Integer.toString(mono2.puntos));
		puntos2.setPosicion( (Config.ANCHO - puntos2.getAncho()) - 10 , (Config.ALTO - puntos2.getAlto()) - 10);
	}
	
	/*public void crearFruta() {
		fruta = new Fruta(MathUtils.random(0, 2));
		arrayFrutas.add(fruta);
		fruta.colision = new Rectangle();
		hs.enviarMensajeATodos("CrearFruta-" + fruta.nroF + "-" + fruta.getPosX());
	}*/
	
	public void crearFruta() {
		int random = MathUtils.random(1, 10);
		if(random > 9) fruta = new Banana(Banana.getNroB(), MathUtils.random(0, Config.ANCHO - Banana.getAncho()),Banana.getVelocidadCaida(),0,0);
		else if (random <= 9 && random > 5) fruta = new Pera(Pera.getNroP(), MathUtils.random(0, Config.ANCHO - Pera.getAncho()),Pera.getVelocidadCaida(),0,0);
		else fruta = new Manzana(Manzana.getNroM(), MathUtils.random(0, Config.ANCHO - Manzana.getAncho()),Manzana.getVelocidadCaida(),0,0);
		arrayFrutas.add(fruta);
		fruta.colision = new Rectangle();
		hs.enviarMensajeATodos("CrearFruta-" + fruta.getNroF() + "-" + fruta.getPosX());
	}
	
	public void crearMono() {
		Sprites.load();
		
		mono1 = new Mono(nroJ);
		mono2 = new Mono((nroJ==1)?2:1);
		
		mono1.colision = new Rectangle();
		mono2.colision = new Rectangle();
	}
	
	public void crearTexto() {
		textoEsp = new Texto(Recursos.FUENTE_MENU, 60, Color.WHITE, true);
		textoEsp.setTexto(textoEspera);
		textoEsp.setPosicion((Config.ANCHO / 2) - (textoEsp.getAncho() / 2), (Config.ALTO / 2) + (textoEsp.getAlto()));
		
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
		puntos2.setTexto(Integer.toString(mono2.puntos));
		puntos2.setPosicion( (Config.ANCHO - puntos2.getAncho()) - 10 , (Config.ALTO - puntos2.getAlto()) - 10);
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
	}
}
