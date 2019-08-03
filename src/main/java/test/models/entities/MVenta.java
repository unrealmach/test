package test.models.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;


/**
 * The persistent class for the tbl_m_venta database table.
 * 
 */
@Entity
@Table(name="tbl_m_venta")
@NamedQuery(name="MVenta.findAll", query="SELECT t FROM MVenta t")
public class MVenta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(name="codigo_cliente")
	private String codigoCliente;

	private LocalDate fecha;

	private double total;

	//bi-directional many-to-one association to TblDVenta
	@OneToMany(mappedBy="MVenta", fetch=FetchType.EAGER)
	private List<DVenta> tblDVentas;

	public MVenta() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCodigoCliente() {
		return this.codigoCliente;
	}

	public void setCodigoCliente(String codigoCliente) {
		this.codigoCliente = codigoCliente;
	}

	public LocalDate getFecha() {
		return this.fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public double getTotal() {
		return this.total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public List<DVenta> getTblDVentas() {
		return this.tblDVentas;
	}

	public void setTblDVentas(List<DVenta> tblDVentas) {
		this.tblDVentas = tblDVentas;
	}

	public DVenta addTblDVenta(DVenta tblDVenta) {
		getTblDVentas().add(tblDVenta);
		tblDVenta.setTblMVenta(this);

		return tblDVenta;
	}

	public DVenta removeTblDVenta(DVenta tblDVenta) {
		getTblDVentas().remove(tblDVenta);
		tblDVenta.setTblMVenta(null);

		return tblDVenta;
	}

}