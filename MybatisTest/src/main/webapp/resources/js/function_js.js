$(function(){

//구현해야 하는 기능
//1. #leftbar를 누르면 gnb 호출(mob/tab)
//2. device-width에 맞춰 fullbanner 사이즈, 배치 조절
//3. listitem 사이즈 조절(pc 25% / tab 33/ mob 25%)
//
	var $win_width=window.innerWidth;
	var $mob_width=768; //모바일해상도 768 이하
	var $tab_width=1024; // 
	var $max_width=1440;
	// console.log($win_width);	 // 1920 나옴. confirmed.

	var $fb=$('.fullbanner');
	var $fb_w=$fb.width();
	var $fb_h=$fb.height();
	// console.log($fb_w); //1440 
	// console.log($fb_h); //445
	
	var $fb_ol=$fb.find('>.banneritem>ol');

	var $fb_ol_li=$fb_ol.find('>li'); //li 


	var $fb_image_count=$fb_ol_li.size(); //이미지의 카운트

	var $imageRatio=1920/1080;
	console.log($imageRatio);
	// console.log($fb_ol_w); //4320찍힘.
	// console.log($fb_ol_li_w); //720 찍힘.
	// console.log($fb_image_count); // 6개 찍힘.

	var $btn_leftbar=$('#call_leftbar');
	var $btn_mypage=$('#call_profile');

//Mission1.
//해상도별 자바스크립트 분리
//if를 이용. width가 767미만일 때(Mobile) / 768~1024까지(Tablet) / 1024이상일 때(PC) 를 구분해서 실행한다.
//Mission2. 
//fullbanner에 노출될 이미지의 수를 제어한다. OL > li의 width를 이용 (pc,tab=50%, mob=100%)
//Misstion3.
//fullbanner에 

// 1. 변수설정
// 1-1. fullbanner의 width 값 = fb_w
// 1-2. fullbanner의 height 값 = fb_g
// 1-3. 현재 윈도우의 width 값 = win_width
// 1-4. 모바일 기준 해상도 768px = mob_width
// 1-5. 태블릿 기준 해상도 1024px = tab_width
// 1-6. 최대 기준 해상도 1440px = max_width
// 1-7. fullbanner > .banneritem > ol의 width값  =  fb_ol_w
// 1-8. fullbanner > .banneritem > ol > li 의 width값 = fb_ol_li_w
// 1-9. fullbanner에 있는 li의 갯수 =6개 = fb_image_count

// 2. PC설정
// 2-1. fb_ol_w를 win_width/2 * fb_image_count 로 설정
// 2-2. ol_li의 width를 win_width의 50%로 설정
 
// fb_h = fb_ol_li_w * 

	if($win_width<$mob_width){
		// window 해상도가 768보다 작다.
		$(function(){    
			// $fb.css({'width':$win_width});
			// console.log($win_width);
			$fb_ol_li.css({'width':$win_width});

			var $fb_ol_w=$fb_ol.width();
			var $fb_ol_li_w=$fb_ol_li.width(); //li의 width

			var $fb_bi=$('.bannerindex');
			// console.log($fb_ol_li.height());
			
			$fb.css({'width':$win_width, 'height':$win_width/$imageRatio + 35});
			$fb_ol.css({'width':$win_width*$fb_image_count});
			$fb_ol_li.css({'height':$win_width/$imageRatio});
			$fb_bi.css({'width':$win_width});
			////////////////////fb w/h fix part end//////////////////
			
			////////////////////fb left/right icon change part///////

			$fb_ol.scroll(function(){
				var $scroll_pos=$fb_ol.scrollLeft();
				console.log('aaaaaaaaaaaaaaaaaaaaaaaaaaa')
				console.log(scroll_pos);

				if($scroll_pos>0){
					$('.banner_L_btn').find('img').attr('src','image/icon/a_b_l.png');
				};
			}); // scroll end


			//////////////fb left/right icon change part end///////
			
			////////////leftbar calling part /////////////
			$('#call_leftbar').clickToggle(function(){

				var $profile_pos=$('#profile').offset();
				if($profile_pos.top>0){
					$('#call_profile').trigger('click');
				}
				$('body').css({'overflow-x':'hidden'});
				$('#wraper').css({'overflow-x':'hidden'});
				$('#wrap').css({'overflow-x':'hidden'});;

				$('#nav').animate({left:0},500);

			},function(){
				$('#nav').animate({left:'-200%'},500);
				$('body').css({'overflow-x':'scroll'});
				$('#wraper').css({'overflow-x':'scroll'});
				$('#wrap').css({'overflow-x':'scroll'});
			});

			/////////////////////////////////////////////////////////////
			
			///////////right Mypage calling part ////////////////////
			$('#call_profile').clickToggle(function(){
				var $nav_pos=$('#nav').offset();
				console.log('sss'); 	
				console.log($nav_pos);

				if($nav_pos.left==0){
					// $('#nav').css({'left':'-200%'});
					$('#call_leftbar').trigger('click');
				}
				$('#profile').animate({top:83},500);
				$('body').css({'overflow':'hidden'});
				$('#wraper').css({'overflow':'hidden'});
				$('#wrap').css({'overflow':'hidden'});
				

			},function(){
				$('#profile').animate({top:'-200%'},500);
				$('body').css({'overflow':'scroll'});
				$('#wraper').css({'overflow':'scroll'});
				$('#wrap').css({'overflow':'scroll'});
			});
			///////////right Mypage calling part end ////////////////////
			
			//////////////////bestlist w/h fix part //////////////////
			//1. win_width의 1/2.3 값을 .bestlist_itemdml width에 대입
			//////////////////bestlist w/h fix part end///////////////
			var $bi=$('.bestlist')
			var $bis=$('.bestlist_scroll')
			var $bis_ol=$bis.find('>ol');
			var $bis_ol_li=$bis_ol.find('>li');
			var $bis_liwidth=$win_width/2.3;
			var $bis_li_count=$bis_ol_li.size();
			var $bis_img=$bis_ol_li.find('>a>.bestlist_box>img');

			console.log($bis_li_count);
			console.log($bis_img.width());
			console.log($bis_img.width()/$imageRatio);

			$bis_ol_li.css({'width':$bis_liwidth});

			var $bis_imageheight=($bis_img.width()/$imageRatio) +2;

			$bi.css({'height':$bis_imageheight+20});
			console.log($bis_imageheight);

			$bi.find('.bestlist_box').css({'height':$bis_imageheight});

			$bis.css({'height':$bis_imageheight});

			$bis_ol.css({'height':$bis_imageheight, 'width':$bis_liwidth*$bis_li_count+55});

			$bis_ol_li.css({'height':$bis_imageheight});
		});
		/////////////mob end/////////////////
	}else if($mob_width<=$win_width && $win_width <= $tab_width){ //태블릿
		// 태블릿 모드. window 해상도가 768~1024다
		$(function(){

			////////////leftbar calling part /////////////
			$('#call_leftbar').clickToggle(function(){
				$('#nav').animate({top:83},500);
			},function(){
				$('#nav').animate({top:'-200%'},500)
			});


			// ////////////leftbar calling part end///////////////////
			
			//////////////
			var $liList = $(".newlist_item> ul li >div"); // width값 구할 엘레먼트 Selector

			var liListArray = $liList.map(function(){
			    return $(this).width();
			})  // map을 이용해서 $liList의 width값을 배열로 만들기
			    console.log(liListArray) // 콘솔로그로 확인
			    Math.max.apply(Math , liListArray); // $liListArray중 가장 큰값 뽑아내기
			    console.log(Math.max.apply(Math , liListArray)); // 콘솔로그로 확인

			$liList.width(Math.max.apply(Math , liListArray)); //$liList의 width 값은 Math.max.apply(Math , liListArray) 라고 지정.

			///////////full banner ///////
			$fb_ol_li.css({'width':$win_width});

			var $fb_ol_w=$fb_ol.width();
			var $fb_ol_li_w=$fb_ol_li.width(); //li의 width

			var $fb_bi=$('.bannerindex');
			// console.log($fb_ol_li.height());
			
			$fb.css({'width':$win_width, 'height':$win_width/$imageRatio + 50});
			$fb_ol.css({'width':$win_width*$fb_image_count});
			$fb_ol_li.css({'height':$win_width/$imageRatio});
			$fb_bi.css({'width':$win_width});
			////////////////////fb w/h fix part end//////////////////
			////bestlist item//////
				var $bi=$('.bestlist')
				var $bis=$('.bestlist_scroll')
				var $bis_ol=$bis.find('>ol');
				var $bis_ol_li=$bis_ol.find('>li');
				// var $bis_liwidth=($win_width-150)/6;
				var $bis_liwidth=$win_width/4;
				var $bis_li_count=$bis_ol_li.size();
				var $bis_img=$bis_ol_li.find('>a>.bestlist_box>img');

				var $bis_LR_btn=$('.bestlist_btn');

				console.log($bis_li_count);
				console.log($bis_img.width());
				console.log($bis_img.width()/$imageRatio);

				$bis_ol_li.css({'width':$bis_liwidth});
				console.log('ssssssssss');
				console.log($bis_liwidth);
				console.log($bis_li_count);

				var $bis_imageheight=($bis_img.width()/$imageRatio) +2;

				// $bi.css({'height':$bis_imageheight+20});
				console.log($bis_imageheight);

				$bi.find('.bestlist_box').css({'height':$bis_imageheight});

				$bis.css({'height':$bis_imageheight, 'width':$bis_liwidth*4});
				$bis_LR_btn.css({'height':$bis_imageheight});
				$bis_ol.css({'height':$bis_imageheight, 'width':$bis_liwidth*$bis_li_count+75});

				$bis_ol_li.css({'height':$bis_imageheight});
			////bestlist item//////



		});
		///////////////////tab end///////////////
	}else if($win_width > $tab_width){  // 윈도우- 해상도 1440 이상
		$(function(){
			//pc 버전

			// win_width가 max_width보다 작은지 큰지 구분
			// win_width가 max_width보다 크면 이미지 폭을 1440px으로 고정해야함.
			if($win_width>=$max_width){
				alert('윈도우가 최대치이거나 그 이상이다.')
				//fullbanner의 li 폭을 max_width/2로 고정
				$fb_ol_li_w=($max_width/2);
				$fb_ol_li.css({'width':$fb_ol_li_w});

				var $img_w=$fb_ol_li.width();
				var $fb_bi=$('.bannerindex');
				$fb_ol.css({'width':$win_width*$fb_image_count/2});
				$fb.css({'width':$max_width, 'height':($max_width/2)/$imageRatio + 35});
				$fb_bi.css({'width':$max_width});
			////////////////////fb w/h fix part end//////////////////
			
			////bestlist item//////
				var $bi=$('.bestlist')
				var $bis=$('.bestlist_scroll')
				var $bis_ol=$bis.find('>ol');
				var $bis_ol_li=$bis_ol.find('>li');
				// var $bis_liwidth=($win_width-150)/6;
				var $bis_liwidth=($max_width-135)/6;
				var $bis_li_count=$bis_ol_li.size();
				var $bis_img=$bis_ol_li.find('>a>.bestlist_box>img');

				var $bis_LR_btn=$('.bestlist_btn');

				console.log($bis_li_count);
				console.log($bis_img.width());
				console.log($bis_img.width()/$imageRatio);

				$bis_ol_li.css({'width':$bis_liwidth});
				console.log('ssssssssss');
				console.log($bis_liwidth);
				console.log($bis_li_count);

				var $bis_imageheight=($bis_img.width()/$imageRatio) +2;

				// $bi.css({'height':$bis_imageheight+20});
				console.log($bis_imageheight);

				$bi.find('.bestlist_box').css({'height':$bis_imageheight});

				$bis.css({'height':$bis_imageheight, 'width':$bis_liwidth*6});
				$bis_LR_btn.css({'height':$bis_imageheight});
				$bis_ol.css({'height':$bis_imageheight, 'width':$bis_liwidth*$bis_li_count+75});

				$bis_ol_li.css({'height':$bis_imageheight});
			////bestlist item//////
			
			///bestlist item btn click///
				$('.bestlist_right').click(function(){
					$bis_ol.animate({'left':-1*($bis_ol.width()/2)+5},500)
					// $bis_ol.css({'left':-1*$bis_liwidth*6+50});
				});

				$('.bestlist_left').click(function(){
					$bis_ol.animate({'left':0},500);
				})

			}else{
				//fullbanner의 li width를 win_width/2로 고정
				$fb_ol_li.css({'width':$win_width/2});

				var $img_w=$fb_ol_li.width();
				var $fb_bi=$('.bannerindex');

				$fb.css({'width':$win_width, 'height':$($win_width/2)/$imageRatio + 35});
				$fb_bi.css({'width':$win_width});
			////////////////////fb w/h fix part end//////////////////
			
			////bestlist item//////
				var $bi=$('.bestlist')
				var $bis=$('.bestlist_scroll')
				var $bis_ol=$bis.find('>ol');
				var $bis_ol_li=$bis_ol.find('>li');
				// var $bis_liwidth=($win_width-150)/6;
				var $bis_liwidth=($win_width-135)/6;
				var $bis_li_count=$bis_ol_li.size();
				var $bis_img=$bis_ol_li.find('>a>.bestlist_box>img');

				var $bis_LR_btn=$('.bestlist_btn');


				console.log($bis_li_count);
				console.log($bis_img.width());
				console.log($bis_img.width()/$imageRatio);

				$bis_ol_li.css({'width':$bis_liwidth});
				console.log('ssssssssss');
				console.log($bis_liwidth);
				console.log($bis_li_count);

				var $bis_imageheight=($bis_img.width()/$imageRatio) +2;

				// $bi.css({'height':$bis_imageheight+20});
				console.log($bis_imageheight);

				$bi.find('.bestlist_box').css({'height':$bis_imageheight});

				$bis.css({'height':$bis_imageheight, 'width':$bis_liwidth*6});
				$bis_LR_btn.css({'height':$bis_imageheight});

				$bis_ol.css({'height':$bis_imageheight, 'width':$bis_liwidth*$bis_li_count+55});

				$bis_ol_li.css({'height':$bis_imageheight});
			////bestlist item//////
			///


			}//else end

			
		});//function wrapper end
	};



});//wrapper end

