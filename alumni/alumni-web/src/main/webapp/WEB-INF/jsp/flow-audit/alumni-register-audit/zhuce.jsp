<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<form class="form-horizontal" id="baseInfoForm">
	<div class="clearfix">
		<div class="col-sm-6">
			<input type="hidden" id="entityId" value="${entity.id}">
			<div class="form-group">
				<label class="col-sm-4 control-label"> 姓名: </label>
				<div class="col-sm-8">
					<p class="form-control-static">${entity.name}</p>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-4 control-label"> <span
					class="star"></span> 性别:
				</label>
				<div class="col-sm-8">
					<p class="form-control-static">${entity.genderName}</p>
				</div>
			</div>

			<div class="form-group">
				<label class="col-sm-4 control-label"> 出生日期: </label>
				<div class="col-sm-8">
					<p class="form-control-static">
						<s:date name="entity.birthDate" format="yyyy-MM-dd" />
					</p>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-4 control-label"> 政治面貌： </label>
				<div class="col-sm-8">
					<p class="form-control-static">${entity.politicalStatusName}</p>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-4 control-label"> 毕业年份： </label>
				<div class="col-sm-8">
					<p class="form-control-static " rows="4">${entity.reVarchar1}</p>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-4 control-label"> 专业: </label>
				<div class="col-sm-8">
					<p class="form-control-static">${entity.magorName}</p>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-4 control-label"> 班级名称: </label>
				<div class="col-sm-8">
					<p class="form-control-static">${entity.className}</p>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-4 control-label"> 辅导员/导师: </label>
				<div class="col-sm-8">
					<p class="form-control-static">${entity.teacher}</p>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-4 control-label"> 行业: </label>
				<div class="col-sm-8">
					<p class="form-control-static">${entity.industryName}</p>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-4 control-label"> 单位地址: </label>
				<div class="col-sm-8">
					<p class="form-control-static">${entity.companyAddress}</p>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-4 control-label"> 部门: </label>
				<div class="col-sm-8">
					<p class="form-control-static">${entity.department}</p>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-4 control-label"> 办公电话: </label>
				<div class="col-sm-8">
					<p class="form-control-static">${entity.officePhone}</p>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-4 control-label"> 职称: </label>
				<div class="col-sm-8">
					<p class="form-control-static">${entity.title}</p>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-4 control-label"> 家庭邮编： </label>
				<div class="col-sm-8">
					<p class="form-control-static " rows="4">${entity.reVarchar3}</p>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-4 control-label"> QQ: </label>
				<div class="col-sm-8">
					<p class="form-control-static">${entity.qq}</p>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-4 control-label"> 微信昵称: </label>
				<div class="col-sm-8">
					<p class="form-control-static">${entity.wechatName}</p>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-4 control-label"> 校友身份: </label>
				<div class="col-sm-8">
					<p class="form-control-static">${entity.alumniIdentityName}</p>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-4 control-label"> 永久通讯地址: </label>
				<div class="col-sm-8">
					<p class="form-control-static">${entity.address}</p>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-4 control-label"> 备注2: </label>
				<div class="col-sm-8">
					<p class="form-control-static">${entity.remark2}</p>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-4 control-label"> 备注4: </label>
				<div class="col-sm-8">
					<p class="form-control-static">${entity.remark4}</p>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-4 control-label"> 备注6: </label>
				<div class="col-sm-8">
					<p class="form-control-static">${entity.remark6}</p>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-4 control-label"> 备注8: </label>
				<div class="col-sm-8">
					<p class="form-control-static">${entity.remark8}</p>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-4 control-label"> 备注10: </label>
				<div class="col-sm-8">
					<p class="form-control-static">${entity.remark10}</p>
				</div>
			</div>
		</div>

		<div class="col-sm-6">
			<div class="form-group">
				<label class="col-sm-4 control-label"> 学号/职工号: </label>
				<div class="col-sm-8">
					<p class="form-control-static">${entity.code}</p>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-4 control-label"> 身份: </label>
				<div class="col-sm-8">
					<p class="form-control-static">${entity.identityName}</p>
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
					<p class="form-control-static">${entity.enrollYear}</p>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-4 control-label"> 院系: </label>
				<div class="col-sm-8">
					<p class="form-control-static">${entity.collegeName}</p>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-4 control-label"> 最高学历: </label>
				<div class="col-sm-8">
					<p class="form-control-static">${entity.highestEducationName}</p>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-4 control-label"> 标签（空格分隔）: </label>
				<div class="col-sm-8">
					<p class="form-control-static">${entity.label}</p>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-4 control-label"> 所在单位: </label>
				<div class="col-sm-8">
					<p class="form-control-static">${entity.company}</p>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-4 control-label"> 单位所在省/市: </label>
				<div class="col-sm-8">
					<!--TODO:调控件-->
					<p class="form-control-static">${entity.companyCityStr}</p>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-4 control-label"> 单位邮编： </label>
				<div class="col-sm-8">
					<p class="form-control-static " rows="4">${entity.reVarchar2}</p>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-4 control-label"> 手机: </label>
				<div class="col-sm-8">
					<p class="form-control-static">${entity.phone}</p>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-4 control-label"> 职务: </label>
				<div class="col-sm-8">
					<p class="form-control-static">${entity.post}</p>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-4 control-label"> 籍贯： </label>
				<div class="col-sm-8">
					<!--TODO:调控件-->
					<p class="form-control-static">${entity.nativeStr}</p>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-4 control-label"> 邮箱: </label>
				<div class="col-sm-8">
					<p class="form-control-static">${entity.email}</p>
				</div>
			</div>

			<div class="form-group">
				<label class="col-sm-4 control-label"> 微信： </label>
				<div class="col-sm-8">
					<p class="form-control-static " rows="4">${entity.wechatId}</p>
				</div>
			</div>

			<div class="form-group">
				<label class="col-sm-4 control-label"> 校友会任职身份: </label>
				<div class="col-sm-8">
					<p class="form-control-static">${entity.alumniClubIdentityName}</p>
				</div>
			</div>

			<div class="form-group">
				<label class="col-sm-4 control-label"> 校友分会任职身份: </label>
				<div class="col-sm-8">
					<p class="form-control-static">${entity.branchClubIdentityName}</p>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-4 control-label"> 备注1: </label>
				<div class="col-sm-8">
					<p class="form-control-static">${entity.remark1}</p>
				</div>
			</div>

			<div class="form-group">
				<label class="col-sm-4 control-label"> 备注3: </label>
				<div class="col-sm-8">
					<p class="form-control-static">${entity.remark3}</p>
				</div>
			</div>

			<div class="form-group">
				<label class="col-sm-4 control-label"> 备注5: </label>
				<div class="col-sm-8">
					<p class="form-control-static">${entity.remark5}</p>
				</div>
			</div>

			<div class="form-group">
				<label class="col-sm-4 control-label"> 备注7: </label>
				<div class="col-sm-8">
					<p class="form-control-static">${entity.remark7}</p>
				</div>
			</div>

			<div class="form-group">
				<label class="col-sm-4 control-label"> 备注9: </label>
				<div class="col-sm-8">
					<p class="form-control-static">${entity.remark9}</p>
				</div>
			</div>
		</div>
	</div>
</form>
