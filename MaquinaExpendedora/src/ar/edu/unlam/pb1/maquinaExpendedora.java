package ar.edu.unlam.pb1;

import java.util.Scanner;

public class maquinaExpendedora {

	private static final String maquinaExpendedora = null;
	private static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {

		// ingresar producto
		// mostrar lista de productos
		// ingresar dinero
		// elejir producto
		// retirar producto
		// reponer producto
		// consultar precio
		// mostrar saldo
		// dar vuelto
		// modificar productos

		Expendedora expendedora = crearMaquinaExpendedora();
		menuInicial(expendedora);
	}

	private static void menuInicial(Expendedora expendedora) {
		int opcion;
		System.out.println("MENU PRINCIPAL");
		do {
			System.out.println("elija 1 para ingresar como repositor");
			System.out.println("elija 2 para ingresar como consumidor");
			System.out.println("elija 0 para salir");
			opcion = teclado.nextInt();

			switch (opcion) {
			case 1:
				System.out.println("mostrar menu de repositor");
				menuRepositor(expendedora);
				break;
			case 2:
				System.out.println("mostrar menu de consumidor");
				menuConsumidor(expendedora);
				break;
			case 0:
				System.out.println("salir");
				break;
			default:
				System.out.println("opcion invalida");
				break;
			}
		} while (opcion != 0);

	}

	private static void menuConsumidor(Expendedora expendedora) {
		// menu consumidor
		// mostrar todos los productos, con id, nombre, precio
		// el consumidor elije el id del producto que quiere
		// el consumidor paga el producto, el monto tiene que ser igual o mayor, no se
		// da cambio
		// retira producto
		// vuelve al menu principal
		int opcion;
		System.out.println("MENU CONSUMIDOR");
		System.out.println("");
		do {
			System.out.println("elija 1 para ver los productos");
			System.out.println("elija 2 para seleccionar el producto");
			opcion = teclado.nextInt();

			switch (opcion) {
			case 1:
				mostrarProducto(expendedora.getProductos());
				break;
			case 2:
				pagarPorducto(expendedora);
				break;
			case 0:
				System.out.println("volver al menu anterior");
				break;
			default:
				System.out.println("opcion invalida");
				break;
			}
		} while (opcion != 0);
	}

	private static void pagarPorducto(Expendedora expendedora) {
		System.out.println("ingrese el id del producto que quiera comprar: ");
		int idProductoDeseado = teclado.nextInt();
		if (expendedora.pagarProducto(idProductoDeseado)) {
			System.out.println("Ingrese el dinero: ");
			double dineroIngresado = teclado.nextDouble();
			if (expendedora.dineroProducto(dineroIngresado)) {
				System.out.println("retire su producto");
			} else {
				System.out.println("dinero insuficiente");
			}
		} else {
			System.out.println("producto no ingresado");
		}
	}

	private static void menuRepositor(Expendedora expendedora) {
		int opcion;
		System.out.println("MENU REPOSITOR");
		do {
			System.out.println("elija 1 para agregar producto");
			System.out.println("elija 2 para modificar precio de un producto");
			System.out.println("elija 3 para quitar un producto");
			System.out.println("elija 4 para consultar un producto");
			System.out.println("elija 0 para volver al menu anterior");
			opcion = teclado.nextInt();

			switch (opcion) {
			case 1:
				agregarProducto(expendedora);
				break;
			case 2:
				modificarPrecio(expendedora);
				break;
			case 3:
				quitarProducto(expendedora);
				break;
			case 4:
				mostrarProducto(expendedora.getProductos());
				break;
			case 0:
				System.out.println("volver al menu anterior");
				break;
			default:
				System.out.println("opcion invalida");
				break;
			}
		} while (opcion != 0);
	}

	private static void modificarPrecio(Expendedora expendedora) {
		System.out.println("Ingresar el id del producto que desea modificarle el precio: ");
		int productoAModificar = teclado.nextInt();
		System.out.println("Ingresar el nuevo precio: ");
		double nuevoPrecio = teclado.nextDouble();
		if (expendedora.modificarPrecio(productoAModificar, nuevoPrecio)) {
			System.out.println("El precio se modifico correctamente");
		}
	}

	private static boolean mostrarProducto(Producto[] producto) {
		for (int i = 0; i < producto.length; i++) {
			if (producto[i] != null) {
				System.out.println(producto[i].toString());
			}
		}
		return false;
	}

	private static void quitarProducto(Expendedora expendedora) {
		System.out.println("Ingrese el id del producto que desea quitar");
		Integer id = teclado.nextInt();
		if (expendedora.quitarProducto(id) == true)
			System.out.println("el producto se quito correctamente");
		else
			System.out.println("el producto no se quito correctamente");
	}

	private static void agregarProducto(Expendedora expendedora) {
		System.out.println("ingrese nombre producto");
		String nombre = teclado.next();
		System.out.println("ingrese cantidad");
		Integer cantidad = teclado.nextInt();
		System.out.println("ingrese precio");
		Double precio = teclado.nextDouble();
		System.out.println("ingrese id");
		Integer id = teclado.nextInt();
		Producto producto = new Producto(nombre, cantidad, precio, id);
		if (expendedora.agregarProducto(producto))
			System.out.println("el producto se agrego correctamente" + producto.toString());
		else
			System.out.println("el producto no se agrego correctamente");
	}

	private static Expendedora crearMaquinaExpendedora() {
		System.out.println("Bienvenido a la maquina expendedora");
		System.out.println("Ingrese numero serie");
		Integer numeroSerie = teclado.nextInt();
		System.out.println("Ingrese cantidad de productos");
		Integer cantidadDeProdutos = teclado.nextInt();
		Expendedora expendedora = new Expendedora(numeroSerie, cantidadDeProdutos);
		return expendedora;
	}

	public static String getMaquinaexpendedora() {
		return maquinaExpendedora;
	}

}
