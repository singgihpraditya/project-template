package com.singgih.velocity.sample;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Map;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;

/**
 * @author singgih praditya
 *
 */
public abstract class AbstractVelocityUtil {
	public String stringFromVm(String vmName, Map<String, Object> objectMap) {
		VelocityContext context = new VelocityContext();
		if (objectMap != null && !objectMap.isEmpty()) {
			for (Map.Entry<String, Object> entry : objectMap.entrySet()) {
				context.put(entry.getKey(), entry.getValue());
			}
		}
		setAdditionalParams(context);
		Writer writer = new StringWriter();
		createTemplate(vmName).merge(context, writer);
		try {
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return writer.toString();
	}

	private Template createTemplate(String velocityTemplateFile) {
		VelocityEngine velocityEngine = new VelocityEngine();
		velocityEngine.setProperty(Velocity.RESOURCE_LOADER, "class");
		velocityEngine.setProperty("class.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
		velocityEngine.init();
		return velocityEngine.getTemplate(velocityTemplateFile);
	}
	
	protected abstract void setAdditionalParams(VelocityContext context);
}
