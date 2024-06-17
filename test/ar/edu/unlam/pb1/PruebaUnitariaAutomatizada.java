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
	public void queSePuedaRealizarLaVentaDeUnaPropiedad() throws UmbralMinimoNoAlcanzadoException {
		//Preparacion de datos
		
	    Inmobiliaria actual = new Inmobiliaria("InmobiliariaPiola", "Av. Don Bosco", "inmobiliariapiola@gmail.com", 4678910);
		Casa casa = new Casa("Alberdi",640, "Haedo", 12000.0, true, TipoDeOperacion.VENTA, null);
		String propietario = "Alfredo";
		Venta nueva = new Venta(casa, propietario);
		 //Ejecucion
		actual.agregarPropiedad(casa);
		Boolean esperado = actual.agregarVenta(nueva);
	    
		//Validacion
		assertTrue(esperado);
		assertNotNull(actual.mostrarVentas());
	}


	//punto j
	@Test
	public void queSePuedaRealizarElAlquilerDeUnaPropiedad() {

	    Inmobiliaria actual = new Inmobiliaria("InmobiliariaPiola", "Av. Don Bosco", "inmobiliariapiola@gmail.com", 4678910);
		Casa casa = new Casa("Alberdi",640, "Haedo", 50000.0, true, TipoDeOperacion.ALQUILER, null);
		String nombreInquilino = "Raul";
		Alquiler nuevo = new Alquiler(casa, nombreInquilino);
		
		 //Ejecucion
		actual.agregarPropiedad(casa);
		actual.agregarAlquiler(nuevo);
		nuevo.ejecutar();
		
	    
		//Validacion
		assertEquals("Raul", casa.getNombreInquilino());
		assertNotNull(actual.mostrarAlquileres());
		assertEquals(1, actual.mostrarAlquileres().size());
	}
	//punto k
	@Test
	public void queSePuedaRealizarLaPermutaDeDosPropiedades() {
		 Inmobiliaria actual = new Inmobiliaria("InmobiliariaPiola", "Av. Don Bosco", "inmobiliariapiola@gmail.com", 4678910);
			Casa casa = new Casa("Alberdi",640, "Haedo", 50000.0, true, TipoDeOperacion.PERMUTA, null);
			Casa casa2 = new Casa("Gaona",500, "Ramos", 100000.0, true, TipoDeOperacion.PERMUTA, null);
            casa.setNombrePropietario("Juan");
            casa2.setNombrePropietario("Raul");
            
			
            actual.agregarPropiedad(casa);
            actual.agregarPropiedad(casa2);
			Permuta permuta = new Permuta(casa, casa2);
			permuta.ejecutar();
	
			
		    
			//Validacion
			assertTrue(actual.agregarPermuta(permuta));
			assertNotNull(actual.mostrarPermutas());
	}
	//punto l
	@Test
	public void queSePuedaRealizarLaBusquedaDeCasasPorRangoDePreciosYElResultadoEsteOrdenadoPorPrecio() throws SinResultadosException {
		Inmobiliaria actual = new Inmobiliaria("InmobiliariaPiola", "Av. Don Bosco", "inmobiliariapiola@gmail.com", 4678910);
		Casa casa = new Casa("Alberdi",640, "Haedo", 50000.0, true, TipoDeOperacion.PERMUTA, null);
		Casa casa2 = new Casa("Gaona",500, "Ramos", 100000.0, true, TipoDeOperacion.PERMUTA, null);
		Casa casa3 = new Casa("Donbosco",4675,"Moron", 160000.0, true, TipoDeOperacion.VENTA, null);
		ArrayList<Propiedad> propiedadesEncontradas = null;
		ArrayList<Propiedad> propiedadesOrdenadas = null;
		
		actual.agregarPropiedad(casa);
		actual.agregarPropiedad(casa2);
		actual.agregarPropiedad(casa3);

		propiedadesEncontradas = actual.buscarPorRangoDePrecio(60000.0, 180000.0);
		propiedadesOrdenadas = actual.ordenarPropiedadesPorPrecio(propiedadesEncontradas);
		
		
		assertEquals(casa2.getPrecio(), propiedadesOrdenadas.getFirst().getPrecio());
		assertEquals(casa3.getPrecio(), propiedadesOrdenadas.getLast().getPrecio());
		assertFalse(propiedadesEncontradas.contains(casa));
		
		
	}
	//punto m
	@Test
	public void queSePuedaRealizarLaBusquedaDeCasasPorUbicacionYElResultadoEsteOrdenadoPorUbicacion() {
		Inmobiliaria actual = new Inmobiliaria("InmobiliariaPiola", "Av. Don Bosco", "inmobiliariapiola@gmail.com", 4678910);
		Casa casa = new Casa("Alberdi",640, "Haedo", 50000.0, true, TipoDeOperacion.PERMUTA, null);
		Casa casa2 = new Casa("Gaona",500, "Ramos", 100000.0, true, TipoDeOperacion.PERMUTA, null);
		Casa casa3 = new Casa("Donbosco",4675,"Moron", 160000.0, true, TipoDeOperacion.VENTA, null);
		ArrayList<Propiedad> propiedadesEncontradas = null;
		ArrayList<Propiedad> propiedadesOrdenadas = null;
		String ubicacion = "Moron";
		
		
		actual.agregarPropiedad(casa);
		actual.agregarPropiedad(casa2);
		actual.agregarPropiedad(casa3);

		propiedadesEncontradas = actual.buscarPorUbicacion(ubicacion);
		propiedadesOrdenadas = actual.ordenarPropiedadesPorUbicacion();
		
		
		assertTrue(propiedadesEncontradas.contains(casa3));
		assertEquals(casa2.getCiudad(), propiedadesOrdenadas.getLast().getCiudad());
		assertFalse(propiedadesEncontradas.contains(casa));
		
		
	}
   //punto n
	@Test
	public void	queSePuedaRealizarLaBusquedaDeDepartamentosPorRangoDePreciosYElResultadoEsteOrdenadoPorPrecio() throws SinResultadosException {
		Inmobiliaria actual = new Inmobiliaria("InmobiliariaPiola", "Av. Don Bosco", "inmobiliariapiola@gmail.com", 4678910);
		Departamento depto1 = new Departamento("Alberdi",1, 8, "Haedo", true, 80000.0, TipoDeOperacion.VENTA, null);
		Departamento depto2 = new Departamento("Gaona",2, 6, "Ramos", true, 50000.0, TipoDeOperacion.VENTA, null);
		Departamento depto3 = new Departamento("Peron",3, 7, "San justo", true, 180000.0, TipoDeOperacion.VENTA, null);
		ArrayList<Propiedad> propiedadesEncontradas = null;
		ArrayList<Propiedad> propiedadesOrdenadas = null;
		
		actual.agregarPropiedad(depto1);
		actual.agregarPropiedad(depto2);
		actual.agregarPropiedad(depto3);

		propiedadesEncontradas = actual.buscarPorRangoDePrecio(80000.0, 180000.0);
		propiedadesOrdenadas = actual.ordenarPropiedadesPorPrecio(propiedadesEncontradas);
		
		
		assertEquals(depto1.getPrecio(), propiedadesOrdenadas.getFirst().getPrecio());
		assertEquals(depto3.getPrecio(), propiedadesOrdenadas.getLast().getPrecio());
		assertFalse(propiedadesEncontradas.contains(depto2));
		
		
	}
	//punto o
	@Test
	public void queSePuedaRealizarLaBusquedaDeDepartamentosPorUbicacionYElResultadoEsteOrdenadoPorUbicacion() {
		Inmobiliaria actual = new Inmobiliaria("InmobiliariaPiola", "Av. Don Bosco", "inmobiliariapiola@gmail.com", 4678910);
		Departamento depto1 = new Departamento("Alberdi",1, 8, "Haedo", true, 80000.0, TipoDeOperacion.VENTA, null);
		Departamento depto2 = new Departamento("Gaona",2, 6, "Ramos", true, 50000.0, TipoDeOperacion.VENTA, null);
		Departamento depto3 = new Departamento("Peron",3, 7, "San justo", true, 180000.0, TipoDeOperacion.VENTA, null);
		ArrayList<Propiedad> propiedadesEncontradas = null;
		ArrayList<Propiedad> propiedadesOrdenadas = null;
		String ubicacion = "Ramos";
		
		
		actual.agregarPropiedad(depto1);
		actual.agregarPropiedad(depto2);
		actual.agregarPropiedad(depto3);

		propiedadesEncontradas = actual.buscarPorUbicacion(ubicacion);
		propiedadesOrdenadas = actual.ordenarPropiedadesPorUbicacion();
		
		
		assertTrue(propiedadesEncontradas.contains(depto2));
		assertEquals(depto3.getCiudad(), propiedadesOrdenadas.getLast().getCiudad());
		assertFalse(propiedadesEncontradas.contains(depto1));
		
		
	}
	//punto p
	@Test(expected = SinResultadosException.class)
    public void queAlBuscarPorUnCriterioQueNoArrojeResultadosSeProduzcaLaExcepcionSinResultadosException() throws SinResultadosException {
		Inmobiliaria actual = new Inmobiliaria("InmobiliariaPiola", "Av. Don Bosco", "inmobiliariapiola@gmail.com", 4678910);
		Departamento depto1 = new Departamento("Alberdi",1, 8, "Haedo", true, 10000.0, TipoDeOperacion.VENTA, null);
		Departamento depto2 = new Departamento("Gaona",2, 6, "Ramos", true, 12000.0, TipoDeOperacion.VENTA, null);
		ArrayList<Propiedad> propiedadesEncontradas = null;
		actual.agregarPropiedad(depto1);
		actual.agregarPropiedad(depto2);
		propiedadesEncontradas = actual.buscarPorRangoDePrecio(1300.0, 8500.0);
	}
	//punto q
	@Test(expected = UmbralMinimoNoAlcanzadoException.class)
    public void queAlIntentarGuardarUnaPropiedadParaLaVentaCuyoImporteEstaPorDebajoDelUmbral10000SeArrojeLaExcepcionUmbralMinimoNoAlcanzadoException() throws UmbralMinimoNoAlcanzadoException {
		Inmobiliaria actual = new Inmobiliaria("InmobiliariaPiola", "Av. Don Bosco", "inmobiliariapiola@gmail.com", 4678910);
		Departamento depto1 = new Departamento("Alberdi",1, 8, "Haedo", true, 9000.0, TipoDeOperacion.VENTA, null);
		Departamento depto2 = new Departamento("Gaona",2, 6, "Ramos", true, 12000.0, TipoDeOperacion.VENTA, null);
		String propietario = "Alfredo";
		actual.agregarPropiedad(depto1);
		actual.agregarPropiedad(depto2);
		Venta nueva = new Venta(depto1, propietario);
		actual.agregarVenta(nueva);
		
	}
	
	
}
