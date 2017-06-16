package com.wisdombud.alumni.manage;

import java.util.List;

import com.wisdombud.alumni.pojo.manage.BaseAlumni;
import com.wisdombud.alumni.pojo.manage.BaseAlumniImport;

public interface ImportExportSrv {
	public BaseAlumniImport convert(BaseAlumni entity);

	public BaseAlumni convert(BaseAlumniImport entity);

	public List<BaseAlumniImport> convert2Export(List<BaseAlumni> entityList);

	public List<BaseAlumni> convert2Base(List<BaseAlumniImport> entityList);
}
