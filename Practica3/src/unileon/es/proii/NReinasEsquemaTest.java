package unileon.es.proii;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;


import org.junit.After;

import org.junit.Before;

import org.junit.Test;


public class NReinasEsquemaTest {


private static InputStream in;
private static PrintStream out;

/**
* Este método se ejecuta antes de la ejecución de cada test.
* Permite almacenar los flujos que tiene la máquina java
* para la entrada y salida estándar
* @throws Exception
*/
@Before
public void realizaAntesDeCadaTest() throws Exception {

in = System.in;
out = System.out;

}

/**
* Este método se ejecuta después de cada test. Permite restaurar
* los flujos de entrada y salida estándar
* @throws Exception
*/
@After
public void realizaDespuésDeCadaTest() throws Exception {

System.setIn(in);
System.setOut(out);

}

@Test
public void testMain1() {

	/*
	//Cadenas que definen el test a realizar
	//Observar que hay un final de línea al final de la cadena
	String entradaTest = "java";
	String salidaEsperadaTest = "hola java\n"; 

	//Redirigimos la entrada estándar
	InputStream nuevo_in = new ByteArrayInputStream(entradaTest.getBytes());
	System.setIn(nuevo_in);
	 */

	//Salida Esperada	
	String salidaEsperadaTest = "(1,3,0,2)\n" + 
		"(2,0,3,1)\n";	
	
	//Redirigimos la salida estándar
	ByteArrayOutputStream salidaRealTest = new ByteArrayOutputStream();
	PrintStream nuevo_out = new PrintStream(salidaRealTest);
	System.setOut(nuevo_out);

	// Llamo a main con su argumento igual a un array de cadenas incluyendo el argumento necesario 

	String[] args = {"4"};	//Array de string de cadena 4
	NReinasEsquema.main(args);

	// El test tendrá éxito si la salida real es igual a la esperada
	assertEquals(salidaEsperadaTest,salidaRealTest.toString());


	}

