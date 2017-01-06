/**
 * 
 */

$("#update").click(function() {
	var status = $(".status");
	var rowList =[{}];
	var rBody = $("#reimb-body").children();
	
	$.each(status, function(i, item) {
		// selected value
		var currSelect = $(item);
		var rowId = currSelect.attr('name');
		var rowStatus = currSelect.val();
		var row = { id: rowId, statusId: rowStatus };
		rowList[i] = row ;
	});
	
	$.ajax({
    	method:"POST",
 		url:"http://localhost:7001/ers/reimbursement.update.do",
 		data: JSON.stringify( { rowList: rowList } ),
 		success: function( resp ){
 			var monthNames = [
	 			                 "Jan", "Feb", "Mar",
	 			                 "Apr", "May", "Jun", "Jul",
	 			                 "Aug", "Sep", "Oct",
	 			                 "Nov", "Dec"
	 			               ];

	 			var date = new Date();
	 			var day = date.getDate();
	 			var monthIndex = date.getMonth();
	 			var year = date.getFullYear();

 			$.each( status, function( i, item ) {
 				var currSelect = 	$( item ).val();
 				var parentDiv = 	$( item ).parent();
 				var tableRow = 		$( parentDiv ).parent().parent();
 				var resolvedTime = 	"<p>" + monthNames[monthIndex] 	+ ' ' + day + ', ' + year 	+ "</p>";
 				var resolver = 		"<p>" 							+ resp.fullName 			+ "</p>"
 				var button;
 			
 				if( currSelect == 2 ){
 					$(item).remove();
 					button = "<button disabled > Approved </button>";
 					$(parentDiv).append( button );
 					$( parentDiv ).find( "button" ).addClass( "btn btn-success" );
 					tableRow.find( "#resolved" ).append( resolvedTime );
 	 				tableRow.find( "#resolver" ).append( resolver );
 				}else if( currSelect == 3 ){
 					$(item).remove();
 					button = "<button disabled > Deny </button>";
 					$( parentDiv ).append	( button );
 					$( parentDiv ).find		( "button" ).addClass( "btn btn-success" );
 					tableRow.find( "#resolved" ).append( resolvedTime );
 	 				tableRow.find( "#resolver" ).append( resolver );
 				}
 			});
 		}
     });
 });

var addReimb = function(){
	var amount = 	$( "#amnt" 			).val();
	var descript = 	$( "#descript" 		).val();
	var typeId = 	$( "#select-type" 	).val();
	var typeName = 	$( "#select-type" 	).find('option:selected').text()
	var message = 	$( "#error-message" );
	var reimbObj = 	JSON.stringify({amount: amount, descript: descript, typeId: typeId});

	if( amount=="" && typeId=="null" ){
		if( $("#error-message").find("p").length == 0 ){
			var error = "<p>Invalid options, please try again</p>"
			$("#error-message").append( error );
		}
	}else{
		$.ajax({
		   	method:"POST",
		 	url:"http://localhost:7001/ers/reimbursement.add.do",
		 	data: reimbObj,
		 	dataType: "json",
		 	success: function( resp ){
		 		var monthNames = [
		 		                 "Jan", "Feb", "Mar",
		 		                 "Apr", "May", "Jun", "Jul",
		 		                 "Aug", "Sep", "Oct",
		 		                 "Nov", "Dec"
		 		               ];
	
		 		var date = new Date();
		 		var day = date.getDate();
		 		var monthIndex = date.getMonth();
		 		var year = date.getFullYear();
		 			
		 		var row = "<tr><td>					Pending								 </td>" +
					"<td>" 							+ resp.fullName 			+ 		"</td>" +
					"<td>$" 						+ Number(amount).toFixed(2) + 		"</td>" +
					"<td>" 							+ descript 					+ 		"</td>" +
					"<td>"							+ typeName					+ 		"</td>" +
					"<td>" 	+ monthNames[monthIndex] + ' ' + day + ', ' + year 	+		"</td>" +
					"<td>																 </td>" +
					"<td>																 </td></tr>";
		 		$("#user-reimb-table tbody").append(row);
		 		
		 		$("#new-reimbursement").dialog( "close" );
		 	}
		});
	}
};

$(function(){
	var form;
	var amount = 	$( "#amnt" )		.val();
	var descript = 	$( "#descript" )	.val();
	var type = 		$( "#select-type" )	.val();
	var allFields = $( [] ).add( amount ).add( descript ).add( type );

	$("#new-reimbursement").dialog({
		create: function(e, ui) {
			$(this).dialog('widget').find('.ui-dialog-titlebar')
				.removeClass('ui-corner-all').addClass('ui-corner-top');
			$(this).dialog('widget').find('.ui-dialog-buttonpane')
				.removeClass('ui-corner-all').addClass('ui-corner-top');
		},
		show: 'puff',
		hide: 'fade',
		dialogClass: 'reimb-dialog',
		height: 400,
		width: 350,
		position: { my: "center", at: "center"},
		draggable: false,
		modal: true,
		autoOpen: false,
		title: "Create New Reimbursement",
		buttons: {
			Submit: function(){
				addReimb();
			},
			Cancel: function(){
				$("#new-reimbursement").dialog( "close" );
			}
		},
		close: function( event, ui ) {
			$( "#amnt" 			)	.val( "" );
			$( "#descript" 		)	.val( "" );
			$( "#select-type"	)	.val( "null" );
		}
	});
	$("#create-reimbursement").click(function(){
		$("#new-reimbursement").dialog( "open" );
	});
});

function doAdminFilter(){
	var filter = 	$("#filter").val();
	var rBody = 	$("#reimb-body").children();
	var filterText = $("#filter").find("option:selected").text();
	
	if( filter == 0 ){
		$(rBody, this).each(function() {
			$(this).css("display", ""); 
		});
	}else{
		$(rBody, this).each(function() {
			$(this).css("display", ""); 
		});
		$(rBody, this).each(function() {
			var status = $(this).find("#status").val();
			if( status != filter ){
				$(this).css("display", "none");
			}
		});
	}
}
function doUserFilter(){
	var filter = 	$("#filter").val();
	var rBody = 	$("#reimb-body").children();
	var filterText = $("#filter").find("option:selected").text();
	
	if( filter == 0 ){
		$(rBody, this).each(function() {
			$(this).css("display", ""); 
		});
	}else{
		$(rBody, this).each(function() {
			$(this).css("display", ""); 
		});
		$(rBody, this).each(function() {
			var userStatus =  $(this).find("#status").find("p").text();
			if( userStatus != filterText){
				$(this).css("display", "none");
			}
		});
	}
}