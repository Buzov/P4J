package com.barracuda.p4j.dao.sqlite;

import com.barracuda.p4j.dao.DaoFactory;
import com.barracuda.p4j.dao.GenericDao;
import com.barracuda.p4j.dao.PersistException;
import com.barracuda.p4j.dao.domain.Comment;
import com.barracuda.p4j.dao.domain.LoginPassword;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class SQLiteDaoFactory implements DaoFactory<Connection> {

    private static final String USER = "root";//Логин пользователя
    private static final String PASSWORD = "";//Пароль пользователя
    private static final String URL = "jdbc:sqlite:p4j.db";//URL адрес
    private static final String DRIVER = "org.sqlite.JDBC";//Имя драйвера
    private Map<Class, DaoCreator> creators;

    @Override
    public Connection getContext() throws PersistException {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            throw new PersistException(e);
        }
        return  connection;
    }

    @Override
    public GenericDao getDao(Connection connection, Class dtoClass) throws PersistException {
        DaoCreator creator = creators.get(dtoClass);
        if (creator == null) {
            throw new PersistException("Dao object for " + dtoClass + " not found.");
        }
        return creator.create(connection);
    }

    public SQLiteDaoFactory() {
        try {
            Class.forName(DRIVER);//Регистрируем драйвер
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        creators = new HashMap<Class, DaoCreator>();
        creators.put(Comment.class, new DaoCreator<Connection>() {
            @Override
            public GenericDao create(Connection connection) {
                return new SQLiteCommentDao(connection);
            }
        });
        creators.put(LoginPassword.class, new DaoCreator<Connection>() {
            @Override
            public GenericDao create(Connection connection) {
                return new SQLiteLoginPasswordDao(connection);
            }
        });
    }
}
