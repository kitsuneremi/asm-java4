package servlet;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;
import model.User;
import model.Video;
import model.VideoSummary;
import repo.AdminReportRepo;
import repo.AdminUserRepo;
import repo.AdminVideo;

@WebServlet(name="Admin", value = { "/admin/video", "/admin/video/create", "/admin/video/update", "/admin/video/delete", "/admin/video/edit/*", "/admin/report"})
public class Admin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AdminVideo videorepo = new AdminVideo();
	AdminUserRepo userrepo = new AdminUserRepo();
	AdminReportRepo reportrepo = new AdminReportRepo();
    public Admin() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();

		if(uri.contains("video")) {
			List<Video> list = videorepo.GetListVideo();
			request.setAttribute("listVideo", list);
			if(uri.contains("edit")) {
				Video v = videorepo.findOne(uri.split("/")[5]);
				request.setAttribute("id", v.getId());
				request.setAttribute("des", v.getDescription());
				request.setAttribute("poster", v.getPoster());
				request.setAttribute("title", v.getTitle());
				request.setAttribute("view", v.getViews());
				request.setAttribute("active", v.getActive());
			}
			request.getRequestDispatcher("/view/admin/videomanage.jsp").forward(request, response);
		}else if(uri.contains("user")) {
			List<User> list = userrepo.GetList();
			request.setAttribute("listUser", list);

			if(uri.contains("edit")) {
				User u = userrepo.findOne(uri.split("/")[5]);
				request.setAttribute("id", u.getId());
				request.setAttribute("fullname", u.getFullname());
				request.setAttribute("email", u.getEmail());
				request.setAttribute("pass", u.getPassword());
				request.setAttribute("admin", u.getAdmin());
				
			}
			request.getRequestDispatcher("/view/admin/usermanage.jsp").forward(request, response);
		}else if(uri.contains("report")) {
			List<VideoSummary> list = reportrepo.One();
			List<Video> listVideo = videorepo.GetListVideo();
			request.setAttribute("one", list);
			request.setAttribute("two", listVideo);
			request.getRequestDispatcher("/view/admin/reportmanage.jsp").forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		System.out.println(uri);
		if(uri.contains("video")) {
			if(uri.contains("create")) {
				String id = request.getParameter("id");
				String poster = request.getParameter("poster");
				String title =  request.getParameter("title");
				int view =  Integer.parseInt(request.getParameter("view"));
				String active = request.getParameter("status");
				String des = request.getParameter("des");
				Video v = new Video();
				v.setId(id);
				v.setActive(Byte.parseByte(active));
				v.setDescription(des);
				v.setPoster(poster);
				v.setTitle(title);
				v.setViews(view);
				videorepo.Insert(v);
			}else if(uri.contains("update")) {
				String id = request.getParameter("id");
				String poster = request.getParameter("poster");
				String title =  request.getParameter("title");
				int view =  Integer.parseInt(request.getParameter("view"));
				String active = request.getParameter("status");
				String des = request.getParameter("des");
				Video v = new Video();
				v.setActive(Byte.parseByte(active));
				v.setDescription(des);
				v.setPoster(poster);
				v.setTitle(title);
				v.setViews(view);
				videorepo.Update(v);
			}else if(uri.contains("delete")) {
				String id = request.getParameter("id");
				videorepo.Delete(id);
			}
			request.getRequestDispatcher("/view/admin/videomanage.jsp").forward(request, response);
		}else if(uri.contains("user")) {
			if(uri.contains("update")) {
				String id = request.getParameter("username");
				String fullname = request.getParameter("fullname");
				String password = request.getParameter("password");
				String email = request.getParameter("email");
				User u = new User();
				u.setAdmin(Byte.parseByte("0"));
				u.setEmail(email);
				u.setFullname(fullname);
				u.setId(id);
				u.setPassword(password);
				userrepo.Update(u);
			}else if(uri.contains("update")) {
				String id = request.getParameter("username");
				userrepo.Delete(id);
			}
		}
	}

}
