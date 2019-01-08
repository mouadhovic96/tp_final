<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>


<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<title>Insert title here</title>
 <style>
 #email
{
    display:none;
    visibility:hidden;
}

  #tconv{
   
  margin-left: 10px;
  margin-top: 10px;
 
 
  }
 #btnsub{
   
    margin-left: 10px;
 
 }
 #conv{
   
  margin-left: 10px;
  margin-top: 10px;
 
 
  }
 
 #wrapper {
width:400px;
height:350px;
margin-top: 40px;
margin-left: 490px;
border-radius:30px;
font-family: helvetica;
font-size:1.2em;
border: 1px solid grey;
background-color: appworkspace;
}
#welcomme{
   margin-left: 320px;
   margin-top: 30px;
    
    
    
}
.form-group{
   
    width:300px;
    
}
 
 
 
 
 </style>
</head>
<body>
<nav class="navbar navbar-dark bg-dark">
 <h2>CLOCO</h2>
</nav>

<div id="welcomme">
            
            
        </div>
    <div id="wrapper">
<form action="uploadFile"    enctype="multipart/form-data" method="post">
  
  
              <div class="col-12 col-md-9 mb-2 mb-md-0">
                  <input type="email" class="form-control form-control-lg" id="email" name="email" value="<%= (String)request.getAttribute("email") %>">
                </div>

  <div id="tconv" class="form-group">
    <label for="exampleFormControlSelect1">Type de Conversion</label>
    <select class="form-control" name="option" id="exampleFormControlSelect1">
      <option>pdftoword</option>
      <option>wordtopdf</option>
        <option>pdftopptx</option>
        <option>pptxtopdf</option>
        
    </select>
  </div>
  <div id="conv" class="input-group mb-3">
  <div class="custom-file">
    <input type="file" class="file-input" name="file1" id="inputGroupFile02" value="file choisie">

  </div>
  
</div>
 
  
<button id="btnsub"type="submit" class="btn btn-primary btn-lg">Converti</button>
<a href=<%= (String)request.getAttribute("path") %>><button type="button">Download</button></a>
</form>
</div>

</body>
</html>