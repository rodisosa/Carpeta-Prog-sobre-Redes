package elementos;

import com.badlogic.gdx.math.Rectangle;

import utiles.Config;

public class Fruta{
	private static final int ALTO = 50;
	private static final int ANCHO = 50;
	protected float posX, posY = Config.ALTO + ALTO;
	protected int nroF, vel;
	public Rectangle colision;
	
	public Fruta(int nro, float posX, int vel) {
		this.nroF = nro;
		this.posX = posX;
		this.vel = vel;
	}
	
	public float getPosX() {
		return posX;
	}

	public void setPosX(float posX) {
		this.posX = posX;
	}

	public float getPosY() {
		return posY;
	}

	public void setPosY(float posY) {
		this.posY = posY;
	}

	public static int getAlto() {
		return ALTO;
	}

	public static int getAncho() {
		return ANCHO;
	}
	
	public int getNroF() {
		return nroF;
	}
	
	public int Velocidad() {
		return vel;
	}
	
}
