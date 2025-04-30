
public class Act_Arreglo_02 {

	public static void main(String[] args) {
		int array[] = new int [11];
		int num=4, cont=0;
		
		for(int i = 0; i < array.length;i++) {		
			array[i]=num++;
		}
		for(int i = 0; i < array.length;i++) {
			cont++;
			System.out.println("Índice "+cont+": "+array[i]);
		}

	}

}
