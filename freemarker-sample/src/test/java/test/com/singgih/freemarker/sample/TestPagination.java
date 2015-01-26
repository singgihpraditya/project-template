package test.com.singgih.freemarker.sample;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.singgih.freemarker.pojo.Pagination;
import com.singgih.freemarker.sample.PaginationUtil;

public class TestPagination {
	Logger log = Logger.getLogger("com.singgih.freemarker");

	@Test
	public void testRenderPagination(){
		PaginationUtil paginationUtil = new PaginationUtil();
		Pagination pagination = paginationUtil.paginate(10, 135, 14, "/foo/bar");
		printMenu(pagination);
		pagination = paginationUtil.paginate(10, 135, 4, "/foo/bar");
		printMenu(pagination);

	}
	
	private void printMenu(Pagination pagination){
		boolean leftIsActive = pagination.getStartPage()!=1;
		log.debug(leftIsActive?"enable":"disable");
		for (int i = pagination.getStartPage(); i <= pagination.getEndPage(); i++) {
			log.debug(i==pagination.getCurrentPage()?i+"_active":i);
		}
		boolean rightIsActive = pagination.getEndPage()!=pagination.getTotalPage();
		log.debug(rightIsActive?"enable":"disable");
	}
}
