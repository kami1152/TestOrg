package com.chapter1;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chapter1.dao.UserDAO;
import com.chapter1.vo.UserVO;

/**
 * Servlet implementation class UsersServlet
 */
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	UserDAO usersDAO = new UserDAO();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserServlet() {
		super();
		System.out.println("git");
		System.out.println("tet git");
		System.out.println("tet git2");
		System.out.println("tet git123");
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doService(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doService(request, response);
	}

	// 공통 처리 함수
	private void doService(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 한글 설정
		request.setCharacterEncoding("utf-8");

		String action = request.getParameter("action");
		switch (action) {
		case "list" -> list(request, response);
		case "view" -> view(request, response);
		case "delete" -> delete(request, response);
		case "updateForm" -> updateForm(request, response);
		case "update" -> update(request, response);
		case "insertForm" -> insertForm(request, response);
		case "insert" -> insert(request, response);
		}

		// 3. jsp 포워딩
		// 포워딩
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/users/" + action + ".jsp");
		rd.forward(request, response);

	}

	private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("목록");

		// 1. 처리
		List<UserVO> list = usersDAO.list();

		// 2. jsp출력할 값 설정
		request.setAttribute("list", list);

	}

	private void view(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("상세보기");
		String userid = request.getParameter("userid");
		// 1. 처리
		UserVO user = usersDAO.read(userid);

		// 2. jsp출력할 값 설정
		request.setAttribute("user", user);
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("삭제");
		String userid = request.getParameter("userid");
		// 1. 처리
		int updated = usersDAO.delete(userid);

		// 2. jsp출력할 값 설정
		request.setAttribute("updated", updated);
	}

	private void updateForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("수정화면");
		String userid = request.getParameter("userid");
		// 1. 처리
		UserVO user = usersDAO.read(userid);

		// 2. jsp출력할 값 설정
		request.setAttribute("user", user);
	}

	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("수정");
		String userid = request.getParameter("userid");
		String userpassword = request.getParameter("userpassword");
		String username = request.getParameter("username");
		String userage = request.getParameter("userage");
		String useremail = request.getParameter("useremail");
		String userjob = request.getParameter("userjob");
		String userhobby = request.getParameter("userhobby");

		UserVO user = new UserVO();
		user.setUserid(userid);
		user.setUserpassword(userpassword);
		user.setUsername(username);
		user.setUserage(Integer.parseInt(userage));
		user.setUseremail(useremail);
		user.setUserjob(userjob);
		user.setUserhobby(userhobby);

		// 1. 처리
		int updated = usersDAO.update(user);

		// 2. jsp출력할 값 설정
		request.setAttribute("updated", updated);
	}

	private void insertForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("등록화면");
		// 1. 처리

		// 2. jsp출력할 값 설정
	}

	private void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("등록");

		UserVO user = new UserVO();
		int updated = usersDAO.insert(user);
		// 2. jsp출력할 값 설정
		request.setAttribute("updated", updated);
	}

	private UserVO createUsers(HttpServletRequest request) {
	
		request.getParameterMap();
		UserVO user = new UserVO();
		user.setUserid(request.getParameter("userid"));
		user.setUserpassword(request.getParameter("userpassword"));
		user.setUsername(request.getParameter("username"));
		user.setUserage(Integer.parseInt(request.getParameter("userage")));
		user.setUseremail(request.getParameter("useremail"));
		user.setUserhobby(request.getParameter("userhobby"));
		user.setUserjob(request.getParameter("userjob"));
		return user;
	}

}