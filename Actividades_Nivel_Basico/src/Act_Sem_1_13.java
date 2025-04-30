import java.util.InputMismatchException;
import java.util.Scanner;

public class Act_Sem_1_13 {

	public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int num=0;
        int cal;
        int res;
        int inv=0;
        boolean error = false;
        
        do {
			error=false;
			System.out.println("Ingrese un número mayor a 10:");
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
				}else if(num<10) {
					error = true;
					System.out.println("|Error|, ingrese un número mayor a 10");
					s.nextLine();
					
				}
				}}while(error);
       
        cal=num;
        while (cal!=0){
            res = cal % 10;
            inv = inv * 10 + res;
            cal = cal / 10;
        }
    
        if(num == inv){
            System.out.println("El número es capicua");
        }else{
            System.out.println("El número no es capicua");
        }
        s.close();

	}

}
