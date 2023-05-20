package ar.edu.unlam.pb1;

public class Expendedora {

	private Integer numeroSerie;
	private Producto[] productos;

	public Expendedora(Integer numeroSerie, Integer cantidadDeProductos) {
		this.numeroSerie = numeroSerie;
		this.productos = new Producto[cantidadDeProductos];
	}

	public Integer getNumeroSerie() {
		return numeroSerie;
	}

	public void setNumeroSerie(Integer numeroSerie) {
		this.numeroSerie = numeroSerie;
	}

	public Producto[] getProductos() {
		return productos;
	}

	public void setProductos(Producto[] productos) {
		this.productos = productos;
	}

	public boolean agregarProducto(Producto producto) {

		for (int i = 0; i < productos.length; i++) {
			if (productos[i] == null) {
				productos[i] = producto;
				return true;
			}
		}
		return false;
	}

	public boolean quitarProducto(Integer id) {

		for (int i = 0; i < productos.length; i++) {
			if (productos[i] != null && id == productos[i].getId()) {
				productos[i] = null;
				return true;
			}
		}
		return false;
	}

	public static boolean mostrarProduto(Producto[] producto) {
		for (int i = 0; i < producto.length; i++) {
			System.out.println(producto[i].toString());
		}
		return false;
	}

	public boolean modificarPrecio(int idAModificar, double precioNuevo) {
		boolean precio = false;
		for (int i = 0; i < productos.length; i++) {
			if (productos[i].getId() == idAModificar) {
				productos[i].setPrecio(precioNuevo);
				precio = true;
			}
		}
		return precio;
	}

	public boolean pagarProducto(int idProductoDeseado) {
		// que pueda comprar si esta ingresado el producto y restarle la cantidad de
		// productos
		for (int i = 0; i < productos.length; i++) {
			int cantidad = (productos[i].getCantidad() - 1);
			if (productos[i] != null && productos[i].getId() == idProductoDeseado) {
				productos[i].setCantidad(cantidad);
				return true;
			}
		}
		return false;
	}

	public boolean dineroProducto(double dineroIngresado) {
		for (int i = 0; i < productos.length; i++) {
			if (dineroIngresado >= productos[i].getPrecio()) {
				System.out.println("Dinero devuelto: " + ((dineroIngresado - productos[i].getPrecio())));
				return true;
			} else {
				System.out.println("Dinero insuficiente");
			}
		}
		return false;
	}
}
