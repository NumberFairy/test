package com.wisdombud.alumni.dao.manage.impl;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.hibernate.SQLQuery;
import org.hibernate.criterion.Order;
import org.hibernate.transform.Transformers;
import org.hibernate.type.StandardBasicTypes;
import org.springframework.stereotype.Repository;

import com.wisdombud.alumni.dao.manage.BaseAlumniDao;
import com.wisdombud.alumni.pojo.manage.BaseAlumni;
import com.wisdombud.alumni.vo.Param;

import common.toolkit.java.entity.PageEntity;
import common.toolkit.java.orm.hibernate.QueryExtension;
import common.toolkit.java.orm.hibernate.SimpleHibernateDao;

/**
 * 校友信息表 DaoImpl. <br/>
 * 
 * @author Administrator
 * 
 */
@Repository(value = "baseAlumniDao")
public class BaseAlumniDaoImpl extends SimpleHibernateDao<BaseAlumni, String> implements BaseAlumniDao {

	private String selSql(Map<String, Object> map) {
		StringBuffer sql = new StringBuffer(" SELECT");
		sql.append(" a.ID,a.NAME name,a.CODE code,a.GENDER gender,a.IDENTITY identity,");
		sql.append(" a.BIRTH_DATE birthDate, a.RE_VARCHAR_0 reVarchar0,a.POLITICAL_STATUS politicalStatus,");
		sql.append(" a.ENROLL_YEAR enrollYear,a.RE_VARCHAR_1 reVarchar1,a.COLLEGE college,a.MAJOR major,");
		sql.append(" a.HIGHEST_EDUCATION highestEducation,a.CLASS_NAME className,a.LABEL label,");
		sql.append(" a.TEACHER teacher,a.COMPANY company,a.INDUSTRY industry,a.COMPANY_CITY_STR companyCityStr,");
		sql.append(" a.COMPANY_ADDRESS companyAddress,a.RE_VARCHAR_2 reVarchar2,a.DEPARTMENT department,");
		sql.append(" a.PHONE phone,a.OFFICE_PHONE officePhone,a.POST post,a.TITLE title,");
		sql.append(" a.NATIVE_STR nativeStr,a.RE_VARCHAR_3 reVarchar3,a.EMAIL email,a.QQ qq,");
		sql.append(" a.WECHAT_ID wechatId,a.WECHAT_NAME wechatName,a.ADDRESS address,");
		sql.append(" a.REMARK1 remark1, a.REMARK2 remark2, a.REMARK3 remark3,a.REMARK4 remark4,");
		sql.append(" a.REMARK5 remark5, a.REMARK6 remark6, a.REMARK7 remark7,a.REMARK8 remark8,");
		sql.append(" a.REMARK9 remark9, a.REMARK10 remark10");

		sql.append(" FROM BASE_ALUMNI a");
		sql.append(" LEFT JOIN BASE_IDENTITY_RELATION i ON( a.ID=i.ALUMNI_ID) WHERE 1=1");
		buildSql(sql, map);
		sql.append(" ORDER BY a.LAST_UPDATE DESC,a.CREATE_TIME DESC , a.ENROLL_YEAR DESC");
		return sql.toString();
	}

