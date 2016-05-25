<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/tags.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
<title>Blog 001</title>
<!-- 
<link rel="stylesheet" href="css/main.css" type="text/css" media="screen"/>
<link rel="stylesheet" href="scripts/jquery/ui/base/jquery.ui.all.css" type="text/css" media="screen"/>
<link rel="stylesheet" href="scripts/jquery/nyromodal/styles/nyroModal.full.css" type="text/css" media="screen"/>
<link rel="stylesheet" href="scripts/jquery/table_sorter/blue/style.css" type="text/css" media="screen"/>
-->

<!--
<script type="text/javascript" src="scripts/main.js"></script>
<script type="text/javascript" src="scripts/jquery/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="scripts/jquery/ui/jquery-ui-1.8.custom.min.js"></script>
<script type="text/javascript" src="scripts/jquery/nyromodal/js/jquery.nyroModal-1.6.2.min.js"></script>
<script type="text/javascript" src="scripts/jquery/table_sorter/jquery.tablesorter.js"></script>
<script type="text/javascript" src="scripts/jquery/table_sorter/jquery.tablesorter.pager.js"></script>
<script type="text/javascript" src="scripts/jquery/bassistance/validate/jquery.validate.js"></script>
<script type="text/javascript" src="scripts/jquery/bassistance/validate/jquery.form.js"></script>
 -->
<tiles:insert attribute="extraScripts"/>
</head>
<body>
<div id="wrapper">
	<div id="contents">
		<div class="header"><tiles:insert attribute="header"/></div>
		<div id="middle-contents" class="clearfix">
			<div id="left-col">
				<div class="content"><tiles:insert attribute="content"/></div>
			</div>
		</div>
	</div>
	<div class="footer"><tiles:insert attribute="footer"/></div>
</div>
</body>
</html>