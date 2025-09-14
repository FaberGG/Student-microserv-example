package co.unicauca.apireststudent.services;

import java.util.List;

public interface BaseService<E> {
    public List<E> findAll() throws Exception;
    public E create(E entity) throws Exception;
    public E update(Long id, E entity) throws Exception;
    public E findById(Long id) throws Exception;
    public boolean delete(Long id) throws Exception;
}
