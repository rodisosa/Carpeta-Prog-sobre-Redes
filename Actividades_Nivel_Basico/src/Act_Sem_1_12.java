import java.util.InputMismatchException;
import java.util.Scanner;

public class Act_Sem_1_12 {

	public static void main(String[] args) {
		Scanner s = new Scanner( System.in );
		int ano=0;
		boolean error = false;
		
		
		do {
			error=false;
			System.out.println("Ingrese el año:");
			try {
				ano = s.nextInt();
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
				if(ano<0) {
					error = true;
					System.out.println("|Error|, ingrese un número positivo");
					s.nextLine();
		}}}while(error);

		if((ano%4==0)&(ano%100!=0)|(ano%400==0)) {
			System.out.println("El año "+ano+" es biciesto");
		}else {
			System.out.println("El año "+ano+" no es biciesto");
		}
		s.close();
	}

}
