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
.button{
 margin:20 30px;
  width: 250px;;
 padding: 14px 40px;
  font-size: 20px;
  display:inline-block;
  }
  body{
        	background-color:#98FB98;
        	}
     .button a{
     text-decoration:none;
     }
	</style>
	
	
</head> 
<body>  
<form action="Main" method="post"> 
<input type="hidden" name="key" value="withdrawSubmit">
   <h1 style="text-align:center"> WITHDRAW</h1>
<table cellSpacing='20px'  class="center">
  <tr>
  <td><label for="customerId"><font size = 5 >Customer Id: </font></label></td>
  <td><textarea row="2" col="5" name="customerId"/></textarea></td>
</tr>
<tr>
  <td><label for="accountNo"><font size = 5 >Account Number:</font> </label></td>
  <td><textarea row="2" col="5" name="accountNo"/></textarea></td>
</tr>
<tr>
  <td><label for="type"><font size = 5 >Transaction Type:</font> </label></td>
  <td><input type="checkbox" name="check" value="savings"><font size = 5 >Savings Account</font></td>
   <td><input type="checkbox" name="check" value="current"><font size = 5 >Current Account</font></td>
</tr>
<tr>
  <td><label for="balance"><font size = 5 >Amount:</font> </label></td>
  <td><textarea row="2" col="5" name="balance"/></textarea></td>
</tr>
</table>
<div class="wrapper">
<input type="submit" value="submit"class="button"></input>
 <input type="button" value="Go back!" onclick="history.back()"class="button">

  
</form>  
</body>  
</html> 


