package com.barracuda.p4j.dao;

import java.io.Serializable;
import java.util.List;

/**
 * Унифицированный интерфейс управления персистентным состоянием объектов
 * @param <T> тип объекта персистенции
 * @param <PK> тип первичного ключа
 */
public interface GenericDao<T extends Identified<PK>, PK extends Serializable> {

    /** Создает новую запись и соответствующий ей объект
     * @return 
     * @throws com.barracuda.p4j.dao.PersistException */
    public T create() throws PersistException;

    /** Создает новую запись, соответствующую объекту object
     * @param object
     * @return 
     * @throws com.barracuda.p4j.dao.PersistException */
    public T persist(T object)  throws PersistException;

    /** Возвращает объект соответствующий записи с первичным ключом key или null
     * @param key
     * @return 
     * @throws com.barracuda.p4j.dao.PersistException */
    public T getByPK(PK key) throws PersistException;

    /** Сохраняет состояние объекта group в базе данных
     * @param object
     * @throws com.barracuda.p4j.dao.PersistException */
    public void update(T object) throws PersistException;

    /** Удаляет запись об объекте из базы данных
     * @param object
     * @throws com.barracuda.p4j.dao.PersistException */
    public void delete(T object) throws PersistException;

    /** Возвращает список объектов соответствующих всем записям в базе данных
     * @return 
     * @throws com.barracuda.p4j.dao.PersistException */
    public List<T> getAll() throws PersistException;
}
