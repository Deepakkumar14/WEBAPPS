package zohobank.controller;


import java.io.IOException;

import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;

import zohobank.model.AccountDetails;
import zohobank.model.CustomException;
import zohobank.model.CustomerDetails;
import zohobank.model.DatabaseManagement;
import zohobank.model.Helper;
import zohobank.model.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private  Persistence persist=new DatabaseManagement(); 
    private CustomerDetails cusInfo=new CustomerDetails();
    private AccountDetails accInfo=new AccountDetails();
    private Helper helper=new Helper();

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		doPost(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
	
		//doGet(request, response);
		response.setContentType("text/html/jsp");  
		PrintWriter out=response.getWriter();
		String key=request.getParameter("key");
		
		if(key.equalsIgnoreCase("customer")) {
				ArrayList<CustomerDetails> list = null;
						try {
							list = persist.dataRetrievalOfCustomer();
						} catch (CustomException e) {
							e.printStackTrace();
						}
			request.setAttribute("list", list);
			request.getRequestDispatcher("view/CustomerHandler.jsp").forward(request, response);
		}
		
		else if(key.equalsIgnoreCase("Account")) {
			ArrayList<AccountDetails> accountList = null;
			try {
				accountList = persist.dataRetrievalOfAccount();
			} catch (CustomException e) {
				e.printStackTrace();
			}
			System.out.println(accountList);
            request.setAttribute("accountList", accountList);
            request.getRequestDispatcher("view/AccountHandler.jsp").forward(request, response);
		}
		
		else if(key.equalsIgnoreCase("Transaction")) {
			RequestDispatcher toJsp=request.getRequestDispatcher("view/Transaction.jsp");
			toJsp.forward(request, response);
		}
		
		else if(key.equalsIgnoreCase("AddAccount")) {
			RequestDispatcher toJsp=request.getRequestDispatcher("view/Account.jsp");
			toJsp.forward(request, response);
		}
		
		else if(key.equalsIgnoreCase("AddCustomer")) {
			RequestDispatcher toJsp=request.getRequestDispatcher("view/Customer.jsp");
			toJsp.forward(request, response);
		}
		
		else if(key.equalsIgnoreCase("submitCustomer")) {
			ArrayList<ArrayList> details = new ArrayList<>();
			ArrayList innerArrayList = new ArrayList(2);
			String customer_name=(String) request.getParameter("customerName");
			String city=(String) request.getParameter("city");
			String branch=(String) request.getParameter("branch");
			BigDecimal balance = BigDecimal.valueOf(Double.parseDouble(request.getParameter("balance")));
			accInfo.setBranch(branch);
			accInfo.setBalance(balance);
			cusInfo.setCity(city);
			cusInfo.setFullName(customer_name);
			innerArrayList.add(cusInfo);
			innerArrayList.add(accInfo);
			details.add(innerArrayList);
			
			try {
				helper.checkPoint(details);
			} catch (CustomException e) {
				System.out.println("Error in add customer details in servlet");
			}
			out.println("Customer details added successfully");
		}
		else  {
			out.println("No jsp file found");
		}
		
		
	}

}
