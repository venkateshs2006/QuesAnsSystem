
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<script type="text/javascript" src="resources/jquery.min.js"></script>
<script src="resources/jquery-ui.js"></script>
<link rel="stylesheet" href="resources/jquery-ui.css" />
<link
	href="http://fonts.googleapis.com/css?family=Source+Sans+Pro:200,300,400,600,700,900"
	rel="stylesheet" />
<link href="resources/default.css" rel="stylesheet" type="text/css"
	media="all" />
<link href="resources/fonts.css" rel="stylesheet" type="text/css"
	media="all" />
<style type="text/css">
#mySubmit {
	font-family: 'Oleo Script', cursive;
	font-size: 18px;
	border: 1px solid #000;
	padding: 5px 10px;
	border: 1px solid rgba(51, 51, 51, .5);
	-webkit-border-radius: 10px;
	-moz-border-radius: 10px;
	border-radius: 10px;
	-webkit-box-shadow: 2px 1px 1px #aaa;
	-moz-box-shadow: 2px 1px 1px #aaa;
	box-shadow: 2px 1px 1px #aaa;
	cursor: pointer;
}

table[class=modern] tr:nth-child(odd)		{ background-color:#f5ccff; }
table[class=modern] tr:nth-child(even)		{ background-color:#fff; }
ul{
    margin:0;
    padding:0;
    width:100%;
}
 
li{
    width:33.3%;
    height:30px;
    float:left;
    color:#191919;
    text-align:center;
    overflow:hidden;
}
 
li a{
    color:#FFF;
    text-decoration:none;
}
 .subtext{
        padding-top:15px;
    }
 
/*Menu Color Classes*/
.green{background:#6AA63B;}
.yellow{background:#FBC700;}
.red{background:#D52100;}
.purple{background:#5122B4;}
.blue{background:#0292C0;}

</style>


<!--[if IE 6]><link href="default_ie6.css" rel="stylesheet" type="text/css" /><![endif]-->

</head>
<body>
	<div id="header-wrapper">
		<div id="header" class="container">
			<div id="logo">
				<h3>
					<span class="fa fa-bolt"></span><a href="#">Interrogative
						System</a>
				
				<span class="fa fa-bolt" style="margin-left:550px;text-align:left;">Welcome <b style="color:white;"><%
HttpSession session2 = request.getSession();
 
if("Admin"==session2.getAttribute("userName")){%>${sessionScope.userName}
     
  <%  }
else{
	out.println("<b>Invalid Session </b>");
    response.sendRedirect("http://localhost:8080/quesans/logout");
    
    }
%> </b><a style="color:brown;" href="/quesans/logout">Logout</a>
				</span></h3>
			</div>

		</div>
	</div>
	<div id="header-featured" style="height: 10px;">
	<ul style="margin-top:-150px;">
        <li class="blue" >
            <p><a href="QUESIndex">List Of Question</a></p>
        </li>
        <li class="yellow">
            <p><a href="SEIndex">List of Search Engine</a></p>
        </li>
        <li class="red">
            <p><a href="KEYIndex">List of Search Keyword</a></p>
        </li>        
    </ul>
		<div id="banner-wrapper">
			<div id="banner" class="container" style="margin-top:-130px;">
<center>
				<form:form method="POST" action="KEYSave"
					commandName="searchKeyword" modelAttribute="searchKeyword">
					<table >
						<tr>
							<th colspan="2">Add Keyword</th>
						</tr>
						<tr>
							<td><form:label path="keywordid">Keyword ID:</form:label></td>
							<td><form:input path="keywordid"
									value="${searchKeyword.keywordid}" default="" /></td>
						</tr>
						<tr>
							<td><form:label path="searchengineid">SearchEngine ID:</form:label></td>
							<td><form:input path="searchengineid"
									value="${searchKeyword.searchengineid}"  /></td>
						</tr>
						<tr>
							<td><form:label path="quesid">Question ID:</form:label></td>
							<td><form:input path="quesid"
									value="${searchKeyword.quesid}" /></td>
						</tr>
						<tr>
							<td><form:label path="keyword">Keyword:</form:label></td>
							<td><form:input path="keyword"
									value="${searchKeyword.keyword}"/></td>
						</tr>
						
												<tr>
							<td  align="center"><input type="submit" value="Submit" /></td>
							<td  align="center"><input type="reset" value="clear" /></td>
						</tr>
					</table>
				</form:form>

</center>
			</div>
		</div>
	</div>
	<div id="wrapper">
		<div id="featured-wrapper">
			<div id="featured" class="extra2 margin-btm container">
				<div class="main-title">
					
	<c:if test="${!empty searchKeywordList}">
		<h3>Search Engine List</h3>
		<table align="center" border="1"  cellspacing=0 style="border-bottom-style: solid;" class="modern">
			<tr style="background-color:gray;color:White;">
				<th>Keyword ID</th>
				<th>SearchEngine ID</th>
				<th>Question ID</th>
				<th>Keyword</th>
				<th>Action</th>
			</tr>

			<c:forEach items="${searchKeywordList}" var="searchKeyword">
				<tr>
					<td style="color:black;"><c:out value="${searchKeyword.keywordid}" /></td>
					<td style="color:black;"><c:out value="${searchKeyword.searchengineid}" /></td>
					<td style="color:black;"><c:out value="${searchKeyword.quesid}" /></td>
					<td style="color:black;"><c:out value="${searchKeyword.keyword}" /></td>
					<td align="center" style="color:black;"><b><a
						href="KEYEdit?keywordid=${searchKeyword.keywordid}">Edit</a>
						| <a href="KEYDelete?keywordid=${searchKeyword.keywordid}">Delete</a></b></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
				
			</div>

		</div>
	</div>
	</div>

	<div id="copyright" class="container">
		<p>&copy; Interrogative System. All rights reserved.</p>
	</div>
</body>
</html>
