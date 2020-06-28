package com.unisys.web.tags;

import java.io.BufferedReader;
import java.io.FileReader;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class IncludeTag extends TagSupport {

	private static final long serialVersionUID = 1310271075941929491L;

	private String type = "ol";
	private String file;

	public IncludeTag() {
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	@Override
	public int doStartTag() throws JspException {
		file = pageContext.getServletContext().getRealPath(".") + "/" + file;

		try(
				FileReader reader = new FileReader(file);
				BufferedReader in = new BufferedReader(reader);		
		) {
			// this is the same "out" variable used by the containing JSP
			JspWriter out = pageContext.getOut();
			out.write("<" + type + ">");
			
			
			
			String line;
			while((line=in.readLine())!=null) {
				out.write("<li>");
				out.write(line);
				out.write("</li>");
			}
			
			out.write("</" + type + ">");
			
			
		} catch (Exception e) {
			throw new JspException(e);
		}
		
		return super.doStartTag();
	}
	
	

}
