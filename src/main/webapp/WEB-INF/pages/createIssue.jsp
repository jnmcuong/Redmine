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

<script type="text/javascript">
//<![CDATA[
//var datepickerOptions={dateFormat: 'yy-mm-dd', firstDay: 0, showWeek: true, showOtherMonths: true, selectOtherMonths: true, changeMonth: true, changeYear: true, beforeShow: beforeShowDatePicker};
var datepickerOptions={beforeShow: beforeShowDatePicker};
//]]>
</script>

<style>
.ui-autocomplete-loading {
	background: white url("<c:url value="/resources/images/loading.gif"/>") right center
		no-repeat;
}
</style>


</head>
<body class="project-xifin controller-issues action-new">
	<div id="wrapper">
		<div id="wrapper2">
			<div id="wrapper3">
				<div id="top-menu">
					<div id="account">
						<ul>
							<li><a href="/my/account" class="my-account">My account</a></li>
							<li><a href="/logout" class="logout" data-method="post"
								rel="nofollow">Sign out</a></li>
						</ul>
					</div>
					<div id="loggedas">
						Logged in as <a href="/users/275" class="user active">cuong.ngo</a>
					</div>
					<ul>
						<li><a href="/" class="home">Home</a></li>
						<li><a href="/my/page" class="my-page">My page</a></li>
						<li><a href="/projects" class="projects">Projects</a></li>
						<li><a href="http://www.redmine.org/guide" class="help">Help</a></li>
					</ul>
				</div>

				<div id="header">
					<div id="quick-search">
						<form accept-charset="UTF-8" action="/projects/xifin/search"
							method="get">
							<div style="margin: 0; padding: 0; display: inline">
								<input name="utf8" type="hidden" value="✓">
							</div>
							<input name="issues" type="hidden" value="1"> <label
								for="q"> <a href="/projects/xifin/search" accesskey="4">Search</a>:
							</label> <input accesskey="f" class="small" id="q" name="q" size="20"
								type="text">
						</form>
						<select id="project_quick_jump_box" name="project_quick_jump_box"
							onchange="if (this.value != '') { window.location = this.value; }"><option
								value="">Jump to a project...</option>
							<option value="" disabled="disabled">---</option>
							<option selected="selected"
								value="/projects/xifin?jump=new_issue">XIFIN</option></select>
					</div>

					<h1>XIFIN</h1>

					<div id="main-menu">
						<ul>
							<li><a href="/projects/xifin" class="overview">Overview</a></li>
							<li><a href="/projects/xifin/activity" class="activity">Activity</a></li>
							<li><a href="<c:url value="/issue/view-all" />"
								class="issues">Issues</a></li>
							<li><a href="<c:url value="/issue/create" />" accesskey="7"
								class="new-issue selected">New issue</a></li>
							<li><a href="/projects/xifin/issues/gantt" class="gantt">Gantt</a></li>
							<li><a href="/projects/xifin/issues/calendar"
								class="calendar">Calendar</a></li>
							<li><a href="/projects/xifin/news" class="news">News</a></li>
							<li><a href="/projects/xifin/documents" class="documents">Documents</a></li>
							<li><a href="/projects/xifin/wiki" class="wiki">Wiki</a></li>
							<li><a href="/projects/xifin/files" class="files">Files</a></li>
							<li><a href="/projects/xifin/settings" class="settings">Settings</a></li>
						</ul>
					</div>
				</div>

				<div id="main" class="nosidebar">
					<div id="sidebar"></div>

					<div id="content">

						<h2>New issue</h2>



						<form accept-charset="UTF-8" action="<c:url value="/issue/create"/>"
							class="new_issue" id="issue-form" enctype="multipart/form-data"
							method="post">
							<div style="margin: 0; padding: 0; display: inline">
								<input name="utf8" type="hidden" value="✓"><input
									name="authenticity_token" type="hidden"
									value="khs2IddO1x7NcxaJW9WhkmlTB+cSr/cZSI1Wev4yc9U=">
							</div>

							<div class="box tabular">
								<div id="all_attributes">
									<p>
										<label for="issue_tracker_id">Tracker<span
											class="required"> *</span></label>
											<select id="issue_tracker_id"
											name="tracker"
											onchange="updateIssueFrom('/projects/xifin/issues/update_form.js')">
											<%-- 											<option value="6" selected="selected">${trackers[0].name}</option> --%>
											<!-- 											<option value="1">Bug</option> -->
											<!-- 											<option value="5">Request</option> -->
											<!-- 											<option value="3">Support</option> -->
											<!-- 											<option value="2">Feature</option></select> -->
											<c:forEach var="item" items="${trackers}">
												<option value="${item.id}">${item.name}</option>
											</c:forEach>
										</select>
										<script type="text/javascript">
											$("#issue_tracker_id option[value=1]").attr('selected','selected');
										</script>
									</p>

									<p>
										<label for="issue_subject">Subject<span
											class="required"> *</span></label><input id="issue_subject"
											maxlength="255" name="subject" size="80" type="text"
											value="" placeholder="insert subject name">
									</p>

									<p>
										<label for="issue_description">Description</label> <span
											id="issue_description_and_toolbar"> <textarea
												accesskey="e" class="wiki-edit" cols="60"
												id="issue_description" name="description" rows="10"></textarea>
										</span>
									</p>
									<script type="text/javascript">
