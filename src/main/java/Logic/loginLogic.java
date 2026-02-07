package Logic;

import java.util.Objects;

import Beans.loginBeans;
import Dao.loginDao;

public class loginLogic {
	public boolean LoginL(loginBeans inputData) {
		
		loginDao dao = new loginDao();
		loginBeans result_data = dao.LoginD(inputData.getUsername());
		
		if (Objects.equals(inputData.getUsername(), result_data.getUsername()) &&
			    Objects.equals(inputData.getPassword(), result_data.getPassword())) {
			    System.out.println("すべて同じ値です");
			    return true;
			} else {
			    System.out.println("違う値があります");
			    return false;
			}
	}
}
