package test.models.entities;

import java.io.Serializable;
import javax.persistence.*;
//import org.codehaus.jackson.annotate.JsonIgnore;

import com.fasterxml.jackson.annotation.JsonIgnore;
//import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * The persistent class for the tbl_articulos database table.
 * 
 */
@Entity
@Table(name = "tbl_articulos")
@NamedQuery(name = "Articulo.findAll", query = "SELECT t FROM Articulo t")
public class Articulo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonIgnore
	private int id;

	private String codigo;

	private String nombre;

	@Column(name = "precio_compra")
	private double precioCompra;

	@Column(name = "precio_venta")
	private double precioVenta;

	private int stock;

	@OneToOne
	@JoinColumn(name = "categoria_id")
	@JsonIgnore 
	private Categoria tblCategoria;

	// bi-directional many-to-one association to TblDCompra
//	@OneToMany(mappedBy = "Articulo", fetch = FetchType.LAZY)
//	// @Fetch(value = FetchMode.SUBSELECT)
//	@JsonIgnore
//	private List<DCompra> tblDCompras;

//	// bi-directional many-to-one association to TblDVenta
//	@OneToMany(mappedBy = "Articulo", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<DVenta> tblDVentas;

	// bi-directional many-to-one association to TblKardex
//	@OneToMany(mappedBy = "Articulo", fetch = FetchType.LAZY)
//	@JsonIgnore
//	// @Fetch(value = FetchMode.SUBSELECT)
//	private List<Kardex> tblKardexs;

	// bi-directional many-to-one association to TblMarca
	@OneToOne
	@JoinColumn(name = "marca_id")
	@JsonIgnore
	private Marca tblMarca;

	public Articulo() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecioCompra() {
		return this.precioCompra;
	}

	public void setPrecioCompra(double precioCompra) {
		this.precioCompra = precioCompra;
	}

	public double getPrecioVenta() {
		return this.precioVenta;
	}

	public void setPrecioVenta(double precioVenta) {
		this.precioVenta = precioVenta;
	}

	public int getStock() {
		return this.stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public Categoria getTblCategoria() {
		return this.tblCategoria;
	}

	public void setTblCategoria(Categoria tblCategoria) {
		this.tblCategoria = tblCategoria;
	}

	public Marca getTblMarca() {
		return this.tblMarca;
	}

	public void setTblMarca(Marca tblMarca) {
		this.tblMarca = tblMarca;
	}

}