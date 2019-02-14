package com.webservice.client;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

import com.spring.webservice.FileUpload;
import com.spring.webservice.FileUploader;

/**
 * Servlet implementation class HomeController
 */
@WebServlet("/fileUpload")
public class FileUploadController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FileUploadController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/fileUpload.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("FileUploadController 호출 ");

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		// multipart로 가져온 파일 객체를 새로 만든 파일 객체에 한 번 쓰고 얘를 FileDataSource로 보내준다?
		Part part = request.getPart("file");
		String fileName = getFilename(part);
		System.out.println("파일명 : " + fileName);

		// 얘를 리턴하는 파일을 FileDataSource로 던져줘
		readFile(part);

		JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();

		factory.getInInterceptors().add(new LoggingInInterceptor());
		factory.getOutInterceptors().add(new LoggingOutInterceptor());
		factory.setServiceClass(FileUpload.class);
		factory.setAddress("http://localhost:9999/webservice/FileUpload");
		FileUpload client = (FileUpload) factory.create();

		FileUploader file = new FileUploader();

		file.setName("Partha");
		file.setFileType("doc");

		DataSource source = new FileDataSource(new File("D:/test/aa.doc"));
		file.setDfile(new DataHandler(source));
		client.uploadFile(file);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/index.jsp");
		dispatcher.forward(request, response);
	}

	private String getFilename(Part part) {
		String fileName = null;
		String contentDispositionHeader = part.getHeader("content-disposition");
		System.out.println(" part.getHeader :" + part.getHeader("content-disposition"));
		// part.getHeader :form-data; name="theFile";
		// filename="RHDSetup.log" 처럼 헤더가 나옴 따라서 세미콜론마다 지워야 할 필요성이 있음
		String[] elements = contentDispositionHeader.split(";");

		for (String element : elements) {
			System.out.println("서브스트링 전:" + element);
			fileName = element.substring(element.indexOf('=') + 1);
			System.out.println("트림 전:" + fileName);
			fileName = fileName.trim().replace("\"", " "); // " <- 쌍따옴표 지움
			System.out.println("트림 후:" + fileName);
		}
		return fileName;
	}

	private void readFile(Part part) {
		try {
			InputStream a = part.getInputStream();
			while (true) {
				int i = a.read();
				if (i == -1)
					break;

				String url = "D:/origintest/data.txt";
				File f = new File(url);
				byte[] b = null;

				FileInputStream fis = (FileInputStream) part.getInputStream();
				int pos = 0;
				int size = 10;
				int temp;
				while ((size = fis.read(b, pos, size)) > 0) {
					pos += size;
					temp = b.length - pos;
					if (temp < 10) {
						size = temp;
					}
				}
				fis.close();
				System.out.println("읽은 바이트 수:" + pos);

				// 4.배열을 통째로 파일에 기록하기
				FileOutputStream fos = new FileOutputStream("D:/test/text.txt");
				fos.write(b);
				fos.close();

			}
		} catch (Exception e) {
			e.printStackTrace();

		}

	}

}
