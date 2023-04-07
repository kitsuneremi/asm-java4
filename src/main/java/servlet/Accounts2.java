package servlet;

import javax.persistence.*;

import repo.DetailRepo;
import repo.HomeRepo;
import repo.LoginRepo;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Video;

@WebServlet(name = "Accounts2", value = { "/home","/account/*", "/detail/*" })
public class Accounts2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	LoginRepo repo = new LoginRepo();
	HomeRepo homerepo = new HomeRepo();
	DetailRepo detailrepo = new DetailRepo();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Accounts2() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		if(uri.contains("login")) {
			request.getRequestDispatcher("/view/login.jsp").forward(request, response);
		}else if(uri.contains("forgotpass")) {
			request.getRequestDispatcher("/view/forgotpass.jsp").forward(request, response);
		}else if(uri.contains("register")) {
			request.getRequestDispatcher("/view/register.jsp").forward(request, response);
		}else if(uri.contains("logoff")) {
			jakarta.servlet.http.HttpSession session = request.getSession();
			session.removeAttribute("user");
			request.getRequestDispatcher("/view/home.jsp").forward(request, response);
		}else if(uri.contains("changepass")) {
			request.getRequestDispatcher("/view/changepass.jsp").forward(request, response);
		}else if(uri.contains("editprofile")) {
			request.getRequestDispatcher("/view/editprofile.jsp").forward(request, response);
		}else if(uri.contains("home")){
			List<Video> list = homerepo.GetListVideo();
			request.setAttribute("listVideo", list);
			request.getRequestDispatcher("/view/home.jsp").forward(request, response);
		}else if(uri.contains("detail")) {
			System.out.println(uri.split("/")[3]);
			Video vid = detailrepo.GetVideo(uri.split("/")[3]);
			request.setAttribute("video", vid);
			request.getRequestDispatcher("/view/detail").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI();
		if(uri.contains("login")) {
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			boolean log = repo.Login(username, password);
			if(log) {
				jakarta.servlet.http.HttpSession session = request.getSession();
				session.setAttribute("username", username);
				request.getRequestDispatcher("/view/home.jsp").forward(request, response);
			}else {
				response.sendRedirect("/home");
				return ;
//				request.getRequestDispatcher("/view/login.jsp").forward(request, response);
			}
		}else if(uri.contains("forgotpass")) {
			
		}else if(uri.contains("register")) {
			
		}else if(uri.contains("logoff")) {
			HttpSession session = (HttpSession) request.getSession();
			session.removeAttribute("user");
			request.getRequestDispatcher("/view/home.jsp").forward(request, response);
		}else if(uri.contains("editprofile")) {

		}
	}

}
