package com.singgih.velocity.sample;

import org.apache.velocity.VelocityContext;

import com.singgih.velocity.util.Calculator;
import com.singgih.velocity.util.FormatterUtil;
import com.singgih.velocity.util.PaperLayout;

public class WebBaseVelocityUtil extends AbstractVelocityUtil {
	@Override
	protected void setAdditionalParams(VelocityContext context) {
		context.put("calculator", new Calculator());
		context.put("formatterUtil", new FormatterUtil());
		context.put("paperLayout", new PaperLayout());		
	}
}
