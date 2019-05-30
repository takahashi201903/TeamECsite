package com.internousdev.orion.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.orion.util.InputChecker;
import com.opensymphony.xwork2.ActionSupport;

public class CreateDestinationConfirmAction extends ActionSupport implements SessionAware{

	private String familyName;
	private String firstName;
	private String familyNameKana;
	private String firstNameKana;
	private String userAddress;
	private String telNumber;
	private String email;

   //inputCheckerの戻り値を格納//
	private List<String> familyNameErrorList;
	private List<String> firstNameErrorList;
	private List<String> familyNameKanaErrorList;
	private List<String> firstNameKanaErrorList;
	private List<String> userAddressErrorList;
	private List<String> telNumberErrorList;
	private List<String> emailErrorList;

	private Map<String,Object>session;

    //セッションに格納
	public String execute(){

        //sessionのタイムアウトをチェック//
		if(session.isEmpty()){
			return "sessionTimeout";
		}

		String result=ERROR;

		session.put("familyName", familyName);
		session.put("firstName", firstName);
		session.put("familyNameKana", familyNameKana);
		session.put("firstNameKana", firstNameKana);
		session.put("userAddress", userAddress);
		session.put("telNumber", telNumber);
		session.put("email", email);

		/*エラーメッセージの判定チェック*/

		InputChecker check=new InputChecker();

		familyNameErrorList=check.doCheck("姓", familyName, 1, 16, true, true, true, false, false, false, false);
		firstNameErrorList=check.doCheck("名", firstName, 1, 16, true, true, true, false, false, false, false);
		familyNameKanaErrorList=check.doCheck("姓ふりがな", familyNameKana, 1, 16, false, false, true, false, false, false, false);
		firstNameKanaErrorList=check.doCheck("名ふりがな", firstNameKana, 1, 16, false, false, true, false, false, false, false);
		userAddressErrorList=check.doCheck("住所", userAddress, 10, 50, true, true, true, true, false, true, false);
		telNumberErrorList=check.doCheck("電話番号", telNumber, 10, 13, false, false, false, true, false, false, false);
		emailErrorList=check.doCheckForEmail("メールアドレス", email, 10, 32);

		if(familyNameErrorList.size() > 0
		|| firstNameErrorList.size() > 0
		|| familyNameKanaErrorList.size() > 0
		|| firstNameKanaErrorList.size() > 0
		|| emailErrorList.size() > 0
		|| telNumberErrorList.size() > 0
		|| userAddressErrorList.size() > 0){

			result=ERROR;
		}else{

			result=SUCCESS;
		}
		return result;
	}

	public String getFamilyName(){
		return familyName;
	}
	public void setFamilyName(String familyName){
		this.familyName=familyName;
	}
	public String getFirstName(){
		return firstName;
	}
	public void setFirstName(String firstName){
		this.firstName=firstName;
	}
	public String getFamilyNameKana(){
		return familyNameKana;
	}
	public void setFamilyNameKana(String familyNameKana){
		this.familyNameKana=familyNameKana;
	}
	public String getFirstNameKana(){
		return firstNameKana;
	}
	public void setFirstNameKana(String firstNameKana){
		this.firstNameKana=firstNameKana;
	}
	public String getUserAddress(){
		return userAddress;
	}
	public void setUserAddress(String userAddress){
		this.userAddress=userAddress;
	}
	public String getTelNumber(){
		return telNumber;
	}
	public void setTelNumber(String telNumber){
		this.telNumber=telNumber;
	}
	public String getEmail(){
		return email;
	}
	public void setEmail(String email){
		this.email=email;
	}
	public List<String> getFamilyNameErrorList(){
		return familyNameErrorList;
	}
	public void setFamilyNameErrorList(List<String> familyNameErrorList){
		this.familyNameErrorList=familyNameErrorList;
	}
	public List<String> getFirstNameErrorList(){
		return firstNameErrorList;
	}
	public void setFirstNameErrorList(List<String> firstNameErrorList){
		this.firstNameErrorList=firstNameErrorList;
	}
	public List<String> getFamilyNameKanaErrorList(){
		return familyNameKanaErrorList;
	}
	public void setFamilyNameKanaErrorList(List<String> familyNameKanaErrorList){
		this.familyNameErrorList=familyNameKanaErrorList;
	}
	public List<String> getFirstNameKanaErrorList(){
		return firstNameKanaErrorList;
	}
	public void setFirstNameKanaErrorList(List<String> firstNameKanaErrorList){
		this.firstNameKanaErrorList=firstNameKanaErrorList;
	}
	public List<String> getUserAddressErrorList(){
		return userAddressErrorList;
	}
	public void setUserAddressErrorList(List<String> userAddressErrorList){
		this.userAddressErrorList=userAddressErrorList;
	}
	public List<String> getTelNumberErrorList(){
		return telNumberErrorList;
	}
	public void setTelNumberErrorList(List<String> telNumberErrorList){
		this.telNumberErrorList=telNumberErrorList;
	}
	public List<String> getEmailErrorList(){
		return emailErrorList;
	}
	public void setEmailErrorList(List<String> emailErrorList){
		this.emailErrorList=emailErrorList;
	}
	public Map<String,Object> getSession(){
		return session;
	}
	public void setSession(Map<String,Object>session){
		this.session=session;
	}
}