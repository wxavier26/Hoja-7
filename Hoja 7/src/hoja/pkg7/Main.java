/*Algoritmos y Esctructuras de Datos
 *BinaryHeap
 *Xavier Cifuentes -13316 
 *Pablo de leon - 13227
 */

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Controller ArbolBinario;
		
		Scanner teclado = new Scanner(System.in);
		System.out.println("Ingrese Palabra Para crear el Codigo...");
		String PALABRA = teclado.nextLine();
		
		ArbolBinario = new Controller(PALABRA);
		
		int opcion =0;
		
		do{
			System.out.println("El listado de letras con su codigo es: \n");
			ArbolBinario.PrintLetters();
			System.out.println("�Que desea Realizar?");
			System.out.println("1. Decodificar mensaje");
			System.out.println("2. Salir");
			
			opcion = teclado.nextInt();
			teclado.nextLine();
			
			if (opcion == 1){
				System.out.println("ingrese la palabra en codigo: \n");
				System.out.println("El codigo decodificado es: " + ArbolBinario.decodeMessage(teclado.nextLine()));
			}
			
		}while (opcion != 2);
				
		System.out.println("Ha Salido del Programa");
				
		teclado.close();
		
	}

}
