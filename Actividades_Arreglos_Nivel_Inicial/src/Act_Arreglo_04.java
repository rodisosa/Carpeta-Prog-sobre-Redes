
public class Act_Arreglo_04 {

	public static void main(String[] args) {
		int array[] = new int [34];
		int cont=0;
		int a=1;
		
		for(int i = 1; i < (array.length*3);i++) {		
			if((i%3)==0) {
				array[a]=i;
				a++;
			}
		}
		
		for(int i = 0; i < array.length;i++) {
			cont++;
			System.out.println("Índice "+cont+": "+array[i]);
		}

	}

}
