<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>S.D.M</title>
		
		<!-- Bootstrap Core CSS -->
	    <link href="/fcsdm/resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	    <!-- MetisMenu CSS -->
	    <link href="/fcsdm/resources/vendor/metisMenu/metisMenu.min.css" rel="stylesheet">
	    <!-- Custom CSS -->
	    <link href="/fcsdm/resources/dist/css/sb-admin-2.css" rel="stylesheet">
	    <!-- Custom Fonts -->
	    <link href="/fcsdm/resources/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
	    
	    <!-- jQuery -->
	    <script src="/fcsdm/resources/vendor/jquery/jquery.min.js"></script>
	    <!-- Bootstrap Core JavaScript -->
	    <script src="/fcsdm/resources/vendor/bootstrap/js/bootstrap.min.js"></script>
	    <!-- Metis Menu Plugin JavaScript -->
	    <script src="/fcsdm/resources/vendor/metisMenu/metisMenu.min.js"></script>
	    <!-- Custom Theme JavaScript -->
	    <script src="/fcsdm/resources/dist/js/sb-admin-2.js"></script>
    
	</head>
<body>
	<div id="wrapper">
	
		<%@ include file="/WEB-INF/views/navigator.jsp" %>
		     
        <div id="page-wrapper">
        	<div class="row">
                <div class="col-lg-12 text-center">
                    <h4>공지사항</h4>
                    <h5>현재 리그전 진행중 (~5/21)</h5>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <div class="row">
                <div class="col-lg-12 text-center">
                    <img src="/fcsdm/resources/images/sdm_pic1.jpg" width="100%" class="img-rounded" />
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- row -->            
        </div>
        <!-- /#page-wrapper -->
    </div>
    <!-- /#wrapper -->
</body>
</html>