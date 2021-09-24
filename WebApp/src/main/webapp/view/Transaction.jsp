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
.button{
 margin:20 30px;
  width: 250px;
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
 <h1 style="text-align:center">Transaction Page</h1> 
 
 

<div class="wrapper">
<a href="Main?key=Withdraw">
  <input type="button" value="WITHDRAW" class="button"></input></a>
  <a href="Main?key=Deposit">
  <input type="button" value="DEPOSIT"class="button"> </a><br>
   <input type="button" value="Go back!" onclick="history.back()" class="button">
  
</form>  
</body>  
</html>  