package test.com.singgih.storeproc.util;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.google.common.collect.Table;
import com.singgih.storeproc.util.StoreProcUtil;

public class TestStoreProc {
	@Test
	public void testExecuteStoreProc() {
		String storeProcedureName = "PKG_TEMPLATE_PAYMENT.INSERT_TEMPLATE_PAYMENT";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("client_id", "123456");
		params.put("company_code", "00001");
		params.put("customer_number", "1111");
		params.put("effective_date", "10102010");
		
		Table<Integer, String, String> data = new StoreProcUtil().executeStoreProcedure(storeProcedureName, params);
//		for(Integer row : data.rowKeySet()){
			System.out.println(data);;
//		}
		
	}

}
