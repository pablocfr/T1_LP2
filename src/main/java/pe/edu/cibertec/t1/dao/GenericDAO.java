package pe.edu.cibertec.t1.dao;

import java.util.List;

public interface GenericDAO<T, ID> {
	T buscarporID(ID id);
    List<T> obtenerTodos();
    void grabar(T entity);
    void actualizar(T entity);
    void eliminar(ID id);
}
