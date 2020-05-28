<%@page import="java.util.Map"%>
<%@page import="utilpack.Method"%>
<%@page import="java.util.HashMap"%>
<%@page import="utilpack.ProcessFiles"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html>
<head>
<style>
table {
	font-family: arial, sans-serif;
	border-collapse: collapse;
	width: 100%;
}

td, th {
	border: 1px solid #dddddd;
	text-align: left;
	padding: 8px;
}

tr:nth-child(even) {
	background-color: #dddddd;
}

.button {
	background-color: #660029;
	border: none;
	color: white;
	padding: 15px 32px;
	text-align: right;
	text-decoration: none;
	display: inline-block;
	font-size: 16px;
	margin: 2px 2px;
	cursor: pointer;
}
</style>
</head>
<body>
	<h2>Coupling</h2>

	<%
		ProcessFiles pf = new ProcessFiles();
	pf.StartCalculate();
	%>


	<table>
		<tr>

			<th scope="col">Program Mehods</th>
			<th scope="col">Nr</th>
			<th scope="col">Nmcms</th>
			<th scope="col">Nmcmd</th>
			<th scope="col">Nmcrms</th>
			<th scope="col">Nmcrmd</th>
			<th scope="col">Nrmcrms</th>
			<th scope="col">Nrmcrmd</th>
			<th scope="col">Nrmcms</th>
			<th scope="col">Nrmcmd</th>
			<th scope="col">Nmrgvs</th>
			<th scope="col">Nmrgvd</th>
			<th scope="col">Nrmrgvs</th>
			<th scope="col">Nrmrgvd</th>
			<th scope="col">Ccp</th>
		</tr>

		<%
			HashMap<String, Method> methodMapjsp = new HashMap<String, Method>();
		methodMapjsp.putAll(pf.methodMap);
		for (Map.Entry<String, Method> readlines : methodMapjsp.entrySet()) {
			System.out.println("line " + readlines.getKey());
		%>
		<tr>

			<td>
				<%
					out.print(readlines.getKey());
				%>
			</td>
			<td>
				<%
					out.print(readlines.getValue().getnR());
				%>
			</td>
			<td>
				<%
					out.print(readlines.getValue().getnMcms());
				%>
			</td>
			<td>
				<%
					out.print(readlines.getValue().getnMcmd());
				%>
			</td>
			<td>
				<%
					out.print(readlines.getValue().getnMcrms());
				%>
			</td>
			<td>
				<%
					out.print(readlines.getValue().getnMcrmd());
				%>
			</td>
			<td>
				<%
					out.print(readlines.getValue().getnRmcrms());
				%>
			</td>
			<td>
				<%
					out.print(readlines.getValue().getnRmcrmd());
				%>
			</td>
			<td>
				<%
					out.print(readlines.getValue().getnRmcms());
				%>
			</td>
			<td>
				<%
					out.print(readlines.getValue().getnRmcmd());
				%>
			</td>
			<td>
				<%
					out.print(readlines.getValue().getnMrgvs());
				%>
			</td>
			<td>
				<%
					out.print(readlines.getValue().getnMrgvd());
				%>
			</td>
			<td>
				<%
					out.print(readlines.getValue().getnRmrgvs());
				%>
			</td>
			<td>
				<%
					out.print(readlines.getValue().getnRmrgvd());
				%>
			</td>
			<td>
				<%
					out.print(readlines.getValue().getCcp());
				%>
			</td>
		<tr>
			<%
				}
			%>
		
	</table>

	<a href="WeightCoupling.jsp" class="button">Back</a>

</body>
</html>
