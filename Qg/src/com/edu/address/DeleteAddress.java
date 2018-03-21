package com.edu.address;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.testng.annotations.Test;

import com.apitest.check.util.Checker;
import com.apitest.core.Common;
import com.apitest.core.HttpUtils;

import net.sf.json.JSONObject;

public class DeleteAddress {
	Checker check;
	String result;
	public void checkAddress(Object id) throws ClientProtocolException, IOException{
		JSONObject json=new JSONObject();
		json.element("id", id);
		result=HttpUtils.post("/fgadmin/address/delete",json,Common.getCookie());
		check= new Checker(result);
	}
	@Test
	public void delAddressTest() throws Exception{
		checkAddress("81001448");
		check.verifyXpath("message", "success");
	}
	@Test
	public void delWrongIdTest() throws Exception{
		checkAddress("11223344");
		check.verifyXpath("code", "400");
	}
}
