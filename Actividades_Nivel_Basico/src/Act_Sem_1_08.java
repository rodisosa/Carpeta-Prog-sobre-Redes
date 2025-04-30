import java.util.InputMismatchException;
import java.util.Scanner;

public class Act_Sem_1_08 {

	public static void main(String[] args) {
		final float pi = 3.141592f;
		Scanner s = new Scanner(System.in);
		boolean error=false;
		int r=0;
		int d;
		float a;
		double c;
		
		do {
			error=false;
			System.out.println("Ingrese el radio:");
			try {
				r = s.nextInt();
			}catch(InputMismatchException e) {
				error = true;
				System.out.println("|Error|, no ingresó un número entero");
				s.nextLine();
			}catch(Exception e) {
				error = true;
				System.out.println("|Error|, no ingresó un número entero");
				s.nextLine();
			}
		}while(error);
		
		d=r*2;
		
		a= (2) * (pi) * ((float)r) ;
		
		c= (pi) * (Math.pow(r,2)) ;
		
		System.out.println("El diametro es: "+d+", el área es: "+a+" y la circunferencia es: "+c);
		s.close();
	}

}
