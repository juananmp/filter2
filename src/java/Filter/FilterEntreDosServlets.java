/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author janto
 */
public class FilterEntreDosServlets implements Filter {
   
    public void init(FilterConfig config) throws ServletException
    {
        System.out
                .println("------------------------------------------------------");
        System.out.println(" init method is called in "
                + this.getClass().getName());
        System.out
                .println("------------------------------------------------------");
    }

    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException{
   HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        String name = req.getParameter("name");
        
        if (name.equals(""))
        {
               System.out.println("Unauthorized request");
            System.out.println("######################################################\n\n");
            res.sendRedirect("index.html");
        }
        else
        {
            // pass the request along the filter chain
            chain.doFilter(request, response);
        }

    }

    public void destroy()
    {
        // add code to release any resource
        System.out
                .println("------------------------------------------------------");
        System.out.println(" destroy method is called in "
                + this.getClass().getName());
        System.out
                .println("------------------------------------------------------");
    }
}