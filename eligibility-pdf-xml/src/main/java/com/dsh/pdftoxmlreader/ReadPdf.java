package com.dsh.pdftoxmlreader;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;

public class ReadPdf {
	public static boolean findNoticedDate(String date){
		Pattern dateFrmtPtrn = 
				Pattern.compile("\\w+\\s\\d{2},\\s\\d{4}");
		Matcher matcher = dateFrmtPtrn.matcher(date);
		if(matcher.matches()){
			return true;
		}
		return false;
	}


	public static Person personDetails() {
		PdfReader reader;
		String textFromPage;
		String noticeDate = "";
		String applicationId = "";
		String applicationDate = "";
		try {

			reader = new PdfReader("C:/Users/hhasan_con/Downloads/Pdf to xml/1133237-edn.pdf");
			int nPages=reader.getNumberOfPages();
			textFromPage = PdfTextExtractor.getTextFromPage(reader, 1);
			String lines[] = textFromPage.split("\\r?\\n");
			for(int i=0;i<lines.length;i++){
				if(findNoticedDate(lines[i])==true){
					noticeDate=lines[i];
				}
				if(lines[i].contains("Application Date:")){
					String text="Application Date:";
					applicationDate=lines[i].substring(text.length(),lines[i].length());
				}
				if(lines[i].contains("Application ID:")){
					String text="Application ID:";
					applicationId=(lines[i].substring(text.length(),lines[i].length()));
				}

			}
          
		

		} catch (IOException e) {
			e.printStackTrace();
		}
		return new Person(applicationId, applicationDate, noticeDate);

      
     
	}

}