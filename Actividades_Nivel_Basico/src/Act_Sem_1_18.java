import java.util.InputMismatchException;
import java.util.Scanner;

public class Act_Sem_1_18 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		boolean error=false;
		int num=0;
		int mod=0;
		int cont=0;
		String bin = null;
		
		do {
			error=false;
			System.out.println("Ingrese un número:");
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
			if(!error) {
				if(num<0) {
					error = true;
					System.out.println("|Error|, ingrese un número positivo");
					s.nextLine();
		}}}while(error);
		
		while(num!=0) {
			if(cont==0) {
				mod= num%2;
				bin= Integer.toString(mod);
				num/=2;
				cont++;
			}else {
				mod= num%2;
				bin= Integer.toString(mod)+bin;
				num/=2;
				cont++;
			}
		}
		System.out.println("El número binario es: "+bin);
		s.close();
	}

}
