<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<HTML><head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>南山人事管理系统</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="js/jquery.js"></script>

<script type="text/javascript">
$(function(){	
	//导航切换
	$(".menuson li").click(function(){
		$(".menuson li.active").removeClass("active")
		$(this).addClass("active");
	});
	
	$('.title').click(function(){
		var $ul = $(this).next('ul');
		$('dd').find('ul').slideUp();
		if($ul.is(':visible')){
			$(this).next('ul').slideUp();
		}else{
			$(this).next('ul').slideDown();
		}
	});
})	
</script>


</head>

<body style="background:#f0f9fd;">
	<div class="lefttop"><span></span>管理菜单</div>
    
    <dl class="leftmenu">
        
    <dd>
    <div class="title">
    <span><img src="images/leftico01.png" /></span>员工资料管理</div>
    	<ul class="menuson">
        <li><cite></cite><a href="${request.contextPath}/MySSH/userqueryaction.action" target="rightFrame">查看员工</a><i></i></li>
        <li><cite></cite><a href="upload.jsp" target="rightFrame">上传员工资料</a><i></i></li>
        <li><cite></cite><a href="download.jsp" target="rightFrame">下载员工资料</a><i></i></li>
        </ul>    
    </dd>
        
    
    <dd>
    <div class="title">
    <span><img src="images/leftico02.png" /></span>工资查询</div>
    <ul class="menuson">
      <li><cite></cite><a href="right10.html" target="rightFrame">查看工资记录</a><i></i></li>
        </ul>     
    </dd> 
    
    
    <dd>
      <div class="title"><span><img src="images/leftico03.png" /></span>员工管理</div>
      <ul class="menuson">
        <li><cite></cite><a href="${request.contextPath}/MySSH/userquery.action" target="rightFrame">管理员工</a><i></i></li>
		 <li><cite></cite><a href="search.jsp" target="rightFrame">员工查询</a><i></i></li>
		<li><cite></cite><a href="tab2.html"target="rightFrame">员工报道</a><i></i></li>         
    </ul>    
    </dd>  
    
    
    <dd>
      <div class="title"><span><img src="images/leftico04.png" /></span>部门管理</div>
      <ul class="menuson">
         <li><cite></cite><a href="imgtable1.html" target="rightFrame">管理部门</a><i></i></li>
        <li><cite></cite><a href="right11.html"target="rightFrame">部门人数汇总及明细</a><i></i></li>
    </ul>
    </dd>
	
	   
     <dd>
      <div class="title"><span><img src="images/leftico04.png" /></span>薪资管理</div>
      <ul class="menuson">
        <li><cite></cite><a href="right8.html" target="rightFrame">管理员工薪资</a><i></i></li>
        <li><cite></cite><a href="right9.html" target="rightFrame">员工薪资明细</a><i></i></li>
 
    </ul>
   </dd>  
    
	 <dd>
      <div class="title"><span><img src="images/leftico04.png" /></span>安全管理</div>
      <ul class="menuson">
        <li><cite></cite><a href="imgtable2.html" target="rightFrame">身份管理</a><i></i></li>
         <li><cite></cite><a href="imgtable3.html" target="rightFrame">系统日志</a><i></i></li>
    </ul>
	
    </dd>   
	
    </dl>
    

</body></HTML>
