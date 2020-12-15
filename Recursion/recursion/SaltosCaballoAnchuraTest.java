package recursion;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;


import org.junit.After;

import org.junit.Before;

import org.junit.Test;


public class SaltosCaballoAnchuraTest {


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

	String entradaTest = "8 1 1 5 3\n";

	//Redirigimos la entrada estándar
	InputStream nuevo_in = new ByteArrayInputStream(entradaTest.getBytes());
	System.setIn(nuevo_in);
	 

	//Salida Esperada	
	String salidaEsperadaTest = "[[1, 1], [3,2], [5, 3]]\n";	
	
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

}
