package Prueba2;

import java.util.Scanner;

public class Examen {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String [][] nombresUsuariosFrecuente = {{"Pepe"},{"Juan"},{"Jhonny"},{"Cesar"},{"Sebas"},{"Kevin"},{"Oscar"},
				{"Javier"},{"Pedro"},{"Dennis"},{"Joel"},{"Augusto"},{"Humberto"},{"Leonel"},{"Cristiano"},{"Gareth"},{"Karim"},{"Antonio"}
				,{"Ivan"},{"Andres"}};
		String [][] nombresUsuariosIdentificador = {{"F-Pepe"},{"N-Juan"},{"F-Jhonny"},{"F-Cesar"},{"F-Sebas"},{"F-Kevin"},{"F-Oscar"},
				{"F-Javier"},{"F-Pedro"},{"F-Dennis"},{"F-Joel"},{"F-Augusto"},{"F-Humberto"},{"F-Leonel"},{"F-Cristiano"},{"F-Gareth"},{"F-Karim"},{"F-Antonio"}
				,{"F-Ivan"},{"F-Andres"}};

		String [][] dueñosRestaurante = {{"Jose"},{"Diego"},{"Asdrubal"},{"Elvis"},{"Josue"}};

		String [][] empleados = {{"Segundo","0.00"},{"Heriberto","0.00"},{"Estrada","0.00"},{"Pantoja","0.00"},{"Luis","0.00"},{"Benito","0.00"},{"Francisco","0.00"},
				{"Steven","0.00"},{"Matias","0.00"},{"Gabriel","0.00"},{"Bravo","0.00"},{"Shelvin","0.00"},{"Boris","0.00"},{"Joan","0.00"},{"Nicolas","0.00"}};

		String [][] empleadosSueldo = {{"Segundo","0.00"},{"Heriberto","0.00"},{"Estrada","0.00"},{"Pantoja","0.00"},{"Luis","0.00"},{"Benito","0.00"},{"Francisco","0.00"},
				{"Steven","0.00"},{"Matias","0.00"},{"Gabriel","0.00"},{"Bravo","0.00"},{"Shelvin","0.00"},{"Boris","0.00"},{"Joan","0.00"},{"Nicolas","0.00"}};

		String [][] proveedores = {{"Pablo"},{"Dorotheo"},{"Arias"},{"Armas"},{"Hector"},{"Panchi"},{"Marcelo"},{"Historia"},{"Reiner"},
				{"Eren"}};

		String [][] precioPlatos = {{"Plato 1","2.50"},{"Plato 2","2.30"},{"Plato 3","2.00"},{"Plato 4","2.25"},{"Plato 5","1.25"},
				{"Plato 6","1.00"},{"Plato 7","1.50"},{"Plato 8","3.00"},{"Plato 9",".75"},{"Plato 10","40.00"}};
		double [][] precioPlatosDouble = {{2.50},{2.30},{2.00},{2.25},{1.25},{1.00},{1.50},{3.00},{.75},{40.00}};

		System.out.println("======================================================================");
		System.out.println("BIENVENIDO AL ESTE ESTABLECIMIENTO DE COMIDA");
		System.out.println("EL MENÚ DE NUESTRO RESTAURANTE ES:");
		funcionImpresiónMatrizString(precioPlatos);
		System.out.println("======================================================================");

		// PARTE DE CLIENTES
		System.out.println("INGRESE EL NOMBRE DEL CLIENTE A ORDENAR");
		String nombreCliente = sc.nextLine();
		int valorCliente = funcionBuscarNombre(nombresUsuariosFrecuente, nombreCliente);
		if (valorCliente<0) {
			System.out.println("HEMOS DETERMINADO QUE NO ES UN CLIENTE FRECUENTE");
			char incialNombre = Character.toUpperCase(nombreCliente.charAt(0));
			nombreCliente = incialNombre+nombreCliente.toLowerCase().substring(1,nombreCliente.length());
			nombreCliente = "N-"+nombreCliente;


		}else {
			System.out.println("HEMOS DETERMINADO QUE ES UN CLIENTE FRECUENTE");
			char incialNombre = Character.toUpperCase(nombreCliente.charAt(0));
			nombreCliente = incialNombre+nombreCliente.toLowerCase().substring(1,nombreCliente.length());
			nombreCliente = "F-"+nombreCliente;
		}


		String reOrdenPlato = "";
		double cuenta = 0;
		do {
			System.out.println("======================================================================");
			System.out.println("SEÑOR "+ nombreCliente + " ¿QUÉ PLATO DE NUESTRO MENÚ DESEA ORDENAR? ESCRIBA SU RESPUESTA");
			String nombrePlato = sc.nextLine();
			int posicionPlato = funcionBuscarNombre(precioPlatos,nombrePlato);
			if (posicionPlato< 0) {
				System.err.println("PLATO NO ENCONTRADO");
			} else {
				System.out.println("PLATO ORDENADO CORRECTAMENTE");
				System.out.println("DISFRUTE SU PLATO");
				cuenta = cuenta +  Double.parseDouble(precioPlatos[posicionPlato][1]);
			}

			System.err.println("SU CUENTA SE ACTUALIZÓ A: "+ cuenta);
			System.out.println("¿DESEA ORDENAR ALGÚN OTRO PLATO? SI / NO");
			reOrdenPlato = sc.nextLine();
		} while (reOrdenPlato.toUpperCase().equals("SI"));

