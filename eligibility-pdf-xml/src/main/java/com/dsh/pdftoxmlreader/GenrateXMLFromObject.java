package com.dsh.pdftoxmlreader;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;

public class GenrateXMLFromObject {

	private static Configuration cfg = null;

	static{		
		// Freemarker below configuration object deprecated
		//Configuration cfg = new Configuration();
		//Please use this. To make it backward compatible. Please visit here for more info: 
		//http://freemarker.org/docs/api/freemarker/template/Configuration.html
		cfg = new Configuration();
	}

	public static void main(String[] args) {
		Person person=ReadPdf.personDetails();
		System.out.println("Noticed Date: "+person.getNoticeDate());
		System.out.println("Application Date: "+person.getApplicationDate());
		System.out.println("Application Id: "+person.getApplicationId());
		ReadPdf.personDetails();

		try {

			Template template = cfg.getTemplate("src/main/resources/EligibilityXML.ftl");

			// Create data for template
			Map<String, Object> templateData = new HashMap<String, Object>();
			templateData.put("applicationId", person.getApplicationId());
			templateData.put("applicationDate", person.getApplicationDate());
			templateData.put("noticeDate", person.getNoticeDate());
			
			// Write data to the file
			Writer file = new FileWriter(new File("src/main/resources/BuildXMLTemplateXML.xml"));
			template.process(templateData, file);
			file.flush();
			file.close();

		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
}