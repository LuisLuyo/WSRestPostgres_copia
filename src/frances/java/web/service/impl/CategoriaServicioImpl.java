package frances.java.web.service.impl;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import frances.java.web.bean.CategoriaBean;
import frances.java.web.persistencia.inf.CategoriaBD;
import frances.java.web.service.ServicioException;
import frances.java.web.service.inf.CategoriaServicio;


@Service("categoriaServicio")
public class CategoriaServicioImpl implements CategoriaServicio{
	@Autowired
	private CategoriaBD categoriaBD;

	@Override
	public boolean insertar(CategoriaBean categoria) throws ServicioException {
		try {
			return this.getCategoriaBD().insertar(categoria);
		} catch (SQLException e) {
			throw new ServicioException(e);
		}
	}

	public CategoriaBD getCategoriaBD() {
		return categoriaBD;
	}

	public void setCategoriaBD(CategoriaBD categoriaBD) {
		this.categoriaBD = categoriaBD;
	}
	
}
