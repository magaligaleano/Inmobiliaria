package ar.edu.unlam.pb1;

import java.util.ArrayList;
import java.util.Scanner;

public class InterfazInmobiliaria {
	
	private static Inmobiliaria actual = new Inmobiliaria("InmobiliariaPiola", "Av. Don Bosco", "inmobiliariapiola@gmail.com", 4678910);

	public static void main(String[] args) throws UmbralMinimoNoAlcanzadoException, SinResultadosException {
		
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
			System.out.println("9. Realizar la permuta de una propiedad");
			System.out.println("0. Salir");
		
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
			System.out.println("3. Venta");
			System.out.println("4. Alquiler");
			opcion6 = teclado.nextInt();

             switch(opcion6) {
             case 1: 
            	 buscarPorRangoDePrecios(teclado);
            	 break;
             case 2:
            	 buscarPorUbicacion(teclado);
            	 break;
             case 3:
            	 mostrarVentas(teclado);
            	 break;
             case 4:
            	 mostrarAlquileres(teclado);
             }
             break;
		case 7:
			venta(teclado);
			break;
			
		case 8:
			alquilar(teclado);
			break;
		case 9:
			permutar(teclado);
		case 0:
			System.out.println("Nos vemosss <3");
			break;
		}
		}while(opcionMenu!=0);
	}

	public static void agregarPropiedades(Scanner teclado) {
		Integer opcion = 0;
		 String calle = "";
	     Integer numero = 0;
	     String ciudad = "";
	     Double precio = 0.0;
	     Boolean estaDisponible = false;
	     String tipoLetra = "";
	     String nombre = "";
	     String nombrePropietario= "";
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
			if(estaDisponible){
				System.out.println("V----Venta\n"
						+ "A----Alquiler \n"
						+ "P----Permutar");
				tipoLetra = teclado.next().toUpperCase();
				if(tipoLetra.equals("A")) {
					tipo = TipoDeOperacion.ALQUILER;
				} else if(tipoLetra.equals("P")) {
					tipo = TipoDeOperacion.PERMUTA;
				}
			}
			System.out.println("Nombre de propietario:");
			nombrePropietario = teclado.next();
			Casa nueva = new Casa(calle, numero, ciudad, precio, estaDisponible, tipo, nombrePropietario);
			if(actual.agregarPropiedad(nueva)) {
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
			
			if(estaDisponible){
				System.out.println("V----Venta\n"
						+ "A----Alquiler \n"
						+ "P----Permutar");
				tipoLetra = teclado.next().toUpperCase();
				if(tipoLetra.equals("A")) {
					tipo = TipoDeOperacion.ALQUILER;
				} else if(tipoLetra.equals("P")) {
					tipo = TipoDeOperacion.PERMUTA;
				}
			}
			System.out.println("Nombre de propietario:");
			nombrePropietario = teclado.next();
           Departamento nuevo = new Departamento(calle, piso, nroDepto, ciudad,estaDisponible, precio, tipo, nombrePropietario);
           actual.agregarPropiedad(nuevo);
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
			if(estaDisponible){
				System.out.println("V----Venta\n"
						+ "A----Alquiler \n"
						+ "P----Permutar");
				tipoLetra = teclado.next().toUpperCase();
				if(tipoLetra.equals("A")) {
					tipo = TipoDeOperacion.ALQUILER;
				} else if(tipoLetra.equals("P")) {
					tipo = TipoDeOperacion.PERMUTA;
				}
			}
			System.out.println("Nombre de propietario:");
			nombrePropietario = teclado.next();
           PH phNuevo = new PH(nroUnidad, piso, cantidadDeAmbientes, precio, ciudad, estaDisponible, tipo, nombrePropietario);
           actual.agregarPropiedad(phNuevo);
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
			if(estaDisponible){
				System.out.println("V----Venta\n"
						+ "A----Alquiler \n"
						+ "P----Permutar");
				tipoLetra = teclado.next().toUpperCase();
				if(tipoLetra.equals("A")) {
					tipo = TipoDeOperacion.ALQUILER;
				} else if(tipoLetra.equals("P")) {
					tipo = TipoDeOperacion.PERMUTA;
				}
			}
			System.out.println("Nombre de propietario:");
			nombrePropietario = teclado.next();
			Terreno terrenoNuevo = new Terreno(ancho, largo, superficie, ciudad, precio , estaDisponible, tipo, nombrePropietario);
		    actual.agregarPropiedad(terrenoNuevo);
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
			if(estaDisponible){
				System.out.println("V----Venta\n"
						+ "A----Alquiler \n"
						+ "P----Permutar");
				tipoLetra = teclado.next().toUpperCase();
				if(tipoLetra.equals("A")) {
					tipo = TipoDeOperacion.ALQUILER;
				} else if(tipoLetra.equals("P")) {
					tipo = TipoDeOperacion.PERMUTA;
				}
			}
			System.out.println("Nombre de propietario:");
			nombrePropietario = teclado.next();
			Campo campoNuevo = new Campo(nombre, superficie, ciudad, precio, estaDisponible, tipo, nombrePropietario);
			actual.agregarPropiedad(campoNuevo);
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
	    String codigo ="";
	    String nombrePropietario = "";
	    Integer piso = 0;
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
			System.out.println(actual.mostrarPropiedadesCasas().toString());   
			System.out.println("Ingrese el codigo de la casa a modificar");
			codigo = teclado.next();
			Propiedad casaAModificar = actual.buscarCodigoPropiedad(codigo);
			if(casaAModificar!=null) {
				
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
				
				if(estaDisponible){
					System.out.println("V----Venta\n"
							+ "A----Alquiler \n"
							+ "P----Permutar");
					tipoLetra = teclado.next().toUpperCase();
					if(tipoLetra.equals("A")) {
						tipo = TipoDeOperacion.ALQUILER;
					} else if(tipoLetra.equals("P")) {
						tipo = TipoDeOperacion.PERMUTA;
					}
				}
				System.out.println("Nombre de propietario:");
				nombrePropietario = teclado.next();
				Casa casaActualizada = new Casa(calle, numero, ciudad, precio, estaDisponible, tipo, nombrePropietario);
				if(actual.modificarPropiedad(codigo, casaActualizada)) {
					System.out.println("Casa modificada correctamente");
				}
				
			}
			else {
				System.out.println("No se encontro la casa");
			}
			break;
		case 2:
			System.out.println(actual.mostrarPropiedadesDeptos());   
			System.out.println("Ingrese el codigo del depto a modificar");
			codigo = teclado.next();
			Propiedad deptoAModificar = actual.buscarCodigoPropiedad(codigo);
			if(deptoAModificar!=null) {
				
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
				
				if(estaDisponible){
					System.out.println("V----Venta\n"
							+ "A----Alquiler \n"
							+ "P----Permutar");
					tipoLetra = teclado.next().toUpperCase();
					if(tipoLetra.equals("A")) {
						tipo = TipoDeOperacion.ALQUILER;
					} else if(tipoLetra.equals("P")) {
						tipo = TipoDeOperacion.PERMUTA;
					}
				}
				System.out.println("Nombre de propietario:");
				nombrePropietario = teclado.next();
				Departamento deptoActualizado = new Departamento(calle, piso,numero, ciudad, estaDisponible, precio, tipo, nombrePropietario);
				if(actual.modificarPropiedad(codigo, deptoActualizado)) {
					System.out.println("Depto modificado correctamente");
				}
				
			}
			else {
				System.out.println("No se encontro el departamento");
			}
			break;
		case 3:
			System.out.println(actual.mostrarPropiedadesPhs());   
			System.out.println("Ingrese el codigo del PH a modificar");
			codigo = teclado.next();
			Propiedad phAModificar = actual.buscarCodigoPropiedad(codigo);
			if(phAModificar!=null) {
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
				if(estaDisponible){
					System.out.println("V----Venta\n"
							+ "A----Alquiler \n"
							+ "P----Permutar");
					tipoLetra = teclado.next().toUpperCase();
					if(tipoLetra.equals("A")) {
						tipo = TipoDeOperacion.ALQUILER;
					} else if(tipoLetra.equals("P")) {
						tipo = TipoDeOperacion.PERMUTA;
					}
				}
				System.out.println("Nombre de propietario:");
				nombrePropietario = teclado.next();
				PH phActualizado = new PH(nroUnidad, piso, cantidadDeAmbientes, precio, ciudad, estaDisponible, tipo, nombrePropietario);
				actual.modificarPropiedad(codigo, phActualizado);
			}
			break;
		case 4:
			System.out.println(actual.mostrarPropiedadesTerrenos());   
			System.out.println("Ingrese el codigo del Terreno a modificar");
			codigo = teclado.next();
			Propiedad aModificar = actual.buscarCodigoPropiedad(codigo);
			if(aModificar!=null) {
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
				if(estaDisponible){
					System.out.println("V----Venta\n"
							+ "A----Alquiler \n"
							+ "P----Permutar");
					tipoLetra = teclado.next().toUpperCase();
					if(tipoLetra.equals("A")) {
						tipo = TipoDeOperacion.ALQUILER;
					} else if(tipoLetra.equals("P")) {
						tipo = TipoDeOperacion.PERMUTA;
					}
				}
				System.out.println("Nombre de propietario:");
				nombrePropietario = teclado.next();
				Terreno terrenoActualizado = new Terreno(ancho, largo, superficie, ciudad, precio , estaDisponible, tipo, nombrePropietario);
				actual.modificarPropiedad(codigo, terrenoActualizado);
			}
			break;
		case 5:
			System.out.println(actual.mostrarPropiedadesCampos());   
			System.out.println("Ingrese el codigo del Campo a modificar");
			codigo = teclado.next();
			Propiedad campoAModificar = actual.buscarCodigoPropiedad(codigo);
			if(campoAModificar!=null) {
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
				if(estaDisponible){
					System.out.println("V----Venta\n"
							+ "A----Alquiler \n"
							+ "P----Permutar");
					tipoLetra = teclado.next().toUpperCase();
					if(tipoLetra.equals("A")) {
						tipo = TipoDeOperacion.ALQUILER;
					} else if(tipoLetra.equals("P")) {
						tipo = TipoDeOperacion.PERMUTA;
					}
				}
				System.out.println("Nombre de propietario:");
				nombrePropietario = teclado.next();
				Campo campoNuevo = new Campo(nombre, superficie, ciudad, precio, estaDisponible, tipo, nombrePropietario);
				actual.modificarPropiedad(codigo, campoNuevo);
			}
			break;
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
		System.out.println(actual.ordenarPropiedadesPorPrecio(actual.mostrarPropiedades()).toString());
		
		
	}
	private static void ordenadosPorUbicacion(Scanner teclado) {
		System.out.println(actual.ordenarPropiedadesPorUbicacion().toString());
		
	}
	private static void buscarPorRangoDePrecios(Scanner teclado) throws SinResultadosException {
		Double precioMaximo = 0.0;
		Double precioMinimo = 0.0;
		System.out.println("Precio maximo: ");
		precioMaximo = teclado.nextDouble();
		System.out.println("Precio minimo: ");
		precioMinimo = teclado.nextDouble();
		try {
			System.out.println(actual.buscarPorRangoDePrecio(precioMinimo, precioMaximo).toString()); 

		}catch(SinResultadosException e) {
			System.out.println(e.getMessage());
            System.out.println("Intente nuevamente.");
		}
		
	}
	private static void buscarPorUbicacion(Scanner teclado) {
		Integer opcion = 0;
		String ubicacionABuscar = "";
		System.out.println("Ingrese a la ubicacion: ");
		ubicacionABuscar = teclado.next();
		System.out.println(actual.buscarPorUbicacion(ubicacionABuscar).toString());
		
	}
	private static void venta(Scanner teclado) throws UmbralMinimoNoAlcanzadoException {
		Integer opcion = 0;
		String codigo;
		Integer dni;
		Propiedad propiedadVenta = null;
		System.out.println("Que tipo de propiedad desea vender? \n"
				+ "1. Casa\n"
				+ "2. Departamento\n"
				+ "3. PH\n"
				+ "4. Terreno\n"
				+ "5. Campo");
		opcion = teclado.nextInt();
		switch(opcion) {
		case 1:
				System.out.println(actual.mostrarPropiedadesCasas());
			
			break;
		case 2:
				System.out.println(actual.mostrarPropiedadesDeptos());
				
			break;
		case 3:
			
				System.out.println(actual.mostrarPropiedadesPhs());
				
			break;
		case 4:
			
				System.out.println(actual.mostrarPropiedadesTerrenos());
				
			break;
		case 5:
	
				System.out.println(actual.mostrarPropiedadesCampos());
				
			break;
			
	}
		do {
		System.out.println("Escriba el codigo de la propiedad: ");
		codigo =teclado.next();
		propiedadVenta =  actual.buscarCodigoPropiedad(codigo);
		if(propiedadVenta == null) {
			System.out.println("El codigo es incorrecto");
			
		}
		
	}while(propiedadVenta == null);
	if(propiedadVenta.estaDisponibleParaVenta()) { 
		System.out.println("Ingrese el dni del cliente");
		dni = teclado.nextInt();
		Cliente interesado = actual.buscarCliente(dni);
		if(interesado!= null) {
			Venta nueva = new Venta(propiedadVenta, interesado.getNombre()+ " "+interesado.getApellido());
			nueva.ejecutar();
			try {
				actual.agregarVenta(nueva);
				System.out.println("Propiedad vendida : \n"
						+ propiedadVenta.toString());
			}catch (UmbralMinimoNoAlcanzadoException e) {
                System.out.println(e.getMessage());
                System.out.println("Intente nuevamente.");
            }
				
			
		} else {
			System.out.println("el dni no esta registrado");
		}
	} else {
		System.out.println("La propiedad no esta disponible para la venta");
	}
	
	}
	private static void mostrarVentas(Scanner teclado) {
		if(actual.mostrarVentas()!=null) {
			System.out.println(actual.mostrarVentas().toString());
		} else {
			System.out.println("No hay ventas registradas");
		}
		
	}
	private static void alquilar(Scanner teclado) {
		Integer opcion = 0;
		String codigo;
		Integer dni;
		Propiedad propiedadAlquiler = null;
		System.out.println("Que tipo de propiedad desea alquilar? \n"
				+ "1. Casa\n"
				+ "2. Departamento\n"
				+ "3. PH\n"
				+ "4. Terreno\n"
				+ "5. Campo");
		opcion = teclado.nextInt();
		switch(opcion) {
		case 1:
			
				System.out.println(actual.mostrarPropiedadesCasas());
			
			break;
		case 2:
			
				System.out.println(actual.mostrarPropiedadesDeptos());
				
			break;
		case 3:
			
				System.out.println(actual.mostrarPropiedadesPhs());
				
			break;
		}
		do {
		System.out.println("Escriba el codigo de la propiedad: ");
		codigo =teclado.next();
		propiedadAlquiler =  actual.buscarCodigoPropiedad(codigo);
		if(propiedadAlquiler == null) {
			System.out.println("El codigo es incorrecto");
			
		}
		
	}while(propiedadAlquiler == null);
	if(propiedadAlquiler.estaDisponibleParaAlquiler()) {
		System.out.println("Ingrese el dni del cliente");
		dni = teclado.nextInt();
		Cliente interesado = actual.buscarCliente(dni);
		if(interesado!= null) {
			Alquiler nuevo = new Alquiler(propiedadAlquiler, interesado.getNombre()+ " "+interesado.getApellido());
			actual.agregarAlquiler(nuevo);
			System.out.println("Propiedad alquilada: \n"
					+ propiedadAlquiler.toString() +" Inquilino= "+nuevo.getNombreInquilino());
		} else {
			System.out.println("El dni no esta registrado");
		}
	} else {
		System.out.println("La propiedad no esta disponible para alquilar");
	}
}
	private static void mostrarAlquileres(Scanner teclado) {
		if(actual.mostrarAlquileres()!=null) {
			System.out.println(actual.mostrarAlquileres().toString());  
		} else {
			System.out.println("NO hay alquileres registrados");
		}
			
		
		}
	private static void permutar(Scanner teclado) {
		String propietarioA = null;
		String propietarioB = null;
		String codigoA = null;
		String codigoB = null;
		Propiedad propiedadA = null;
		Propiedad propiedadB = null;
		System.out.println("Ingrese el nombre del propietario A");
		propietarioA = teclado.next();
		ArrayList<Propiedad> propiedadesA = actual.getPropiedades(propietarioA);
		if(propiedadesA==null) {
			System.out.println("NO tiene ninguna propiedad a su nombre");
		} else {
			System.out.println("Usted es propietario de : "+ propiedadesA.toString());
			System.out.println("Ingrese el codigo de la propiedad a permutar");
			codigoA = teclado.next();
			propiedadA = actual.buscarCodigoPropiedad(codigoA);
			if(propiedadA==null) {
				System.out.println("Codigo incorrecto");
			} else if(propiedadA.estaDisponibleParaPermuta()) {
				System.out.println("La propiedad no esta disponible para permuta");
			} else {
				System.out.println("Ingrese el nombre del propietario B");
				propietarioB = teclado.next();
				ArrayList<Propiedad> propiedadesB = actual.getPropiedades(propietarioB);
				if(propiedadesB==null) {
					System.out.println("NO tiene ninguna propiedad a su nombre");
				} else {
					System.out.println("Usted es propietario de : "+ propiedadesB.toString());
					System.out.println("Ingrese el codigo de la propiedad a permutar");
					codigoB = teclado.next();
					propiedadB = actual.buscarCodigoPropiedad(codigoB);
					if(propiedadB==null) {
						System.out.println("Codigo incorrecto");
					}
					Permuta nueva = new Permuta(propiedadA, propiedadB);
					nueva.ejecutar();
					actual.agregarPermuta(nueva);
					System.out.println(nueva.toString());
					
			}
			
			
		}
			}
			
	}
	

}