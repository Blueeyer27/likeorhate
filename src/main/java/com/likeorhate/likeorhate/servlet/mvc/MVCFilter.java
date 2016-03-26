package com.likeorhate.likeorhate.servlet.mvc;

import com.likeorhate.likeorhate.servlet.mvc.models.MVCModel;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Anton on 2016.03.26..
 */
public class MVCFilter implements Filter {

    private Map<String, MVCController> controllerMapping;

    @Override
    public void init (FilterConfig filterConfig) throws ServletException {
        controllerMapping = new HashMap<String, MVCController>();
        controllerMapping.put("/", new HelloWorldController());
    }

    @Override
    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest)request;
        HttpServletResponse resp = (HttpServletResponse)response;

        String contextURI = req.getServletPath();
        String path = ((HttpServletRequest) request).getRequestURI();

        System.out.println(contextURI);
        if (controllerMapping.keySet().contains(contextURI)){
            MVCController controller = controllerMapping.get(contextURI);
            MVCModel model = controller.processRequest(req, resp);

            req.setAttribute("model", model.getData());
            ServletContext context = req.getServletContext();
            System.out.println("View: " + model.getView());

            RequestDispatcher requestDispatcher = context.getRequestDispatcher(model.getView());
            requestDispatcher.forward(req, resp);
        }
        else filterChain.doFilter(request,response);


    }

    @Override
    public void destroy() {

    }
}
