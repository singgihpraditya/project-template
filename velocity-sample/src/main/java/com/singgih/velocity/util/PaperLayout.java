package com.singgih.velocity.util;

import org.apache.commons.lang.StringUtils;

public class PaperLayout {
	private static final int LAYOUT_LEFT = 0;
	private static final int LAYOUT_CENTER = 1;
	private static final int LAYOUT_RIGHT = 2;

	public String printLine(int paperWidth) {
		return StringUtils.leftPad("", paperWidth, '-');

	}

	public String titleLayout(String title, int paperWidth, int layout) {
		switch (layout) {
		case LAYOUT_LEFT:
			break;
		case LAYOUT_CENTER:
			title = StringUtils.leftPad(title, ((paperWidth / 2) + (title.length() / 2)));
			break;
		case LAYOUT_RIGHT:
			title = StringUtils.leftPad(title, paperWidth);
			break;
		}
		return title;
	}
}
