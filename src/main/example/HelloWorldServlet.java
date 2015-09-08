package main.example;


import org.kohsuke.stapler.HttpResponse;
import org.kohsuke.stapler.StaplerRequest;
import org.pac4j.saml.credentials.Saml2Credentials;
import org.pac4j.saml.profile.Saml2Profile;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Sergey_Stefoglo1 on 8/21/2015.
 */
public class HelloWorldServlet extends HttpServlet {

    private String message;

    public void init() throws ServletException {
        // Do required initialization
        message = "Hello World";
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //  super.doPost(req, resp);
        resp.setContentType("text/html");
        System.out.print("eee");
        // Actual logic goes here.

        PrintWriter out = resp.getWriter();
        out.println("<h1>" + message + "</h1>");
        SSO sso=new SSO();

        Saml2Profile saml2Profile=new Saml2Profile();

       sso.doCommenceLogin(req,resp,saml2Profile);
      System.out.println(req.getAttribute("userSSONAME"));
        System.out.print(saml2Profile);
System.out.print(resp);
//        resp=(HttpServletResponse)httpResponse;
//        SamlSecurityRealm samlSecurityRealm=new SamlSecurityRealm("","","sergey_stefoglo1","epam.com",24 * 60 * 60);
        // System.out.println(samlSecurityRealm.doCommenceLogin(req,"Sergey_stegoglo1"));
        //    SamlUserDetailsService samlUserDetailsService=new SamlUserDetailsService();
        //  SamlUserDetails object = samlUserDetailsService.loadUserByUsername("Sergey_Stefoglo1");
        // System.out.print(object.getAuthorities());
        //     SamlUserDetails samlUserDetails= new SamlUserDetailsService().loadUserByUsername("Sergey_stefoglo1");
        //    System.out.print(samlUserDetails);



    }

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {
        // Set response content type
        response.setContentType("text/html");

        // Actual logic goes here.
        PrintWriter out = response.getWriter();
        out.println("<h1>" + message + "</h1>");
    }

    public void destroy() {
        // do nothing.
    }

}