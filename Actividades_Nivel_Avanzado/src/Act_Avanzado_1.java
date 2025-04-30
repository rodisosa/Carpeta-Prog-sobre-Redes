import java.util.InputMismatchException;
import java.util.Scanner;

public class Act_Avanzado_1 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		boolean error = false, gallina = false, lobo = false, maiz = false, hombre=false;
		int men=0;
		
		do {
			
			System.out.println("");
			System.out.println("1-Llevar a la Gallina");
			System.out.println("2-Llevar a el Lobo");
			System.out.println("3-Llevar el Maiz");
			System.out.println("4-Cruzar el río solo");
			System.out.println("");
			
			do {
				error=false;
				System.out.println("Ingrese un número:");
				try {
					men = s.nextInt();
				}catch(InputMismatchException e) {
					error = true;
					System.out.println("|Error|, no ingresó un número entero");
					s.nextLine();
				}catch(Exception e) {
					error = true;
					System.out.println("|Error|, no ingresó un número entero");
					s.nextLine();
				}
				if(!error) {
					if(men<0) {
						error = true;
						System.out.println("|Error|, ingrese un número positivo");
						s.nextLine();
			}}}while(error);
				
			System.out.println("");
			
			switch(men) {
				case 1: 
					
					if(hombre == gallina || !hombre == !gallina) {
						hombre = (!hombre) ? true : false;
						gallina = (!gallina) ? true : false;
					} else {
						System.out.println("El hombre y la gallina no están del mismo lado");
					}
					break;
					
				case 2: 
					
					if(hombre == lobo || !hombre == !lobo) {
						hombre = (!hombre) ? true : false;
						lobo = (!lobo) ? true : false;
					} else {
						System.out.println("El hombre y el lobo no están del mismo lado");
					}
					break;
					
				case 3: 
					
					if(hombre == maiz || !hombre == !maiz) {
					hombre = (!hombre) ? true : false;
					maiz = (!maiz) ? true : false;
					} else {
						System.out.println("El hombre y el maiz no están del mismo lado");
					}
					break;
					
				case 4: 
					
					hombre = (!hombre) ? true : false;
					break;
					
				default:
					System.out.println("Ingrese un número entre los disponibles");
					break;
				}
			
			
			error = (gallina || lobo || !hombre) ? error==true: error==false;
			error = (!gallina || !lobo || hombre) ? error==true: error==false;
			
			if(error) { 
				System.out.println("El lobo se comió a la gallina");
				break;
			}
			
			error = (gallina || maiz || !hombre) ? error==true: error==false;
			error = (!gallina || !maiz || hombre) ? error==true: error==false;
			
			if(error) { 
				System.out.println("La gallina se comió el maiz");
				break;
			}
			
		}while( !gallina | !lobo | !maiz);
		
		String respuesta = ( !gallina | !lobo | !maiz) ? "Perdiste, vuelve a intentarlo" : "Felicidades, todos cruzaron el río";
		System.out.println(respuesta);
		
		s.close();
	}

}
