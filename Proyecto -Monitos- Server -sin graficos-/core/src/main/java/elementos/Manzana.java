package elementos;

public class Manzana extends Fruta{
	private static final int ALTO = 50;
	private static final int ANCHO = 50;
	private static final int PUNTOS = 25;
	private static final int VELOCIDAD_CAIDA = 3;
	private static final int NRO_M = 0;
	
	public Manzana(int nroF, float posX, int vel, int ancho, int alto) {
		super(nroF, posX, vel);
		ancho = Banana.getAncho();
		alto = Banana.getAlto();
	}
	
	public static int getAlto() {
		return ALTO;
	}

	public static int getAncho() {
		return ANCHO;
	}
	
	public static int getPuntos() {
		return PUNTOS;
	}
	
	public int getVelocidad() {
		return vel;
	}
	
	public static int getVelocidadCaida() {
		return VELOCIDAD_CAIDA;
	}
	
	public static int getNroM() {
		return NRO_M;
	}
}
