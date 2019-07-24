package frances.java.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import frances.java.web.bean.CategoriaBean;
import frances.java.web.rest.exception.CodigoException;
import frances.java.web.service.inf.CategoriaServicio;

@Controller
@RequestMapping("/CategoriaREST")
public class CategoriaREST extends SpringBeanAutowiringSupport {

	@Autowired
	private CategoriaServicio categoriaServicio;
	
	@RequestMapping(value = "/insertar",
	method = RequestMethod.POST,
	produces = "application/json; charset=utf-8")
	public @ResponseBody Object insertar(@RequestBody CategoriaBean categoriabean) {
		boolean sw = false;
		/* Validaciones
		CodigoException ce = this.validar(alumnoBean);
		if (ce != null) {
			return ce;
		}*/

		try {
			sw = this.getCategoriaServicio().insertar(categoriabean);
		} catch (Exception e) {
			e.printStackTrace();
			return new CodigoException("cus.code.500.1");
		}
		String ret = (sw) ? "cus.code.200.1" : "cus.code.500.1";
		return new CodigoException(ret);
	}

	public CategoriaServicio getCategoriaServicio() {
		return categoriaServicio;
	}

	public void setCategoriaServicio(CategoriaServicio categoriaServicio) {
		this.categoriaServicio = categoriaServicio;
	}
	
}
