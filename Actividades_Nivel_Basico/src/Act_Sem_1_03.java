
public class Act_Sem_1_03 {

	public static void main(String[] args) {
		int num = 0;
		int cuad = 0;
		int cubo = 0;
		System.out.println("Número    Cuadrado    Cubo \n");
		while(num != 11) {
			cuad = num * num;
			cubo = num * num * num;
			if (num < 4) {
				System.out.println(num + "         " + cuad + "           " + cubo);
			}else if (num > 3 && num < 10){
				System.out.println(num + "         " + cuad + "          " + cubo);
			}else{
				System.out.println(num + "        " + cuad + "         " + cubo);
			}
			num ++;
			cuad = 0;
			cubo = 0;
		}
	}

}