//<![CDATA[
var wikiToolbar = new jsToolBar(document.getElementById('issue_description')); wikiToolbar.setHelpLink('/help/en/wiki_syntax.html'); wikiToolbar.draw();
//]]>
</script>

									<div id="attributes" class="attributes">


										<div class="splitcontent">
											<div class="splitcontentleft">
												<p>
													<label for="issue_status_id">Status<span
														class="required"> *</span></label> <select id="issue_status_id"
														name="status"
														onchange="updateIssueFrom('/projects/xifin/issues/update_form.js')">
														<!-- 														<option value="1" selected="selected">New</option> -->
														<!-- 														<option value="2">In Progress</option> -->
														<!-- 														<option value="3">Resolved</option> -->
														<!-- 														<option value="8">On-hold</option> -->
														<!-- 														<option value="7">Blocked</option> -->
														<!-- 														<option value="5">Closed</option> -->
														<!-- 														<option value="4">Feedback</option> -->

														<c:forEach var="item" items="${status}">
															<option value="${item.id}">${item.name}</option>
														</c:forEach>
													</select>
													<script type="text/javascript">
														$("#issue_status_id option[value=1]").attr('selected','selected');
													</script>
												</p>


												<p>
													<label for="issue_priority_id">Priority name<span
														class="required"> *</span></label>
														<select id="issue_priority_id"
														name="priority">
														<!-- 														<option value="1">Low</option> -->
														<!-- 														<option value="2" selected="selected">Normal</option> -->
														<!-- 														<option value="3">High</option> -->
														<!-- 														<option value="4">Urgent</option> -->
														<!-- 														<option value="5">Immediate</option> -->
														<c:forEach var="item" items="${priority}">
															<option value="${item.id}">${item.name}</option>
														</c:forEach>
													</select>
												</p>

												<p>
													<label for="issue_assigned_to_id">Assignee<span
														class="required"> *</span></label>
														<select id="issue_assigned_to_id" name="assignee">
															<option value="">&nbsp;</option>
															<option value="275">&lt;&lt; me &gt;&gt;</option>
															<c:forEach var="item" items="${members}">
																<option value="${item.id}">${item.fullName}</option>
															</c:forEach>
														</select>
												</p>

												<p>
													<label for="issue_category_id">Category name</label>
													<select id="issue_category_id" name="category">
														<option value="">&nbsp;</option>
														<option value="36">Function</option>
													</select>
													<a href="#" id="create-category"
													data-method="get" data-remote="true" tabindex="200"
													title="New category"><img alt="Add"
													src="<c:url value="/resources/images/add.png"/>"
													style="vertical-align: middle;"></a>
													<div id="dialog" title="New Category" style="overflow: hidden;"></div>
												</p>

											</div>

											<div class="splitcontentright">
												<p id="parent_issue">
													<label for="issue_parent_issue_id">Parent task</label>
													<input id="issue_parent_issue_id" name="parent_issue"
														size="10" type="text"
														class="ui-autocomplete-input autocomplete"
														autocomplete="off">
												</p>
												<script type="text/javascript">
