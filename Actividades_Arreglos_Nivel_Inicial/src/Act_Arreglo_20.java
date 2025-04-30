import java.util.InputMismatchException;
import java.util.Scanner;

public class Act_Arreglo_20 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int aux=0, emp=0;
		boolean error = false;
		
		
		do {
			error=false;
			System.out.println("Ingrese la cantidad de empleados:");
			try {
				emp = s.nextInt();
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
				if(emp<0) {
					error = true;
					System.out.println("|Error|, ingrese un número positivo");
					s.nextLine();
				} else if (emp==0){
					error = true;
					System.out.println("|Error|, ingrese un número mayor a 0");
					s.nextLine();
				}
			}
		}while(error);
		
		s.nextLine();
		
		String empleados[] = new String [emp];
		int sueldos[] = new int [emp];
		
		
		
		for(int i = 0; i < emp; i++) {
			
			do {
				error = false;
				System.out.println("Ingrese el nombre del empleado:");
				empleados[i] = s.nextLine();	
				if(empleados[i].matches("[A-Za-z]*")) {
				}else {
					error=true;
					System.out.println("|Error|");
				}
			}while(error);
			
			
			
			do {
				error=false;
				System.out.println("Ingrese el sueldo de "+empleados[i]+": ");
				try {
					 sueldos[i] = s.nextInt();
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
					if(sueldos[i]<0) {
						error = true;
						System.out.println("|Error|, no existen las notas negativas");
						s.nextLine();
					} else if (sueldos[i]==0){
						error = true;
						System.out.println("|Error|, no existen las notas iguales a 0");
						s.nextLine();
					} 
				}	
				
				s.nextLine();
				
			}while(error);
			
		}
		
		for(int i = 0; i <emp;i++) {		
			if(i==0) {
				aux=sueldos[i];
			} else if(aux<sueldos[i]) {
				aux=sueldos[i];
			}
		}
		
		for(int i = 0; i <emp;i++) {		
			if(sueldos[i]==aux) {	
				System.out.println("El empleado nro "+(i+1)+" con el nombre: "+empleados[i]+" tiene el mayor sueldo, siendo de "+sueldos[i]+"$");
			}
		}
		s.close();
	}

}
