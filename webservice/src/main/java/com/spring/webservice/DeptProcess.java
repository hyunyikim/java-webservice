package com.spring.webservice;

import java.util.List;

import javax.jws.WebService;
import javax.servlet.http.HttpServletRequest;

@WebService
public interface DeptProcess {
	List<DeptVo> processDept();
	/* public void fileUpload(HttpServletRequest request); */
}
