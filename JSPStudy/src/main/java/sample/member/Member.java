package sample.member;

public class Member {
	private int no; // pk
	private String id; // un
	private String pw;
	private String name;
	private String nick; // un
	private String mail;
	private String phone;
	private String regdate;

	public Member() {
		super();
	}

	public Member(String id, String pw, String name, String nick, String mail, String phone) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.nick = nick;
		this.mail = mail;
		this.phone = phone;
	}

	public Member(int no, String id, String pw, String name, String nick, String mail, String phone, String regdate) {
		super();
		this.no = no;
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.nick = nick;
		this.mail = mail;
		this.phone = phone;
		this.regdate = regdate;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	@Override
	public String toString() {
		return "Member [no=" + no + ", id=" + id + ", pw=" + pw + ", name=" + name + ", nick=" + nick + ", mail=" + mail
				+ ", phone=" + phone + ", regdate=" + regdate + "]";
	}

}
