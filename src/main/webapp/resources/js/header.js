function resizeNav(){
    var wth = $(this).width();
    if(wth <= 1000){
        $('.nav-link').removeAttr('style');
  	}
};

$(function(){
	var wth = $(this).width();
	if(wth <= 1000){
        $('.nav-link').removeAttr('style');
        $('.manuBtns>li').css({borderTop:"1px solid #786B6B",float:"none"});
        $('.loginZon>ul>li').css({borderTop:"1px solid #786B6B",float:"none"});
        $('#imgBanner').css({display:'none'});
    }else{
    	$('.manuBtns>li').removeAttr('style');
        $('.loginZon>ul>li').removeAttr('style');
        $('#imgBanner').css({display:'block'});
    }
	 
    $(window).resize(function(){
        
        if(wth <= 1000){
            $('.nav-link').removeAttr('style');
            $('.manuBtns>li').css({borderTop:"1px solid #786B6B",float:"none"});
            $('.loginZon>ul>li').css({borderTop:"1px solid #786B6B",float:"none"});
        }else{
        	$('.manuBtns>li').removeAttr('style');
            $('.loginZon>ul>li').removeAttr('style');
        }
       
    });
    
    $('.buttons>a').click(function(e){
		e.preventDefault();
		if(!uNo>0){
			alert('로그인후 이용가능합니다.');
		}else{
			var url = $(this).attr('href');
			location.href=url;
		}
	});
});