package test.models.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;


/**
 * The persistent class for the tbl_m_compra database table.
 * 
 */
@Entity
@Table(name="tbl_m_compra")
@NamedQuery(name="MCompra.findAll", query="SELECT t FROM MCompra t")
public class MCompra implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(name="codigo_cliente")
	private String codigoCliente;

	private LocalDate fecha;

	private double total;

	//bi-directional many-to-one association to TblDCompra
	@OneToMany(mappedBy="MCompra", fetch=FetchType.EAGER)
	private List<DCompra> tblDCompras;

	public MCompra() {
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

	public List<DCompra> getTblDCompras() {
		return this.tblDCompras;
	}

	public void setTblDCompras(List<DCompra> tblDCompras) {
		this.tblDCompras = tblDCompras;
	}

	public DCompra addTblDCompra(DCompra tblDCompra) {
		getTblDCompras().add(tblDCompra);
		tblDCompra.setTblMCompra(this);

		return tblDCompra;
	}

	public DCompra removeTblDCompra(DCompra tblDCompra) {
		getTblDCompras().remove(tblDCompra);
		tblDCompra.setTblMCompra(null);

		return tblDCompra;
	}

}