package house_sale.model;

/*
 * 作者:张家旺
 */
import java.util.List;

public class PageCheck_order {

    private int totalPage;
	
	private int curPage;
	
	private int totalCount;
	
	private int pageSize = 3;
	
	List<User_time> list;

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getCurPage() {
		return curPage;
	}

	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public List<User_time> getList() {
		return list;
	}

	public void setList(List<User_time> list) {
		this.list = list;
	}
	
	
}
