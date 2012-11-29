$(window).load(function () {
	loadDivs();
	sortChampions();
	$('#itemDiv').center(false);
	$('#itemDiv').hide();
	});

$(window).resize(function() {
	$('#itemDiv').center(false);
	});

$(window).scroll(function() {
	$('#itemDiv').center(false);
	});

$('#itemDiv>div#selected-items').live('mouseenter', function() {
	$('#itemDiv>div#selected-items').sortable();
});

$('#itemDiv>div#selected-items').live('mouseleave', function() {
	$('#itemDiv>div#selected-items').sortable("destroy");
});


$('#search').keyup(function() {
	 var searchWord = $('#search').val();
	 var lookIn = $('div[class="champion-container"]#available-champs').find('div[class="champion-icon"]');
	 var matches = $('div[class="champion-container"]#available-champs').find('div[champ-name^='+searchWord.toUpperCase()+']');
	 if ( $(matches).size()>0){
		 $(lookIn).not($(matches)).fadeOut('slow');
	$(matches).fadeIn('slow');
	 }else{
		 $('div[class="champion-icon"]').fadeIn('slow');
	 }
	});

$('div[class="champion-container"]#available-champs').on('click', 'div[class="champion-icon"]', function(){ //Select new champion
	var url = $(this).attr('url');
	var name = $(this).attr('champ-name');
	var divUrl = $(this).attr('div-url');
	var champDiv = $(this);
	if($('div[class="champion-container"]#selected-champs>div[champ-name='+name+']').length == 0){
	$.get(url, function() {}).success(function(data) { //Get added champion result
	  if (parseInt(data)==1){ //successfully added champion
		$.get(divUrl, function() {}).success(function(data) { //get the selected champion div
			$("#selected-champs").append(data); //add it to the selected champion container.
			$('div[class="champion-container"]#selected-champs>div[champ-name='+name+']').hide().fadeIn('slow'); //fade in the new div
			$(champDiv).fadeOut('slow', function () {$(champDiv).remove();});
		}).error(function(){alert('Error Retrieving champion display.');}).complete(function(){sortChampions();});
	  }else{
		  alert('Server Error: Could not add champ.');
	  }}).error(function(){alert('Server Error - Could not add champion.');}).complete(function(){});
	}
});

$('div[class="champion-container"]#selected-champs').on('click', 'div[class="delete-champ"]', function(){ //Delete current champion
	var champDiv = $(this).parent('div[class="champion-icon"]');
	var url = $(champDiv).attr('url');
	var name = $(champDiv).attr('champ-name');
	var divUrl = $(champDiv).attr('div-url');
	if($('div[class="champion-container"]#available-champs>div[champ-name='+name+']').length == 0){
	$.get(url, function() {}).success(function(data) { //Get added champion result
	  if (parseInt(data)==1){ //successfully added champion
		$.get(divUrl, function() {}).success(function(data) { //get the selected champion div
			$("#available-champs").append(data); //add it to the selected champion container.
			$('div[class="champion-container"]#available-champs>div[champ-name='+name+']').hide().fadeIn('slow'); //fade in the new div
			$(champDiv).fadeOut('slow', function () {$(champDiv).remove();});
		}).error(function(){alert('Error Retrieving champion display.');}).complete(function(){sortChampions();});
	  }else{
		  alert('Server Error: Could not add champ.');
	  }}).error(function(){alert('Server Error - Could not add champion.');}).complete(function(){});
	}
	
});

$('div[class="champion-container"]#selected-champs').on('click', 'img[class="show-items"]', function(){ //Delete current champion
	var champDiv = $(this).parent('div[class="champion-icon"]');
	var itemDivUrl = $(champDiv).attr('item-div-url');
		$.get(itemDivUrl, function() {}).success(function(data) { //get the selected champion div
			$("#itemDiv").html(data); //add it to the selected champion container.
			$('#itemDiv').center(false);
			$('#itemDiv').find('div[class="item-container"]#available-items>div[selected="false"]').show();
			$('#itemDiv').find('div[class="item-container"]#available-items>div[selected="true"]').hide();
			$('#itemDiv').find('div[class="item-container"]#selected-items>div[selected="false"]').hide();
			$('#itemDiv').find('div[class="item-container"]#selected-items>div[selected="true"]').show();
			$('#itemDiv').fadeIn('slow');
		}).error(function(){alert('Error Retrieving champion display.');}).complete(function(){sortChampions();});
});

$('#itemDiv').on('click', 'div[class="item-container"]#available-items>div[class="item-icon"]', function(){ //Select new item
	var url = $(this).attr('request-url');
	var name = $(this).attr('item-name');
	$.get(url, function() {}).success(function(data) { //Get added item result
	  if (parseInt(data)==1){ //successfully added item
			$('#itemDiv').find('div[class="item-container"]#available-items>div[item-name="'+name+'"]').fadeOut('slow', function(){ $(this).hide(); });
			$('#itemDiv').find('div[class="item-container"]#selected-items>div[item-name="'+name+'"]').fadeIn('slow', function(){ $(this).show(); });
	  }else if(parseInt(data)==2){
		  alert('Error: Inventory Full');
	  }else{
		  alert('error adding item.');
	  }
}).error(function(){alert('Server Error - Could not add item.');}).complete(function(){});
});

$('#itemDiv').on('click', 'div[class="item-container"]#selected-items>div[class="item-icon"]', function(){ //Remove Selected item
	var url = $(this).attr('request-url');
	var name = $(this).attr('item-name');
	$.get(url, function() {}).success(function(data) { //Get deleted item result
	  if (parseInt(data)==1){ //successfully deleted item
		  alert('test');
			$('#itemDiv').find('div[class="item-container"]#selected-items>div[item-name="'+name+'"]').fadeOut('slow', function(){ $(this).hide(); });
			$('#itemDiv').find('div[class="item-container"]#available-items>div[item-name="'+name+'"]').fadeIn('slow', function(){ $(this).show(); });
	  }else if(parseInt(data)==2){
		  //no items already
	  }else{
		  alert('error removing item item.');
	  }
}).error(function(){alert('Server Error - Could not delete item.');}).complete(function(){});
});

function sortChampions(){
	$('div[class="champion-container"]>div[class="champion-icon"]').tsort({attr:'champ-name'});
}
$('#itemDiv').on('click', 'div[class="close-window"]', function(){ //Close item selection pane
	$('#itemDiv').fadeOut('slow', function(){$('#itemDiv').hide();});
});

function sortChampions(){
	$('div[class="champion-container"]>div[class="champion-icon"]').tsort({attr:'champ-name'});
}

function loadDivs(){
	$('div[class="load-div"]').each(function(index) {
		var divUrl = $(this).attr('href');
		var replaceDiv = $(this);
		$.get(divUrl, function() {}).success(function(data) { 
			$(replaceDiv).replaceWith(data);
		}).error(function(){}).complete(function(){});
	});
}


jQuery.fn.center = function(parent) {
    if (parent) {
        parent = this.parent();
    } else {
        parent = window;
     //   alert("window: height "+$(parent).height()+" width "+$(parent).width()+" div: height: "+this.outerHeight()+" width: "+this.outerWidth()+".");
    }
   // this.html("window: height "+$(parent).height()+" width "+$(parent).width()+" div: height: "+this.outerHeight()+" width: "+this.outerWidth()+".");
    this.css({
        "position": "absolute",
        "top": ((($(parent).height() - this.outerHeight()) / 2) + $(parent).scrollTop() + "px"),
        "left": ((($(parent).width() - this.outerWidth()) / 2) + $(parent).scrollLeft() + "px")
    });
return this;
};
    