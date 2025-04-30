import java.util.InputMismatchException;
import java.util.Scanner;

public class Act_Arreglo_16 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int dim=0, aux=0, positivo=0, negativo=0, cero=0;
		boolean error = false;
		
		do {
			error=false;
			System.out.println("Ingrese la dimención del vector:");
			try {
				dim = s.nextInt();
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
				if(dim<0) {
					error = true;
					System.out.println("|Error|, ingrese un número positivo");
					s.nextLine();
				} else if (dim==0){
					error = true;
					System.out.println("|Error|, ingrese un número mayor a 0");
					s.nextLine();
				}
			}
		}while(error);
		
		int array[] = new int [dim];
		int pos[] = new int [dim];
		int arrayCopia[] = new int [dim];
		
		for(int i = 0; i < array.length;i++) {	
			
			do {
				error=false;
				System.out.println("Ingrese un número para la posición "+(i+1)+": ");
				try {
					array[i] = s.nextInt();
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
		}
		
		for(int i = 0; i < dim;i++) {	
			arrayCopia[i]=array[i];
		}
		
		for(int i = 0; i < dim;i++) {	
			
			if(array[i]>0) {
				positivo++;
			}else if(array[i]<0) {
				negativo++;
			}else {
				cero++;
			}
		}
		
		for(int i = 0; i < (dim-1);i++) {	
			
			for(int j = 0; j < (dim-1);j++) {	
				
				if(array[j]>array[j+1]) {
					aux=array[j];
					array[j]=array[j+1];
					array[j+1]=aux;
				}	
			}
		}
		
		for(int i = 0; i < dim;i++) {	
			for(int j = 0; j < dim;j++) {				
				if(array[j]==arrayCopia[i]) {	
					
					pos[j]=i+1;
				}
			}
		}
		System.out.println("");
		
		for(int i = 0; i < array.length;i++) {	
			System.out.println("Posición "+pos[i]+". = "+array[i]);
			
		}

		System.out.println("");
		System.out.println("El valor mínimo es: "+array[0]);
		System.out.println("El valor máximo es: "+array[dim-1]);
		System.out.println("");
		System.out.println("Hay : "+positivo+" números positivos");
		System.out.println("Hay : "+negativo+" números negativos");
		System.out.println("Hay : "+cero+" ceros");
		
		s.close();

	}

}
