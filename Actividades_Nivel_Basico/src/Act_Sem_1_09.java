import java.util.InputMismatchException;
import java.util.Scanner;

public class Act_Sem_1_09 {

public static void main(String[] args) {
		
		Scanner s = new Scanner( System.in );
		int num = 0;
		double f;
		boolean error = false;
		
		do {
			error=false;
			System.out.println("Ingrese un número para factorizar:");
			try {
				num = s.nextInt();
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
		
		f=1; 
		for (int i=num;i>0;i--){
			f=f*i;
		}
		System.out.println("El factorial de: "+num+" es: " + f);
		s.close();
	}

}
