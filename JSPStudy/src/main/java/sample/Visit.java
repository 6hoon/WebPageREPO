package sample;

public class Visit {

	private int no;
	private String writer;
	private String memo;
	private String regdate;

	public Visit() {
		super();
	}

	public Visit(int no, String writer, String memo, String regdate) {
		super();
		this.no = no;
		this.writer = writer;
		this.memo = memo;
		this.regdate = regdate;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	@Override
	public String toString() {
		return "[no=" + no + ", " + writer + ", " + memo + ", " + regdate + "]";
	}

}
