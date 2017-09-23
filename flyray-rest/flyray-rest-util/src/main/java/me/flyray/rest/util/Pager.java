package me.flyray.rest.util;

public class Pager {
	 private int total_page; // 总页数
	    private int total_count; // 总记录数
	    private int current_page; // 当前页
	    private int page_size; // 每页的数量
	    private int first_page; // 首页
	    private int pre_page; // 上一页
	    private int next_page; // 下一页
	    private int last_page; // 最后一页
	    private int start_size;// 从第几个开始
	    private int end_size;// 到第几个结束
	    private boolean is_first; // 是否是第一页
	    private boolean is_last; // 是否

	    public int getTotal_page() {
	        return total_page;
	    }

	    public void setTotal_page(int total_page) {
	        this.total_page = total_page;
	    }

	    public int getTotal_count() {
	        return total_count;
	    }

	    public void setTotal_count(int total_count) {
	        this.total_count = total_count;
	    }

	    public int getCurrent_page() {
	        return current_page;
	    }

	    public void setCurrent_page(int current_page) {
	        this.current_page = current_page;
	    }

	    public int getPage_size() {
	        return page_size;
	    }

	    public void setPage_size(int page_size) {
	        this.page_size = page_size;
	    }

	    public int getFirst_page() {
	        return first_page;
	    }

	    public void setFirst_page(int first_page) {
	        this.first_page = first_page;
	    }

	    public int getPre_page() {
	        return pre_page;
	    }

	    public void setPre_page(int pre_page) {
	        this.pre_page = pre_page;
	    }

	    public int getNext_page() {
	        return next_page;
	    }

	    public void setNext_page(int next_page) {
	        this.next_page = next_page;
	    }

	    public int getLast_page() {
	        return last_page;
	    }

	    public void setLast_page(int last_page) {
	        this.last_page = last_page;
	    }

	    public int getStart_size() {
	        return start_size;
	    }

	    public void setStart_size(int start_size) {
	        this.start_size = start_size;
	    }

	    public int getEnd_size() {
	        return end_size;
	    }

	    public void setEnd_size(int end_size) {
	        this.end_size = end_size;
	    }

	    public boolean isIs_first() {
	        return is_first;
	    }

	    public void setIs_first(boolean is_first) {
	        this.is_first = is_first;
	    }

	    public boolean isIs_last() {
	        return is_last;
	    }

	    public void setIs_last(boolean is_last) {
	        this.is_last = is_last;
	    }

	    public Pager() {
	        super();
	    }

	    /**
	     * 构造函数分页处理 包括对0的处理 , 
	     * 总数为0时,部分数据重置为1或true ;
	     * current_page 为0时,重置为1; 
	     * page_size 为0时 ,重置为10;
	     * 
	     * @param current_page
	     *            当前页
	     * @param page_size
	     *            每页的数量
	     * @param total_count
	     *            总记录数
	     */
	    
	    public Pager(int current_page, int page_size, int total_count) {

	        if (current_page > 0) {
	            this.current_page = current_page;
	        } else {
	            this.current_page = 1;
	        }
	        if (page_size > 0) {
	            this.page_size = page_size;
	        } else {
	            this.page_size = 10;
	        }

	        if (total_count > 0) {
	            this.total_page = (int) Math.ceil((double) total_count / page_size);
	            this.total_count = total_count;
	        } else {
	            this.total_page = 1;
	            this.total_count = 0;
	        }
	        
	        this.current_page = this.current_page > this.total_page?1:this.current_page;
	        
	        this.next_page = (this.current_page + 1 > this.total_page) ? this.total_page
	                : this.current_page + 1;
	        this.pre_page = (this.current_page - 1 < 1) ? 1 : this.current_page - 1;

	        this.first_page = 1;
	        this.last_page = this.total_page;

	        this.is_first = this.current_page == 1 ? true : false;
	        this.is_last = this.current_page == this.total_page ? true : false;

	        //处理total_count 为0时  开始页 也为0 ,结束页也为0
	        this.start_size =this.total_count==0?0: (this.current_page - 1) * this.page_size;
	        //this.end_size = ((this.start_size + this.page_size - 1) > this.total_count ? this.total_count==0?0:this.total_count : (this.start_size + this.page_size-1));
	        this.end_size = ((this.start_size + this.page_size - 1) > this.total_count ? this.total_count : (this.start_size + this.page_size-1));

	    }
}
