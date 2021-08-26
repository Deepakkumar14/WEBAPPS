<html>  
<head>  
    <title>Welcome page</title>  
<style>
.center {
  margin-left: auto;
  margin-right: auto;
}</style>

</head> 
<body>  
<form action="Main" method="post"> 
<input type="hidden" name="key" value="submitCustomer">
   <h1 style="text-align:center">Customer Registration</h1>
<table cellSpacing='10px' class="center">
  <tr>
  <td><label for="customerName">Name: </label></td>
  <td><input type="text" name="customerName"/></td>
</tr>
<tr>
<td><label for="city">City: </label></td>
<td><input type="text" name="city"/></td>
</tr>
<tr>
  <td><label for="branch">Branch: </label></td>
  <td><input type="text" name="branch"/></td>
</tr>
<tr>
  <td><label for="balance">Balance: </label></td>
  <td><input type="text" name="balance"/></td>
</tr>
</table>

<input type="submit" value="submit"/></input>
 <input type="button" value="Go back!" onclick="history.back()">

  
</form>  
</body>  
</html> 


         