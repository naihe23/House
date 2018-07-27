$(document).ready(function(){
	
	
	announce_house_index_order_jContainer1_obj=$('#announce_house_index_order_jContainer1_container').layout({
		onresize:function(){},
		center__paneSelector:'.announce_house_index_order_jContainer1_center'
		,north__paneSelector:'.announce_house_index_order_jContainer1_north'
		,north__size:	133
		,north__spacing_open:	0
		,west__paneSelector:'.announce_house_index_order_jContainer1_west'
		,west__size:	241
		,west__spacing_open:	0
		,maskIframesOnResize: true
	});
});

$(document).ready(function(){
	announce_house_index_order_jContainer1_obj.resizeAll();
});
