package frances.java.web.service.inf;

import frances.java.web.service.ServicioException;


public interface GenericoServicio<T> {

	    public boolean insertar(T t) throws ServicioException;

}
