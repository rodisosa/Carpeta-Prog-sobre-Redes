import java.util.InputMismatchException;
import java.util.Scanner;

public class Act_Arreglo_17 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int pos=0, men=0;
		boolean error = false;
		int array[]= new int [20];
		array[0]= -4;
		array[1]= 5;
		array[2]= 4;
		array[3]= 14;
		
		do {
			
			System.out.println("");
			System.out.println("1- Consultar");
			System.out.println("2- Asignar");
			System.out.println("3- Modificar");
			System.out.println("4- Eliminar");
			System.out.println("5- Salir");
			System.out.println("");
			
			do {
				error=false;
				System.out.println("Ingrese un número:");
				try {
					men = s.nextInt();
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
			
			System.out.println("----------------------------------");
			
			switch(men) {
				case 1:
					
					do {
						error=false;
						System.out.println("Ingrese la posición a consultar:");
						try {
							pos = s.nextInt();
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
							if(pos<0) {
								error = true;
								System.out.println("|Error|, ingrese un número positivo");
								s.nextLine();
							} else if (pos==0){
								error = true;
								System.out.println("|Error|, ingrese un número mayor a 0");
								s.nextLine();
							} else if ( pos > array.length) {
								error = true;
								System.out.println("|Error|, esa posición no existe");
								s.nextLine();
							}
						}
					}while(error);
					
					for(int i = 0; i < array.length; i++) {
						if((pos-1)==i) {
							System.out.println("El número de la posición "+pos+ " es= "+array[i]);
						}
					}
					break;
				
				case 2:
					
					do {
						error=false;
						System.out.println("Ingrese la posición a asignar:");
						try {
							pos = s.nextInt();
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
							if(pos<0) {
								error = true;
								System.out.println("|Error|, ingrese un número positivo");
								s.nextLine();
							} else if (pos==0){
								error = true;
								System.out.println("|Error|, ingrese un número mayor a 0");
								s.nextLine();
							} else if ( pos > array.length) {
								error = true;
								System.out.println("|Error|, esa posición no existe");
								s.nextLine();
							}
						}
					}while(error);
					
					
					for(int i = 0; i < array.length; i++) {
						if((pos-1)==i) {
							
							if(array[i]==0) {
								do {
									error=false;
									System.out.println("Ingrese un número para la posición:");
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
									if(!error) {
										if(array[i]==0) {
											error = true;
											System.out.println("|Error|, no se aceptan ceros");
											s.nextLine();
										}
									}
								}while(error);
								
								System.out.println("Número asignado");
								
								
							} else {
								System.out.println("El número de la posición "+pos+ " ya está asignado");
							}
						}
					}
					break;
					
				case 3:
					
					do {
						error=false;
						System.out.println("Ingrese la posición a modificar:");
						try {
							pos = s.nextInt();
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
							if(pos<0) {
								error = true;
								System.out.println("|Error|, ingrese un número positivo");
								s.nextLine();
							} else if (pos==0){
								error = true;
								System.out.println("|Error|, ingrese un número mayor a 0");
								s.nextLine();
							} else if ( pos > array.length) {
								error = true;
								System.out.println("|Error|, esa posición no existe");
								s.nextLine();
							}
						}
					}while(error);
					
					
					for(int i = 0; i < array.length; i++) {
						if((pos-1)==i) {
							
							if(array[i]==0) {
								
								System.out.println("No se puede modificar una posición sin asignar");
								
							} else {
								
								do {
									error=false;
									System.out.println("Ingrese un número para la posición:");
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
									if(!error) {
										if(array[i]==0) {
											error = true;
											System.out.println("|Error|, no se aceptan ceros");
											s.nextLine();
										}
									}
								}while(error);
								
								System.out.println("Número asignado");
								
								
							}
						}
					}
					break;
					
				case 4:
					
					do {
						error=false;
						System.out.println("Ingrese la posición a eliminar:");
						try {
							pos = s.nextInt();
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
							if(pos<0) {
								error = true;
								System.out.println("|Error|, ingrese un número positivo");
								s.nextLine();
							} else if (pos==0){
								error = true;
								System.out.println("|Error|, ingrese un número mayor a 0");
								s.nextLine();
							} else if ( pos > array.length) {
								error = true;
								System.out.println("|Error|, esa posición no existe");
								s.nextLine();
							}
						}
					}while(error);
					
					for(int i = 0; i < array.length; i++) {
						if((pos-1)==i) {
							array[i]=0;
						}
					}
					
					System.out.println("Número eliminado");
					
					break;
					
				case 5:
					error=true;
					System.out.println("Saliendo...");
					break;	
					
				default:
					System.out.println("Ingrese un número entre los disponibles");
					break;
			
			}
		}while(!error);
		
		s.close();
	}

}
