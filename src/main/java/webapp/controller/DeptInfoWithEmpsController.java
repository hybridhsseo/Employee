package webapp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import webapp.model.Dept;
import webapp.service.DeptInfoService;

/**
 * Servlet implementation class DeptController
 */
@WebServlet("/dept/infowithemps")
public class DeptInfoWithEmpsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static Log log = LogFactory.getLog(DeptInfoWithEmpsController.class);
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeptInfoWithEmpsController() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    ApplicationContext factory;
        
    @Override
    public void init(ServletConfig config) throws ServletException {
    	super.init(config);
    	factory = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
    	
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		log.info("dept called...");

		String param = request.getParameter("deptno");
		
		int deptno = 10;
		deptno = Integer.parseInt(param);
		
		DeptInfoService service = factory.getBean(DeptInfoService.class);
		Dept dept = service.getDeptInfoWithEmps(deptno);
		request.setAttribute("dept", dept);
		
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/dept/infowithemps.jsp");
		rd.forward(request, response);
	}

}
