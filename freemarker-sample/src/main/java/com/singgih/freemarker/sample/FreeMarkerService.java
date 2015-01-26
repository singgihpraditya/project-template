package com.singgih.freemarker.sample;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Map;

import org.apache.log4j.Logger;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class FreeMarkerService {

	Logger log = Logger.getLogger("com.singgih.freemarker");
	public String render(String path, Map<String, Object> map) {
		String renderedPage = null;
		Configuration cfg = new Configuration();
		cfg.setClassForTemplateLoading(this.getClass(), "/");
		try {
			Template template = cfg.getTemplate(path);
			Writer out = new StringWriter();
			template.process(map, out);
			renderedPage = out.toString();
//			log.debug("result : "+renderedPage);
		} catch (TemplateException fuckingException) {
			log.error("Found Exception : "+ fuckingException.getLocalizedMessage());
			fuckingException.printStackTrace();
		} catch (IOException fuckingException) {
			log.error("Found Exception : "+ fuckingException.getLocalizedMessage());
			fuckingException.printStackTrace();
		}
		return renderedPage;
	}
}
