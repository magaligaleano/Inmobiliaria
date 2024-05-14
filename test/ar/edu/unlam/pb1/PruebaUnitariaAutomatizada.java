package ar.edu.unlam.pb1;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class PruebaUnitariaAutomatizada {

	@Test
	public void queSiTengoTresCasasDeCincuentaCienYSesentaMilElPrecioPromedioSeaSetenta() {
		//Preparacion de datos
		Inmobiliaria actual = new Inmobiliaria("InmobiliariaPiola", "Av. Don Bosco", "inmobiliariapiola@gmail.com", 4678910);
		Casa casa1 = new Casa("Alberdi",640, "Haedo", 50000.0, true, TipoDeOperacion.VENTA);
		Casa casa2 = new Casa("Gaona",500, "Ramos", 100000.0, true, TipoDeOperacion.VENTA);
		Casa casa3 = new Casa("Peron",100, "San Justo", 60000.0, true, TipoDeOperacion.VENTA);
        //Ejecucion
		actual.agregarCasa(casa1);
		actual.agregarCasa(casa2);
		actual.agregarCasa(casa3);
		//Validacion
		assertEquals(70000.0, actual.calcularPromedioPrecioDeLasCasas(), 0.01);
	}
	@Test
	public void queSiNoTengoCasasElPromedioSeaCero() {
		//Preparacion de datos
				Inmobiliaria actual = new Inmobiliaria("InmobiliariaPiola", "Av. Don Bosco", "inmobiliariapiola@gmail.com", 4678910);
				
		//Ejecucion
				
	    //Validacion
		assertEquals(0.0, actual.calcularPromedioPrecioDeLasCasas(), 0.01);
	}
	
	
	
	//punto a
	@Test
	public void queSePuedaDarDeAltaUnaCasaEnLaInmobiliaria () {
		//Preparacion de datos
		Inmobiliaria actual = new Inmobiliaria("InmobiliariaPiola", "Av. Don Bosco", "inmobiliariapiola@gmail.com", 4678910);
		Casa casa = new Casa("Alberdi",640, "Haedo", 50000.0, true, TipoDeOperacion.VENTA);
		Boolean resultadoEsperado = true;
		//Ejecucion
		Boolean resultadoObtenido = actual.agregarCasa(casa);
		//Validacion
		assertEquals(resultadoEsperado, resultadoObtenido);
	}

	//punto b
	@Test
	public void queSePuedaDarDeAltaDosCasaEnLaInmobiliaria () {
		//Preparacion de datos
		Inmobiliaria actual = new Inmobiliaria("InmobiliariaPiola", "Av. Don Bosco", "inmobiliariapiola@gmail.com", 4678910);
		Casa casa1 = new Casa("Alberdi",640, "Haedo", 50000.0, true, TipoDeOperacion.VENTA);
		Casa casa2 = new Casa("Gaona",500, "Ramos", 100000.0, true, TipoDeOperacion.VENTA);
		Boolean resultadoEsperado = true;
		//Ejecucion
		Boolean resultadoObtenido1 = actual.agregarCasa(casa1);
		Boolean resultadoObtenido2 = actual.agregarCasa(casa2);
		//Validacion
		assertEquals(resultadoEsperado, resultadoObtenido1);
		assertTrue(resultadoObtenido2);
	}
	//punto c
	@Test
	public void queNoSePuedanDarDeAltaDosCasasConUnaMismaDireccion  () {
		//Preparacion de datos
		Inmobiliaria actual = new Inmobiliaria("InmobiliariaPiola", "Av. Don Bosco", "inmobiliariapiola@gmail.com", 4678910);
		Casa casa1 = new Casa("Gaona",500, "Haedo", 50000.0, true, TipoDeOperacion.VENTA);
		Casa casa2 = new Casa("Gaona",500, "Haedo", 100000.0, true, TipoDeOperacion.VENTA);
		//Ejecucion
	    actual.agregarCasa(casa1);
		Boolean resultadoObtenido = actual.agregarCasa(casa2);
		//Validacion
		assertFalse(resultadoObtenido);
	}
	//punto d
	@Test
	public void queSePuedaDarDeAltaUnDepartamentoEnLaInmobiliaria () {
		//Preparacion de datos
		Inmobiliaria actual = new Inmobiliaria("InmobiliariaPiola", "Av. Don Bosco", "inmobiliariapiola@gmail.com", 4678910);
		Departamento depto = new Departamento("Alberdi",2, 8, "Haedo", true, 50000.0, TipoDeOperacion.VENTA);
		//Ejecucion
		Boolean resultadoObtenido = actual.agregarDepartamento(depto);
		//Validacion
		assertTrue(resultadoObtenido);
	}
	//punto e
	@Test
	public void queSePuedaDarDeAltaDosDepartamentoEnLaInmobiliaria () {
		//Preparacion de datos
		Inmobiliaria actual = new Inmobiliaria("InmobiliariaPiola", "Av. Don Bosco", "inmobiliariapiola@gmail.com", 4678910);
		Departamento depto1 = new Departamento("Alberdi",2, 8, "Haedo", true, 50000.0, TipoDeOperacion.VENTA);
		Departamento depto2 = new Departamento("Gaona",1, 5, "Ramos", true, 50000.0, TipoDeOperacion.VENTA);
        //Ejecucion
		Boolean resultadoObtenido = actual.agregarDepartamento(depto1);
		Boolean resultadoObtenido2 = actual.agregarDepartamento(depto2);
		//Validacion
		assertTrue(resultadoObtenido);
		assertTrue(resultadoObtenido2);
	}
	//punto f
	@Test
	public void queNoSePuedanDarDeAltaDosDepartamentosConUnaMismaDireccion  () {
		//Preparacion de datos
		Inmobiliaria actual = new Inmobiliaria("InmobiliariaPiola", "Av. Don Bosco", "inmobiliariapiola@gmail.com", 4678910);
		Departamento depto1 = new Departamento("Gaona",1, 8, "Haedo", true, 50000.0, TipoDeOperacion.VENTA);
		Departamento depto2 = new Departamento("Gaona",1, 8, "Haedo", true, 50000.0, TipoDeOperacion.VENTA);
        //Ejecucion
	    actual.agregarDepartamento(depto1);
		Boolean resultadoObtenido = actual.agregarDepartamento(depto2);
		//Validacion
		assertFalse(resultadoObtenido);
	}
	//punto g 
	@Test
	public void queSePuedaObtenerElValorPromedioDeLasCasas() {
		//Preparacion de datos
		Inmobiliaria actual = new Inmobiliaria("InmobiliariaPiola", "Av. Don Bosco", "inmobiliariapiola@gmail.com", 4678910);
		Casa casa1 = new Casa("Alberdi",640, "Haedo", 50000.0, true, TipoDeOperacion.VENTA);
		Casa casa2 = new Casa("Gaona",500, "Ramos", 100000.0, true, TipoDeOperacion.VENTA);
		Casa casa3 = new Casa("Peron",100, "San Justo", 60000.0, true, TipoDeOperacion.VENTA);
		//Ejecucion
		actual.agregarCasa(casa1);
		actual.agregarCasa(casa2);
		actual.agregarCasa(casa3);
		//Validacion
		assertEquals(70000.0, actual.calcularPromedioPrecioDeLasCasas(), 0.01);
	}
	//punto h
	@Test
	public void queSePuedaObtenerElValorPromedioDeLosDepartamentos() {
		//Preparacion de datos
		Inmobiliaria actual = new Inmobiliaria("InmobiliariaPiola", "Av. Don Bosco", "inmobiliariapiola@gmail.com", 4678910);
		Departamento depto1 = new Departamento("Alberdi",1, 8, "Haedo", true, 80000.0, TipoDeOperacion.VENTA);
		Departamento depto2 = new Departamento("Gaona",2, 6, "Ramos", true, 50000.0, TipoDeOperacion.VENTA);
		Departamento depto3 = new Departamento("Peron",3, 7, "San justo", true, 80000.0, TipoDeOperacion.VENTA);
		//Ejecucion
		actual.agregarDepartamento(depto1);
		actual.agregarDepartamento(depto2);
		actual.agregarDepartamento(depto3);
		//Validacion
		assertEquals(70000.0, actual.calcularPromedioPrecioDeLosDeptos(), 0.01);
	}
	
	//punto que agregue porque inicialmente no cree un array en esa busqueda, sino un string concatenado
	@Test 
	public void queSiBuscoUnaCasaPorRangoDePrecioLaEncuentre() {
		//Preparacion de datos
		Double precioMinimo = 0.0;
		Double precioMaximo = 60000.0;
	    Inmobiliaria actual = new Inmobiliaria("InmobiliariaPiola", "Av. Don Bosco", "inmobiliariapiola@gmail.com", 4678910);
		Casa casa1 = new Casa("Alberdi",640, "Haedo", 50000.0, true, TipoDeOperacion.VENTA);
		Casa casa2 = new Casa("Gaona",500, "Ramos", 100000.0, true, TipoDeOperacion.VENTA);
		Casa casa3 = new Casa("Peron",100, "San Justo", 60000.0, true, TipoDeOperacion.VENTA);
		 //Ejecucion
		actual.agregarCasa(casa1);
		actual.agregarCasa(casa2);
		actual.agregarCasa(casa3);
		String casasEncontradas = actual.rangoPreciosCasas(precioMinimo, precioMaximo);
		
		//Validacion
		assertEquals(casa1 + "\n" + casa3 + "\n", casasEncontradas);
	}
	//punto i
	@Test 
	public void queLaBusquedaPorRangoDePrecioDeMeArrojeUnArrayNoNuloSiAplicanResultados() {
		//Preparacion de datos
		Double precioMinimo = 0.0;
		Double precioMaximo = 60000.0;
	    Inmobiliaria actual = new Inmobiliaria("InmobiliariaPiola", "Av. Don Bosco", "inmobiliariapiola@gmail.com", 4678910);
		Casa casa1 = new Casa("Alberdi",640, "Haedo", 50000.0, true, TipoDeOperacion.VENTA);
		Casa casa2 = new Casa("Gaona",500, "Ramos", 100000.0, true, TipoDeOperacion.VENTA);
		Casa casa3 = new Casa("Peron",100, "San Justo", 60000.0, true, TipoDeOperacion.VENTA);
		 //Ejecucion
		actual.agregarCasa(casa1);
		actual.agregarCasa(casa2);
		actual.agregarCasa(casa3);
		ArrayList <Casa> casasEncontradas = actual.rangoPrecioCasasArray(precioMinimo, precioMaximo);
		
		assertNotNull(casasEncontradas);
	}
	//punto j, 
	@Test
	public void queLaBusquedaPorRangoDePrecioDeMeArrojeUnArrayNuloSiNoAplicanResultados() {
		//Preparacion de datos
		Double precioMinimo = 0.0;
		Double precioMaximo = 40000.0;

	    Inmobiliaria actual = new Inmobiliaria("InmobiliariaPiola", "Av. Don Bosco", "inmobiliariapiola@gmail.com", 4678910);
		Casa casa1 = new Casa("Alberdi",640, "Haedo", 50000.0, true, TipoDeOperacion.VENTA);
		Casa casa2 = new Casa("Gaona",500, "Ramos", 100000.0, true, TipoDeOperacion.VENTA);
		Casa casa3 = new Casa("Peron",100, "San Justo", 60000.0, true, TipoDeOperacion.VENTA);
		 //Ejecucion
		actual.agregarCasa(casa1);
		actual.agregarCasa(casa2);
		actual.agregarCasa(casa3);
		ArrayList <Casa> casasEncontradas = actual.rangoPrecioCasasArray(precioMinimo, precioMaximo);
		//Validacion
		assertNull(casasEncontradas);
	}
}
