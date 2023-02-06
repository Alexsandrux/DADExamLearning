package eu.ase.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Servlet implementation class HandlingServletRequests
 */
@WebServlet("/HandlingServletRequests")
public class HandlingServletRequests extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HandlingServletRequests() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		System.out.println(request.getReader().readLine());
		String s = request.getParameter("v");
		System.out.println(s);
		response.getWriter().append("Served at: ").append(request.getContextPath());
		if ( s == null)
		{
			return;
		}
		List<String> my_list = new ArrayList<String>(Arrays.asList(s.split(",")));
		for (String string : my_list) {
			System.out.println(string);
		}
		
		List<Float> my_list_float = new ArrayList<>();
		for (String float1 : my_list) {
			my_list_float.add(Float.parseFloat(float1));
		}
		
		List<Float> new_list = my_list_float.stream().map((elem) -> {
			return elem + 1;
		}).toList();
		
		for (Float float1 : new_list) {
			System.out.println(float1);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
