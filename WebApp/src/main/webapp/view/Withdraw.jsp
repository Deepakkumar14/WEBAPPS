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
  width: 150px;;
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
     
     
   /* function checkCheckbox() {  
   var yes = document.getElementById("check");  
  var no = document.getElementById("check");  
  if (yes.checked == true && no.checked == true){  
    return document.getElementById("error").innerHTML = "Please mark only one checkbox ";  
   }  
  else if (yes.checked == true){  
    var y = document.getElementById("check").value;  
    return document.getElementById("result").innerHTML = y;   
   }   
  else if (no.checked == true){  
    var n = document.getElementById("check").value;  
    return document.getElementById("result").innerHTML = n;  
   }  
  else {  
    return document.getElementById("error").innerHTML = "*Please mark any of checkbox";  
  }  
}  
 */
     
	</style>
	
	
</head> 
<body>  
<form action="Main" method="post"> 
<input type="hidden" name="key" value="withdrawSubmit">
   <h1 style="text-align:center"> WITHDRAW</h1>
<table cellSpacing='20px'  class="center">
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
  <td><input type="checkbox" id="check" value="savings"><font size = 5 >Savings Account</font></td>
   <td><input type="checkbox" id="check" value="current"><font size = 5 >Current Account</font></td>
</tr>
<tr>
  <td><label for="balance"><font size = 5 >Amount:</font> </label></td>
  <td><input type="text" name="balance"/></textarea></td>
</tr>
</table>
<div class="wrapper">
<input  type="submit" value="submit"class="button"></input>
 <input type="button" value="Go back!" onclick="history.back()"class="button">

  
</form>  
</body>  
</html> 


