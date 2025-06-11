package elementos;

public class Pera extends Fruta {
	private static final int ALTO = 50;
	private static final int ANCHO = 50;
	private static final int PUNTOS = 50;
	private static final int VELOCIDAD_CAIDA = 4;
	private static final int NRO_P = 1;
	
	public Pera(int nroF, float posX, int vel, int ancho, int alto) {
		super(nroF, posX, vel);
		ancho = Banana.getAncho();
		alto = Banana.getAlto();
	}
	
	public void mostrarFruta() {
		System.out.println(nroF);
		System.out.println(posX);
		System.out.println(getAlto());
		System.out.println(getAncho());
		System.out.println(vel);
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
	
	public static int getNroP() {
		return NRO_P;
	}
}
