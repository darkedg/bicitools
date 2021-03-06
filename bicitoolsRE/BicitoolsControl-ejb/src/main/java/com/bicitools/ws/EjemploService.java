/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bicitools.ws;

import com.bicitools.dao.TemporalDAOLocal;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;

/**
 *
 * @author Ludwing
 */
@WebService(serviceName = "EjemploService")
@Stateless()
public class EjemploService {
    @EJB
    TemporalDAOLocal t;
    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        
        t.creaTemp(new Integer(txt), "dato");
        
        return "Hello " + txt + " !";
    }
}
