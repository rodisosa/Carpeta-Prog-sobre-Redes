import java.util.InputMismatchException;
import java.util.Scanner;

public class Act_Arreglo_07 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int array[] = new int [5];
		int num=0, suma=0;
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
			suma+=array[i];
		}
		
		suma/=array.length;
		
		System.out.println("El promedio es= "+suma);
		
		s.close();

	}

}
