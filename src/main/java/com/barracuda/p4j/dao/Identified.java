package com.barracuda.p4j.dao;

import java.io.Serializable;

/**
 * Интерфейс идентифицируемых объектов.
 * @param <PK>
 */
public interface Identified<PK extends Serializable> {

    /** Возвращает идентификатор объекта
     * @return  */
    public PK getId();
}
