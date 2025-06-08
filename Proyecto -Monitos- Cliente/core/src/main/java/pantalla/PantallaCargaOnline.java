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
import red.HiloCliente;

public class PantallaCargaOnline implements Screen{

	Teclado entradas = new Teclado(this);
	
	
	
	Texto texto, contador;
	String texto1= "BUSCANDO SERVIDOR...", texto2 = "CONECTADO, ESPERANDO RIVAL...";
	Imagen fondo;
	
	
	int tem=120, con=0, division=0, espera=0;
	boolean mantener = false;
	
	public float tiempo, tiempo1;
	public boolean jugador;
	public Mono mono1, mono2;
	public static Array<Fruta> arrayFrutas;
	public Fruta fruta;
	
	
	private int nroJ = 1; 
	private float posRival;
	private HiloCliente hc;
	
	@Override
	public void show() {
		fondo = new Imagen (Recursos.FONDO_JUEGO);
		crearTexto();
		
		entradas.startInput();
		Gdx.input.setInputProcessor(entradas);
		arrayFrutas = new Array<>();
		crearMono();
		
		hc = new HiloCliente(this);
		hc.start();
	}
	
	@Override
	public void render(float delta) {
		tiempo += delta; 
		Render.LimpPant();
		if(tiempo > 1) {
			tiempo=0;
		}
		
		Render.begin();
		fondo.dibujar();
		Render.end();
		
		if(!Config.online) {
			
			Render.begin();
			dibujarTexto(tiempo);
			Render.end();
			
			if(!Config.conectado) {
				if(con == 15 || con==30) hc.enviarMensaje("Conexion");
				else if (con == 60) {
					int puerto = hc.getPuerto();
					puerto++;
					hc.setPuerto(puerto);
					hc.enviarMensaje("Conexion");
					con=0;
				}
			}
			
		} else {  
			tiempo += delta;
			tiempo1 += delta;
			mono1.setTiempo(tiempo1);
			mono2.setTiempo(tiempo1);
			update();
			
			if(tiempo > 1) {
				tiempo = 0;
				tem--;
				}
			
			Render.begin();
			mono1.dibujar();
			mono2.dibujar();	
			dibujarFrutas();
			Render.end();
		}
	}
	
	@SuppressWarnings("static-access")
	private void dibujarFrutas() {
		
		for(int i = arrayFrutas.size - 1; i >= 0; i--) {
			fruta = arrayFrutas.get(i);
			fruta.setPosY(fruta.getPosY() - Fruta.getVelocidadCaida());
			fruta.colision.set(fruta.getPosX(), fruta.getPosY(), fruta.getAncho(), fruta.getAlto());
			
			if(fruta.getPosY() < -(fruta.getAlto())) {
				arrayFrutas.removeIndex(i);
			} 
			
			/*else if(mono1.colision.overlaps(fruta.colision)) {
				if (fruta.nroF == 0) mono1.puntos += 25;
				else if (fruta.nroF == 1) mono1.puntos += 50;
				else mono1.puntos += 100;
				arrayFrutas.removeIndex(i);
			} else if(mono2.colision.overlaps(fruta.colision)) {
				if (fruta.nroF == 0) mono2.puntos += 25;
				else if (fruta.nroF == 1) mono2.puntos += 50;
				else mono2.puntos += 100;
				arrayFrutas.removeIndex(i);
			}*/
		}
		
		for(Fruta fruta : arrayFrutas) {
			fruta.dibujar();
		}
	}
	
	
	public void dibujarTexto(float tiempo) {	
		if(!Config.online) {
			if(!Config.conectado) texto.setTexto(texto1);
			else texto.setTexto(texto2);
			texto.setPosicion((Config.ANCHO / 2) - (texto.getAncho() / 2), (Config.ALTO / 2) + (texto.getAlto()));
		
			if(tiempo==0) con++;
			contador.setTexto(Integer.toString(con));
			contador.setPosicion((Config.ANCHO / 2) - (contador.getAncho() / 2), (Config.ALTO / 3) + (contador.getAlto()));
		
			texto.dibujar();
			contador.dibujar();
		}	
	}
	
	
	
	public void update() {
		
		if(jugador) {
			if(entradas.isIzq()) {
				hc.enviarMensaje("Izq");
				mono1.camIzq = true;
				mono1.camDer = false;
				mono1.setPosX(mono1.getPosX()-mono1.getVelocidad());		
			} else {
				hc.enviarMensaje("NoIzq");
				mono1.camIzq = false;
			}
		
			if(entradas.isDer()) {
				hc.enviarMensaje("Der");
				mono1.camIzq = false;
				mono1.camDer = true;
				mono1.setPosX(mono1.getPosX()+mono1.getVelocidad());
			} else {
				hc.enviarMensaje("NoDer");
				mono1.camDer = false;
			} 
		
			if(posRival!=mono2.getPosX()) {
				if(posRival>mono2.getPosX()) {
					mono2.camIzq = true;
					mono2.camDer = false;
				} else {
					mono2.camIzq = false;
					mono2.camDer = true;
				}
				posRival=mono2.getPosX();
			} else {
				mono2.camIzq = false;
				mono2.camDer = false;
			}
		} else {
			if(entradas.isIzq()) {
				hc.enviarMensaje("Izq");
				mono2.setPosX(mono2.getPosX()-mono2.getVelocidad());
				mono2.camIzq = true;
				mono2.camDer = false;
			} else {
				hc.enviarMensaje("NoIzq");
				mono2.camIzq = false;
			}
		
			if(entradas.isDer()) {
				hc.enviarMensaje("Der");
				mono2.setPosX(mono2.getPosX()+mono2.getVelocidad());
				mono2.camIzq = false;
				mono2.camDer = true;
			} else {
				hc.enviarMensaje("NoDer");
				mono2.camDer = false;
			} 
		
			if(posRival!=mono1.getPosX()) {
				if(posRival>mono1.getPosX()) {
					mono1.camIzq = true;
					mono1.camDer = false;
					} else {
						mono1.camIzq = false;
						mono1.camDer = true;
					}
					posRival=mono1.getPosX();
			} else {
				mono1.camIzq = false;
				mono1.camDer = false;
			}
		}	
		
		if(Config.online) {
			
			
			
			
		}
		
		
		//mono1.colision.set(mono1.getPosX(), 0, mono1.getAncho(), mono1.getAlto());
		//mono2.colision.set(mono2.getPosX(), 0, mono2.getAncho(), mono2.getAlto());
		
		//puntos1.setTexto(Integer.toString(mono1.puntos));
		//puntos2.setTexto(Integer.toString(mono2.puntos));
		//puntos2.setPosicion( (Config.ANCHO - puntos2.getAncho()) - 10 , (Config.ALTO - puntos2.getAlto()) - 10);
	}
	
	public void crearFruta(int nroF, float posX) {
		fruta = new Fruta(nroF, posX);
		arrayFrutas.add(fruta);
		fruta.colision = new Rectangle();
	}
	
	public void crearMono() {
		Sprites.load();
		
		mono1 = new Mono(nroJ);
		mono2 = new Mono((nroJ==1)?2:1);
		
		mono1.colision = new Rectangle();
		mono2.colision = new Rectangle();
		
		if(jugador) posRival=mono2.getPosX();
		else posRival=mono1.getPosX();
			
		
		
	}
	
	public void crearTexto() {
		texto = new Texto(Recursos.FUENTE_MENU, 45, Color.WHITE, true);
		contador = new Texto(Recursos.FUENTE_MENU, 60, Color.WHITE, true);
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
