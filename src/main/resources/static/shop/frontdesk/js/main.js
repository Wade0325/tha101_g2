(function($) {

	"use strict";


	$(window).stellar({
    responsive: true,
    parallaxBackgrounds: true,
    parallaxElements: true,
    horizontalScrolling: false,
    hideDistantElements: false,
    scrollProperty: 'scroll'
  });


	var fullHeight = function() {

		$('.js-fullheight').css('height', $(window).height());
		$(window).resize(function(){
			$('.js-fullheight').css('height', $(window).height());
		});

	};
	fullHeight();

	// loader
	var loader = function() {
		setTimeout(function() { 
			if($('#ftco-loader').length > 0) {
				$('#ftco-loader').removeClass('show');
			}
		}, 1);
	};
	loader();

  var carousel = function() {
		$('.carousel-testimony').owlCarousel({
			center: true,
			loop: true,
			items:1,
			margin: 30,
			stagePadding: 0,
			nav: false,
			navText: ['<span class="ion-ios-arrow-back">', '<span class="ion-ios-arrow-forward">'],
			responsive:{
				0:{
					items: 1
				},
				600:{
					items: 2
				},
				1000:{
					items: 3
				}
			}
		});

	};
	carousel();

	$('nav .dropdown').hover(function(){
		var $this = $(this);
		// 	 timer;
		// clearTimeout(timer);
		$this.addClass('show');
		$this.find('> a').attr('aria-expanded', true);
		// $this.find('.dropdown-menu').addClass('animated-fast fadeInUp show');
		$this.find('.dropdown-menu').addClass('show');
	}, function(){
		var $this = $(this);
			// timer;
		// timer = setTimeout(function(){
			$this.removeClass('show');
			$this.find('> a').attr('aria-expanded', false);
			// $this.find('.dropdown-menu').removeClass('animated-fast fadeInUp show');
			$this.find('.dropdown-menu').removeClass('show');
		// }, 100);
	});


	$('#dropdown04').on('show.bs.dropdown', function () {
	  console.log('show');
	});

	// magnific popup
	$('.image-popup').magnificPopup({
    type: 'image',
    closeOnContentClick: true,
    closeBtnInside: false,
    fixedContentPos: true,
    mainClass: 'mfp-no-margins mfp-with-zoom', // class to remove default margin from left and right side
     gallery: {
      enabled: true,
      navigateByImgClick: true,
      preload: [0,1] // Will preload 0 - before current, and 1 after the current image
    },
    image: {
      verticalFit: true
    },
    zoom: {
      enabled: true,
      duration: 300 // don't foget to change the duration also in CSS
    }
  });

  $('.popup-youtube, .popup-vimeo, .popup-gmaps').magnificPopup({
    disableOn: 700,
    type: 'iframe',
    mainClass: 'mfp-fade',
    removalDelay: 160,
    preloader: false,

    fixedContentPos: false
  });


  var counter = function() {
		
		$('#section-counter').waypoint( function( direction ) {

			if( direction === 'down' && !$(this.element).hasClass('ftco-animated') ) {

				var comma_separator_number_step = $.animateNumber.numberStepFactories.separator(',')
				$('.number').each(function(){
					var $this = $(this),
						num = $this.data('number');
						console.log(num);
					$this.animateNumber(
					  {
					    number: num,
					    numberStep: comma_separator_number_step
					  }, 7000
					);
				});
				
			}

		} , { offset: '95%' } );

	}
	counter();

	var contentWayPoint = function() {
		var i = 0;
		$('.ftco-animate').waypoint( function( direction ) {

			if( direction === 'down' && !$(this.element).hasClass('ftco-animated') ) {
				
				i++;

				$(this.element).addClass('item-animate');
				setTimeout(function(){

					$('body .ftco-animate.item-animate').each(function(k){
						var el = $(this);
						setTimeout( function () {
							var effect = el.data('animate-effect');
							if ( effect === 'fadeIn') {
								el.addClass('fadeIn ftco-animated');
							} else if ( effect === 'fadeInLeft') {
								el.addClass('fadeInLeft ftco-animated');
							} else if ( effect === 'fadeInRight') {
								el.addClass('fadeInRight ftco-animated');
							} else {
								el.addClass('fadeInUp ftco-animated');
							}
							el.removeClass('item-animate');
						},  k * 50, 'easeInOutExpo' );
					});
					
				}, 100);
				
			}

		} , { offset: '95%' } );
	};
	contentWayPoint();

	$('.appointment_date').datepicker({
	  'format': 'm/d/yyyy',
	  'autoclose': true
	});

	$('.appointment_time').timepicker();

})(jQuery);


