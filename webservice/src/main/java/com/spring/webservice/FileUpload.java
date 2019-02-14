package com.spring.webservice;

import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public interface FileUpload {
	void uploadFile(@WebParam(name="Dfile") FileUploader Dfile);
}