	// Un segundo test se realiza fácilmente cambiando el valor
	// de las cadenas de entrada y esperadas
@Test
public void testMain2() {


	/*
	//Cadenas que definen el test a realizar
	//Observar que hay un final de línea al final de la cadena
	String entradaTest = "java";
	String salidaEsperadaTest = "hola java\n"; 

	//Redirigimos la entrada estándar
	InputStream nuevo_in = new ByteArrayInputStream(entradaTest.getBytes());
	System.setIn(nuevo_in);
	*/

	//Salida Esperada	
	String salidaEsperadaTest = "(1,3,5,0,2,4)\n" + 
			"(2,5,1,4,0,3)\n" + 
			"(3,0,4,1,5,2)\n" + 
			"(4,2,0,5,3,1)\n";	
		
	//Redirigimos la salida estándar
	ByteArrayOutputStream salidaRealTest = new ByteArrayOutputStream();
	PrintStream nuevo_out = new PrintStream(salidaRealTest);
	System.setOut(nuevo_out);

	// Llamo a main con su argumento igual a un array de cadenas incluyendo el argumento necesario 

	String[] args = {"6"};	//Array de string de cadena 6
	NReinasEsquema.main(args);

	// El test tendrá éxito si la salida real es igual a la esperada
	assertEquals(salidaEsperadaTest,salidaRealTest.toString());


	}

@Test
public void testMain3() {


	/*
	//Cadenas que definen el test a realizar
	//Observar que hay un final de línea al final de la cadena
	String entradaTest = "java";
	String salidaEsperadaTest = "hola java\n"; 

	//Redirigimos la entrada estándar
	InputStream nuevo_in = new ByteArrayInputStream(entradaTest.getBytes());
	System.setIn(nuevo_in);
	*/

	//Salida Esperada	
	String salidaEsperadaTest = "(0,4,7,5,2,6,1,3)\n" + 
			"(0,5,7,2,6,3,1,4)\n" + 
			"(0,6,3,5,7,1,4,2)\n" + 
			"(0,6,4,7,1,3,5,2)\n" + 
			"(1,3,5,7,2,0,6,4)\n" + 
			"(1,4,6,0,2,7,5,3)\n" + 
			"(1,4,6,3,0,7,5,2)\n" + 
			"(1,5,0,6,3,7,2,4)\n" + 
			"(1,5,7,2,0,3,6,4)\n" + 
			"(1,6,2,5,7,4,0,3)\n" + 
			"(1,6,4,7,0,3,5,2)\n" + 
			"(1,7,5,0,2,4,6,3)\n" + 
			"(2,0,6,4,7,1,3,5)\n" + 
			"(2,4,1,7,0,6,3,5)\n" + 
			"(2,4,1,7,5,3,6,0)\n" + 
			"(2,4,6,0,3,1,7,5)\n" + 
			"(2,4,7,3,0,6,1,5)\n" + 
			"(2,5,1,4,7,0,6,3)\n" + 
			"(2,5,1,6,0,3,7,4)\n" + 
			"(2,5,1,6,4,0,7,3)\n" + 
			"(2,5,3,0,7,4,6,1)\n" + 
			"(2,5,3,1,7,4,6,0)\n" + 
			"(2,5,7,0,3,6,4,1)\n" + 
			"(2,5,7,0,4,6,1,3)\n" + 
			"(2,5,7,1,3,0,6,4)\n" + 
			"(2,6,1,7,4,0,3,5)\n" + 
			"(2,6,1,7,5,3,0,4)\n" + 
			"(2,7,3,6,0,5,1,4)\n" + 
			"(3,0,4,7,1,6,2,5)\n" + 
			"(3,0,4,7,5,2,6,1)\n" + 
			"(3,1,4,7,5,0,2,6)\n" + 
			"(3,1,6,2,5,7,0,4)\n" + 
			"(3,1,6,2,5,7,4,0)\n" + 
			"(3,1,6,4,0,7,5,2)\n" + 
			"(3,1,7,4,6,0,2,5)\n" + 
			"(3,1,7,5,0,2,4,6)\n" + 
			"(3,5,0,4,1,7,2,6)\n" + 
			"(3,5,7,1,6,0,2,4)\n" + 
			"(3,5,7,2,0,6,4,1)\n" + 
			"(3,6,0,7,4,1,5,2)\n" + 
			"(3,6,2,7,1,4,0,5)\n" + 
			"(3,6,4,1,5,0,2,7)\n" + 
			"(3,6,4,2,0,5,7,1)\n" + 
			"(3,7,0,2,5,1,6,4)\n" + 
			"(3,7,0,4,6,1,5,2)\n" + 
			"(3,7,4,2,0,6,1,5)\n" + 
			"(4,0,3,5,7,1,6,2)\n" + 
			"(4,0,7,3,1,6,2,5)\n" + 
			"(4,0,7,5,2,6,1,3)\n" + 
			"(4,1,3,5,7,2,0,6)\n" + 
			"(4,1,3,6,2,7,5,0)\n" + 
			"(4,1,5,0,6,3,7,2)\n" + 
			"(4,1,7,0,3,6,2,5)\n" + 
			"(4,2,0,5,7,1,3,6)\n" + 
			"(4,2,0,6,1,7,5,3)\n" + 
			"(4,2,7,3,6,0,5,1)\n" + 
			"(4,6,0,2,7,5,3,1)\n" + 
			"(4,6,0,3,1,7,5,2)\n" + 
			"(4,6,1,3,7,0,2,5)\n" + 
			"(4,6,1,5,2,0,3,7)\n" + 
			"(4,6,1,5,2,0,7,3)\n" + 
			"(4,6,3,0,2,7,5,1)\n" + 
			"(4,7,3,0,2,5,1,6)\n" + 
			"(4,7,3,0,6,1,5,2)\n" + 
			"(5,0,4,1,7,2,6,3)\n" + 
			"(5,1,6,0,2,4,7,3)\n" + 
			"(5,1,6,0,3,7,4,2)\n" + 
			"(5,2,0,6,4,7,1,3)\n" + 
			"(5,2,0,7,3,1,6,4)\n" + 
			"(5,2,0,7,4,1,3,6)\n" + 
			"(5,2,4,6,0,3,1,7)\n" + 
			"(5,2,4,7,0,3,1,6)\n" + 
			"(5,2,6,1,3,7,0,4)\n" + 
			"(5,2,6,1,7,4,0,3)\n" + 
			"(5,2,6,3,0,7,1,4)\n" + 
			"(5,3,0,4,7,1,6,2)\n" + 
			"(5,3,1,7,4,6,0,2)\n" + 
			"(5,3,6,0,2,4,1,7)\n" + 
			"(5,3,6,0,7,1,4,2)\n" + 
			"(5,7,1,3,0,6,4,2)\n" + 
			"(6,0,2,7,5,3,1,4)\n" + 
			"(6,1,3,0,7,4,2,5)\n" + 
			"(6,1,5,2,0,3,7,4)\n" + 
			"(6,2,0,5,7,4,1,3)\n" + 
			"(6,2,7,1,4,0,5,3)\n" + 
			"(6,3,1,4,7,0,2,5)\n" + 
			"(6,3,1,7,5,0,2,4)\n" + 
			"(6,4,2,0,5,7,1,3)\n" + 
			"(7,1,3,0,6,4,2,5)\n" + 
			"(7,1,4,2,0,6,3,5)\n" + 
			"(7,2,0,5,1,4,6,3)\n" + 
			"(7,3,0,2,5,1,6,4)\n";	
		
	//Redirigimos la salida estándar
	ByteArrayOutputStream salidaRealTest = new ByteArrayOutputStream();
	PrintStream nuevo_out = new PrintStream(salidaRealTest);
	System.setOut(nuevo_out);

	// Llamo a main con su argumento igual a un array de cadenas incluyendo el argumento necesario 

	String[] args = {"8"};	//Array de string de cadena 8
	NReinasEsquema.main(args);

	// El test tendrá éxito si la salida real es igual a la esperada
	assertEquals(salidaEsperadaTest,salidaRealTest.toString());


	}

}