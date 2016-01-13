package com.barracuda.p4j.dao.sqlite;

import com.barracuda.p4j.dao.AbstractJDBCDao;
import com.barracuda.p4j.dao.PersistException;
import com.barracuda.p4j.dao.domain.Comment;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

public class SQLiteCommentDao extends AbstractJDBCDao<Comment, Integer> {

    private class PersistComment extends Comment {
        public void setId(int id) {
            super.setId(id);
        }
    }

    @Override
    public String getSelectQuery() {
        return "SELECT id, number, department FROM daotalk.Group";
    }

    @Override
    public String getCreateQuery() {
        return "INSERT INTO daotalk.Group (number, department) \n" +
                "VALUES (?, ?);";
    }

    @Override
    public String getUpdateQuery() {
        return "UPDATE daotalk.Group SET number= ? department = ? WHERE id= ?;";
    }

    @Override
    public String getDeleteQuery() {
        return "DELETE FROM daotalk.Group WHERE id= ?;";
    }

    @Override
    public Comment create() throws PersistException {
        Comment g = new Comment();
        return persist(g);
    }

    public SQLiteCommentDao(Connection connection) {
        super(connection);
    }

    @Override
    protected List<Comment> parseResultSet(ResultSet rs) throws PersistException {
        LinkedList<Comment> result = new LinkedList<Comment>();
        try {
            while (rs.next()) {
                PersistComment group = new PersistComment();
                group.setId(rs.getInt("id"));
                group.setComment(rs.getString("comment"));
                result.add(group);
            }
        } catch (Exception e) {
            throw new PersistException(e);
        }
        return result;
    }

    @Override
    protected void prepareStatementForInsert(PreparedStatement statement, Comment object) throws PersistException {
        try {
            statement.setString(1, object.getComment());
        } catch (Exception e) {
            throw new PersistException(e);
        }
    }

    @Override
    protected void prepareStatementForUpdate(PreparedStatement statement, Comment object) throws PersistException {
        try {
            statement.setInt(1, object.getId());
            statement.setString(2, object.getComment());
        } catch (Exception e) {
            throw new PersistException(e);
        }
    }
}
