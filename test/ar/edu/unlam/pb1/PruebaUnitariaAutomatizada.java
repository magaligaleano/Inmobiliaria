package ar.edu.unlam.pb1;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class PruebaUnitariaAutomatizada {
	
	
	//punto a
	@Test
	public void queSePuedaDarDeAltaUnaCasaEnLaInmobiliaria () {
		//Preparacion de datos
		Inmobiliaria actual = new Inmobiliaria("InmobiliariaPiola", "Av. Don Bosco", "inmobiliariapiola@gmail.com", 4678910);
		Casa casa = new Casa("Alberdi",640, "Haedo", 50000.0, true, TipoDeOperacion.VENTA, null);
		Boolean resultadoEsperado = true;
		//Ejecucion
		Boolean resultadoObtenido = actual.agregarPropiedad(casa);
		//Validacion
		assertEquals(resultadoEsperado, resultadoObtenido);
	}

	//punto b
	@Test
	public void queSePuedaDarDeAltaDosCasaEnLaInmobiliaria () {
		//Preparacion de datos
		Inmobiliaria actual = new Inmobiliaria("InmobiliariaPiola", "Av. Don Bosco", "inmobiliariapiola@gmail.com", 4678910);
		Casa casa1 = new Casa("Alberdi",640, "Haedo", 50000.0, true, TipoDeOperacion.VENTA, null);
		Casa casa2 = new Casa("Gaona",500, "Ramos", 100000.0, true, TipoDeOperacion.VENTA, null);
		Boolean resultadoEsperado = true;
		//Ejecucion
		Boolean resultadoObtenido1 = actual.agregarPropiedad(casa1);
		Boolean resultadoObtenido2 = actual.agregarPropiedad(casa2);
		//Validacion
		assertEquals(resultadoEsperado, resultadoObtenido1);
		assertTrue(resultadoObtenido2);
	}
	//punto c
	@Test
	public void queSePuedaDarDeAltaUnDepartamentoEnLaInmobiliaria () {
		//Preparacion de datos
		Inmobiliaria actual = new Inmobiliaria("InmobiliariaPiola", "Av. Don Bosco", "inmobiliariapiola@gmail.com", 4678910);
		Departamento depto = new Departamento("Alberdi",2, 8, "Haedo", true, 50000.0, TipoDeOperacion.VENTA, null);
		//Ejecucion
		Boolean resultadoObtenido = actual.agregarPropiedad(depto);
		//Validacion
		assertTrue(resultadoObtenido);
	}
	//punto d
	@Test
	public void queSePuedaDarDeAltaDosDepartamentoEnLaInmobiliaria () {
		//Preparacion de datos
		Inmobiliaria actual = new Inmobiliaria("InmobiliariaPiola", "Av. Don Bosco", "inmobiliariapiola@gmail.com", 4678910);
		Departamento depto1 = new Departamento("Alberdi",2, 8, "Haedo", true, 50000.0, TipoDeOperacion.VENTA, null);
		Departamento depto2 = new Departamento("Gaona",1, 5, "Ramos", true, 50000.0, TipoDeOperacion.VENTA, null);
        //Ejecucion
		Boolean resultadoObtenido = actual.agregarPropiedad(depto1);
		Boolean resultadoObtenido2 = actual.agregarPropiedad(depto2);
		//Validacion
		assertTrue(resultadoObtenido);
		assertTrue(resultadoObtenido2);
	}

	//punto e
	@Test
	public void queSePuedaObtenerElValorPromedioDeLasCasas() {
		//Preparacion de datos
		Inmobiliaria actual = new Inmobiliaria("InmobiliariaPiola", "Av. Don Bosco", "inmobiliariapiola@gmail.com", 4678910);
		Casa casa1 = new Casa("Alberdi",640, "Haedo", 50000.0, true, TipoDeOperacion.VENTA, null);
		Casa casa2 = new Casa("Gaona",500, "Ramos", 100000.0, true, TipoDeOperacion.VENTA, null);
		Casa casa3 = new Casa("Peron",100, "San Justo", 60000.0, true, TipoDeOperacion.VENTA, null);
		//Ejecucion
		actual.agregarPropiedad(casa1);
		actual.agregarPropiedad(casa2);
		actual.agregarPropiedad(casa3);
		//Validacion
		assertEquals(70000.0, actual.calcularPromedioPrecioDeLasCasas(), 0.01);
	}
	//punto f
	@Test
	public void queSePuedaObtenerElValorPromedioDeLosDepartamentos() {
		//Preparacion de datos
		Inmobiliaria actual = new Inmobiliaria("InmobiliariaPiola", "Av. Don Bosco", "inmobiliariapiola@gmail.com", 4678910);
		Departamento depto1 = new Departamento("Alberdi",1, 8, "Haedo", true, 80000.0, TipoDeOperacion.VENTA, null);
		Departamento depto2 = new Departamento("Gaona",2, 6, "Ramos", true, 50000.0, TipoDeOperacion.VENTA, null);
		Departamento depto3 = new Departamento("Peron",3, 7, "San justo", true, 80000.0, TipoDeOperacion.VENTA, null);
		//Ejecucion
		actual.agregarPropiedad(depto1);
		actual.agregarPropiedad(depto2);
		actual.agregarPropiedad(depto3);
		//Validacion
		assertEquals(70000.0, actual.calcularPromedioPrecioDeLosDeptos(), 0.01);
	}
	
	//punto g
	
	@Test
	public void queSePuedaAgregarUnClienteALaInmobiliaria() {
		//Preparacion de datos
	    Inmobiliaria actual = new Inmobiliaria("InmobiliariaPiola", "Av. Don Bosco", "inmobiliariapiola@gmail.com", 4678910);
	    Cliente nuevo = new Cliente("Magui", "Galeano", 39927593);
	    //Ejecucion
	    
	    Boolean resultado = actual.agregarCliente(nuevo);
	    //Resultado
	    
	    assertTrue(resultado);

	}
	//punto h
	@Test
	public void queNoSePuedanAgregarDosClientesConUnMismoDni() {
		//Preparacion de datos
	    Inmobiliaria actual = new Inmobiliaria("InmobiliariaPiola", "Av. Don Bosco", "inmobiliariapiola@gmail.com", 4678910);
	    Cliente cliente = new Cliente("Magui", "Galeano", 39927593);
	    Cliente cliente2 = new Cliente("Facu", "Sanabria", 39927593);
	    //Ejecucion
	    actual.agregarCliente(cliente);
	    actual.agregarCliente(cliente2);
	    //Resultado
	    
	    assertEquals(1, actual.mostrarClientes().size());
	}
	//punto i
	@Test
	public void queSePuedaRealizarLaVentaDeUnaPropiedad() {
		//Preparacion de datos
		
	    Inmobiliaria actual = new Inmobiliaria("InmobiliariaPiola", "Av. Don Bosco", "inmobiliariapiola@gmail.com", 4678910);
		Casa casa = new Casa("Alberdi",640, "Haedo", 50000.0, true, TipoDeOperacion.VENTA, null);
		String propietario = "Alfredo";
		Venta nueva = new Venta(casa, propietario);
		 //Ejecucion
		actual.agregarPropiedad(casa);
		actual.agregarVenta(nueva);
	    
		//Validacion
		assertTrue(actual.agregarVenta(nueva));
		assertNotNull(actual.mostrarVentas());
	}


	//punto j
	@Test
	public void queSePuedaRealizarElAlquilerDeUnaPropiedad() {

	    Inmobiliaria actual = new Inmobiliaria("InmobiliariaPiola", "Av. Don Bosco", "inmobiliariapiola@gmail.com", 4678910);
		Casa casa = new Casa("Alberdi",640, "Haedo", 50000.0, true, TipoDeOperacion.VENTA, null);
		String nombreInquilino = "Raul";
		Alquiler nuevo = new Alquiler(casa, nombreInquilino);
		
		 //Ejecucion
		actual.agregarPropiedad(casa);
		actual.agregarAlquiler(nuevo);
		
	    
		//Validacion
		assertNotNull(actual.mostrarAlquileres());
	}
	
}
