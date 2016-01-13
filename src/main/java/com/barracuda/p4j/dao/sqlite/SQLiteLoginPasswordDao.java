package com.barracuda.p4j.dao.sqlite;

import com.barracuda.p4j.dao.AbstractJDBCDao;
import com.barracuda.p4j.dao.PersistException;
import com.barracuda.p4j.dao.domain.LoginPassword;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

public class SQLiteLoginPasswordDao extends AbstractJDBCDao<LoginPassword, Integer> {

    private class PersistLoginPassword extends LoginPassword {
        public void setId(int id) {
            super.setId(id);
        }
    }

    @Override
    public String getSelectQuery() {
        return "SELECT id, name, surname, enrolment_date, group_id FROM daotalk.Student ";
    }

    @Override
    public String getCreateQuery() {
        return "INSERT INTO daotalk.Student (name, surname, enrolment_date, group_id) \n" +
                "VALUES (?, ?, ?, ?);";
    }

    @Override
    public String getUpdateQuery() {
        return "UPDATE daotalk.Student \n" +
                "SET name = ?, surname  = ?, enrolment_date = ?, group_id = ? \n" +
                "WHERE id = ?;";
    }

    @Override
    public String getDeleteQuery() {
        return "DELETE FROM daotalk.Student WHERE id= ?;";
    }

    @Override
    public LoginPassword create() throws PersistException {
        LoginPassword s = new LoginPassword();
        return persist(s);
    }

    public SQLiteLoginPasswordDao(Connection connection) {
        super(connection);
    }

    @Override
    protected List<LoginPassword> parseResultSet(ResultSet rs) throws PersistException {
        LinkedList<LoginPassword> result = new LinkedList<LoginPassword>();
        try {
            while (rs.next()) {
                PersistLoginPassword student = new PersistLoginPassword();
                student.setId(rs.getInt("id"));
                student.setLogin(rs.getString("login"));
                student.setPassword(rs.getString("password"));
                student.setCommentId(rs.getInt("comment_id"));
                result.add(student);
            }
        } catch (Exception e) {
            throw new PersistException(e);
        }
        return result;
    }

    @Override
    protected void prepareStatementForUpdate(PreparedStatement statement, LoginPassword object) throws PersistException {
        try {
            /*Date sqlDate = convert(object.getEnrolmentDate());
            statement.setString(1, object.getName());
            statement.setString(2, object.getSurname());
            statement.setDate(3, sqlDate);
            statement.setInt(4, object.getGroupId());
            statement.setInt(5, object.getId());*/
        } catch (Exception e) {
            throw new PersistException(e);
        }
    }

    @Override
    protected void prepareStatementForInsert(PreparedStatement statement, LoginPassword object) throws PersistException {
        try {
            /*Date sqlDate = convert(object.getEnrolmentDate());
            int groupId = (object.getGroupId() == null) ? 0 : object.getGroupId();

            statement.setString(1, object.getName());
            statement.setString(2, object.getSurname());
            statement.setDate(3, sqlDate);
            statement.setInt(4, groupId);*/
        } catch (Exception e) {
            throw new PersistException(e);
        }
    }

    protected java.sql.Date convert(java.util.Date date) {
        if (date == null) {
            return null;
        }
        return new java.sql.Date(date.getTime());
    }
}
