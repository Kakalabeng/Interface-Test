package com.edu.login;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.apitest.check.util.Checker;
import com.apitest.core.BaseTest;
import com.apitest.core.HttpUtils;

import net.sf.json.JSONObject;

public class loginTest{

	String result=null;
	Checker check=null;
	public void login(Object phoneArea,Object phoneNumber,Object password){
		JSONObject json=new JSONObject();
		json.element("phoneArea",phoneArea);
		json.element("phoneNumber", phoneNumber);
		json.element("password", password);
		result=HttpUtils.post("/common/fgadmin/login", json,null);
		check = new Checker(result);
	}
	@Test()
	public void loginSuccess() throws Exception{
		login("86","20000000008","netease123");
		check.verifyXpath("message", "success");
	}
	@Test
	public void loginFail1()throws Exception{
		login(86,"20000000008","netease123");
		check.verifyXpath("code", "400");
	}
	@Test
	public void loginFail2() throws Exception{
		login("86",2000,"netease123");
		check.verifyXpath("code", "400");
	}
	@Test
	public void loginFail3() throws Exception{
		login("86","20000000008",123);
		check.verifyXpath("code", "400");
	}
	@Test
	public void loginFail4() throws Exception{
		login(null,"20000000008","netease123");
		check.verifyXpath("code", "400");
	}

}
