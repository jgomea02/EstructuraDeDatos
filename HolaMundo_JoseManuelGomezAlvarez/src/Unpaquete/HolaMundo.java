package Unpaquete;

import java.util.Scanner;

/**
 * Primer programa de entrega para VPL
 * 
 * @author jose
 *
 */
public class HolaMundo {

	/**
	 * Método para la ejecucion de HolaMundo.
	 * 
	 * Lee de la entrada estandar un nombre y envia un saludo a la salida estandar.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc1 = new Scanner(System.in);
		
		extracted(sc1);
	}

	private static void extracted(Scanner sc1) {
		String nombre;
		System.out.println("Buenos dias, ¿Cuál es tu nombre?");
		nombre = sc1.nextLine();
		System.out.println("Hola " + nombre + ", Bienvenido a Programacion II y al mundo Java.");
	}

}
