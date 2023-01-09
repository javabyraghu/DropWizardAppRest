package com.app.resources;

import com.app.dao.BookDao;
import com.app.entity.Book;
import io.dropwizard.hibernate.UnitOfWork;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/books")
public class BookResource {

    private BookDao bookDao;

    public BookResource(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    @UnitOfWork
    public List<Book> getAllBooks()
    {
        return bookDao.getAllBooks();
    }

    @GET
    @Path("/author/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @UnitOfWork
    public List<Book> getBooksByAuthorId(@PathParam("id") Integer id)
    {
        return bookDao.getBooksByAuthorId(id);
    }
    @GET
    @Path("/find/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @UnitOfWork
    public Book getOne(@PathParam("id") Integer id) {
        return bookDao.getBookById(id);
    }

    @POST
    @Path("/create")
    @UnitOfWork
    public Integer create(Book book) {
        return bookDao.saveBook(book);
    }
}
