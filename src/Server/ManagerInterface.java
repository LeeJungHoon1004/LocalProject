package Server;

public interface ManagerInterface {
	
	/**
	 * ���(String id)
	 * �� ���ڷ� �޾Ƽ� DB���� ��ġ�ϴ� ���� �ִ��� �˻��ѵ�
	 * ���� �����ϸ� true ������ false�� ��ȯ�մϴ�.
	 * @param m
	 */
	public boolean isExist(Member m);
	
	/**���(String name, String id , String pw , boolean gender)
	 * �� ���ڷ� �޾Ƽ� DB�� �����մϴ�.
	 * 
	 * @param m
	 */
	public void insertData(Member m);
	
	/**���(String id , String pw) ��ġ�ϴ� ���� �ִ��� �˻��ѵ�
	 * ���� �����ϸ� true ������ false�� ��ȯ�մϴ�
	 * @param m
	 */
	public boolean isLoginOk(Member m);
	/**
	 * BMI�������� stature,wieght,gender�� �����ɴϴ�.
	 * @return
	 */
	public Member getBMIData();
	
	
	
}
