import java.util.InputMismatchException;
import java.util.Scanner;

public class Act_Arreglo_01 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int array[] = new int [10];
		int num=0, cont=0;
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
		for(int i = 0; i < array.length;i++) {
			cont++;
			System.out.println("Índice "+cont+": "+array[i]);
		}
		s.close();

	}

}
