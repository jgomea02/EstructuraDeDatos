package unileon.es.proii.main;

import java.util.Scanner;

public class ejercicio1Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc1 = new Scanner(System.in);
		int elementos;

		elementos = sc1.nextInt();
		int[] array = new int[elementos];
		int count = 0;

		crearVector(count, array, sc1);
		sc1.close();

		int minimum = array[0];
		int maximum = array[0];
		int min = comprobarMinimo(array, count, minimum);
		// System.out.println(min);
		int max = comprobarMaximo(array, count, maximum);
		// System.out.println(max);

		int minresult = min + 1;
		int maxresult = max - 1;
		checkMin(minresult, array, count, max);
		checkMax(maxresult, array, count, min);
	}

	private static void checkMax(int maxresult, int[] array, int count, int min) {
		// TODO Auto-generated method stub
		if (count < array.length) {
			if (maxresult == array[count]) {
				if (maxresult > min) {
					maxresult--;
					count = 0;
					checkMax(maxresult, array, count, min);
				} else {
					System.out.print("Sucesión completa");
				}

			} else {
				count++;
				checkMax(maxresult, array, count, min);
			}
		} else {
			System.out.println(maxresult);

		}
	}

	private static void checkMin(int minresult, int[] array, int count, int max) {
		// TODO Auto-generated method stub
		if (count < array.length) {
			if (minresult == array[count]) {
				if (minresult < max) {
					minresult++;
					count = 0;
					checkMin(minresult, array, count, max);
				}
			} else {
				count++;
				checkMin(minresult, array, count, max);
			}
		} else {
			System.out.print(minresult + " ");

		}

	}

	private static int comprobarMaximo(int[] array, int count, int maximum) {
		// TODO Auto-generated method stub
		if (maximum < array[count]) {
			maximum = array[count];
		}
		if (count < array.length - 1) {
			count++;
			return comprobarMaximo(array, count, maximum);
		}
		return maximum;
	}

	private static int comprobarMinimo(int[] array, int count, int minimum) {
		// TODO Auto-generated method stub
		if (minimum > array[count]) {
			minimum = array[count];
		}
		if (count < array.length - 1) {
			count++;
			return comprobarMinimo(array, count, minimum);
		}
		return minimum;
	}

	private static void crearVector(int count, int[] array, Scanner sc1) {
		// TODO Auto-generated method stub
		if (count != array.length) {
			int elemento = sc1.nextInt();
			array[count] = elemento;
			count++;
			crearVector(count, array, sc1);
		}
	}

}
