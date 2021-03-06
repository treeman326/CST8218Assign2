/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cst8218.base0001.service;

import java.util.Set;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.security.enterprise.authentication.mechanism.http.BasicAuthenticationMechanismDefinition;
import javax.security.enterprise.identitystore.DatabaseIdentityStoreDefinition;
import javax.security.enterprise.identitystore.PasswordHash;
import javax.security.enterprise.identitystore.Pbkdf2PasswordHash;

/**
 * Configures authentication and RESTful resources
 * @author Todd Kelley, Patrick Hessian
 */
@DatabaseIdentityStoreDefinition(
        dataSourceLookup = "${'java:comp/DefaultDataSource'}",
        callerQuery = "#{'select PASSWORD from app.appuser where userid= ?'}",
        groupsQuery = "select GROUPNAME from app.appuser where userid= ?",
        hashAlgorithm = Pbkdf2PasswordHash.class,
        priority = 10
)
@javax.ws.rs.ApplicationPath("webresources")
@BasicAuthenticationMechanismDefinition
@ApplicationScoped
@Named
public class ApplicationConfig extends javax.ws.rs.core.Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    
    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(cst8218.base0001.service.SpriteFacadeREST.class);
    }
    
}
