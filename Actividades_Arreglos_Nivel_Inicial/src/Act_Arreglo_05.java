
public class Act_Arreglo_05 {

	public static void main(String[] args) {
		int array[] = new int [5];
		int arrayCopia[] = new int [5];
		int num=1;
		
		for(int i = 0; i < array.length;i++) {		
			array[i]=num++;
		}
		System.out.print("Array 1=");
		for(int i = 0; i < array.length;i++) {	
			arrayCopia[i]=array[i];
			System.out.print(" "+array[i]);
		}
		System.out.println("");
		System.out.print("Array 2=");
		for(int i = 0; i < arrayCopia.length;i++) {	
			System.out.print(" "+arrayCopia[i]);
		}

	}

}
