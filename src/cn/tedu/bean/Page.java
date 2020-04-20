package cn.tedu.bean;

public class Page {

	private int index = 1;// ��ǰҳ Ĭ��Ϊ��һҳ
	private int rows = 5;// ÿҳ��ʾ�����������
	private int total;// �ܹ�ҳ����
	private int totalRows;// �ܹ���������
	private int start;// �ӵڼ������ݿ�ʼ
	
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public int getTotal() {
		return (int)Math.ceil(totalRows * 1.0 / rows);
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getTotalRows() {
		return totalRows;
	}
	public void setTotalRows(int totalRows) {
		this.totalRows = totalRows;
	}
	public int getStart() {
		return (index - 1)*rows;
	}
	public void setStart(int start) {
		this.start = start;
	}
	
	public Page() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Page(int index, int rows, int total, int totalRows, int start) {
		super();
		this.index = index;
		this.rows = rows;
		this.total = total;
		this.totalRows = totalRows;
		this.start = start;
	}

	@Override
	public String toString() {
		return "Page [index=" + index + ", rows=" + rows + ", total=" + total + ", totalRows=" + totalRows + ", start="
				+ start + "]";
	}
	
}
