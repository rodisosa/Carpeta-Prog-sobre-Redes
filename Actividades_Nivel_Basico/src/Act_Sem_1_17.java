import java.util.InputMismatchException;
import java.util.Scanner;

public class Act_Sem_1_17 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		boolean error=false;
		double a=0,b=0,c=0, x1=0, x2=0;
		double cal=0;
				
		System.out.println("Ingrese los número para:   a(x)^2 - bx = c");
		System.out.println("");
		
		do {
			error=false;
			System.out.println("Ingrese A:");
			try {
				a = s.nextInt();
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
		
		do {
			error=false;
			System.out.println("Ingrese B:");
			try {
				b = s.nextInt();
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
		
		do {
			error=false;
			System.out.println("Ingrese C:");
			try {
				c = s.nextInt();
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
				
		b*=-1;
		c*=-1;
		
		cal= Math.sqrt(  (Math.pow(b, 2)) - 4 * (a * c) );
		
		a*=2;	
		b*=-1;
		
		for(int i = 0; i<2; i++) {
			
			if(i==0) {
				x1= (int)(( b + cal ) / a);
			} else {
				x2= (int)(( b - cal ) / a);
			}
		}	
		System.out.println("El resultado es X1= "+x1+" y X2= "+x2);
		s.close();
	}

}
