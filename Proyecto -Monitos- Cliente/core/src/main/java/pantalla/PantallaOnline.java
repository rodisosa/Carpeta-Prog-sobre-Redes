package pantalla;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
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
import red.HiloCliente;

public class PantallaOnline implements Screen{

	Teclado entradas = new Teclado(this);
	
	Texto texto, contador, jugador1, jugador2, temporizador, puntos1, 
		  puntos2, textoEsp, gan, opciones[] = new Texto[2], men;
	
	String texto1= "BUSCANDO SERVIDOR...", 
		   texto2 = "CONECTADO, ESPERANDO RIVAL...",
		   texto3 = "JUGADOR 1",
		   texto4 = "JUGADOR 2",
		   texto5 = "Menu Principal= (esc)",
		   textos[] = {"Volver a Jugar","Menu Principal"},  
		   ganador1 = "El ganador es el Jugador 1",
		   ganador2 = "El ganador es el Jugador 2",
		   empate = "Empate";
	
	Imagen fondo, fondoFinal;
	
	int con=0, division=0, espera=0, opc=1;
	boolean mantener = false;
	public int tem=120, ganador=0;
	public float tiempo, tiempo1, tiempo2;
	public boolean aux1=false, aux2=false, aux3=false, partidaTerminada = false, cerrar = false;
	public Mono mono1, mono2;
	public Array<Fruta> arrayFrutas;
	public Fruta fruta;
	private int nroJ = 1; 
	private HiloCliente hc;
	
	@Override
	public void show() {
		entradas.startInput();
		Gdx.input.setInputProcessor(entradas);
		arrayFrutas = new Array<>();
		fondo = new Imagen (Recursos.FONDO_JUEGO);
		fondoFinal = new Imagen (Recursos.FONDO_FINAL);
		Sprites.load();
		crearMono();
		crearTexto();
		hc = new HiloCliente(this);
		hc.start();
	}
	
	@Override
	public void render(float delta) {
		tiempo += delta; 
		Render.LimpPant();
		if (tiempo>1) {
			tiempo=0;
			if (!Config.online)con++;
			else con=0;
		}
		if (cerrar) {
			Render.app.setScreen(new PantallaMenu());
		}
		Render.begin();
		fondo.dibujar();
		Render.end();
		if (!Config.online) {
			Render.begin();
			dibujarTexto();
			updateBusqueda();
			Render.end();
			if (!Config.conectado) {
				if (con%2==0 && con!=60) hc.enviarMensaje("Conexion");
				else if (con==60) {
					int puerto = hc.getPuerto();
					puerto++;
					hc.setPuerto(puerto);
					hc.enviarMensaje("Conexion");
					con=0;
				}
			}
		} else {  
			if (!partidaTerminada) {
				tiempo += delta;
				tiempo1 += delta;
				mono1.setTiempo(tiempo1);
				mono2.setTiempo(tiempo1);
				update();
				//if (tiempo>1) {
				//	tiempo = 0;
				//	tem--;
				//}
				Render.begin();
				mono1.dibujar();
				mono2.dibujar();	
				dibujarFrutas();
				dibujarTexto();
				Render.end();
			} else {
				tiempo2 += delta;
				Render.begin();
				fondoFinal.dibujar();
				dibujarGanador();
				for (int i=0; i<opciones.length; i++) {	
					opciones[i].dibujar();
				}
				Render.end();
				updateFinal();
			}
		}
	}
	
