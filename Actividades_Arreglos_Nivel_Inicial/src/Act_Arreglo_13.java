
public class Act_Arreglo_13 {

	public static void main(String[] args) {
		int array[] = new int [101];
		int num=0, cont=0;
		
		
		for(int i = 0; i < array.length;i++) {		
			array[i]=num++;
		}
		
		for(int i = 0; i < array.length;i++) {
			if(i>0) {
				
				cont++;
				System.out.print("Índice "+cont+": "+array[i]);
				if((array[i])%2==0) {
					System.out.print(" es par");
				} else {
					System.out.print(" no es par");
				}
			}
			System.out.println("");
		}
	}

}