//<![CDATA[
observeAutocompleteField('issue_parent_issue_id', '/issues/auto_complete?project_id=xifin&scope=tree')
//]]>
</script>

												<p id="start_date_area">
													<label for="issue_start_date">Start date</label> <input
														id="issue_start_date" name="start_date" type="text" size="10">

												</p>

												<p id="due_date_area">
													<label for="issue_due_date">Due date</label><input
														id="issue_due_date" name="due_date" type="text" size="10">

												</p>

												<p>
													<label for="issue_estimated_hours">Estimated time</label><input
														id="issue_estimated_hours" name="estimated_hours"
														size="3" type="text"> Hours
												</p>

												<p>
													<label for="issue_done_ratio">% Done</label><select
														id="issue_done_ratio" name="done_ratio"><option
															value="0" selected="selected">0 %</option>
														<option value="10">10 %</option>
														<option value="20">20 %</option>
														<option value="30">30 %</option>
														<option value="40">40 %</option>
														<option value="50">50 %</option>
														<option value="60">60 %</option>
														<option value="70">70 %</option>
														<option value="80">80 %</option>
														<option value="90">90 %</option>
														<option value="100">100 %</option></select>
												</p>
											</div>
										</div>

										<div class="splitcontent">
											<div class="splitcontentleft"></div>
										</div>
									</div>
									<script type="text/javascript">
//<![CDATA[

$(document).ready(function(){
  $("#issue_tracker_id, #issue_status_id").each(function(){
    $(this).val($(this).find("option[selected=selected]").val());
  });
});

//]]>
</script>
									<p id="attachments_form">
										<label>Files</label>
										<span id="attachments_fields"> </span>
										<span class="add_attachment"> <input class="file_selector"
											data-description-placeholder="Optional description"
											data-max-concurrent-uploads="2"
											data-max-file-size-message="This file cannot be uploaded because it exceeds the maximum allowed file size (29.3 MB)"
											data-max-file-size="30720000" data-upload-path="<c:url value="/issue/upload.js"/>"
											multiple="multiple" name="attachments[dummy][file]"
											onchange="addInputFiles(this);" type="file"> (Maximum
											size: 29.3 MB)
										</span>

									</p>

									<p id="watchers_form">
										<label>Watchers</label>
										<span id="watchers_inputs">
											<c:forEach var="item" items="${members}">
												<label class="floating" id="issue_watcher_user_ids_${item.id}"><input name="issue[watcher_user_ids][]" type="checkbox" value="${item.id}">${item.fullName}</label>
											</c:forEach>
										</span>
										<span
											class="search_for_watchers"> <a
											href="<c:url value="/member/list-json" />" data-method="get"
											data-remote="true">Search for watchers to add</a>
										</span>
									</p>
								</div>
							</div>

							<input name="commit" type="submit" value="Create">
							<input name="continue" type="submit" value="Create and continue">
							<a accesskey="r" href="#"
								onclick="submitPreview(&quot;/issues/preview/new/xifin&quot;, &quot;issue-form&quot;, &quot;preview&quot;); return false;">Preview</a>
						</form>
						
						<div id="preview" class="wiki"></div>



						<div style="clear: both;"></div>
					</div>
				</div>
			</div>

			<div id="ajax-indicator" style="display: none;">
				<span>Loading...</span>
			</div>
			<div id="ajax-modal" style="display: none;"></div>

			<div id="footer">
				<div class="bgl">
					<div class="bgr">
						Powered by <a href="http://www.redmine.org/">Redmine</a> ©
						2006-2015 Jean-Philippe Lang
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- 	<script -->
	<!-- 		src="/plugin_assets/redmine_email_fetcher/javascripts/email_configurations.js?1434365599" -->
	<!-- 		type="text/javascript"></script> -->


	<ul
		class="ui-autocomplete ui-front ui-menu ui-widget ui-widget-content"
		id="ui-id-1" tabindex="0" style="display: none;"></ul>
	<span role="status" aria-live="assertive" aria-relevant="additions"
		class="ui-helper-hidden-accessible"></span>
	<!-- 	<div id="ui-datepicker-div" -->
	<!-- 		class="ui-datepicker ui-widget ui-widget-content ui-helper-clearfix ui-corner-all"></div> -->

	
	<div class="ui-dialog ui-widget ui-widget-content ui-corner-all ui-front ui-draggable modal" tabindex="-1" role="dialog" aria-describedby="ajax-modal" aria-labelledby="ui-id-2" style="height: auto; width: 400px; top: 147px; left: 82.5px; display: none; z-index: 101;"><div class="ui-dialog-titlebar ui-widget-header ui-corner-all ui-helper-clearfix ui-draggable-handle"><span id="ui-id-2" class="ui-dialog-title">Add watchers</span><button type="button" class="ui-button ui-widget ui-state-default ui-corner-all ui-button-icon-only ui-dialog-titlebar-close" role="button" title="Close"><span class="ui-button-icon-primary ui-icon ui-icon-closethick"></span><span class="ui-button-text">Close</span></button></div><div id="ajax-modal" style="width: auto; min-height: 96px; max-height: none; height: auto;" class="ui-dialog-content ui-widget-content new-watcher">