	private void addScalar(SQLQuery sql) {

		sql.addScalar("id");
		sql.addScalar("name");
		sql.addScalar("code");
		sql.addScalar("gender", StandardBasicTypes.INTEGER);
		sql.addScalar("identity", StandardBasicTypes.INTEGER);

		sql.addScalar("birthDate");
		sql.addScalar("reVarchar0");
		sql.addScalar("politicalStatus", StandardBasicTypes.INTEGER);
		sql.addScalar("enrollYear", StandardBasicTypes.INTEGER);
		sql.addScalar("reVarchar1");

		sql.addScalar("college", StandardBasicTypes.INTEGER);
		sql.addScalar("major");
		sql.addScalar("highestEducation", StandardBasicTypes.INTEGER);
		sql.addScalar("className");
		sql.addScalar("label");

		sql.addScalar("teacher");
		sql.addScalar("company");
		sql.addScalar("industry", StandardBasicTypes.INTEGER);
		sql.addScalar("companyCityStr");
		sql.addScalar("companyAddress");

		sql.addScalar("reVarchar2");// 单位邮编
		sql.addScalar("department");
		sql.addScalar("phone");
		sql.addScalar("officePhone");
		sql.addScalar("post");

		sql.addScalar("title");// 职称
		sql.addScalar("nativeStr");
		sql.addScalar("reVarchar3");// 家庭邮编
		sql.addScalar("email");
		sql.addScalar("qq");

		sql.addScalar("wechatId");// 微信
		sql.addScalar("wechatName");
		sql.addScalar("address");
		sql.addScalar("remark1");
		sql.addScalar("remark2");

		sql.addScalar("remark3");
		sql.addScalar("remark4");
		sql.addScalar("remark5");
		sql.addScalar("remark6");
		sql.addScalar("remark7");

		sql.addScalar("remark8");
		sql.addScalar("remark9");
		sql.addScalar("remark10");

		sql.setResultTransformer(Transformers.aliasToBean(BaseAlumni.class));
	}

	@Override
	public void page(PageEntity<BaseAlumni> pageEntity, Map<String, Param> params, List<Order> orders) {
		Map<String, Object> map = buildParams(params);
		pageBySql(selSql(map), pageEntity, queryExtension(), map);
	}

	public void buildSql(StringBuffer hql, Map<String, Object> parm) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

