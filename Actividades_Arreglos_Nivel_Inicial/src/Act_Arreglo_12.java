import java.util.Scanner;

public class Act_Arreglo_12 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String cadena = "", inv = "";
		boolean error=false;
		
		do {
			error = false;
			System.out.println("Ingrese una cadena de letras:");
			cadena = s.nextLine();	
			if(cadena.matches("[A-Za-z]*")) {
			} else {
				error=true;
				System.out.println("|Error|, ingrese una letra");
			}
		}while(error);	
			
		for (int i = cadena.length() -1; i>=0; i--) {
			inv += cadena.charAt(i);
		}
		
		System.out.println("");
		System.out.println("Cadena de caracteres ingresada: " + cadena);
		System.out.println("Cadena de caracteres invertida: " + inv);
		System.out.println("");
		
		if (cadena.equals(inv)) {
	          System.out.println("Es palíndromo");
	        }
	        else {
	          System.out.println("No es palíndromo");
	        }
		s.close();
	}

}
