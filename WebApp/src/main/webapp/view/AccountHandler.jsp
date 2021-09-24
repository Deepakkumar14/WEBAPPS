<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>  
<head>  
    <title>Account page</title> 
    
     
	<style>
	table{
	border-collapse: collapse;
	}
	.center {
  margin-left: auto;
  margin-right: auto;
}
.wrapper{
  
 text-align: center;
   margin-left:-20px;
    margin-right:-20px;
   
 line-height:50px;
}
body{
        	background-color:#98FB98;
        	}
.button{
 margin:20 30px;
  width: 150px;;
 padding: 14px 40px;
  font-size: 20px;
  display:inline-block;
}
     .button a{
     text-decoration:none;
     }
	</style>
	
	
</head> 
<body> 
<form action="Main" method="post"> 
<input type="hidden" name="key" value="DeleteAccount"> 
  <h1 style="text-align:center">Account Gallery</h1> 
  <table Border='1' cellSpacing='10px' cellpadding='10px' class='center'>
            <thead>
                <tr>
                <th>Check</th>
                    <th>CustomerId</th>
                    <th>AccountNumber</th>
                    <th>Branch</th>
                     <th>AccountBalance</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${accountList}" var="accountList">
                <tr>
               <td> <input type="checkbox" name="account" value="${accountList.customerId},${accountList.accountNumber}"> </td>
					<td><c:out value="${accountList.customerId}" /></td>
                   <td><c:out value="${accountList.accountNumber}" /></td>
                    <td><c:out value="${accountList.branch}" /></td>
                    <td><c:out value="${accountList.balance}" /></td>
                </tr>
                </c:forEach>   
            </tbody>
        </table>
 


<div class="wrapper">
<a href="Main?key=AddAccount">
  <input type="button" value="ADD" class="button"></input></a>
  <input type="submit" value="DELETE" class="button">
  <input type="button" value="Go back!" onclick="history.back()" class="button"></input>
 
</div>
</form>
     
</body>  
</html>  

