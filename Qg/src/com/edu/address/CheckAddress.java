package com.edu.address;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.testng.annotations.Test;

import com.apitest.check.util.Checker;
import com.apitest.core.Common;
import com.apitest.core.HttpUtils;

public class CheckAddress {
	Checker check;
	String result;
	public void checkAddress() throws ClientProtocolException, IOException{
		result=HttpUtils.get11("/fgadmin/address/list",Common.getCookie());
		check= new Checker(result);
	}
	@Test
	public void checkAddressTest() throws Exception{
		checkAddress();
		check.verifyXpath("message", "success");
	}
}
