package com.fable.dwjd.common.export;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;

public class DocumentHandler {

	private static final String EXPORT_PATH = "/export";
	
	private String template = null;
	
	private Configuration configuration = null;
	
	public DocumentHandler() {
		configuration = new Configuration();
		configuration.setDefaultEncoding("UTF-8");
	}
	
	public String getTemplate() {
		return template;
	}

	public void setTemplate(String template) {
		this.template = template;
	}

	public void createDoc(Map<String, Object> dataMap, String fileName) throws UnsupportedEncodingException, FileNotFoundException {
		configuration.setClassForTemplateLoading(this.getClass(), EXPORT_PATH);
		Template t = null;
		try {
			t = configuration.getTemplate(template + ".ftl");
		} catch (Exception e) {
			e.printStackTrace();
		}
		File outFile = new File(fileName);
		Writer out = null;
		FileOutputStream fos = new FileOutputStream(outFile);
		out = new OutputStreamWriter(fos, "UTF-8");
		
		try {
			t.process(dataMap, out);
			out.flush();
			out.close();
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
