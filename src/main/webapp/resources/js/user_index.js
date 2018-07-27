$(document).ready(function(){
	
	
	user_index_index_jContainer1_obj=$('#user_index_index_jContainer1_container').layout({
		onresize:function(){},
		center__paneSelector:'.user_index_index_jContainer1_center'
		,north__paneSelector:'.user_index_index_jContainer1_north'
		,north__size:	133
		,north__spacing_open:	0
		,west__paneSelector:'.user_index_index_jContainer1_west'
		,west__size:	241
		,west__spacing_open:	0
		,maskIframesOnResize: true
	});
});

$(document).ready(function(){
	user_index_index_jContainer1_obj.resizeAll();
});
