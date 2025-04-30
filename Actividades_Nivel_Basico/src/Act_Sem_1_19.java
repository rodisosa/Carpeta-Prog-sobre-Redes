import java.util.InputMismatchException;
import java.util.Scanner;

public class Act_Sem_1_19 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		boolean error=false;
		float vel=0;
		float ms=0;
		
		do {
			error=false;
			System.out.println("Ingrese la velocidad en Km/h:");
			try {
				vel = s.nextFloat();
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
				if(vel<0) {
					error = true;
					System.out.println("|Error|, ingrese un número positivo");
					s.nextLine();
		}}}while(error);
		
		ms= (vel * 1000)/3600;
		
		System.out.println("La converción de "+vel+" KM/H a M/S es de: ");
		System.out.println("");
		System.out.println("         "+vel+" x 1000    ");
		System.out.println("M/S=  ---------------");
		System.out.println("           3600    ");
		System.out.println("");
		System.out.println("M/S= "+ms);
		
		s.close();
	}

}
