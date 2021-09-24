<html>  
<head>  
    <title>Customer page</title>  
    
    
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
<input type="hidden" name="key" value="depositSubmit">
   <h1 style="text-align:center"> DEPOSIT</h1>
 
<table  cellpadding=10px   class="center">
  <tr>
  <td><label for="customerId"><font size = 5 >Customer Id: </font></label></td>
  <td><input type="text" name="customerId"/></textarea></td>
</tr>
<tr>
  <td><label for="accountNo"><font size = 5 >Account Number:</font> </label></td>
  <td><input type="text" name="accountNo"/></textarea></td>
</tr>
<tr>
  <td><label for="type"><font size = 5 >Transaction Type:</font> </label></td>
  <td><input type="checkbox" name="check" value="savings"><font size = 5 >Savings Account</font></td>
   <td><input type="checkbox" name="check" value="current"><font size = 5 >Current Account</font></td>
</tr>
<tr>
  <td><label for="balance"><font size = 5 >Amount:</font> </label></td>
  <td><input type="text" name="balance"/></textarea></td>
</tr>
</table>
<div class="wrapper">
<input type="submit" value="submit"class="button"></input>
 <input type="button" value="Go back!" onclick="history.back()"class="button">

  
</form>  
</body>  
</html> 