//浩元

var itemList = $(".cart-items");
var currentCount;  //購物車icon商品數量
// var cartItemsList = $(".cart-items");
 
// 商品數量增減按鈕
$(document).ready(function() {
	// 綁定增加按鈕點擊事件
	$(document).on('click', '.increment-button', function() {
	  // 獲取相對應的 input 元素
	  var inputElement = $(this).siblings('.quantity-input');
	  var currentValue = parseInt(inputElement.val());
	  // 增加值
	  currentValue++;
	  // 更新 input 框的值
	  inputElement.val(currentValue);
	});
  
	// 綁定減少按鈕點擊事件
	$(document).on('click', '.decrement-button', function() {
	  // 獲取相對應的 input 元素
	  var inputElement = $(this).siblings('.quantity-input');
	  var currentValue = parseInt(inputElement.val());
	  // 確保值大於 1 再減少
	  if (currentValue > 1) {
		currentValue--;
		// 更新 input 框的值
		inputElement.val(currentValue);
	  }
	});
  });

//   顯示/隱藏 購物車清單
  $(document).ready(function() {
	var cartIcon = $('.cart-icon');
	var cartDropdown = $('.cart-dropdown');
  
	cartIcon.on('click', function() {
		cartDropdown.slideToggle();
		checkEmptyCart();
	});
});
	function checkEmptyCart() {
		
		if (itemList.find('li').length === 0) {
			itemList.html('<p>暫無商品</p>');
			$("button.in_cart").hide();
		  } else {
			itemList.find("p:contains('暫無商品')").remove();
			$("button.in_cart").show();
		  }
	  }
	

  
  

//   商品名稱/數量 加入購物車清單
$(document).ready(function() {
	var addToCartBtn = $(".add-to-cart");
	var cartItemsList = $(".cart-items");
  
	$(document).on("click", ".add-to-cart", function() {
	  var productName = $(this).closest(".card").find("a").text(); // 假設這是你要加入購物車的商品名稱
	  var quantity = $(this).siblings("div.quantity-container").find("input").val(); // 假設這是你要加入購物車的商品數量
	 
	  
	//叉叉圖示
	  var listItem = $("<li>").text(productName + " - " + quantity);
	//   var deleteButton = $('<button>').text('X').addClass('delete-button');
	//   listItem.append(deleteButton);
	  cartItemsList.append(listItem);

	 // 增加商品數量
	  currentCount = parseInt($('.pro_amount').text());
      var newCount = currentCount + 1;

     // 更新購物車數字顯示
      $('.pro_amount').text(newCount);
	  checkEmptyCart();
  });
});


  // 購物車商品刪除按鈕點擊事件處理程序
  $('.cart-items').on('click', '.delete-button', function(event) {
    event.stopPropagation(); // 防止事件冒泡到父元素
    $(this).parent().remove(); // 刪除該商品項目
	currentCount = parseInt($('.pro_amount').text());
	var newCount = currentCount - 1;
	$('.pro_amount').text(newCount);
	checkEmptyCart();
	if (itemList.children().length === 0) {
		itemList.html("<li>暫無商品</li>");
	  }

  });
  

	
    document.addEventListener('DOMContentLoaded', function() {
      var scrollToTopBtn = document.querySelector('#scroll-to-top');
      
      // 監聽滾動事件
      window.addEventListener('scroll', function() {
        // 檢查捲軸位置
        if (window.pageYOffset > 300) {
          // 顯示回到頂部按鈕
          scrollToTopBtn.classList.add('show');
        } else {
          // 隱藏回到頂部按鈕
          scrollToTopBtn.classList.remove('show');
        }
      });
      
      // 監聽按鈕點擊事件
      scrollToTopBtn.addEventListener('click', function() {
        // 平滑捲動至頂部
        window.scrollTo({
          top: 0,
          behavior: 'smooth'
        });
      });
    });
  