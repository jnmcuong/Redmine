<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="<c:url value="/resources/css/jquery-ui.css" />" media="all"
	rel="stylesheet" type="text/css" />
<link href="<c:url value="/resources/css/application.css" />"
	media="all" rel="stylesheet" type="text/css" />

<link href="<c:url value="/resources/css/jstoolbar.css" />" media="all"
	rel="stylesheet" type="text/css" />

<link href="<c:url value="/resources/css/style.css" />" media="all"
	rel="stylesheet" type="text/css" />

<link href="<c:url value="/resources/css/email_configurations.css" />"
	media="all" rel="stylesheet" type="text/css" />

<script src="<c:url value="/resources/js/jquery-1.11.1.js"/>"
	type="text/javascript"></script>

<script src="<c:url value="/resources/js/ujs-3.1.1.js"/>"
	type="text/javascript"></script>
<script src="<c:url value="/resources/js/jquery-ui-v1.11.0.js"/>"
	type="text/javascript"></script>

<script type="text/javascript"
	src="<c:url value="/resources/js/jstoolbar-textile.min.js"/> "></script>

<script type="text/javascript"
	src="<c:url value="/resources/js/attachments.js"/> "></script>

<script type="text/javascript"
	src="<c:url value="/resources/js/datepicker.js"/> "></script>

<script type="text/javascript"
	src="<c:url value="/resources/js/email_configurations.js"/> "></script>

<script type="text/javascript"
	src="<c:url value="/resources/js/application.js"/> "></script>

	<style>
  .ui-autocomplete-loading {
    background: white url("images/ui-anim_basic_16x16.gif") right center no-repeat;
  }
  #city { width: 25em; }
  </style>
  
</head>
<body>
<%-- 	<form action="<c:url value="/issue/test" />" method="post"> --%>
<!-- 		<input type="text" name="user"> <input type="text" name="pass"> -->
<!-- 		<input type="submit" name="submit" value="Submit"> -->
<!-- 	</form> -->
<script type="text/javascript">
    $(function () {
        $('#dialog').dialog({
            autoOpen: false,
            width: 400,
            resizable: false,
            //title: 'hi there',
            modal: true,
            open: function(event, ui) {
                //Load the CreateAlbumPartial action which will return 
                // the partial view _CreateAlbumPartial
                $(this).load('<c:url value="/category/create"/>');
            },
            buttons: {
//                 "Close": function () {
//                     $(this).dialog("close");
//                 }
            }
        });

        $('#create-category').click(function () {
            $('#dialog').dialog('open');
        });
    });
	
	$(function() {
    function log( message ) {
      $( "<div>" ).text( message ).prependTo( "#log" );
      $( "#log" ).scrollTop( 0 );
    }
 
    $( "#city" ).autocomplete({
      source: "http://gd.geobytes.com/AutoCompleteCity",
      minLength: 2,
      select: function( event, ui ) {
        log( ui.item ?
          "Selected: " + ui.item.value + " aka " + ui.item.id :
          "Nothing selected, input was " + this.value );
      }
    });
  });
  
</script>
<button id="create-category">Create new category</button>

<div id="dialog" title="New Category" style="overflow: hidden;"></div>
<br>
<div class="ui-widget">
  <label for="city">Your city: </label>
	<input id="city">  
</div>

<div>
<form id="uploadForm">
     <input type="file" name="myimage" id="imageid" accept=".png" />
</form>
<input type="button" id="uploadbutton" value="submit file"/>
</div>

</body>
<script type="text/javascript">
$("#uploadbutton").on("click", function() {
	var formData = new FormData($('#uploadForm')[0]);
	$.ajax({
	    url: '<c:url value="/issue/test" />',
	    type: "POST",
	    dataType: 'text',
	    contentType: false,
	    processData: false,
	    cache: false,
	    data: formData,
	    success: function(response) {
	        alert("success");
	    },
	    error: function() {
	        alert("unable to create the record");
	    }
	});
})
</script>
</html>