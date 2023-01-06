package com.app.dao;

import com.app.entity.Author;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;

import java.util.List;

public class AuthorDao extends AbstractDAO<Author> {

    public AuthorDao(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public List<Author> getAll() {
        return query("select a from Author").getResultList();
    }

    public Author getById(Integer id) {
        return get(id);
    }

    public Integer save(Author author) {
       return persist(author).getAuthId();
    }
}
