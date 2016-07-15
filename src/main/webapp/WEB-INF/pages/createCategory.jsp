<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- <html> -->
<!-- <head> -->
<!-- <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"> -->
<!-- <title>Insert title here</title> -->
<!-- </head> -->
<!-- <body> -->

<!-- </body> -->
<!-- </html> -->

<form accept-charset="UTF-8" action="<c:url value="/category/create" />"
	class="new_issue_category" id="new_issue_category" method="post">
	<div style="margin: 0; padding: 0; display: inline">
		<input name="utf8" type="hidden" value="✓"><input
			name="authenticity_token" type="hidden"
			value="I9DQaXoImDRa2voHuiAWC6ZavGmZ2Pacs6faMY4/mxs=">
	</div>


	<div>
		<p style="padding-left: 12px">
			<label for="issue_category_name">Name<span class="required">*</span></label>
			<input id="issue_category_name" name="issue_category[name]" size="30" type="text" value="">
		</p>
		<p>
			<label for="issue_category_assigned_to_id">Assignee</label>
			<select
				id="issue_category_assigned_to_id"
				name="issue_category[assigned_to_id]">
				<option value="">&nbsp;</option>
				<option value="275">&lt;&lt; me &gt;&gt;</option>
				<c:forEach var="item" items="${members}">
					<option value="${item.id}">${item.fullName}</option>
				</c:forEach>
			</select>
		</p>
	</div>

	<input name="commit" type="submit" value="Create">
</form>
<div style="clear: both;"></div>