	private void updateBusqueda() {
		if (entradas.isEsc()) {
			if (aux3==false) {
				aux3 = true;
				if (Config.conectado) {
					hc.enviarMensaje("Desconexion");
				}
				hc.cerrarHilo();
				Render.app.setScreen(new PantallaMenu());	
			}
			inputwait();
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
	
	public  void updateFinal(){ 
		if (entradas.isAbajo()){ 	
			esperaEntrada();			
			if (tiempo2>0.5f){ 
				tiempo2 = 0;
				opc++;			
				if (opc>opciones.length){
					opc = 1;
				}
			}
		}
		
		if (entradas.isArriba()){
			esperaEntrada();
			if (tiempo2>0.5f){
				tiempo2 = 0;
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
			tiempo2 = 0;
			switch (opc){
				case 1: hc.enviarMensaje("Volver-a-Jugar");
					break;
				case 2: 
					hc.enviarMensaje("Desconexion");
					hc.cerrarHilo();
					Render.app.setScreen(new PantallaMenu());
					break;
			}
		}
	}
	
	@SuppressWarnings("static-access")
	private void dibujarFrutas() {
		for (int i=arrayFrutas.size-1; i>=0; i--) {
			fruta = arrayFrutas.get(i);
			fruta.setPosY(fruta.getPosY() - fruta.Velocidad());
			fruta.dibujar(fruta.getNroF());
			if (fruta.getPosY()<-(fruta.getAlto())) {
				arrayFrutas.removeIndex(i);
			} 
		}
	}
	
	public void dibujarTexto() {	
		if (!Config.online) {
			if (!Config.conectado) texto.setTexto(texto1);
			else texto.setTexto(texto2);
			texto.setPosicion((Config.ANCHO / 2) - (texto.getAncho() / 2), (Config.ALTO / 2) + (texto.getAlto()));
			contador.setTexto(Integer.toString(con));
			contador.setPosicion((Config.ANCHO / 2) - (contador.getAncho() / 2), (Config.ALTO / 3) + (contador.getAlto()));
			texto.dibujar();
			contador.dibujar();
			men.dibujar();
		} else {
			jugador1.dibujar();
			jugador2.dibujar();
			temporizador.dibujar();
			puntos1.dibujar();
			puntos2.dibujar();
		}
	}
	
	public void update() {
		
		temporizador.setTexto(Integer.toString(tem));
		temporizador.setPosicion(((Config.ANCHO / 2) - (temporizador.getAncho() / 2)), Config.ALTO);
		if (Config.jugador) {
			if (entradas.isIzq()) {
				if (aux1==false) {
					hc.enviarMensaje("Izq");
					aux1=true;
				}
				mono1.setPosX(mono1.getPosX()-mono1.getVelocidad());
				mono1.camIzq = true;
			} else {
				if (aux1==true) {
					hc.enviarMensaje("NoIzq");
					aux1=false;	
				}
				mono1.camIzq = false;
			}	
			if (entradas.isDer()) {	
				if (aux2==false) {
					hc.enviarMensaje("Der");
					aux2=true;
				}
				mono1.setPosX(mono1.getPosX()+mono1.getVelocidad());
				mono1.camDer = true;
			} else {
				if (aux2==true) {
					hc.enviarMensaje("NoDer");
					aux2=false;
				}
				mono1.camDer = false;
			}
		} else {
			if (entradas.isIzq()) {
				if (aux1==false) {
					hc.enviarMensaje("Izq");
					aux1=true;
				}
				mono2.setPosX(mono2.getPosX()-mono2.getVelocidad());
				mono2.camIzq = true;
			} else {
				if (aux1==true) {
					hc.enviarMensaje("NoIzq");
					aux1=false;
				}
				mono2.camIzq = false;
			}	
			if (entradas.isDer()) {	
				if (aux2==false) {
					hc.enviarMensaje("Der");
					aux2=true;
				}
				mono2.setPosX(mono2.getPosX()+mono2.getVelocidad());
				mono2.camDer = true;
			} else {
				if (aux2==true) {
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
		if (nroF==Banana.getNroB()) fruta = new Banana(Banana.getNroB(), posX ,Banana.getVelocidadCaida(),0,0);
		else if (nroF==Pera.getNroP()) fruta = new Pera(Pera.getNroP(), posX,Pera.getVelocidadCaida(),0,0);
		else if (nroF==Manzana.getNroM()) fruta = new Manzana(Manzana.getNroM(), posX,Manzana.getVelocidadCaida(),0,0);
		arrayFrutas.add(fruta);
	}
	
	public void crearMono() {
		mono1 = new Mono(nroJ);
		mono2 = new Mono((nroJ==1)?2:1);
		mono1.camDer=false;
		mono1.camIzq=false;
		mono2.camDer=false;
		mono2.camIzq=false;
		mono1.setPosX(0);
		mono2.setPosX(Config.ANCHO - Mono.getAncho());
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
	
		int avance = 50;
		gan = new Texto(Recursos.FUENTE_MENU, 45, Color.WHITE, true);
		for (int i=0; i<opciones.length; i++) {	
			opciones[i] = new Texto(Recursos.FUENTE_MENU, 45, Color.WHITE, true);
			opciones[i].setTexto(textos[i]);
			opciones[i].setPosicion( ( Config.ANCHO / 2 ) - ( opciones[i].getAncho() / 2 ) , ( ( Config.ALTO / 2) - ( opciones[0].getAlto() + avance) ) - ( ( opciones[i].getAlto() * i ) + ( avance * i ) ) );	
		}
		
		men = new Texto(Recursos.FUENTE_MENU, 25, Color.WHITE, true);
		men.setTexto(texto5);
		men.setPosicion(10 , (Config.ALTO - puntos1.getAlto()) - 60);
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
	
	public void reiniciarValores() {
		tem = 120;
		mono1.setPosX(0);
		mono2.setPosX(Config.ANCHO - Mono.getAncho());
		mono1.puntos = 0;
		mono2.puntos = 0;
		mono1.camDer = false;
		mono1.camIzq = false;
		mono2.camDer = false;
		mono2.camIzq = false;
		for (int i=arrayFrutas.size-1; i>=0; i--) {
			arrayFrutas.removeIndex(i);
		}
		if (entradas.isIzq()) {
			entradas.setIzq(false);
		} 
		if (entradas.isDer()) {
			entradas.setIzq(false);
		} 
	}
	
	private void inputwait() {
		synchronized (entradas){
            try {
                entradas.wait(200);
            } catch (InterruptedException e) {
            	e.printStackTrace();
            }
        }
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