		if (cuenta > 30) {
			System.out.println("SE LE APLICARÁ UN DESCUENTO DEL 5%");
			int foN = funcionDeterminarClienteFoN(nombresUsuariosIdentificador, nombreCliente);
			if (foN >= 0) {
				System.out.println("SE LE APLICARÁ UN DESCUENTO ESPECIAL DEL 7.5% POR SER CLIENTE FRECUENTE");
				cuenta = cuenta * 0.925;
				System.out.println("EL VALOR TOTAL A PAGAR CON DESCUENTO DEL 7.5% ES: "+cuenta);	
			}else {
				cuenta = cuenta * 0.95;
				System.out.println("EL VALOR TOTAL A PAGAR CON DESCUENTO DEL 5% ES: "+cuenta);
			}

		} else {
			System.out.println("EL VALOR TOTAL A PAGAR ES: "+cuenta);
		}







		// PARTE DE EMPLEADOS
		String condiciónSueldosEmpleados = "";
		System.out.println("======================================================================");

		System.out.println("BIENVENIDO AL MENÚ DE EMPLEADOS");
		do {
			System.out.println("======================================================================");
			funcionImpresiónMatrizString(empleadosSueldo);
			System.out.println("======================================================================");

			System.out.println("INGRESE EL NOMBRE DEL EMPLEADO A PAGAR");
			String nombreEmpleado = sc.nextLine().toUpperCase();

			int posiciónEmpleado  = funcionBuscarNombre(empleadosSueldo,nombreEmpleado);
			if (posiciónEmpleado< 0) {
				System.out.println("======================================================================");

				System.err.println("EL EMPLEADO NO ESTÁ REGITRADO");
				System.out.println("NO SE APLICARÁN CAMBIOS");
			} else {
				System.out.println("======================================================================");
				System.err.println("EMPLEADO ENCONTRADO");
				System.out.println("¿CUANTAS HORAS TRABAJÓ?");
				int numeroDeHoras = Integer.parseInt(sc.nextLine());
				double salarioAumento = numeroDeHoras * 8.5;

				salarioAumento = salarioAumento +  Double.parseDouble(empleadosSueldo[posiciónEmpleado][1]);
				empleadosSueldo[posiciónEmpleado][1] = salarioAumento +"";

			}

			System.out.println("¿DESEA INGRESAR OTRO EMPLEADO? SI/NO");
			condiciónSueldosEmpleados = sc.nextLine();
		} while (condiciónSueldosEmpleados.toUpperCase().equals("SI"));

		System.out.println("EL TOTAL A PAGAR A LOS EMPLEADOS ES: ");
		funcionImpresiónMatrizString(empleadosSueldo);


		System.out.println("===================================================");
		System.out.println("LOS PLATILLOS ORDENADOS DE MAYOR A MENOR SON: ");
		funcionOrdenarMatriz(precioPlatosDouble);
		System.out.println("LOS NOMBRES ORDENADOR DE LA A - Z DE LOS DUEÑOS SON: ");

		System.out.println("===================================================");


	}

	public static void funcionOrdenarMatriz(double[][] matrizIngresada) {


		int valorFilas = matrizIngresada.length;
		for (int filas = 0; filas < valorFilas; filas++) {
			for (int columnas = 0; columnas < valorFilas - filas - 1; columnas++) {
				if (matrizIngresada[columnas][0] < matrizIngresada[columnas + 1][0]) {
					double [] pivoteDeOrdenamiento = matrizIngresada[columnas];
					matrizIngresada[columnas] = matrizIngresada[columnas + 1];
					matrizIngresada[columnas + 1] = pivoteDeOrdenamiento;

				}
			}
		}
		System.out.println("===================================================");
		System.out.println("LA MATRIZ DE PRECIOS ORDENADA DE MAYOR A MENOR ES:");
		funcionImpresiónMatrizDouble(matrizIngresada);


	}


	//









	//
	private static int funcionDeterminarClienteFoN(String[][] nombresUsuariosFrecuente, String nombreCliente) {
		int valorRetorno = -1;
		for(int filas = 0 ; filas < nombresUsuariosFrecuente.length; filas++) {
			if(nombresUsuariosFrecuente[filas][0].toLowerCase().equals(nombreCliente.toLowerCase())) {
				return filas; 
			}
		}
		return valorRetorno;
	}













	public static int funcionBuscarNombre(String[][] empleados, String nombreEmpleado) {

		int posMat = -1 ; 
		for(int filas = 0 ; filas < empleados.length; filas++) {
			if(empleados[filas][0].toLowerCase().equals(nombreEmpleado.toLowerCase())) {
				return filas; 
			}
		}
		return posMat;
	}






	public static void funcionImpresiónMatrizDouble(double[][] matrizIngresada) {

		for (int i = 0; i < matrizIngresada.length; i++) {
			for (int j = 0; j < matrizIngresada[0].length; j++) {
				System.out.print(matrizIngresada[i][j]+ " \t");
			}
			System.out.println();
		}

	}







	public static void funcionImpresiónMatrizString(String[][] matrizIngresada) {

		for (int i = 0; i < matrizIngresada.length; i++) {
			for (int j = 0; j < matrizIngresada[0].length; j++) {
				System.out.print(matrizIngresada[i][j]+ " \t \t");
			}
			System.out.println();
		}

	}
}