<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<jsp:useBean id="cidadeBean" class = "br.com.projetowebjspdao.bean.CidadeBean" 
scope = "session"/>
 
    
<%

	String idExcluir = request.getParameter("idExcluir");
	String mensagem = "";
	
	if(idExcluir != null){
		mensagem = cidadeBean.deletar(Integer.parseInt(idExcluir));
		out.println();
	}

 %>   
    
    
    
 <script type="text/javascript"> 
 function nova() { 
 location.href = "CidadeCreate.jsp"; 
 } 
 function voltar() { 
location.href = "../index.jsp"; 
 } 
</script> 
   
     
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista de Cidades</title>
</head>
<body>

	<form method="POST">
		<div id="cadastro">
			<fieldset>
				<legend>Cidades Cadastradas</legend>
				<table border="1">
					<tr>
						<td>COD.</td>
						<td>DESCRIÇÃO</td>
						<td>UF</td>
						<td>AÇÃO</td>
					</tr>
				</table>
			</fieldset>
		</div>
		<hr />
		<input type="button" value="Novo" onclick="nova()">
		<input type="button" value="Voltar" onclick="voltar()"> 
 </form> 
 </body> 
</html>
		
		
		
		
		
		
		
		
		
		
