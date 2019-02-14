package com.webservice.client;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HomeController
 */
@WebServlet("/deptInfo")
public class DeptInfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeptInfoController() {
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
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("DeptInfoController 호출 ");
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		/*
		DeptProcessImplService deptService = new DeptProcessImplService();
		DeptProcess port = deptService.getDeptProcessImplPort();
		
		List<DeptVo> deptList = new ArrayList<DeptVo>();
		for (int i = 0; i < port.processDept().size(); i++) {
			DeptVo deptVo = port.processDept().get(i);
			deptList.add(deptVo);
		}
		
		request.setAttribute("deptList", deptList);
		*/
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/dept.jsp");
		dispatcher.forward(request, response);
	}

}
