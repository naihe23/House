$(document).ready(function(){
	
	
	page28_request_order_order_jContainer1_obj=$('#page28_request_order_order_jContainer1_container').layout({
		onresize:function(){},
		center__paneSelector:'.page28_request_order_order_jContainer1_center'
		,north__paneSelector:'.page28_request_order_order_jContainer1_north'
		,north__size:	133
		,north__spacing_open:	0
		,west__paneSelector:'.page28_request_order_order_jContainer1_west'
		,west__size:	241
		,west__spacing_open:	0
		,maskIframesOnResize: true
	});
});

$(document).ready(function(){
	page28_request_order_order_jContainer1_obj.resizeAll();
});
