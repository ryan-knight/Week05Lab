/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 763198
 */
public class ShoppingListServlet extends HttpServlet
{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        doStuff(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        doStuff(request, response);
    }
    
    private void doStuff(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        HttpSession session = request.getSession(false);
        
        String action = request.getParameter("action");
        if(action == null)
            action = "";
        
        String username = (String)session.getAttribute("username");
        
        if(action.equals("register") && !request.getParameter("name").equals(""));
        {
            session = request.getSession();
            username = request.getParameter("name");
            session.setAttribute("username", username);
        }
                
        if(username == null)
        {
            request.setAttribute("message", "No session" + username);
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
            return;
        }
        
        if(action.equals("logout"))
        {
            session.invalidate();
            request.setAttribute("message", "Logged out successfully");
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
            return;
        }
        
        ArrayList<String> list;
        list = (ArrayList<String>)session.getAttribute("list");
        
        if(list == null)
            list = new ArrayList();
        
        if(action.equals("add"))
            list.add(request.getParameter("newItem"));
        
        if(action.equals("delete"))
            {
                try
                {
                    int index = Integer.parseInt(request.getParameter("itemIndex"));
                    list.remove(index);
                }
                catch(Exception e)
                {
                    request.setAttribute("message", "Nothing to delete.");
                }
            }
        
        session.setAttribute("list", list);
        getServletContext().getRequestDispatcher("/WEB-INF/shoppinglist.jsp").forward(request, response);
    }
}


