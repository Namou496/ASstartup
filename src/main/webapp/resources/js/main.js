$(function(){
    var wth = $(this).width();
    if(wth > 550){
        $('#apply_next>img').attr('src','../resources/img/next-logo.png');
        $('.mainFooter').css({marginTop:'130px'});
    }else if(wth <= 550){
        $('#apply_next>img').attr('src','../resources/img/next-logo2.png');
        $('.mainFooter').css({marginTop:'800%'});
    }
    $(window).resize(function(){
      var wth = $(this).width();
        
        console.log(wth);
      if(wth < 550){
          $('#apply_next>img').attr('src','../resources/img/next-logo2.png');
          $('.mainFooter').css({marginTop:'130px'});
      } else if(wth >= 550){
          $('#apply_next>img').attr('src','../resources/img/next-logo.png');
          $('.mainFooter').css({marginTop:'800%'});
      };
      
   });
    
   
});