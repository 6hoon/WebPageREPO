package mymemberone;

public class MymemDAO {

	// 자기 자신을 부르는 정적 자기객체 참조변수(private static)
	private static MymemDAO instance = null;// 멤버필드

	// 생성자(절대 외부 접근 차단 : private)
	private MymemDAO() {
	}

	// 싱글톤 객체를 호출하기 위한 getInstance() 함수
	public static MymemDAO getInstance() {
		if (instance == null) {
			synchronized (MymemDAO.class) {
				instance = new MymemDAO();
			}
		}
		return instance;
	}

}
