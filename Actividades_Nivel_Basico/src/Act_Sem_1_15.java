import java.util.InputMismatchException;
import java.util.Scanner;

public class Act_Sem_1_15 {

	public static void main(String[] args) {
		Scanner s = new Scanner( System.in );
		int seg = 0, hor, min, numUno, numDos;
		boolean error = false;
		
		do {
			error=false;
			System.out.println("Ingrese los segundos:");
			try {
				seg = s.nextInt();
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
				if(seg<0) {
					error = true;
					System.out.println("|Error|, ingrese un número positivo");
					s.nextLine();
		}}}while(error);
		
		
		hor=seg/3600;
		numUno=seg%3600;
		min=numUno/60;
		numDos=numUno%60;
		
		System.out.println("Son "+hor+" horas con "+min+" minutos y "+numDos+" segundos");
		s.close();
	}

}
