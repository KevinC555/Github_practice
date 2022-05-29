import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        request.getRequestDispatcher("navbar.html").include(request, response);

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if(username.equals("admin") && password.equals("123")){
            out.println("you are successfully logged in");
            out.println("<br>Welcome "+ username);

            HttpSession session = request.getSession();
            session.setAttribute("username", username);
        }else if(username.equals("employee") && password.equals("123")){
            out.println("you are successfully logged in");
            out.println("<br>Welcome "+ username);

            HttpSession session = request.getSession();
            session.setAttribute("username", username);
        }else{
            out.println("sorry! invalid details");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/login.html");
            requestDispatcher.include(request, response);
        }
        out.close();
    }
}