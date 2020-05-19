package servlets;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletLogin
 * Servlet es un objeto (singleton) que procesa mensajes http
 */
@WebServlet("/ServletLogin")
public class ServletLogin extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("peticion get");
		String prueba = "Esto es una prueba";
		String nombre = request.getParameter("nombre");
		String password = request.getParameter("password");
		//tendria que comunicarme con modleo (gestorLogin) y que me diga
		//si el usuario esta registrado
		//Esta parte no se hace en los servlets
		//response.setContentType("text/plain");
		//response.getWriter().append("variable: " + prueba + " " + nombre + " " + password);
		
		//request.getServletContext().setAttribute(name, object);
		//request dispatcher declaramos a donde queremos ir
		Date date = new Date();
		request.setAttribute("fecha", date);
		request.getSession().setAttribute("fechaSession", date);
		RequestDispatcher rd = request.getRequestDispatcher("inicio.jsp");
		//ejecutamos la accion de ir, le pasamos nuestra request y nuestra response
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("peticion");
		doGet(request, response);
	}

}
