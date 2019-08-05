package test.models.entities;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


/**
 * The persistent class for the tbl_d_venta database table.
 * 
 */
@Entity
@Table(name="tbl_d_venta")
@NamedQuery(name="DVenta.findAll", query="SELECT t FROM DVenta t")
public class DVenta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private int cantidad;

	private double subtotal;

	//bi-directional many-to-one association to TblArticulo
	@ManyToOne
	@JoinColumn(name="articulo_id")
//	@JsonIgnore
	private Articulo Articulo;

	//bi-directional many-to-one association to TblMVenta
	@ManyToOne
	@JoinColumn(name="m_venta_id")
	private MVenta MVenta;

	public DVenta() {
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

//	public Articulo getTblArticulo() {
//		return this.Articulo;
//	}
//
//	public void setTblArticulo(Articulo tblArticulo) {
//		this.Articulo = tblArticulo;
//	}

//	public MVenta getTblMVenta() {
//		return this.MVenta;
//	}
//
//	public void setTblMVenta(MVenta tblMVenta) {
//		this.MVenta = tblMVenta;
//	}

}