$(document).ready(function(){
	
	
	query_request_order_order_jContainer1_obj=$('#query_request_order_order_jContainer1_container').layout({
		onresize:function(){},
		center__paneSelector:'.query_request_order_order_jContainer1_center'
		,north__paneSelector:'.query_request_order_order_jContainer1_north'
		,north__size:	133
		,north__spacing_open:	0
		,west__paneSelector:'.query_request_order_order_jContainer1_west'
		,west__size:	241
		,west__spacing_open:	0
		,maskIframesOnResize: true
	});
});

$(document).ready(function(){
	query_request_order_order_jContainer1_obj.resizeAll();
});
