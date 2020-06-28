package com.unisys.web.servlets;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.unisys.model.Customer;

@WebServlet("/el-demo")
public class ELDemoServlet extends HttpServlet {

	private static final long serialVersionUID = 5936900616865155705L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		Integer count = (Integer) session.getAttribute("count");
		if(count==null) {
			count = 0;
		}
		count++;
		session.setAttribute("count", count);
		
		Integer count1 = (Integer) req.getAttribute("count");
		if(count1==null) {
			count1 = 0;
		}
		count1++;
		req.setAttribute("count", count1);
		
		Integer count2 = (Integer) getServletContext().getAttribute("count");
		if(count2==null) {
			count2 = 0;
		}
		count2++;
		getServletContext().setAttribute("count", count2);

		Customer c1 = new Customer(1, "Vinod Kumar", "vinod@vinod.co", "9731424784", "Bangalore");
		req.setAttribute("customer", c1);
		
		List<Customer> list = Arrays.asList(
				new Customer(1, "Vinod Kumar", "vinod@vinod.co", "9731424784", "Bangalore"),
				new Customer(2, "Shyam", "shyam@exmaple.com", "928272722", "Bangalore"),
				new Customer(3, "John", "john@xmpl.com", "5554443333", "Dallas"),
				new Customer(4, "Jane", "jane@xmpl.com", "5554443222", "Newyork")
				);
		req.setAttribute("customerList", list);
		
		req.getRequestDispatcher("/WEB-INF/views/el-demo.jsp").forward(req, resp);
	}
}
















