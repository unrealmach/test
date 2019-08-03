package test.models.entities;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;


/**
 * The persistent class for the tbl_d_compra database table.
 * 
 */
@Entity
@Table(name="tbl_d_compra")
@NamedQuery(name="DCompra.findAll", query="SELECT t FROM DCompra t")
public class DCompra implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private int cantidad;

	private double subtotal;

	//bi-directional many-to-one association to TblArticulo
	@ManyToOne
	@JoinColumn(name="articulo_id")
	@JsonBackReference
	private Articulo Articulo;

	//bi-directional many-to-one association to TblMCompra
	@ManyToOne
	@JoinColumn(name="m_compra_id")
//	@JsonBackReference
	private MCompra MCompra;

	public DCompra() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getSubtotal() {
		return this.subtotal;
	}

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}

	public Articulo getTblArticulo() {
		return this.Articulo;
	}

	public void setTblArticulo(Articulo tblArticulo) {
		this.Articulo = tblArticulo;
	}

	public MCompra getTblMCompra() {
		return this.MCompra;
	}

	public void setTblMCompra(MCompra tblMCompra) {
		this.MCompra = tblMCompra;
	}

}