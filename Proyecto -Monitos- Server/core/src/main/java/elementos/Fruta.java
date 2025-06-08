package elementos;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;

import utiles.Config;
import utiles.Render;

public class Fruta extends Sprites{

	
	private static final int ALTO = 50;
	private static final int ANCHO = 50;
	private static final int VELOCIDAD_CAIDA = 2;
	
	private float posX, posY = Config.ALTO + ALTO;
	public int nroF;
	public Rectangle colision;
	
	public Fruta(int nro) {
		this.nroF = nro;
		setPosX(MathUtils.random(0, Config.ANCHO - ANCHO));
	}
		
	public void dibujar() {	
		if(nroF == 0) {
			manzana.setPosition(posX,posY);
			manzana.draw(Render.sb);	
		} else if(nroF == 1) {
			pera.setPosition(posX,posY);
			pera.draw(Render.sb);	
		} else {
			banana.setPosition(posX,posY);
			banana.draw(Render.sb);
		}
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
	
	public static int getVelocidadCaida() {
		return VELOCIDAD_CAIDA;
	}

}
