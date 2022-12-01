package pl.polsl.kubala.patryk.servlet;

import java.io.*;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/**
 * Main class of the servlet that demonstrates parameter download given during
 * servlet initialization
 *
 * @author Gall Anonim
 * @version 1.0
 */
@WebServlet("/Cryp")
public class MainFormServlet extends HttpServlet {

    /**
     * Collection of statistics
     */
    private final HashMap<String, String> stats;

    /**
     * Constructor initiating statistics collection
     */
    public MainFormServlet() {
        this.stats = new HashMap<>();
    }

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        // Get parameter values - seedField i textField
        String seedField = request.getParameter("seed");
        String textField = request.getParameter("textField");
        String choose = request.getParameter("choose");
        // FirstName or textField was not given - send error message

        if (seedField.length() == 0 || textField.length() == 0) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "You should give two parameters!");
        } else {
            if (choose.equals("encode")) {
                out.println("<html>\n<body>\n<h1>Eneode seed: " + seedField + "textField: "
                        + textField + "!!!</h1>\n");
                getServletContext().getRequestDispatcher("/encrypt").forward(request, response);

            } else {
                out.println("<html>\n<body>\n<h1>Decode seed: " + seedField + "textField: "
                        + textField + "!!!</h1>\n");
                getServletContext().getRequestDispatcher("/decrypt").forward(request, response);

            }
        }

    }
}
