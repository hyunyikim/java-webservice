package com.spring.webservice;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.activation.DataHandler;
import javax.jws.WebService;

@WebService(endpointInterface = "com.spring.webservice.FileUpload")
public class FileUploadImpl implements FileUpload {

	@Override
	public void uploadFile(FileUploader Dfile) {
		DataHandler handler = Dfile.getDfile();
		try {
			InputStream is = handler.getInputStream();
			OutputStream os = new FileOutputStream(
					new File("D:/test/" + Dfile.getName() + "." + Dfile.getFileType()));
			byte[] b = new byte[100000];
			int bytesRead = 0;
			while ((bytesRead = is.read(b)) != -1) {
				os.write(b, 0, bytesRead);
			}
			os.flush();
			os.close();
			is.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
