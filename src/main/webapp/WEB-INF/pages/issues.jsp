<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>



<script src="<c:url value="/resources/js/jquery-1.11.1.js" />"
	type="text/javascript"></script>
<script src="<c:url value="/resources/js/jquery-ui-v1.11.0.js" />"
	type="text/javascript"></script>
<script src="<c:url value="/resources/js/ujs-3.1.1.js" />"
	type="text/javascript"></script>	
<script src="<c:url value="/resources/js/jquery.jqGrid.js" />"
	type="text/javascript"></script>
<script src="<c:url value="/resources/js/grid.locale-en.js" />"
	type="text/javascript"></script>

<script src="<c:url value="/resources/js/application.js" />"
	type="text/javascript"></script>

<link href="<c:url value="/resources/css/jquery-ui.css" />" media="all"
	rel="stylesheet" type="text/css" />
<link href="<c:url value="/resources/css/application.css" />"
	media="all" rel="stylesheet" type="text/css" />
	
<script type="text/javascript">
//<![CDATA[
$(window).load(function(){ warnLeavingUnsaved('The current page contains unsaved text that will be lost if you leave this page.'); });
//]]>
</script>

<link href="<c:url value="/resources/css/style.css" />" media="screen"
	rel="stylesheet" type="text/css" />
<link href="<c:url value="/resources/css/email_configurations.css" />"
	media="screen" rel="stylesheet" type="text/css" />
<link href="<c:url value="/resources/css/ui.jqgrid.css" />"
	media="screen" rel="stylesheet" type="text/css" />
	

<script src="<c:url value="/resources/js/datepicker.js" />"
	type="text/javascript"></script>
<script type="text/javascript">
//<![CDATA[
var datepickerOptions={dateFormat: 'yy-mm-dd', firstDay: 0, showOn: 'button', buttonImageOnly: true, buttonImage: '/images/calendar.png?1431245373', showButtonPanel: true, showWeek: true, showOtherMonths: true, selectOtherMonths: true, changeMonth: true, changeYear: true, beforeShow: beforeShowDatePicker};
//]]>
</script>

<script src="<c:url value="/resources/js/select_list_move.js" />"
	type="text/javascript"></script>
<script src="<c:url value="/resources/js/context-menu.js" />"
	type="text/javascript"></script>
<%-- <link href="<c:url value="/resources/css/context_menu.css" />" --%>
<!-- 	media="screen" rel="stylesheet" type="text/css" /> -->

