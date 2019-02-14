package com.spring.webservice;

import javax.activation.DataHandler;

public class FileUploader {
	private String Name;
	private String FileType;
	private DataHandler Dfile;

	public String getName() {
		return this.Name;
	}

	public void setName(String Name) {
		this.Name = Name;
	}

	public DataHandler getDfile() {
		return this.Dfile;
	}

	public void setDfile(DataHandler Dfile) {
		this.Dfile = Dfile;
	}

	public String getFileType() {
		return FileType;
	}

	public void setFileType(String FileType) {
		this.FileType = FileType;
	}

}
