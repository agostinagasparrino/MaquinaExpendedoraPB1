package ar.edu.unlam.pb1;

public class Producto {

	private String nombre;
	private Integer cantidad;
	private Double precio;
	private Integer id;

	public Producto(String nombre, Integer cantidad, Double precio, Integer id) {

		this.nombre = nombre;
		this.cantidad = cantidad;
		this.precio = precio;
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Producto [nombre=" + nombre + ", cantidad=" + cantidad + ", precio=" + precio + ", id=" + id + "]";
	}

	public Producto(Integer id2) {

	}
}
