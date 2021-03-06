/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cst8218.base0001.service;

import cst8218.base0001.entity.Sprite;
import java.util.List;
import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * This class declares and restricts the REST functions
 * @author Todd Kelley, Patrick Hessian
 */
@DeclareRoles("{Admin,RestGroup}")//these are the two roles used for the REST functions
@javax.ejb.Stateless
@javax.ws.rs.Path("cst8218.base0001.entity.sprite")
public class SpriteFacadeREST extends cst8218.base0001.entity.AbstractFacade<Sprite> {

    @PersistenceContext(unitName = "SpriteBasePU")
    private EntityManager em;

    public SpriteFacadeREST() {
        super(Sprite.class);
    }

    @javax.ws.rs.POST
    @RolesAllowed({"RestGroup", "Admin"})//only these roles can access this resource
    @Override
    @javax.ws.rs.Consumes({javax.ws.rs.core.MediaType.APPLICATION_XML, javax.ws.rs.core.MediaType.APPLICATION_JSON})
    public void create(Sprite entity) {
        super.create(entity);
    }

    @javax.ws.rs.PUT
    @RolesAllowed({"RestGroup", "Admin"})
    @javax.ws.rs.Path("{id}")
    @javax.ws.rs.Consumes({javax.ws.rs.core.MediaType.APPLICATION_XML, javax.ws.rs.core.MediaType.APPLICATION_JSON})
    public void edit(@javax.ws.rs.PathParam("id") Long id, Sprite entity) {
        super.edit(entity);
    }

    @javax.ws.rs.DELETE
    @RolesAllowed({"RestGroup", "Admin"})
    @javax.ws.rs.Path("{id}")
    public void remove(@javax.ws.rs.PathParam("id") Long id) {
        super.remove(super.find(id));
    }

    @javax.ws.rs.GET
    @RolesAllowed({"RestGroup", "Admin"})
    @javax.ws.rs.Path("{id}")
    @javax.ws.rs.Produces({javax.ws.rs.core.MediaType.APPLICATION_XML, javax.ws.rs.core.MediaType.APPLICATION_JSON})
    public Sprite find(@javax.ws.rs.PathParam("id") Long id) {
        return super.find(id);
    }

    @javax.ws.rs.GET
    @RolesAllowed({"RestGroup", "Admin"})
    @Override
    @javax.ws.rs.Produces({javax.ws.rs.core.MediaType.APPLICATION_XML, javax.ws.rs.core.MediaType.APPLICATION_JSON})
    public List<Sprite> findAll() {
        return super.findAll();
    }

    @javax.ws.rs.GET
    @RolesAllowed({"RestGroup", "Admin"})
    @javax.ws.rs.Path("{from}/{to}")
    @javax.ws.rs.Produces({javax.ws.rs.core.MediaType.APPLICATION_XML, javax.ws.rs.core.MediaType.APPLICATION_JSON})
    public List<Sprite> findRange(@javax.ws.rs.PathParam("from") Integer from, @javax.ws.rs.PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @javax.ws.rs.GET
    @RolesAllowed({"RestGroup", "Admin"})
    @javax.ws.rs.Path("count")
    @javax.ws.rs.Produces(javax.ws.rs.core.MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
