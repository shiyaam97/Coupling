package servelt;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CouplingValues;

/**
 * Servlet implementation class Coupling
 */
@WebServlet("/")
public class CouplingServelt extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static int wR = 2; // Weight of recursive call
	public static int wMcms = 2; // Weight of regular method calling regular method same file
	public static int wMcmd = 3; // Weight of regular method calling another regular method in a different file
	public static int wMcrms = 3; // Weight of regular method calling a recursive method in the same file
	public static int wMcrmd = 4; // Weight of regular method calling a recursive method in the same file
	public static int wRmcrms = 4;// Weight of recursive method calling another recursive method in the same file
	public static int wRmcrmd = 5;// Weight of recursive method calling another recursive method in a different
									// file
	public static int wRmcms = 3; // Weight of recursive method calling a regular method in the same file
	public static int wRmcmd = 4; // Weight of recursive method calling a regular method in a different file
	public static int wMrgvs = 1; // Weight of regular method referencing a global variable in the same file
	public static int wMrgvd = 2; // Weight of regular method referencing a global variable in a different file
	public static int wRmrgvs = 1;// Weight of recursive method referencing a global variable in the same file
	public static int wRmrgvd = 2;// Weight of recursive method referencing a global variable in a different file

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CouplingServelt() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		wR = Integer.parseInt(request.getParameter("wR"));
		System.out.println(wR);

		wMcms = Integer.parseInt(request.getParameter("wMcms"));
		System.out.println(wMcms);

		wMcmd = Integer.parseInt(request.getParameter("wMcmd"));
		System.out.println(wMcmd);

		wMcrms = Integer.parseInt(request.getParameter("wMcrms"));
		System.out.println(wMcrms);
		
		wMcrmd = Integer.parseInt(request.getParameter("wMcrmd"));
		System.out.println(wMcrmd);
	
		wRmcrms = Integer.parseInt(request.getParameter("wRmcrms"));
		System.out.println(wRmcrms);
		
		wRmcrmd = Integer.parseInt(request.getParameter("wRmcrmd"));
		System.out.println(wRmcrmd);

		wRmcms = Integer.parseInt(request.getParameter("wRmcms"));
		System.out.println(wRmcms);

		wRmcmd = Integer.parseInt(request.getParameter("wRmcmd"));
		System.out.println(wRmcmd);

		wMrgvs = Integer.parseInt(request.getParameter("wMrgvs"));
		System.out.println(wMrgvs);

		wMrgvd = Integer.parseInt(request.getParameter("wMrgvd"));
		System.out.println(wMrgvd);

		wRmrgvs = Integer.parseInt(request.getParameter("wRmrgvs"));
		System.out.println(wRmrgvs);

		wRmrgvd = Integer.parseInt(request.getParameter("wRmrgvd"));
		System.out.println(wRmrgvd);

		PrintWriter out = response.getWriter();
		request.getRequestDispatcher("/WeightCoupling.jsp").include(request, response);

	}

}
