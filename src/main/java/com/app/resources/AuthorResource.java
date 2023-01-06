package com.app.resources;

import com.app.dao.AuthorDao;
import com.app.entity.Author;
import io.dropwizard.hibernate.UnitOfWork;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/authors")
public class AuthorResource {

    private AuthorDao authorDao;

    public AuthorResource(AuthorDao authorDao) {
        this.authorDao = authorDao;
    }
    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    @UnitOfWork
    public List<Author> getInfo()
    {
        return authorDao.getAll();
    }
    @GET
    @Path("/find/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @UnitOfWork
    public Author getOne(@PathParam("id") Integer id) {
        return authorDao.getById(id);
    }

    @POST
    @Path("/create")
    @UnitOfWork
    public Integer create(Author author) {
        return authorDao.save(author);
    }
}