		if (parm.containsKey("name")) {
			hql.append(" AND a.NAME LIKE :name");
		}
		if (parm.containsKey("college")) {
			hql.append(" AND a.COLLEGE = :college");
		}
		if (parm.containsKey("major")) {
			hql.append(" AND a.MAJOR = :major");
		}
		if (parm.containsKey("gender")) {
			hql.append(" AND a.GENDER = :gender");
		}
		if (parm.containsKey("identity")) {
			hql.append(" AND a.IDENTITY = :identity");
		}
		if (parm.containsKey("code")) {
			hql.append(" AND a.CODE = :code");
		}
		if (parm.containsKey("birthDate")) {
			hql.append(" AND a.BIRTH_DATE like '%" + df.format(parm.get("birthDate")) + "%'");
			parm.remove("birthDate");
		}
		if (parm.containsKey("nativeStr")) {
			hql.append(" AND a.NATIVE_STR = :nativeStr");
		}
		if (parm.containsKey("politicalStatus")) {
			hql.append(" AND a.POLITICAL_STATUS = :politicalStatus");
		}
		if (parm.containsKey("enrollYear")) {
			hql.append(" AND a.ENROLL_YEAR = :enrollYear");
		}
		if (parm.containsKey("reVarchar1")) {
			hql.append(" AND a.RE_VARCHAR_1 LIKE '" + parm.get("reVarchar1") + "'");
			parm.remove("reVarchar1");
		}
		if (parm.containsKey("wechatId")) {
			hql.append(" AND a.WECHAT_ID LIKE :wechatId");
		}
		if (parm.containsKey("wechatName")) {
			hql.append(" AND a.WECHAT_NAME LIKE :wechatName");
		}
		if (parm.containsKey("phone")) {
			hql.append(" AND a.PHONE LIKE :phone");
		}
		if (parm.containsKey("email")) {
			hql.append(" AND a.EMAIL LIKE :email");
		}
		if (parm.containsKey("className")) {
			hql.append(" AND a.CLASS_NAME LIKE :className");
		}
		if (parm.containsKey("teacher")) {
			hql.append(" AND a.TEACHER LIKE :teacher");
		}
		if (parm.containsKey("company")) {
			hql.append(" AND a.COMPANY LIKE :company");
		}
		if (parm.containsKey("reVarchar2")) {
			hql.append(" AND a.RE_VARCHAR_2 LIKE :reVarchar2");
		}
		if (parm.containsKey("reVarchar3")) {
			hql.append(" AND a.RE_VARCHAR_3 LIKE :reVarchar3");
		}
		if (parm.containsKey("companyAddress")) {
			hql.append(" AND a.COMPANY_ADDRESS LIKE :companyAddress");
		}
		if (parm.containsKey("department")) {
			hql.append(" AND a.DEPARTMENT LIKE :department");
		}
		if (parm.containsKey("title")) {
			hql.append(" AND a.TITLE LIKE :title");
		}
		if (parm.containsKey("address")) {
			hql.append(" AND a.ADDRESS LIKE :address");
		}
		if (parm.containsKey("highestEducation")) {
			hql.append(" AND a.HIGHEST_EDUCATION = :highestEducation");
		}
		if (parm.containsKey("alumniClubIdentityId")) {
			hql.append(" AND i.ALUMNI_CLUB_IDENTITY_ID LIKE :alumniClubIdentityId");
		}
		if (parm.containsKey("alumniIdentityId")) {
			hql.append(" AND i.ALUMNI_IDENTITY_ID LIKE :alumniIdentityId");
		}
		if (parm.containsKey("branchClubIdentityId")) {
			hql.append(" AND i.BRANCH_CLUB_IDENTITY_ID LIKE :branchClubIdentityId");
		}
		if (parm.containsKey("industry")) {
			hql.append(" AND a.INDUSTY = :industry");
		}
		if (parm.containsKey("companyCityStr")) {
			hql.append(" AND a.COMPANY_CITY_STR LIKE :companyCityStr");
		}
		if (parm.containsKey("officePhone")) {
			hql.append(" AND a.OFFICE_PHONE LIKE :officePhone");
		}
		if (parm.containsKey("post")) {
			hql.append(" AND a.POST LIKE :post");
		}
		if (parm.containsKey("remark1")) {
			hql.append(" AND a.REMARK1 LIKE :remark1");
		}
		if (parm.containsKey("remark2")) {
			hql.append(" AND a.REMARK2 LIKE :remark2");
		}
		if (parm.containsKey("remark3")) {
			hql.append(" AND a.REMARK3 LIKE :remark3");
		}
		if (parm.containsKey("remark4")) {
			hql.append(" AND a.REMARK4 LIKE :remark4");
		}
		if (parm.containsKey("remark5")) {
			hql.append(" AND a.REMARK5 LIKE :remark5");
		}
		if (parm.containsKey("remark6")) {
			hql.append(" AND a.REMARK6 LIKE :remark6");
		}
		if (parm.containsKey("remark7")) {
			hql.append(" AND a.REMARK7 LIKE :remark7");
		}
		if (parm.containsKey("remark8")) {
			hql.append(" AND a.REMARK8 LIKE :remark8");
		}
		if (parm.containsKey("remark9")) {
			hql.append(" AND a.REMARK9 LIKE :remark9");
		}
		if (parm.containsKey("remark10")) {
			hql.append(" AND a.REMARK10 LIKE :remark10");
		}

	}

	protected Map<String, Object> buildParams(Map<String, Param> params) {
		Map<String, Object> paramsMap = new HashMap<String, Object>();
		for (Entry<String, Param> entry : params.entrySet()) {
			paramsMap.put(entry.getKey(), entry.getValue().getVal());
		}
		return paramsMap;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<BaseAlumni> findBy(Map<String, Param> params, List<Order> orders) {
		Map<String, Object> map = buildParams(params);
		SQLQuery sql = createSQLQuery(selSql(map), map);
		addScalar(sql);
		sql.setResultTransformer(Transformers.aliasToBean(BaseAlumni.class));
		return sql.list();
	}

	private QueryExtension<BaseAlumni> queryExtension() {
		QueryExtension<BaseAlumni> q = new QueryExtension<BaseAlumni>() {
			@Override
			public void doExtend(SQLQuery sq) {
				addScalar(sq);
			}
		};
		return q;
	}
}
