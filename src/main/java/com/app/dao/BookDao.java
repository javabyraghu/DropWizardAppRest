package com.app.dao;

import com.app.entity.Book;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;

import java.util.List;

public class BookDao extends AbstractDAO<Book> {

    public BookDao(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public List<Book> getAllBooks() {
        return query("SELECT B FROM Book B").getResultList();
    }

    public List<Book> getBooksByAuthorId(Integer id) {
        return query("select B from Book B INNER JOIN B.authors AS authors WHERE authors.id = :aid ")
                .setParameter("aid",id)
                .getResultList();
    }

    public Integer saveBook(Book book) {
        return persist(book).getBookId();
    }

    public Book getBookById(Integer id) {
        return get(id);
    }
}