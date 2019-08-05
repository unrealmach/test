package test.models.entities;

import java.io.Serializable;
import javax.persistence.*;

import test.resources.utils.JPADefines.TipoMovimientoEnum;

import java.sql.Timestamp;


/**
 * The persistent class for the tbl_kardex database table.
 * 
 */
@Entity
@Table(name="tbl_kardex")
@NamedQuery(name="Kardex.findAll", query="SELECT t FROM Kardex t")
public class Kardex implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private int cantidad;

	private String fecha;

	 @Enumerated(EnumType.STRING)
	 @Column(columnDefinition = "enum('ENTRADA','SALIDA')")
	private TipoMovimientoEnum movimiento;

	private int saldo;

	//bi-directional many-to-one association to TblArticulo
//	@ManyToOne
//	@JoinColumn(name="articulo_id")
	private Articulo Articulo;

	
	public Kardex(int cantidad, String fecha, TipoMovimientoEnum movimiento, int saldo,
			test.models.entities.Articulo articulo) {
		super();
		this.cantidad = cantidad;
		this.fecha = fecha;
		this.movimiento = movimiento;
		this.saldo = saldo;
		Articulo = articulo;
	}

	public Kardex() {
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

	public String getFecha() {
		return this.fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public TipoMovimientoEnum getMovimiento() {
		return movimiento;
	}

public void setMovimiento(TipoMovimientoEnum movimiento) {
	this.movimiento = movimiento;
}
	public int getSaldo() {
		return this.saldo;
	}

	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}

//	public Articulo getTblArticulo() {
//		return this.Articulo;
//	}
//
//	public void setTblArticulo(Articulo tblArticulo) {
//		this.Articulo = tblArticulo;
//	}

}