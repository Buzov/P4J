package com.barracuda.p4j.dao;

/** Фабрика объектов для работы с базой данных
 * @param <Context> */
public interface DaoFactory<Context> {

    public interface DaoCreator<Context> {
        public GenericDao create(Context context);
    }

    /** Возвращает подключение к базе данных
     * @return
     * @throws com.barracuda.p4j.dao.PersistException  */
    public Context getContext() throws PersistException;

    /** Возвращает объект для управления персистентным состоянием объекта
     * @param context
     * @param dtoClass
     * @return 
     * @throws com.barracuda.p4j.dao.PersistException */
    public GenericDao getDao(Context context, Class dtoClass) throws PersistException;
}
