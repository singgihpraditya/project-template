package test.com.singgih.xml.util;

import org.junit.Test;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import com.singgih.xml.util.TableConverter;

public class TestTableConverter {
	@Test
	public void testParseData() {
		Table<Integer, String, String> data = HashBasedTable.create();
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				data.put(i, "column:" + j, "value:" + i + ":" + j);
			}
		}
		String result = new TableConverter<Integer, String, String>().convertTableToXMLString("foobar", data);
		System.out.println(result);
	}

}
