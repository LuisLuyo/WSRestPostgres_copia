package frances.java.web.persistencia.inf;

import java.sql.SQLException;
import java.util.List;

public interface GenericoBD<T> {
	
	    public boolean insertar(T t) throws SQLException;
	    
}
