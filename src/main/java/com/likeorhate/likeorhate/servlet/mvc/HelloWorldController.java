package com.likeorhate.likeorhate.servlet.mvc;

import com.likeorhate.likeorhate.servlet.mvc.models.MVCModel;
import com.sun.corba.se.impl.io.TypeMismatchException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Anton on 2016.03.26..
 */
public class HelloWorldController implements MVCController {

    @Override
    public MVCModel processRequest(HttpServletRequest request, HttpServletResponse response) throws TypeMismatchException {
        String message = "Hello from MVC!";
        MVCModel model = new MVCModel("/helloWorld.jsp", message);
        return model;
    }
}
