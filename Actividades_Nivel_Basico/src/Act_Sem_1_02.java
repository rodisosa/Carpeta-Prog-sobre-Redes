import java.util.InputMismatchException;
import java.util.Scanner;

public class Act_Sem_1_02 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		boolean error = false;
		int num=0, l=0, t=0;

		
		do {
			error=false;
			System.out.println("Ingrese un número de 5 dígitos: ");
			try {
				num = s.nextInt();
			}catch(InputMismatchException e) {
				error = true;
				System.out.println("|Error|, no ingresó un número");
				s.nextLine();
			}catch(Exception e) {
				error = true;
				System.out.println("|Error|, no ingresó un número");
				s.nextLine();
			}
			
			l = Integer.toString(num).length();
			
			if (l != 5 && !error) {
				System.out.println("Su número no contiene 5 dígitos");
				error = true;
				s.nextLine();
			}
		}while(error);
		
		for (int i = 0; i < l; i++) {
			String sum = String.valueOf(Integer.toString(num).charAt(i));
			t += Integer.parseInt(sum);
		}
		
		System.out.println("La suma de los dígitos de: " + num + " es: " + t);
		s.close();

	}

}
