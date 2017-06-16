<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<div class="clearfix">
	<form class="form-inline clearfix" id="sech-form" role="form">
		<div class="sl-item marb">
			<div class="form-group marb">
				<label class="label-reset">姓名：</label>
				<input placeholder="姓名" class="form-control input-reset" value="${entity.name}" name="entity.name">
			</div>
			<div class="form-group marb">
				<label class="label-reset">入学年份：</label>
				<input placeholder="入学年份" class="form-control input-reset form_year" value="${entity.enrollYear}" name="entity.enrollYear">
			</div>
			<div class="form-group marb">
				<label class="label-reset">院系：</label>
				<select id="collegeId" name="entity.college" class="form-control input-reset">
				</select>
			</div>
			<div class="form-group marb">
				<label class="label-reset">专业：</label>
				<select id="major-sel" name="entity.magorName" class="form-control input-reset">
				</select>
			</div>
			<div class="btn-search-parent">
				<button class="btn btn-sm btn-info mar0" type="button" id="btn-search">查 询</button>
			</div>
		</div>

	</form>
	<table class="table  table-bordered table-hover">
		<thead>
			<tr>
				<th class="bs-checkbox" style="width:36px;">
					<input type="checkbox" class="check-all">
				</th>
				<th>姓名</th>
				<th>标签</th>
				<th>院系</th>
				<th>单位</th>
				<th>职务</th>
				<th>联系电话</th>
				<th>邮箱</th>
			</tr>
		</thead>
		<tbody id="gridBody">
		</tbody>
	</table>
	<div align="right">
		<ul class="pagination" id="pageUl">
		</ul>
	</div>
</div>

<script type="text/html" id="gridTpl">
	{{each results as value index}}
	<tr id="{{value.id}}">
		<td class="bs-checkbox" style="width:36px;">
			<input type="checkbox" class="child" value="{{value.id}}">
		</td>
		<td>{{value.name}}</td>
		<td>{{value.label}}</td>
		<td>{{value.collegeName}}</td>
		<td>{{value.company}}</td>
		<td>{{value.post}}</td>
		<td>{{value.phone}}</td>
		<td>{{value.email}}</td>
	</tr>
	{{/each}}
</script>