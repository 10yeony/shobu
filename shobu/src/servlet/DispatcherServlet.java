package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.HandlerMapping;
import controller.ModelAndView;

@WebServlet("*.do")
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doProcess(req, res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doProcess(req, res);
	}
	
	protected void doProcess(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String reqURI = req.getRequestURI();
		String command = reqURI.substring(req.getContextPath().length()+1);
		System.out.println(command);
		
		ModelAndView mv = null;
		String path = "index.jsp";
		Controller controller = HandlerMapping.getInstance().createController(command);
		
		try{
			mv = controller.execute(req, res);
			path = mv.getPath();
		}catch (Exception e){
			System.out.println("*****Error*****");
		}
				
		if (mv.isRedirect() == false) req.getRequestDispatcher(path).forward(req, res);
		else res.sendRedirect(path);
	}

}
