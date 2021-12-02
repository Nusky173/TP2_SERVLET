package dao;

import java.io.Serializable;
import java.util.List;

public interface IGenericDao<K, T extends Serializable> {

    /**
     *
     * @param id the id of the data object to find
     * @return T the data object of it has been found.
     */
    T findOne(final K id);

    /**
     *
     * @return a list of data object
     */
    List<T> findAll();

    /**
     *
     * @param entity persist an entity into the database
     */
    void save(final T entity);

    /**
     *
     * @param entity update fields of an entity
     * @return persist the updated entity into the database
     */
    T update(final T entity);

    /**
     *
     * @param entity delete the specified entity
     */
    void delete(final T entity);

    /**
     *
     * @param entityId find the entity with the id
     *                 delete the specific data object if exist
     */
    void deleteById(final K entityId);
}