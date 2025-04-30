import java.util.InputMismatchException;
import java.util.Scanner;

public class Act_Arreglo_19 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int aux=0, alum=0;
		boolean error = false;
		
		
		do {
			error=false;
			System.out.println("Ingrese la cantidad de alumnos:");
			try {
				alum = s.nextInt();
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
				if(alum<0) {
					error = true;
					System.out.println("|Error|, ingrese un número positivo");
					s.nextLine();
				} else if (alum==0){
					error = true;
					System.out.println("|Error|, ingrese un número mayor a 0");
					s.nextLine();
				}
			}
		}while(error);
		
		int alumnos[] = new int [alum];
		
		for(int i = 0; i <alum;i++) {	
			
			do {
				error=false;
				System.out.println("Ingrese una nota para el alumno "+(i+1)+": ");
				try {
					alumnos[i] = s.nextInt();
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
					if(alum<0) {
						error = true;
						System.out.println("|Error|, no existen las notas negativas");
						s.nextLine();
					} else if (alum==0){
						error = true;
						System.out.println("|Error|, no existen las notas iguales a 0");
						s.nextLine();
					} else if (alum>10){
						error = true;
						System.out.println("|Error|, no existen las notas mayores a 10");
						s.nextLine();
					}
				}	
			}while(error);
		}
		
		for(int i = 0; i <alum;i++) {		
			aux+=alumnos[i];	
		}
		
		aux/=alum;
		
		for(int i = 0; i <alum;i++) {		
			
			if(alumnos[i]>aux) {
				
				System.out.println("El alumno "+(i+1)+" esta por arriba del promedio");
			}
		}
		s.close();
	}

}
