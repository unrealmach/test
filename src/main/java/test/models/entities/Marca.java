package test.models.entities;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;


/**
 * The persistent class for the tbl_marcas database table.
 * 
 */
@Entity
@Table(name="tbl_marcas")
@NamedQuery(name="Marca.findAll", query="SELECT t FROM Marca t")
public class Marca implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String codigo;

	private String descripcion;

	//bi-directional many-to-one association to TblArticulo
//	@OneToMany(mappedBy="tblMarca", fetch=FetchType.LAZY)
//	@JsonIgnore
	private List<Articulo> tblArticulos;

	public Marca() {
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

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<Articulo> getTblArticulos() {
		return this.tblArticulos;
	}

	public void setTblArticulos(List<Articulo> tblArticulos) {
		this.tblArticulos = tblArticulos;
	}

	public Articulo addTblArticulo(Articulo tblArticulo) {
		getTblArticulos().add(tblArticulo);
		tblArticulo.setTblMarca(this);

		return tblArticulo;
	}

	public Articulo removeTblArticulo(Articulo tblArticulo) {
		getTblArticulos().remove(tblArticulo);
		tblArticulo.setTblMarca(null);

		return tblArticulo;
	}

}