</head>
<body class="project-xifin controller-issues action-index">
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
								<input name="utf8" type="hidden" value="&#x2713;" />
							</div>
							<input name="issues" type="hidden" value="1" /> <label for='q'>
								<a href="/projects/xifin/search" accesskey="4">Search</a>:
							</label> <input accesskey="f" class="small" id="q" name="q" size="20"
								type="text" />
						</form>
						<select id="project_quick_jump_box" name="project_quick_jump_box"
							onchange="if (this.value != &#x27;&#x27;) { window.location = this.value; }"><option
								value=''>Jump to a project...</option>
							<option value="" disabled="disabled">---</option>
							<option selected="selected" value="/projects/xifin?jump=issues">XIFIN</option></select>
					</div>

					<h1>XIFIN</h1>

					<div id="main-menu">
						<ul>
							<li><a href="/projects/xifin" class="overview">Overview</a></li>
							<li><a href="/projects/xifin/activity" class="activity">Activity</a></li>
							<li><a href="<c:url value="/issue/view-all" />" class="issues selected">Issues</a></li>
							<li><a href="<c:url value="/issue/create" />" accesskey="7"
								class="new-issue">New issue</a></li>
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

				<div id="main" class="">
					<div id="sidebar">
						<h3>Issues</h3>

						<ul>
							<li><a href="/projects/xifin/issues?set_filter=1">View
									all issues</a></li>
							<li><a href="/projects/xifin/issues/report">Summary</a></li>

							<li><a href="/projects/xifin/issues/calendar">Calendar</a></li>
							<li><a href="/projects/xifin/issues/gantt">Gantt</a></li>
						</ul>









					</div>

					<div id="content">

						<div class="contextual"></div>

						<h2>Issues</h2>

						<form accept-charset="UTF-8" action="/projects/xifin/issues"
							id="query_form" method="get">
							<div style="margin: 0; padding: 0; display: inline">
								<input name="utf8" type="hidden" value="&#x2713;" />
							</div>
							<div id="query_form_with_buttons" class="hide-when-print">
								<input id="set_filter" name="set_filter" type="hidden" value="1" />
								<div id="query_form_content">
									<fieldset id="filters" class="collapsible ">
										<legend onclick="toggleFieldset(this);">Filters</legend>
										<div style="">
											<script type="text/javascript">
										</script>
											<table style="width: 100%">
												<tr>
													<td>
														<table id="filters-table">
														</table>
													</td>
													<td class="add-filter"><label for="add_filter_select">Add
															filter</label> <select id="add_filter_select"><option
																value="">&nbsp;</option>
															<option value="status_id">Status</option>
															<option value="tracker_id">Tracker</option>
															<option value="priority_id">Priority name</option>
															<option value="author_id">Author</option>
															<option value="assigned_to_id">Assignee</option>
															<option value="member_of_group">Assignee&#x27;s
																group</option>
															<option value="assigned_to_role">Assignee&#x27;s
																role</option>
															<option value="category_id">Category name</option>
															<option value="subject">Subject</option>
															<option value="created_on">Created</option>
															<option value="updated_on">Updated</option>
															<option value="closed_on">Closed</option>
															<option value="start_date">Start date</option>
															<option value="due_date">Due date</option>
															<option value="estimated_hours">Estimated time</option>
															<option value="done_ratio">% Done</option>
															<option value="watcher_id">Watcher</option>
															<option value="subproject_id">Subproject</option>
															<option value="relates">Related to</option>
															<option value="duplicates">Duplicates</option>
															<option value="duplicated">Duplicated by</option>
															<option value="blocks">Blocks</option>
															<option value="blocked">Blocked by</option>
															<option value="precedes">Precedes</option>
															<option value="follows">Follows</option>
															<option value="copied_to">Copied to</option>
															<option value="copied_from">Copied from</option></select></td>
												</tr>
											</table>
											<input id="f_" name="f[]" type="hidden" value="" />

										</div>
									</fieldset>
									<fieldset class="collapsible collapsed">
										<legend onclick="toggleFieldset(this);">Options</legend>
										<div style="display: none;">
											<table>
												<tr>
													<td>Columns</td>
													<td><table class="query-columns">
															<tr>
																<td style="padding-left: 0"><label
																	for="available_columns">Available Columns</label> <br />
																	<select id="available_columns" multiple="multiple"
																	name="available_columns[]"
																	ondblclick="moveOptions(this.form.available_columns, this.form.selected_columns);"
																	size="10" style="width: 150px"><option
																			value="project">Project</option>
																		<option value="parent">Parent task</option>
																		<option value="author">Author</option>
																		<option value="fixed_version">Target version</option>
																		<option value="estimated_hours">Estimated
																			time</option>
																		<option value="created_on">Created</option>
																		<option value="closed_on">Closed</option>
																		<option value="relations">Related issues</option></select></td>
																<td class="buttons"><input type="button"
																	value="&#8594;"
																	onclick="moveOptions(this.form.available_columns, this.form.selected_columns);" /><br />
																	<input type="button" value="&#8592;"
																	onclick="moveOptions(this.form.selected_columns, this.form.available_columns);" />
																</td>
																<td><label for="selected_columns">Selected
																		Columns</label> <br /> <select id="selected_columns"
																	multiple="multiple" name="c[]"
																	ondblclick="moveOptions(this.form.selected_columns, this.form.available_columns);"
																	size="10" style="width: 150px"><option
																			value="tracker">Tracker</option>
																		<option value="status">Status</option>
																		<option value="priority">Priority name</option>
																		<option value="subject">Subject</option>
																		<option value="assigned_to">Assignee</option>
																		<option value="category">Category name</option>
																		<option value="updated_on">Updated</option>
																		<option value="start_date">Start date</option>
																		<option value="due_date">Due date</option>
																		<option value="done_ratio">% Done</option>
																		<option value="spent_hours">Spent time</option></select></td>
																<td class="buttons"><input type="button"
																	value="&#8648;"
																	onclick="moveOptionTop(this.form.selected_columns);" /><br />
																	<input type="button" value="&#8593;"
																	onclick="moveOptionUp(this.form.selected_columns);" /><br />
																	<input type="button" value="&#8595;"
																	onclick="moveOptionDown(this.form.selected_columns);" /><br />
																	<input type="button" value="&#8650;"
																	onclick="moveOptionBottom(this.form.selected_columns);" />
																</td>
															</tr>
														</table></td>
												</tr>
												<tr>
													<td><label for='group_by'>Group results by</label></td>
													<td><select id="group_by" name="group_by"><option
																value="">&nbsp;</option>
															<option value="project">Project</option>
															<option value="tracker">Tracker</option>
															<option value="status">Status</option>
															<option value="priority">Priority name</option>
															<option value="author">Author</option>
															<option value="assigned_to">Assignee</option>
															<option value="category">Category name</option>
															<option value="fixed_version">Target version</option>
															<option value="done_ratio">% Done</option></select></td>
												</tr>
												<tr>
													<td>Show</td>
													<td><label class="inline"><input name="c[]"
															type="checkbox" value="description" /> Description</label></td>
												</tr>
											</table>
										</div>
									</fieldset>
								</div>
								<p class="buttons">
									<a class="icon icon-checked" href="#"
										onclick="submit_query_form(&quot;query_form&quot;); return false;">Apply</a>
									<a href="/projects/xifin/issues?set_filter=1"
										class="icon icon-reload">Clear</a> <a class="icon icon-save"
										href="#"
										onclick="$(&#x27;#query_form&#x27;).attr(&#x27;action&#x27;, &#x27;/projects/xifin/queries/new&#x27;); submit_query_form(&#x27;query_form&#x27;); return false;">Save</a>
								</p>
							</div>
						</form>

						<form accept-charset="UTF-8" action="/projects/xifin/issues"
							method="post">
							<div style="margin: 0; padding: 0; display: inline">
								<input name="utf8" type="hidden" value="&#x2713;" /><input
									name="authenticity_token" type="hidden"
									value="vZ1GMfWgWVwfsgZfcoo62/XTKaPPQ73wSYMmkCNh37M=" />
							</div>
							<input name="back_url" type="hidden"
								value="/projects/xifin/issues" />
								<table id="jqGrid"></table>
								<div id="jqGridPager"></div>
						</form>
						<script type="text/javascript"> 
							
							function initGrid() {
								$(this).contextMenu('contextMenu', {
									bindings: {
										'edit': function (t) {
											alert("Edit Row Command Selected");
										},
										'copy': function (t) {
											alert("Add Row Command Selected");
										},
										'del': function (t) {
											alert("Delete Row Command Selected");
										}
									},
									onContextMenu: function (event, menu) {
										var rowId = $(event.target).parent("tr").attr("id")
										var grid = $("#jqGrid");
										grid.setSelection(rowId);

										return true;
									}
								});
							}
						
							$(document).ready(function () {
								$("#jqGrid").jqGrid({
									url: '<c:url value="/issue/getIssues" />',
									mtype: "GET",
									datatype: "json",
									sortable: true,
									colModel: [
										{ label: '#', name: 'id', width: 15, formatter: 'showlink',formatoptions: { baseLinkUrl: 'javascript:', showAction: "Link('", addParam: "');"}, sortable: true, sorttype: 'number'},
										{ label: 'Tracker', name: 'nameTracker', width: 90 },
										{ label: 'Status', name: 'nameStatus', width: 100},
										{ label: 'Priority', name: 'namePriority', width: 80},
										{ label: 'Subject', name: 'subject', width: 80},
										{ label: 'Assignee', name: 'nameAssignee', width: 80},
										{ label: 'Category', name: 'category', width: 80},
										{ label: 'Updated', name: 'timeUpdated', width: 80},
										{ label: 'Start date', name: 'startDate', width: 80},
										{ label: 'Due date', name: 'dueDate', width: 80},
										{ label: '% done', name: 'percentFinished', width: 80},
										{ label: 'Spent time', name: 'spentTime', width: 80}
									],
									width: 1000,
									height: 200,
									rowNum: 20,
									loadonce: true,
									pager: "#jqGridPager",
									multiselect: true,
									gridComplete: initGrid									
								});
							});

							

						</script>

						<p class="other-formats">
							Also available in: <span><a
								href="/projects/xifin/issues.atom?key=cef790aeee0c4f6682cfe1da65d097b20868c292"
								class="atom" rel="nofollow">Atom</a></span> <span><a
								href="/projects/xifin/issues.csv" class="csv"
								onclick="showModal(&#x27;csv-export-options&#x27;, &#x27;350px&#x27;); return false;"
								rel="nofollow">CSV</a></span> <span><a
								href="/projects/xifin/issues.pdf" class="pdf" rel="nofollow">PDF</a></span>
						</p>
						<div id="csv-export-options" style="display: none;">
							<h3 class="title">CSV export options</h3>
							<form accept-charset="UTF-8" action="/projects/xifin/issues.csv"
								id="csv-export-form" method="get">
								<div style="margin: 0; padding: 0; display: inline">
									<input name="utf8" type="hidden" value="&#x2713;" />
								</div>
								<p>
									<label><input checked="checked" id="columns_"
										name="columns" type="radio" value="" /> Selected Columns</label><br />
									<label><input id="columns_all" name="columns"
										type="radio" value="all" /> All Columns</label>
								</p>
								<p>
									<label><input id="description" name="description"
										type="checkbox" value="1" /> Description</label>
								</p>
								<p class="icon icon-warning">Issues export limit: 1000</p>
								<p class="buttons">
									<input onclick="hideModal(this);" type="submit" value="Export" />
									<input onclick="hideModal(this);" type="button" value="Cancel" />
								</p>
							</form>
						</div>
						<script type="text/javascript">
