package ar.edu.unlam.pb1;

import java.util.Scanner;

public class InterfazInmobiliaria {
	
	private static Inmobiliaria actual = new Inmobiliaria("InmobiliariaPiola", "Av. Don Bosco", "inmobiliariapiola@gmail.com", 4678910);

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		Integer opcionMenu = 0;
		Integer opcion6 = 0;
		do {
			System.out.println("Menu de opciones");
			System.out.println("1. Agregar nuevas propiedades");
			System.out.println("2. Modificar propiedades existentes");
			System.out.println("3. Agregar clientes");
			System.out.println("4. Obtener listado de propiedades ordenado por precio");
			System.out.println("5. Obtener el listado de propiedades ordenado por ubicación");
			System.out.println("6. Buscar propiedades por diferentes parametros");
			System.out.println("7. Realizar la venta de una propiedad");
			System.out.println("8. Realizar el alquiler de una propiedad");
			System.out.println("9. Salir");
			
			opcionMenu = teclado.nextInt();
		
		
		
		switch(opcionMenu) {
		case 1:
			agregarPropiedades(teclado);
			break;
		case 2:
			modificarPropiedades(teclado);
			break;
		case 3:
			agregarCliente(teclado);
			break;
		case 4: 
			ordenadosPorPrecio(teclado);
			break;
		case 5:
			ordenadosPorUbicacion(teclado);
			break;
		case 6:
			System.out.println("1. Rango de precios");
			System.out.println("2. Ubicacion");
			opcion6 = teclado.nextInt();
			if(opcion6.equals(1)) {
				buscarPorRangoDePrecios(teclado);
			} else {
				buscarPorUbicacion(teclado);
			}
			break;
		}
		}while(opcionMenu!=9 || opcionMenu>9);
	}

	public static void agregarPropiedades(Scanner teclado) {
		Integer opcion = 0;
		 String calle = "";
	     Integer numero = 0;
	     String ciudad = "";
	     Double precio = 0.0;
	     Boolean estaDisponible;
	     String tipoLetra = "";
	     String nombre = "";
	     Integer piso = 0;
	 	Integer nroDepto = 0;
	 	Integer nroUnidad;
		Integer cantidadDeAmbientes = 0;
		Double ancho = 0.0;
		Double largo = 0.0;
		Double superficie = 0.0;
	 	
	     TipoDeOperacion tipo = TipoDeOperacion.VENTA;
		System.out.println("Que propiedad desea agregar? \n"
				+ "1. Casa\n"
				+ "2. Departamento\n"
				+ "3. PH\n"
				+ "4. Terreno\n"
				+ "5. Campo");
		opcion = teclado.nextInt();
		switch(opcion) {
		case 1:
			System.out.println("Calle: ");
			calle = teclado.next();
			System.out.println("Numero: ");
			numero = teclado.nextInt();
			System.out.println("Ciudad: ");
			ciudad = teclado.next();
			System.out.println("Precio: ");
			precio = teclado.nextDouble();
			System.out.println("Esta disponible?");
			estaDisponible = teclado.nextBoolean();
			teclado.nextLine();
			System.out.println("V----Venta\n"
					+ "A----Alquiler");
			tipoLetra = teclado.next().toUpperCase();
			if(tipoLetra.equals("A")) {
				tipo = TipoDeOperacion.ALQUILER;
			}
			Casa nueva = new Casa(calle, numero, ciudad, precio, estaDisponible, tipo);
			if(actual.agregarCasa(nueva)) {
				System.out.println("Casa agregada correctamente");
			} else {
				System.out.println("Hubo un error!");
			}
			break;
		
		case 2:
			System.out.println("Calle: ");
			calle = teclado.next();
			System.out.println("Piso: ");
			piso = teclado.nextInt();
			System.out.println("Numero depto:");
			nroDepto = teclado.nextInt();
			System.out.println("Ciudad: ");
			ciudad = teclado.next();
			System.out.println("Precio: ");
			precio = teclado.nextDouble();
			System.out.println("Esta disponible?");
			estaDisponible = teclado.nextBoolean();
			teclado.nextLine();
			System.out.println("V----Venta\n"
					+ "A----Alquiler");
			tipoLetra = teclado.next().toUpperCase();
			if(tipoLetra.equals("A")) {
				tipo = TipoDeOperacion.ALQUILER;
			}
           Departamento nuevo = new Departamento(calle, piso, nroDepto, ciudad,estaDisponible, precio, tipo);
           actual.agregarDepartamento(nuevo);
           break;
		case 3:
			System.out.println("Nro de unidad:");
			nroUnidad = teclado.nextInt();
			System.out.println("Piso:");
			piso = teclado.nextInt();
			System.out.println("Cantidad de ambientes: ");
			cantidadDeAmbientes = teclado.nextInt();
			System.out.println("Precio: ");
			precio = teclado.nextDouble();
			System.out.println("Ciudad: ");
			ciudad = teclado.next();
			System.out.println("Esta disponible?");
			estaDisponible = teclado.nextBoolean();
			teclado.nextLine();
			System.out.println("V----Venta\n"
					+ "A----Alquiler");
			tipoLetra = teclado.next().toUpperCase();
			if(tipoLetra.equals("A")) {
				tipo = TipoDeOperacion.ALQUILER;
			}
           PH phNuevo = new PH(nroUnidad, piso, cantidadDeAmbientes, precio, ciudad, estaDisponible, tipo);
           actual.agregarPH(phNuevo);
			break;
		case 4:
			System.out.println("Ancho: ");
			ancho = teclado.nextDouble();
			System.out.println("Largo: ");
			largo = teclado.nextDouble();
			System.out.println("Superficie: ");
			superficie = teclado.nextDouble();
			System.out.println("Precio: ");
			precio = teclado.nextDouble();
			System.out.println("Ciudad: ");
			ciudad = teclado.next();
			System.out.println("Esta disponible?");
			estaDisponible = teclado.nextBoolean();
			teclado.nextLine();
			System.out.println("V----Venta\n"
					+ "A----Alquiler");
			tipoLetra = teclado.next().toUpperCase();
			if(tipoLetra.equals("A")) {
				tipo = TipoDeOperacion.ALQUILER;
			}
			Terreno terrenoNuevo = new Terreno(ancho, largo, superficie, ciudad, precio , estaDisponible, tipo);
		    actual.agregarTerreno(terrenoNuevo);
		    break;
		case 5:
			System.out.println("Nombre: ");
			nombre = teclado.next();
			System.out.println("Superficie: ");
			superficie = teclado.nextDouble();
			System.out.println("Precio: ");
			precio = teclado.nextDouble();
			System.out.println("Ciudad: ");
			ciudad = teclado.next();
			System.out.println("Esta disponible?");
			estaDisponible = teclado.nextBoolean();
			teclado.nextLine();
			System.out.println("V----Venta\n"
					+ "A----Alquiler");
			tipoLetra = teclado.next().toUpperCase();
			if(tipoLetra.equals("A")) {
				tipo = TipoDeOperacion.ALQUILER;
			}
			Campo campoNuevo = new Campo(nombre, superficie, ciudad, precio, estaDisponible, tipo);
			actual.agregarCampo(campoNuevo);
			break;
		}
		
	}
	
	private static void modificarPropiedades(Scanner teclado) {
		Integer opcion = 0;
		 String calle = "";
	     Integer numero = 0;
	     String ciudad = "";
	     Double precio = 0.0;
	     Boolean estaDisponible;
	     String tipoLetra = "";
	     String nombre = "";
	     String codigo = teclado.next();
	     Integer piso = 0;
	 	Integer nroDepto = 0;
	 	Integer nroUnidad;
		Integer cantidadDeAmbientes = 0;
		Double ancho = 0.0;
		Double largo = 0.0;
		Double superficie = 0.0;
		TipoDeOperacion tipo = TipoDeOperacion.VENTA;
		System.out.println("Que tipo de propiedad desea modificar? \n"
				+ "1. Casa\n"
				+ "2. Departamento\n"
				+ "3. PH\n"
				+ "4. Terreno\n"
				+ "5. Campo");
		opcion = teclado.nextInt();
		switch(opcion) {
		case 1:
			System.out.println(actual.mostrarPropiedadesCasas());   
			System.out.println("Ingrese el codigo de la casa a modificar");
			codigo = teclado.next();
			Boolean casaAModificar = actual.buscarCodigoCasa(codigo);
			if(casaAModificar) {
				
				System.out.println("Nueva calle: ");
				calle = teclado.next();
				System.out.println("Nuevo numero:");
				numero = teclado.nextInt();
				System.out.println("Nueva ciudad: ");
				ciudad = teclado.next();
				System.out.println("Nuevo precio: ");
				precio = teclado.nextDouble();
				System.out.println("Esta disponible?");
				estaDisponible = teclado.nextBoolean();
				teclado.nextLine();
				
				System.out.println("V----Venta\n"
						+ "A----Alquiler");
				
				tipoLetra = teclado.next().toUpperCase();
				if(tipoLetra.equals("A")) {
					tipo = TipoDeOperacion.ALQUILER;
				}
				Casa casaActualizada = new Casa(calle, numero, ciudad, precio, estaDisponible, tipo);
				if(actual.modificarCasa(codigo, casaActualizada)) {
					System.out.println("Casa modificada correctamente");
				}
				
			}
			else {
				System.out.println("No se encontro la casa");
			}
		case 2:
			System.out.println(actual.mostrarPropiedadesDeptos());   
			System.out.println("Ingrese el codigo del depto a modificar");
			codigo = teclado.next();
			Boolean deptoAModificar = actual.buscarCodigoDepto(codigo);
			if(deptoAModificar) {
				
				System.out.println("Calle: ");
				calle = teclado.next();
				System.out.println("Piso:");
				piso = teclado.nextInt();
				System.out.println("Nro de depto");
				numero = teclado.nextInt();
				System.out.println("Ciudad: ");
				ciudad = teclado.next();
				System.out.println("Precio: ");
				precio = teclado.nextDouble();
				System.out.println("Esta disponible?");
				estaDisponible = teclado.nextBoolean();
				teclado.nextLine();
				
				System.out.println("V----Venta\n"
						+ "A----Alquiler");
				
				tipoLetra = teclado.next().toUpperCase();
				if(tipoLetra.equals("A")) {
					tipo = TipoDeOperacion.ALQUILER;
				}
				Departamento deptoActualizado = new Departamento(calle, piso,numero, ciudad, estaDisponible, precio, tipo);
				if(actual.modificarDepto(codigo, deptoActualizado)) {
					System.out.println("Depto modificado correctamente");
				}
				
			}
			else {
				System.out.println("No se encontro el departamento");
			}
			break;
		case 3:
			System.out.println(actual.mostrarPropiedadesPH());   
			System.out.println("Ingrese el codigo del PH a modificar");
			codigo = teclado.next();
			Boolean phAModificar = actual.buscarCodigoPH(codigo);
			if(phAModificar) {
				System.out.println("Nro de unidad:");
				nroUnidad = teclado.nextInt();
				System.out.println("Piso:");
				piso = teclado.nextInt();
				System.out.println("Cantidad de ambientes: ");
				cantidadDeAmbientes = teclado.nextInt();
				System.out.println("Precio: ");
				precio = teclado.nextDouble();
				System.out.println("Ciudad: ");
				ciudad = teclado.next();
				System.out.println("Esta disponible?");
				estaDisponible = teclado.nextBoolean();
				teclado.nextLine();
				System.out.println("V----Venta\n"
						+ "A----Alquiler");
				tipoLetra = teclado.next().toUpperCase();
				if(tipoLetra.equals("A")) {
					tipo = TipoDeOperacion.ALQUILER;
				}
				PH phActualizado = new PH(nroUnidad, piso, cantidadDeAmbientes, precio, ciudad, estaDisponible, tipo);
				actual.modificarPH(codigo, phActualizado);
			}
			
		}
	}
	
	private static void agregarCliente(Scanner teclado) {
		String nombre = "";
	 	String apellido = "";
	 	Integer dni = 0;
		System.out.println("Nombre:");
		nombre = teclado.next();
		System.out.println("Apellido");
		apellido = teclado.next();
		System.out.println("Dni: ");
		dni = teclado.nextInt();
		
		Cliente nuevo = new Cliente(nombre, apellido, dni);
		if(actual.agregarCliente(nuevo)) {
			System.out.println("Cliente agregado correctamente");
		}
		
		
	}
	
	private static void ordenadosPorPrecio(Scanner teclado) {
		Integer opcion = 0;
		System.out.println("Que tipo de propiedad desea ordenar? \n"
				+ "1. Casa\n"
				+ "2. Departamento\n"
				+ "3. PH\n"
				+ "4. Terreno\n"
				+ "5. Campo");
		opcion = teclado.nextInt();
		
		switch(opcion) {
		case 1: 
			actual.ordenarCasasPorPrecio();
			System.out.println(actual.mostrarPropiedadesCasas());
			break;
//		case 2:
//			actual.ordenarDeptosPorPrecio();
//			System.out.println(actual.mostrarPropiedadesDeptos());
//			break;
//		case 3:
//			actual.ordenarPHPorPrecio();
//			System.out.println(actual.mostrarPropiedadesPH());
//			break;
//		case 4:
//			actual.ordenarTerrenosPorPrecio();
//			System.out.println(actual.mostrarPropiedadesTerrenos());
//			break;
//		case 5:
//			actual.ordenarCamposPorPrecio();
//			System.out.println(actual.mostrarPropiedadesCampos());
//			break;
		}
		
		
	}
	private static void ordenadosPorUbicacion(Scanner teclado) {
		Integer opcion = 0;
		System.out.println("Que tipo de propiedad desea ordenar? \n"
				+ "1. Casa\n"
				+ "2. Departamento\n"
				+ "3. PH\n"
				+ "4. Terreno\n"
				+ "5. Campo");
		opcion = teclado.nextInt();
		
		switch(opcion) {
		case 1: 
//			actual.ordenarCasasPorUbicacion();
//			System.out.println(actual.mostrarPropiedadesCasas());
		}
	}
	private static void buscarPorRangoDePrecios(Scanner teclado) {
		Integer opcion = 0;
		Double precioMaximo = 0.0;
		Double precioMinimo = 0.0;
		System.out.println("Que tipo de propiedad desea buscar? \n"
				+ "1. Casa\n"
				+ "2. Departamento\n"
				+ "3. PH\n"
				+ "4. Terreno\n"
				+ "5. Campo");
		opcion = teclado.nextInt();
		System.out.println("Precio maximo: ");
		precioMaximo = teclado.nextDouble();
		System.out.println("Precio minimo: ");
		precioMinimo = teclado.nextDouble();
		switch(opcion) {
		case 1:
			System.out.println(actual.rangoPreciosCasas(precioMinimo, precioMaximo)); 
			break;
		case 2:
			System.out.println(actual.rangoPreciosDeptos(precioMinimo, precioMaximo));
			break;
		case 3:
			System.out.println(actual.rangoPreciosPH(precioMinimo, precioMaximo));
			break;
		case 4:
			System.out.println(actual.rangoPreciosTerrenos(precioMinimo, precioMaximo));
			break;
		case 5: 
			System.out.println(actual.rangoPrecioCampos(precioMinimo, precioMaximo));
			break;
		}
	}
	private static void buscarPorUbicacion(Scanner teclado) {
		Integer opcion = 0;
		String ubicacionABuscar = "";
		System.out.println("Que tipo de propiedad desea buscar? \n"
				+ "1. Casa\n"
				+ "2. Departamento\n"
				+ "3. PH\n"
				+ "4. Terreno\n"
				+ "5. Campo");
		opcion = teclado.nextInt();
		System.out.println("Ubicacion a buscar: ");
		ubicacionABuscar = teclado.next();
		
		switch(opcion) {
		case 1:
		    System.out.println(actual.ubicacionCasas(ubicacionABuscar));
		    break;
		case 2:
			System.out.println(actual.ubicacionDeptos(ubicacionABuscar));
			break;
		case 3:
			System.out.println(actual.ubicacionPH(ubicacionABuscar));
			break;
		case 4: 
			System.out.println(actual.ubicacionTerrenos(ubicacionABuscar));
			break;
		case 5:
			System.out.println(actual.ubicacionCampos(ubicacionABuscar));
			break;
		}
		
	}
}
