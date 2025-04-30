import java.util.InputMismatchException;
import java.util.Scanner;

public class Act_Sem_1_06 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		long poblacion=7309784505l;
		int crecimiento=24807909;
		int anos=0;
		boolean error=false;
		
		do {
			error=false;
			System.out.println("Ingrese la cantidad de años:");
			try {
				anos = s.nextInt();
			}catch(InputMismatchException e) {
				error = true;
				System.out.println("|Error|, no ingresó un número");
				s.nextLine();
			}catch(Exception e) {
				error = true;
				System.out.println("|Error|, no ingresó un número");
				s.nextLine();
			}
		}while(error);
		
		for(int i=0;i<anos;i++) {	
			poblacion+=(long)crecimiento;
		}
		
		System.out.println("La población dentro de "+anos+" años va a ser de: "+poblacion);
		s.close();
	}

}