//<![CDATA[
//contextMenuInit('/issues/context_menu')
//]]>
</script>
						<div class="contextMenu" id="contextMenu" style="display:none">
					        <ul style="width: 300px; font-size: 65%;">
					            <li id="add">
					                <span class="ui-icon ui-icon-plus" style="float:left"></span>
					                <span style="font-size:100%; font-family:Verdana">Add Row</span>
					            </li>
					            <li id="edit">
					                <span class="ui-icon ui-icon-pencil" style="float:left"></span>
					                <span style="font-size:100%; font-family:Verdana">Edit Row</span>
					            </li>                
					            <li id="del">
					                <span class="ui-icon ui-icon-trash" style="float:left"></span>
					                <span style="font-size:100%; font-family:Verdana">Delete Row</span>
					            </li>                
					        </ul>
					    </div>	
						<div style="clear: both;"></div>
					</div>
				</div>
			</div>
			<div id="footer">
				<div class="bgl">
					<div class="bgr">
						Powered by <a href="http://www.redmine.org/">Redmine</a> &copy;
						2006-2015 Jean-Philippe Lang
					</div>
				</div>
			</div>
		</div>
	</div>
	<script src="<c:url value="/resources/js/email_configurations.js" />"
		type="text/javascript"></script>
</body>
</html>