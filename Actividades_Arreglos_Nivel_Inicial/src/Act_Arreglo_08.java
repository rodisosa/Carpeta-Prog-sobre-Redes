
public class Act_Arreglo_08 {

	public static void main(String[] args) {
		int array[]= {-2,5,8,-9,10,15,-4};
		int sumaPos=0, sumaNeg=0;
		
		for(int i = 0; i < array.length;i++) {		
			
			if(array[i]>0) {
				sumaPos+=array[i];
			} else if (array[i]<0){
				sumaNeg+=array[i];
			}	
		}
		System.out.println("La suma de los positivos es: "+sumaPos);
		System.out.println("La suma de los negativos es: " +sumaNeg);	
	}

}
