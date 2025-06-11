package elementos;

public class Banana extends Fruta{

	private static final int ALTO = 50;
	private static final int ANCHO = 50;
	private static final int PUNTOS = 100;
	private static final int VELOCIDAD_CAIDA = 5;
	private static final int NRO_B = 2;
	
	public Banana(int nroF, float posX, int vel, int ancho, int alto) {
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
	
	public static int getNroB() {
		return NRO_B;
	}
}
