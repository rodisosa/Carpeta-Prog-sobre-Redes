package elementos;

import com.badlogic.gdx.math.Rectangle;

import utiles.Config;

public class Mono {
	private static final int ALTO = 112;
	private static final int ANCHO = 88;
	public static final float DURACION_DE_FRAMES = 0.1f;
	private float posX;
	private int nroJ, velocidad = 3;
	public Rectangle colision;
	public int puntos = 0;
	public float tiempo;
	public boolean camDer, camIzq;
	
	public void setTiempo(float tiempo) {
		this.tiempo = tiempo;
	}
	
	public Mono(int nro) {
		nroJ = nro;
		if (nroJ==1) posX=0;
		else posX=(Config.ANCHO - ANCHO);
	}
	
	public void limitarMono() {
		if (posX<0) posX=0;
		if (posX>(Config.ANCHO - ANCHO)) posX = (Config.ANCHO - ANCHO);
	}
	
	public static float getAlto() {
		return ALTO;
	}

	public static float getAncho() {
		return ANCHO;
	}
	
	public float getPosX() {
		return posX;
	}

	public void setPosX(float posX) {
		this.posX = posX;
	}
	
	public static float getDuracionDeFrames() {
		return DURACION_DE_FRAMES;
	}
	
	public void setColision(Rectangle colision) {
		this.colision = colision;
	}
	
	public int getVelocidad() {
		return velocidad;
	}
}
