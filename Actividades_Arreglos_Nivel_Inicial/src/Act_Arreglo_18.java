import java.util.InputMismatchException;
import java.util.Scanner;

public class Act_Arreglo_18 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int dim=10;
		int dim2=5;
		int array[] = new int [dim];
		int num=0;
		boolean error = false;
		
		for(int i = 0; i < array.length;i++) {	
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
			}while(error);
			array[i]=num;
		}
		
		int arrayCopia[] = new int [dim2];
		
		for(int i = 0; i < dim;i++) {	
			if(i>4) {
				arrayCopia[i-5]=array[i];
			}
		}
		
		int cont=6;
		
		for(int i = 0; i < dim2;i++) {	
			System.out.println("Índice "+cont+". "+arrayCopia[i]);
			cont++;
		}
		s.close();

	}

}
