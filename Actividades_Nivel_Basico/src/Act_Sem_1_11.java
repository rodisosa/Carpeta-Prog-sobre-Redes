import java.util.InputMismatchException;
import java.util.Scanner;

public class Act_Sem_1_11 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		boolean error=false;
		int min=0;
		int cont=0;
		int res=0;
		int montoBase=5;
		
		do {
			error=false;
			System.out.println("Ingrese la cantidad de minutos:");
			try {
				min = s.nextInt();
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
				if(min<0) {
					error = true;
					System.out.println("|Error|, ingrese un número positivo");
					s.nextLine();
		}}}while(error);
		
		
		if(min<=montoBase) {
			System.out.println("El monto son 5 pesos");
		}
		
		if(min>montoBase) {
			min-=montoBase;
			while(min!=0) {
				min--;
				cont++;
				
			}
			cont*=50;
			if(cont>=100) {
				res=cont/100;
				montoBase+=res;
				cont%=100;
				System.out.println("El monto son "+montoBase+" pesos con "+cont+" centavos");
			} else {
				System.out.println("El monto son "+montoBase+" pesos con "+cont+" centavos");
			}
		}
		s.close();
		
	}

}
