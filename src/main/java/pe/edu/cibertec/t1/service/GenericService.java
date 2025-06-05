package pe.edu.cibertec.t1.service;

import java.util.List;

public interface GenericService<T, ID> {
	T BuscarID(ID id);
    List<T> ListarTodo();
    void Crear(T entity);
    void Modificar(T entity);
    void Eliminar(ID id);
}
