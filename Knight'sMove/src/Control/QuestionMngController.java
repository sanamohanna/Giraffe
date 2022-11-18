package Control;

import model.SysData;

public class QuestionMngController {
	private SysData sysData;
private static QuestionMngController instance;
	

	

	/**
	 * Instance Getter Of QuestionMgmtController
	 * @return instance
	 */
	public static QuestionMngController getInstance() 
	{ 
		if (instance == null) 
		{ 
			instance = new QuestionMngController(); 
		} 
		return instance; 
	}

}
