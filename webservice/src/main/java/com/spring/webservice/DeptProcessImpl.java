package com.spring.webservice;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

@WebService(endpointInterface = "com.spring.webservice.DeptProcess")
public class DeptProcessImpl implements DeptProcess {
    
    @Override
    public List<DeptVo> processDept() {
        //System.out.println("웹서비스 호출");
        List<DeptVo> deptVos = new ArrayList<DeptVo>();
        for(int i=0;i<20;i++) {
            DeptVo deptVo = new DeptVo();
            deptVo.setDeptName("부서명"+i);
            deptVo.setDeptNo(i);
            deptVo.setLocation("지역"+i);
            deptVos.add(deptVo);
        }
        return deptVos;
    }
    
    /*
    @Override
    public void fileUpload(HttpServletRequest request) {
    	// 첨부 파일 처리
		String saveDir = request.getSession().getServletContext().getRealPath("/upload");
		int maxSize = 1024 * 1024 * 100;
		String encType = "UTF-8";
		
		try {
			MultipartRequest multipartRequest 
				= new MultipartRequest(request, saveDir, maxSize, encType, new DefaultFileRenamePolicy());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	*/
}
