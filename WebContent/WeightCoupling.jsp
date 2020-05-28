<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="resources.*"%>
<%
	if (request != null) {
	String loc = DataModel.map.get(request.getParameter("fileName"));
	request.getSession().setAttribute("file", loc);
}
%>

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

.button {
	background-color: #660029;
	border: none;
	color: white;
	padding: 15px 32px;
	text-align: right;
	text-decoration: none;
	display: inline-block;
	font-size: 16px;
	margin: 4px 2px;
	cursor: pointer;
}

h2.headertekst {
	text-align: center;
}
</style>
<meta charset="ISO-8859-1">
<title>Coulping</title>
</head>
<body>
	<h2 class="headertekst" Weights related to the coupling factor></h2>
	<form method="post">
		<table style="width: 100%">
			<tr>
				<th>Coupling Type</th>
				<th>Weight</th>
			</tr>
			<tr>
				<td>A recursive call</td>
				<td><input type="text" id="t1" name="wR" value="0" size="2"><br>
					<br></td>

			</tr>
			<tr>
				<td>A regular method calling another regular method in the same
					file</td>
				<td><input type="text" id="t2" name="wMcms" value="0" size="2"><br>
					<br></td>

			</tr>
			<tr>
				<td>A regular method calling another regular method in a
					different file</td>
				<td><input type="text" id="t3" name="wMcmd" value="3" size="2"><br>
					<br></td>

			</tr>
			<tr>
				<td>A regular method calling a recursive method in the same
					file</td>
				<td><input type="text" id="t4" name="wMcrms" value="3" size="2"><br>
					<br></td>

			</tr>
			<tr>
				<td>A regular method calling a recursive method in a different
					file</td>
				<td><input type="text" id="t5" name="wMcrmd" value="4" size="2"><br>
					<br></td>

			</tr>
			<tr>
				<td>A recursive method calling another recursive method in the
					same file</td>
				<td><input type="text" id="t6" name="wRmcrms" value="4"
					size="2"><br> <br></td>

			</tr>
			<tr>
				<td>A recursive method calling another recursive method in a
					different file</td>
				<td><input type="text" id="t6" name="wRmcrmd" value="5"
					size="2"><br> <br></td>

			</tr>
			<tr>
				<td>A recursive method calling a regular method in the same
					file</td>
				<td><input type="text" id="t7" name="wRmcms" value="3" size="2"><br>
					<br></td>

			</tr>
			<tr>
				<td>A recursive method calling a regular method in a different
					file</td>
				<td><input type="text" id="t8" name="wRmcmd" value="4" size="2"><br>
					<br></td>

			</tr>
			<tr>
				<td>A regular method referencing a global variable in the same
					file</td>
				<td><input type="text" id="t9" name="wMrgvs" value="1" size="2"><br>
					<br></td>

			</tr>
			<tr>
				<td>A regular method referencing a global variable in a
					different file</td>
				<td><input type="text" id="t10" name="wMrgvd" value="2"
					size="2"><br> <br></td>

			</tr>
			<tr>
				<td>A recursive method referencing a global variable in the
					same file</td>
				<td><input type="text" id="t11" name="wRmrgvs" value="1"
					size="2"><br> <br></td>

			</tr>
			<tr>
				<td>A recursive method referencing a global variable in a
					different file</td>
				<td><input type="text" id="t12" name="wRmrgvd" value="2"
					size="2"><br> <br></td>

			</tr>


		</table>

		<input class="button" type="submit" value="save">

	</form>
	<form>

		<input type="hidden"
			value="<%String s = (String) session.getAttribute("loc");
			out.print(s);
			session.removeAttribute("loc");%>">
		<a href="Output.jsp" class="button">Measure</a>
	</form>

</body>

</body>
</html>