import java.util.InputMismatchException;
import java.util.Scanner;

public class Act_Avanzado_3 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int frasco=0;
		boolean error=false, azul=false, verde=false, amarillo=false, violeta=false, anaranjado=false;
		
		System.out.println("");
		System.out.println("INGRESE UN NÚMERO ELEGIR EL FRASCO CON VENENO:");
		System.out.println("1-Azul");
		System.out.println("2-Verde");
		System.out.println("3-Amarillo");
		System.out.println("4-Violeta");
		System.out.println("5-Anaranjado");
		System.out.println("6-Terminar");
		System.out.println("");
		
		do {
		
			do {
				error=false;
				System.out.println("Ingrese un número para elegir un frasco:");
				try {
					frasco = s.nextInt();
				}catch(InputMismatchException e) {
					error = true;
					System.out.println("|Error|, no ingresó un número entero");
					s.nextLine();
				}catch(Exception e) {
					error = true;
					System.out.println("|Error|, no ingresó un número entero");
					s.nextLine();
			}}while(error);
		
			System.out.println("");
			
			switch(frasco) {
			case 1: 
				
				if(!azul) {
					azul=true;
					System.out.println("Se eligió el azul");
					System.out.println("");
				} else {
					System.out.println("Este frasco ya se eligió");
					System.out.println("");
				}
				break;
				
			case 2: 
				
				if(!verde) {
					verde=true;
					System.out.println("Se eligió el verde");
					System.out.println("");
				} else {
					System.out.println("Este frasco ya se eligió");
					System.out.println("");
				}
				break;
				
			case 3: 
				
				if(!amarillo) {
					amarillo=true;
					System.out.println("Se eligió el amarillo");
					System.out.println("");
				} else {
					System.out.println("Este frasco ya se eligió");
					System.out.println("");
				}
				break;
				
			case 4: 
				
				if(!violeta) {
					violeta=true;
					System.out.println("Se eligió el violeta");
					System.out.println("");
				} else {
					System.out.println("Este frasco ya se eligió");
					System.out.println("");
				}
				break;
				
			case 5: 
				
				if(!anaranjado) {
					anaranjado=true;
					System.out.println("Se eligió el anaranjado");
					System.out.println("");
				} else {
					System.out.println("Este frasco ya se eligió");
					System.out.println("");
				}
				break;
				
			case 6: 
				
				System.out.println("Saliendo...");
				System.out.println("");
				error = (!azul & verde & amarillo & violeta & anaranjado ) ? error==true : error==false;
				String respuesta = (!error) ? "Felicidades el azul no tiene veneno :)" : "Incorrecto, vuelva a intentar :(";
				System.out.println(respuesta);			
				break;
				
			default:
				System.out.println("Ingrese un número entre los disponibles");
				break;
			}
			
		}while(!error);
		s.close();
	}

}
