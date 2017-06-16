<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<form class="form-horizontal" id="baseInfoForm">
	<div class="clearfix">
		<div class="col-sm-6">
			<input type="hidden" id="entityId" value="${alumni.id}">
			<div class="form-group">
				<label class="col-sm-4 control-label"> 姓名: </label>
				<div class="col-sm-8">
					<p class="form-control-static">${alumni.name}</p>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-4 control-label"> <span
					class="star"></span> 性别:
				</label>
				<div class="col-sm-8">
					<p class="form-control-static">${alumni.genderName}</p>
				</div>
			</div>

			<div class="form-group">
				<label class="col-sm-4 control-label"> 出生日期: </label>
				<div class="col-sm-8">
					<p class="form-control-static">
						<s:date name="alumni.birthDate" format="yyyy-MM-dd" />
					</p>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-4 control-label"> 政治面貌： </label>
				<div class="col-sm-8">
					<p class="form-control-static">${alumni.politicalStatusName}</p>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-4 control-label"> 毕业年份： </label>
				<div class="col-sm-8">
					<p class="form-control-static " rows="4">${alumni.reVarchar1}</p>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-4 control-label"> 专业: </label>
				<div class="col-sm-8">
					<p class="form-control-static">${alumni.magorName}</p>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-4 control-label"> 班级名称: </label>
				<div class="col-sm-8">
					<p class="form-control-static">${alumni.className}</p>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-4 control-label"> 辅导员/导师: </label>
				<div class="col-sm-8">
					<p class="form-control-static">${alumni.teacher}</p>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-4 control-label"> 行业: </label>
				<div class="col-sm-8">
					<p class="form-control-static">${alumni.industryName}</p>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-4 control-label"> 单位地址: </label>
				<div class="col-sm-8">
					<p class="form-control-static">${alumni.companyAddress}</p>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-4 control-label"> 部门: </label>
				<div class="col-sm-8">
					<p class="form-control-static">${alumni.department}</p>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-4 control-label"> 办公电话: </label>
				<div class="col-sm-8">
					<p class="form-control-static">${alumni.officePhone}</p>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-4 control-label"> 职称: </label>
				<div class="col-sm-8">
					<p class="form-control-static">${alumni.title}</p>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-4 control-label"> 家庭邮编： </label>
				<div class="col-sm-8">
					<p class="form-control-static " rows="4">${alumni.reVarchar3}</p>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-4 control-label"> QQ: </label>
				<div class="col-sm-8">
					<p class="form-control-static">${alumni.qq}</p>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-4 control-label"> 微信昵称: </label>
				<div class="col-sm-8">
					<p class="form-control-static">${alumni.wechatName}</p>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-4 control-label"> 校友身份: </label>
				<div class="col-sm-8">
					<p class="form-control-static">${alumni.alumniIdentityName}</p>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-4 control-label"> 永久通讯地址: </label>
				<div class="col-sm-8">
					<p class="form-control-static">${alumni.address}</p>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-4 control-label"> 备注2: </label>
				<div class="col-sm-8">
					<p class="form-control-static">${alumni.remark2}</p>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-4 control-label"> 备注4: </label>
				<div class="col-sm-8">
					<p class="form-control-static">${alumni.remark4}</p>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-4 control-label"> 备注6: </label>
				<div class="col-sm-8">
					<p class="form-control-static">${alumni.remark6}</p>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-4 control-label"> 备注8: </label>
				<div class="col-sm-8">
					<p class="form-control-static">${alumni.remark8}</p>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-4 control-label"> 备注10: </label>
				<div class="col-sm-8">
					<p class="form-control-static">${alumni.remark10}</p>
				</div>
			</div>
		</div>

		<div class="col-sm-6">
			<div class="form-group">
				<label class="col-sm-4 control-label"> 学号/职工号: </label>
				<div class="col-sm-8">
					<p class="form-control-static">${alumni.code}</p>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-4 control-label"> 身份: </label>
				<div class="col-sm-8">
					<p class="form-control-static">${alumni.identityName}</p>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-4 control-label">民族: </label>
				<div class="col-sm-8">
					<p class="form-control-static">${entity.nationalName}</p>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-4 control-label"> 入学年份: </label>
				<div class="col-sm-8">
					<p class="form-control-static">${alumni.enrollYear}</p>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-4 control-label"> 院系: </label>
				<div class="col-sm-8">
					<p class="form-control-static">${alumni.collegeName}</p>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-4 control-label"> 最高学历: </label>
				<div class="col-sm-8">
					<p class="form-control-static">${alumni.highestEducationName}</p>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-4 control-label"> 标签（空格分隔）: </label>
				<div class="col-sm-8">
					<p class="form-control-static">${alumni.label}</p>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-4 control-label"> 所在单位: </label>
				<div class="col-sm-8">
					<p class="form-control-static">${alumni.company}</p>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-4 control-label"> 单位所在省/市: </label>
				<div class="col-sm-8">
					<!--TODO:调控件-->
					<p class="form-control-static">${alumni.companyCityStr}</p>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-4 control-label"> 单位邮编： </label>
				<div class="col-sm-8">
					<p class="form-control-static " rows="4">${alumni.reVarchar2}</p>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-4 control-label"> 手机: </label>
				<div class="col-sm-8">
					<p class="form-control-static">${alumni.phone}</p>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-4 control-label"> 职务: </label>
				<div class="col-sm-8">
					<p class="form-control-static">${alumni.post}</p>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-4 control-label"> 籍贯： </label>
				<div class="col-sm-8">
					<!--TODO:调控件-->
					<p class="form-control-static">${alumni.nativeStr}</p>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-4 control-label"> 邮箱: </label>
				<div class="col-sm-8">
					<p class="form-control-static">${alumni.email}</p>
				</div>
			</div>

			<div class="form-group">
				<label class="col-sm-4 control-label"> 微信： </label>
				<div class="col-sm-8">
					<p class="form-control-static " rows="4">${alumni.wechatId}</p>
				</div>
			</div>

			<div class="form-group">
				<label class="col-sm-4 control-label"> 校友会任职身份: </label>
				<div class="col-sm-8">
					<p class="form-control-static">${alumni.alumniClubIdentityName}</p>
				</div>
			</div>

			<div class="form-group">
				<label class="col-sm-4 control-label"> 校友分会任职身份: </label>
				<div class="col-sm-8">
					<p class="form-control-static">${alumni.branchClubIdentityName}</p>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-4 control-label"> 备注1: </label>
				<div class="col-sm-8">
					<p class="form-control-static">${alumni.remark1}</p>
				</div>
			</div>

			<div class="form-group">
				<label class="col-sm-4 control-label"> 备注3: </label>
				<div class="col-sm-8">
					<p class="form-control-static">${alumni.remark3}</p>
				</div>
			</div>

			<div class="form-group">
				<label class="col-sm-4 control-label"> 备注5: </label>
				<div class="col-sm-8">
					<p class="form-control-static">${alumni.remark5}</p>
				</div>
			</div>

			<div class="form-group">
				<label class="col-sm-4 control-label"> 备注7: </label>
				<div class="col-sm-8">
					<p class="form-control-static">${alumni.remark7}</p>
				</div>
			</div>

			<div class="form-group">
				<label class="col-sm-4 control-label"> 备注9: </label>
				<div class="col-sm-8">
					<p class="form-control-static">${alumni.remark9}</p>
				</div>
			</div>
		</div>
	</div>
</form>
