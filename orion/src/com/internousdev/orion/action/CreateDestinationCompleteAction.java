package com.internousdev.orion.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.orion.dao.DestinationInfoDAO;
import com.opensymphony.xwork2.ActionSupport;

public class CreateDestinationCompleteAction extends ActionSupport implements SessionAware{

	private Map<String,Object>session;

//    セッションから持ってくる
	public String execute(){

//      sessionのタイムアウトをチェック
		if(session.isEmpty()){
			return "sessionTimeout";
		}

		String result = ERROR;
		DestinationInfoDAO dao = new DestinationInfoDAO();

		//DAOからsessionに格納されてる値を持ってくる

		int count = dao.insert(
			String.valueOf(session.get("loginUserId")),
			String.valueOf(session.get("familyName")),
			String.valueOf(session.get("firstName")),
			String.valueOf(session.get("familyNameKana")),
			String.valueOf(session.get("firstNameKana")),
			String.valueOf(session.get("email")),
			String.valueOf(session.get("telNumber")),
			String.valueOf(session.get("userAddress"))
		);

        if(count > 0) {
			result = SUCCESS;
		}

        session.remove("familyName");
        session.remove("firstName");
        session.remove("familyNameKana");
        session.remove("firstNameKana");
        session.remove("email");
        session.remove("telNumber");
        session.remove("userAddress");

	    return result;
	}

	public Map<String,Object>getSession(){
		return session;
	}
	public void setSession(Map<String,Object>session){
		this.session=session;
	}
}
