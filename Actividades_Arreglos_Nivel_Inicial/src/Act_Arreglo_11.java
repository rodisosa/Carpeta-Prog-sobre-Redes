import java.util.Scanner;

public class Act_Arreglo_11 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String cadena = "", inv = "";
		
		System.out.println("Ingrese una cadena de caracteres:");
		cadena = s.nextLine();	
			
		for (int i = cadena.length() -1; i>=0; i--) {
			inv += cadena.charAt(i);
		}
		
		System.out.println("Cadena de caracteres invertida: " + inv);
		s.close();
	}

}
