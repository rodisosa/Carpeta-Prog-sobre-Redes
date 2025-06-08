package pantalla;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
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
	
	Texto texto, contador, jugador1, jugador2, temporizador, puntos1, puntos2, textoEsp;;
	String texto1= "BUSCANDO SERVIDOR...", 
		   texto2 = "CONECTADO, ESPERANDO RIVAL...",
		   texto3 = "JUGADOR 1",
		   texto4 = "JUGADOR 2";
	Imagen fondo;
	
	
	int con=0, division=0, espera=0;
	boolean mantener = false;
	
	public int tem=120;
	public float tiempo, tiempo1;
	public boolean jugador, aux1=false, aux2=false;
	public Mono mono1, mono2;
	public Array<Fruta> arrayFrutas;
	public Fruta fruta;
	
	private int nroJ = 1; 
	private HiloCliente hc;
	
	@Override
	public void show() {
		fondo = new Imagen (Recursos.FONDO_JUEGO);
		
		
		entradas.startInput();
		Gdx.input.setInputProcessor(entradas);
		arrayFrutas = new Array<>();
		crearMono();
		crearTexto();
		hc = new HiloCliente(this);
		hc.start();
	}
	
	@Override
	public void render(float delta) {
		tiempo += delta; 
		Render.LimpPant();
		if(tiempo > 1) {
			tiempo=0;
			if(!Config.online)con++;
			else con=0;
		}
		
		Render.begin();
		fondo.dibujar();
		Render.end();
		
		if(!Config.online) {
			
			Render.begin();
			dibujarTexto();
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
			dibujarTexto();
			Render.end();
		}
	}
	
	@SuppressWarnings("static-access")
	private void dibujarFrutas() {
		for(int i = arrayFrutas.size - 1; i >= 0; i--) {
			fruta = arrayFrutas.get(i);
			fruta.setPosY(fruta.getPosY() - Fruta.getVelocidadCaida());
			fruta.dibujar();
			if(fruta.getPosY() < -(fruta.getAlto())) {
				arrayFrutas.removeIndex(i);
			} 
		}
	}
	
	public void dibujarTexto() {	
		if(!Config.online) {
			if(!Config.conectado) texto.setTexto(texto1);
			else texto.setTexto(texto2);
			texto.setPosicion((Config.ANCHO / 2) - (texto.getAncho() / 2), (Config.ALTO / 2) + (texto.getAlto()));
		
			contador.setTexto(Integer.toString(con));
			contador.setPosicion((Config.ANCHO / 2) - (contador.getAncho() / 2), (Config.ALTO / 3) + (contador.getAlto()));
		
			texto.dibujar();
			contador.dibujar();
		} else {
			jugador1.dibujar();
			jugador2.dibujar();
			temporizador.dibujar();
			puntos1.dibujar();
			puntos2.dibujar();
		}
	}
	
	public void update() {
		if(jugador) {
			if(entradas.isIzq()) {
				if(aux1==false) {
					hc.enviarMensaje("Izq");
					aux1=true;
				}
				mono1.setPosX(mono1.getPosX()-mono1.getVelocidad());
				mono1.camIzq = true;
			} else {
				if(aux1==true) {
					hc.enviarMensaje("NoIzq");
					aux1=false;
					
				}
				mono1.camIzq = false;
			}	
			if(entradas.isDer()) {	
				if(aux2==false) {
					hc.enviarMensaje("Der");
					aux2=true;
				}
				mono1.setPosX(mono1.getPosX()+mono1.getVelocidad());
				mono1.camDer = true;
			} else {
				if(aux2==true) {
					hc.enviarMensaje("NoDer");
					aux2=false;
				}
				mono1.camDer = false;
			}
		} else {
			if(entradas.isIzq()) {
				if(aux1==false) {
					hc.enviarMensaje("Izq");
					aux1=true;
				}
				mono2.setPosX(mono2.getPosX()-mono2.getVelocidad());
				mono2.camIzq = true;
			} else {
				if(aux1==true) {
					hc.enviarMensaje("NoIzq");
					aux1=false;
				}
				mono2.camIzq = false;
			}	
			if(entradas.isDer()) {	
				if(aux2==false) {
					hc.enviarMensaje("Der");
					aux2=true;
				}
				mono2.setPosX(mono2.getPosX()+mono2.getVelocidad());
				mono2.camDer = true;
			} else {
				if(aux2==true) {
					hc.enviarMensaje("NoDer");
					aux2=false;
				}
				mono2.camDer = false;
			}
		}
		
		puntos1.setTexto(Integer.toString(mono1.puntos));
		puntos2.setTexto(Integer.toString(mono2.puntos));
		puntos2.setPosicion( (Config.ANCHO - puntos2.getAncho()) - 10 , (Config.ALTO - puntos2.getAlto()) - 10);
		
	}
	
	public void crearFruta(int nroF, float posX) {
		fruta = new Fruta(nroF, posX);
		arrayFrutas.add(fruta);
	}
	
	public void crearMono() {
		Sprites.load();
		mono1 = new Mono(nroJ);
		mono2 = new Mono((nroJ==1)?2:1);
	}
	
	public void crearTexto() {
		texto = new Texto(Recursos.FUENTE_MENU, 45, Color.WHITE, true);
		contador = new Texto(Recursos.FUENTE_MENU, 60, Color.WHITE, true);
		
		jugador1 = new Texto(Recursos.FUENTE_MENU, 45, Color.GOLD, true);
		jugador1.setTexto(texto3);
		jugador1.setPosicion(10, Config.ALTO);
		
		jugador2 = new Texto(Recursos.FUENTE_MENU, 45, Color.GOLD, true);
		jugador2.setTexto(texto4);
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
