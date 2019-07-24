package frances.java.web.bean;

public class CategoriaBean {
    private long idcategoria;
    private String descripcion;
    private String estado;
    
    public CategoriaBean() {

	}
    
	public CategoriaBean(long idcategoria, String descripcion, String estado) {
		super();
		this.idcategoria = idcategoria;
		this.descripcion = descripcion;
		this.estado = estado;
	}
	public long getIdcategoria() {
		return idcategoria;
	}
	public void setIdcategoria(long idcategoria) {
		this.idcategoria = idcategoria;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	@Override
	public String toString() {
		return "Categoria {idcategoria=" + idcategoria + ", descripcion=" + descripcion + ", estado=" + estado
				+ "}";
	}
    
}
