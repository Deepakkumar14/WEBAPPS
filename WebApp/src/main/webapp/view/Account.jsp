<html>  
<head>  
    <title>Welcome page</title>  
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
  width: 250px;;
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
<input type="hidden" name="key" value="submitAccount">
   <h1 style="text-align:center">Account Registration</h1>
<table cellpadding=10px  class="center">
  <tr>
  <td><font size = 5 ><label for="customerId">Customer Id: </label></font></td>
  <td><textarea row="2" col="5"  name="customerId"/></textarea></td>
</tr>
<tr>
  <td><label for="branch"><font size = 5 >Branch: </label></font></td>
  <td><textarea row="2" col="5" name="branch"/></textarea></td>
</tr>
<tr>
  <td><label for="balance"><font size = 5 >Balance: </label></font></td>
  <td><textarea row="2" col="5" name="balance"/></textarea></td>
</tr>
</table>

<div class="wrapper">
<input type="submit" value="submit"class="button"></input>
 <input type="button" value="Go back!" onclick="history.back()"class="button">

  
</form>  
</body>  
</html> 


         