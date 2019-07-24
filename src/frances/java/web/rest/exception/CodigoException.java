package frances.java.web.rest.exception;

import java.util.Date;

import frances.java.web.util.PropertiesUtil;

public class CodigoException {
	
	private String codigo;
	
	private String descripcion;
	
	private String fechaHora;
	
	private String retorno;

	public CodigoException() {
		super();
	}
	
	public CodigoException(String codigo) {
		String ret= PropertiesUtil.getKeyCode(codigo);
		String data[]=ret.split(":");
		System.out.println("data "+data);
		if (data.length>=2) {
			this.setCodigo(data[0]);
			this.setDescripcion(ret.substring(data[0].length()+1));
			this.setFechaHora(new Date().toString());
			this.setRetorno("");
		}
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(String fechaHora) {
		this.fechaHora = fechaHora;
	}

	public String getRetorno() {
		return retorno;
	}

	public void setRetorno(String retorno) {
		this.retorno = retorno;
	}

	@Override
	public String toString() {
		return "CodigoException [codigo=" + codigo + ", descripcion="
				+ descripcion + ", fechaHora=" + fechaHora + ", retorno="
				+ retorno + "]";
	}
	
}
