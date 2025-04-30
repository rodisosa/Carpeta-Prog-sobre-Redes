import java.util.Scanner;

public class Act_Arreglo_10 {

	public static void main(String[] args) {
		boolean error = false;
		Scanner s = new Scanner(System.in);
		char vocales[]= {'A','E','I','O','U','a','e','i','o','u'};
		String cadena = null;
		int cont=0;
				
		do {
			error = false;
			System.out.println("Ingrese una cadena de letras:");
			cadena = s.nextLine();	
			if(cadena.matches("[A-Za-z]*")) {
			}else {
				error=true;
				System.out.println("|Error|, ingrese una letra");
			}
		}while(error);

		for(int i =0; i<cadena.length();i++) {
			for(int j=0; j<vocales.length;j++) {
				
				if(cadena.charAt(i) == vocales[j]) {
					cont++;
				}
			}
		}	
		System.out.println("La cantidad de vocales son: "+cont);
		s.close();
		
	}

}
