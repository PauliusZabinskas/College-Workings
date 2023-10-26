package controller;

import entity.Book;
import entity.Author;
import java.io.IOException;
import java.util.Collection;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import session.AuthorFacade;

@WebServlet(name = "Controller",
        loadOnStartup = 1,
        urlPatterns =
        {
            "/author",
            "/chooseLanguage"
        })
public class ControllerServlet extends HttpServlet
{

    Author selectedAuthor;
    Collection<Book> authorBooks;
    Collection<Author> authors;

    @EJB
    private AuthorFacade authorFacade;

    @Override
    public void init(ServletConfig servletConfig) throws ServletException
    {

        super.init(servletConfig);

        authors = authorFacade.findAll();
        // while loop
        for (Author a : authors)
        {
            System.out.println(a.getAuthorid());
            System.out.println(a.getSurname());
            System.out.println(a.getFirstname());
            System.out.println(a.getYob());
            System.out.println(a.getNationality());
            System.out.println(a.getBiography());
        }
        // store author list in servlet context
        getServletContext().setAttribute("authors", authors);

    }

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {

        String userPath = request.getServletPath();
        HttpSession session = request.getSession();

        // if author is selected
        if (userPath.equals("/author"))
        {

            // get authorid from request
            String authorid = request.getQueryString();
            System.out.println("author id = " + authorid);

            if (authorid != null)
            {

                // get selected category
                selectedAuthor = authorFacade.find(Integer.valueOf(authorid));

                // place selected category in session scope
                session.setAttribute("selectedAuthor", selectedAuthor);

                // get all products for selected category
                authorBooks = selectedAuthor.getBookCollection();

                // place category products in session scope
                session.setAttribute("authorBooks", authorBooks);

               request.getRequestDispatcher("/authorBooks.jsp").forward(request, response);
               
               return;
            }
        } else if (userPath.equals("/chooseLanguage"))
        {
            // get language choice
            String language = request.getParameter("language");

            // place in request scope
            request.setAttribute("language", language);
        }

        String userView = (String) session.getAttribute("view");

        // use RequestDispatcher to forward request internally
        String url = "/" + userView + ".jsp";

        try
        {
            request.getRequestDispatcher(url).forward(request, response);
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {

        processRequest(request, response);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {

        processRequest(request, response);

    }
}