<form accept-charset="UTF-8" action="/watchers/append?project_id=xifin" data-remote="true" id="new-watcher-form" method="post"><div style="margin:0;padding:0;display:inline"><input name="utf8" type="hidden" value="✓"><input name="authenticity_token" type="hidden" value="BPv7fFTUiiEjrOakGT+TVs6RMps/KGPs0DFvCJ3EJCA="></div>

  <p><label for="user_search">Search for user:</label><input id="user_search" name="user_search" type="text" class="autocomplete" data-value-was=""></p>
  <script type="text/javascript">
//<![CDATA[
//observeSearchfield('user_search', 'users_for_watcher', 'Redmine/member/list-json')
//]]>
</script>

  <div id="users_for_watcher">
    <label><input name="watcher[user_ids][]" type="checkbox" value="275"> Cuong Ngo</label>
<label><input name="watcher[user_ids][]" type="checkbox" value="86"> Dung Mai Xuan</label>
<label><input name="watcher[user_ids][]" type="checkbox" value="192"> Hieu Huynh</label>
<label><input name="watcher[user_ids][]" type="checkbox" value="183"> Hoai  Nguyen Trong - XIFIN</label>
<label><input name="watcher[user_ids][]" type="checkbox" value="135"> Huong Vu Mai</label>
<label><input name="watcher[user_ids][]" type="checkbox" value="120"> Jeff Carmichael</label>
<label><input name="watcher[user_ids][]" type="checkbox" value="105"> Khoa Tran Dang</label>
<label><input name="watcher[user_ids][]" type="checkbox" value="61"> Lam Nguyen Thanh</label>
<label><input name="watcher[user_ids][]" type="checkbox" value="228"> Minh Truong</label>
<label><input name="watcher[user_ids][]" type="checkbox" value="126"> Nam Nguyen Hoai</label>
<label><input name="watcher[user_ids][]" type="checkbox" value="184"> Nghia  Le Do Trong</label>
<label><input name="watcher[user_ids][]" type="checkbox" value="266"> Oanh Nguyen</label>
<label><input name="watcher[user_ids][]" type="checkbox" value="48"> Phong Do Vuong</label>
<label><input name="watcher[user_ids][]" type="checkbox" value="114"> Quyen Vu Dinh</label>
<label><input name="watcher[user_ids][]" type="checkbox" value="238"> Shekhar Bhusannavar</label>
<label><input name="watcher[user_ids][]" type="checkbox" value="230"> Tan Pham</label>
<label><input name="watcher[user_ids][]" type="checkbox" value="3"> Tang Luong Xuan</label>
<label><input name="watcher[user_ids][]" type="checkbox" value="43"> Thanh Le Duc</label>
<label><input name="watcher[user_ids][]" type="checkbox" value="259"> Tien Huynh</label>
<label><input name="watcher[user_ids][]" type="checkbox" value="127"> Trang Le Nguyen Thuy</label>
<label><input name="watcher[user_ids][]" type="checkbox" value="155"> Trang Nguyen Pham Ngoc</label>
<label><input name="watcher[user_ids][]" type="checkbox" value="276"> Trung Dao</label>
<label><input name="watcher[user_ids][]" type="checkbox" value="204"> Trung Nguyen</label>
<label><input name="watcher[user_ids][]" type="checkbox" value="122"> Tung Pham Son</label>
<label><input name="watcher[user_ids][]" type="checkbox" value="236"> Tuong Hong</label>
<label><input name="watcher[user_ids][]" type="checkbox" value="159"> Vu Nguyen Le Anh</label>

  </div>

  <p class="buttons">
    <input onclick="hideModal(this);" type="submit" value="Add">
    <input onclick="hideModal(this);" type="button" value="Cancel">
  </p>
</form></div></div>
	
	
	<script type="text/javascript">

	$(function() {
		$("#issue_start_date").datepicker();
	});
	
	$(function() {
		$("#issue_due_date").datepicker();
	});
	
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
	 
	    $( "#issue_parent_issue_id" ).autocomplete({
	      source: "<c:url value="/issue/auto-complete" />",
	      minLength: 2,
	      select: function( event, ui ) {
	        log( ui.item ?
	          "Selected: " + ui.item.value + " aka " + ui.item.id :
	          "Nothing selected, input was " + this.value );
	      }
	    });
  });
</script>
</body>
</html>