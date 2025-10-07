package controller;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import Model.Game;
import jakarta.servlet.http.HttpSession;
import controller.DBConnection;

/**
 *
 * @author ASUS
 */
@WebServlet(name = "RetrieveAllgame", urlPatterns = {"/RetrieveAllgame"})
public class RetrieveAllgame extends HttpServlet {
    DBConnection db = new DBConnection();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
        response.setContentType("text/html;charset=UTF-8");
        

        List<Game> games = new ArrayList();
        games = db.retrieveAllGame();
        //  store List<Food> in session object
        HttpSession session = request.getSession();
        session.setAttribute("games", games);

        // forward to showAllFood.jsp
        response.sendRedirect("ShowAllgame.jsp");
    }

 
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    try {
      List<Game> games = db.retrieveAllGame();
      req.setAttribute("games", games);
      req.getRequestDispatcher("/ShowAllgame.jsp").forward(req, resp);
    } catch (Exception e) {
      throw new ServletException(e);
    }
  }




    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            System.getLogger(RetrieveAllgame.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}