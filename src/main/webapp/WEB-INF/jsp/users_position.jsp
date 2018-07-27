<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>pos</title>
<script type="text/javascript" src="https://webapi.amap.com/maps?v=1.4.6&key=3680a4e85ac740bd8ec87049083e6d96"></script> 
<link href="<%=request.getContextPath()%>/resources/css/bootstrap.min.css" rel="stylesheet" type="text/css">
  <style type="text/css">
        #panel {
            position: absolute;
            background-color: white;
            max-height: 90%;
            overflow-y: auto;
            top: 178px;
            right: 10px;
            width: 280px;
        }
    </style>
<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/style.js"></script>
<link href="<%=request.getContextPath()%>/resources/css/style.css" rel="stylesheet" type="text/css">
</head>

<body>
<div id="container"> 
<jsp:include page="frame.jsp" />

<div id="map">

</div>
<div id="panel"></div>
</div>
</body>
<script type="text/javascript">
 (function() { 
	 var map,geolocation;
	 map = new AMap.Map('map', {
	        resizeEnable: true
	    });
	 map.setZoom(15);
	 map.plugin(['AMap.Scale','AMap.MapType','AMap.OverView','AMap.ToolBar'],function(){
		 var scale = new AMap.Scale();
		 var type = new AMap.MapType();
		 var view = new AMap.OverView();
		 view.open();
		 var tool = new AMap.ToolBar();
		 map.addControl(scale);
		 map.addControl(type);
		 map.addControl(view);
		 map.addControl(tool);	 
	 });
	 
	 map.plugin('AMap.Geolocation', function() {
	        geolocation = new AMap.Geolocation({
	            enableHighAccuracy: true,//是否使用高精度定位，默认:true
	            timeout: 10000,          //超过10秒后停止定位，默认：无穷大
	            buttonOffset: new AMap.Pixel(10, 20),//定位按钮与设置的停靠位置的偏移量，默认：Pixel(10, 20)
	            zoomToAccuracy: false,      //定位成功后调整地图视野范围使定位位置及精度范围视野内可见，默认：false
	            buttonPosition:'RB'
	        });
	        map.addControl(geolocation);
	        geolocation.getCurrentPosition();
	        AMap.event.addListener(geolocation, 'complete', onComplete);//返回定位信息
	        AMap.event.addListener(geolocation, 'error', onError);      //返回定位出错信息
	        
	    });
	    //解析定位结果
	    function onComplete(data) {
	        var str=['定位成功'];
	        str.push('经度：' + data.position.getLng());
	        str.push('纬度：' + data.position.getLat());
	        if(data.accuracy){
	             str.push('精度：' + data.accuracy + ' 米');
	        }//如为IP精确定位结果则没有精度信息
	        str.push('是否经过偏移：' + (data.isConverted ? '是' : '否'));
	        document.getElementById('tip').innerHTML = str.join('<br>');
	    }
	    //解析定位错误信息
	    function onError(data) {
	        document.getElementById('tip').innerHTML = '定位失败';
	    }
	    
	    AMap.service(["AMap.PlaceSearch"], function() {
	        var placeSearch = new AMap.PlaceSearch({ //构造地点查询类
	            pageSize: 3,
	            pageIndex: 1,
	            city: "010", //城市
	            map: map,
	            panel: "panel"
	        });
	        //关键字查询
	        placeSearch.search('${house_pos}');
	    });
 })();
</script>
</html>
