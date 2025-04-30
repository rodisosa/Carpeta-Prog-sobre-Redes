import java.util.InputMismatchException;
import java.util.Scanner;

public class Act_Sem_1_20 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		boolean error=false;
		boolean errorP =false;
		int art=0, cant=0,precio=0, precioT=0;
		
		do {
			
			do {
				error=false;
				System.out.println("Ingrese el ID del artículo |ingrese 0 para salir|:");
				try {
					art = s.nextInt();
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
					if(art<0) {
						error = true;
						System.out.println("|Error|, ingrese un número positivo");
						s.nextLine();
			}}}while(error);
			
			if(art==0) {
				errorP=true;
			}
			
			if(!errorP) {
				
				do {
					error=false;
					System.out.println("Ingrese la cantidad:");
					try {
						 cant = s.nextInt();
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
						if( cant<0) {
							error = true;
							System.out.println("|Error|, ingrese un número positivo");
							s.nextLine();
				}}}while(error);
				
				do {
					error=false;
					System.out.println("Ingrese el precio:");
					try {
						precio = s.nextInt();
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
						if( precio<0) {
							error = true;
							System.out.println("|Error|, ingrese un número positivo");
							s.nextLine();
				}}}while(error);
				
				precioT= precio * cant;
				System.out.println("");
				System.out.println("----------------------");
				System.out.println("Nro: "+art);
				System.out.println("");
				System.out.println("Cantidad: "+cant);
				System.out.println("");
				System.out.println("Precio unitario: "+precio);
				System.out.println("");
				System.out.println("Precio total: "+precioT);
				System.out.println("----------------------");
				System.out.println("");
			}
		}while(!errorP);
		s.close();
	}
}
