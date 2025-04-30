import java.util.InputMismatchException;
import java.util.Scanner;

public class Act_Sem_1_01 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		Float peso = null;
		boolean error = false;
		
		do {
			error=false;
			System.out.println("Ingrese su peso:");
			try {
				peso = s.nextFloat();
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
		
		
		peso= peso * (17.0f / 100.0f);
		System.out.println("Su peso en la luna sería de: " + peso + "Kg");
		s.close();

	}

}
