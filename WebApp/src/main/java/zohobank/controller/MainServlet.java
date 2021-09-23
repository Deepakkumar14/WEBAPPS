package zohobank.controller;


import java.io.IOException;

import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import zohobank.model.AccountDetails;
import zohobank.model.CustomException;
import zohobank.model.CustomerDetails;
import zohobank.model.DatabaseManagement;
import zohobank.model.Helper;
import zohobank.model.Persistence;
import zohobank.model.TransactionDetails;

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
    private Helper helper=Helper.OBJECT;

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
		else if(key.equalsIgnoreCase("Main")) {
			RequestDispatcher toJsp=request.getRequestDispatcher("view/Homepage.jsp");
			toJsp.forward(request, response);
		}
		else if(key.equalsIgnoreCase("withdraw")) {
			RequestDispatcher toJsp=request.getRequestDispatcher("view/Withdraw.jsp");
			toJsp.forward(request, response);
		}
		else if(key.equalsIgnoreCase("Deposit")) {
			RequestDispatcher toJsp=request.getRequestDispatcher("view/Deposit.jsp");
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
				HashMap<String, String> successAndFailure = helper.checkPoint(details);
				for (Map.Entry entry : successAndFailure.entrySet()) {
					System.out.println(entry.getValue() + " == " + entry.getKey());
				}
				System.out.println();
			} catch (CustomException e) {
				System.out.println("Error in adding customer details in servlet");
			}
			out.println(cusInfo);
			out.println("Customer details added successfully");
		}
		else if(key.equals("DeleteCustomer")) {
			String[] allCustomerId=request.getParameterValues("customerId");
			
			for(int i=0;i<allCustomerId.length;i++) {
				int customerId=Integer.parseInt(allCustomerId[i]);
				try {
					
					String output=helper.updateAllAccounts(customerId);
					out.println(output);
					
				} catch (CustomException e) {
					e.printStackTrace();
			
				}
		}
		}
		else if(key.equals("DeleteAccount")) {
			String[] allAccount=request.getParameterValues("account");
	
			for(int i=0;i<allAccount.length;i++) {
				String[] particularAccount=allAccount[i].split(",");
				int customerId=Integer.parseInt(particularAccount[0]);
				long accountNo=Long.parseLong(particularAccount[1]);
				try {
					String output=helper.updateAccount(customerId, accountNo);
					out.println(output);
					
				} catch (CustomException e) {
					e.printStackTrace();
			
				}
		}
		}
		else if(key.equalsIgnoreCase("submitAccount")) {
			int customerId=Integer.parseInt(request.getParameter("customerId"));
			String branch=(String) request.getParameter("branch");
			BigDecimal balance = BigDecimal.valueOf(Double.parseDouble(request.getParameter("balance")));
			accInfo.setBranch(branch);
			accInfo.setBalance(balance);
			accInfo.setCustomerId(customerId);
			try {
				String output=helper.insertNewAccountDetails(accInfo);
				out.println(output);
			} catch (CustomException e) {
				out.println("Error in adding account details in servlet");
			}
		}
		else if(key.equalsIgnoreCase("withdrawSubmit")) {
			TransactionDetails transDetails = new TransactionDetails();
			int customerId=Integer.parseInt(request.getParameter("customerId"));
			long accountNo=Long.parseLong(request.getParameter("accountNo"));
			String type=(String) request.getParameter("check");
			BigDecimal balance = BigDecimal.valueOf(Double.parseDouble(request.getParameter("balance")));
			transDetails.setAccountNumber(accountNo);
			transDetails.setCustomerId(customerId);
			transDetails.setTransactionAmount(balance);
			transDetails.setTransactionType(type);
			try {
				String output=helper.withdrawal(transDetails);
				out.println(output);
			} catch (CustomException e) {
				out.println("Error in adding account details in servlet");
			}
		}
		else if(key.equalsIgnoreCase("depositSubmit")) {
			TransactionDetails transDetails = new TransactionDetails();
			int customerId=Integer.parseInt(request.getParameter("customerId"));
			long accountNo=Long.parseLong(request.getParameter("accountNo"));
			String type=(String) request.getParameter("check");
			BigDecimal balance = BigDecimal.valueOf(Double.parseDouble(request.getParameter("balance")));
			transDetails.setAccountNumber(accountNo);
			transDetails.setCustomerId(customerId);
			transDetails.setTransactionAmount(balance);
			transDetails.setTransactionType(type);
			try {
				String output=helper.deposit(transDetails);
				out.println(output);
			} catch (CustomException e) {
				out.println("Error in adding account details in servlet");
			}
		}
		else  {
			out.println("No jsp file found");
		}
		
	}

}
