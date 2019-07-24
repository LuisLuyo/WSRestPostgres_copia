package frances.java.web.persistencia.impl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import frances.java.web.bean.CategoriaBean;
import frances.java.web.persistencia.inf.CategoriaBD;

@Transactional
@Repository("categoriaBD")
public class CategoriaBDImpl implements CategoriaBD {

	//@PersistenceContext 
	//private EntityManager em;
	
	@Autowired(required=true)
	public JdbcTemplate postgressqljdbctemplate;
	
	
	
	public JdbcTemplate getPostgressqljdbctemplate() {
		return postgressqljdbctemplate;
	}



	public void setPostgressqljdbctemplate(JdbcTemplate postgressqljdbctemplate) {
		this.postgressqljdbctemplate = postgressqljdbctemplate;
	}



	@Override
	public boolean insertar(CategoriaBean categoria) throws SQLException {
		try {
			
			
			/*StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("sigv_inventario.grabar_categoria");
			// IN
			spq.setParameter("_id_cbo_categoria", categoria.getIdcategoria());
			spq.setParameter("_cadena_categoria", categoria.getDescripcion());

			spq.execute();

			Object id = spq.getOutputParameterValue(1);
			if (id != null) {
				categoria.setIdcategoria(Long.valueOf(id.toString()));
			}
			em.close();*/

			
			final SimpleJdbcCall updateEmployeeCall = new SimpleJdbcCall(this.getPostgressqljdbctemplate()).withSchemaName("sigv_inventario").withFunctionName("grabar_categoria");
			final Map<String, Object> params = new HashMap<>();
			params.put("_id_cbo_categoria", null);
			params.put("_cadena_categoria", "John");
			//params.put("p_age", 28);
			//params.put("p_salary", 150000);

			final Map<String, Object> result = updateEmployeeCall.execute(params);
			System.out.println(result.get("returnvalue"));
			
			
			
			
			return true;
		} catch (Exception e) {
			throw new SQLException(e);
		}
	}
}
