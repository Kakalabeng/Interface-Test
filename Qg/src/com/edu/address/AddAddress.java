package com.edu.address;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.testng.annotations.Test;

import com.apitest.check.util.Checker;
import com.apitest.core.Common;
import com.apitest.core.HttpUtils;

import net.sf.json.JSONObject;


public class AddAddress {
	Checker check;
	String subUrl = "/fgadmin/address/new";
	String result=null;

	public void addAddress(Object receiverName,Object cellPhone,Object addressDetail,
			Object province,Object city,Object area) throws ClientProtocolException, IOException{
		JSONObject json=new JSONObject();
		json.element("receiverName", receiverName);
		json.element("cellPhone",cellPhone);
		json.element("addressDetail",addressDetail);
		json.element("province", province);
		json.element("city",city);
		json.element("area",area);
		result=HttpUtils.post(subUrl, json,Common.getCookie());
		check= new Checker(result);
	}
	@Test
	public void addAddressSuccess() throws Exception{
		addAddress("oo","13788889999","河北师范大学","河北省","石家庄市","裕华区");
		check.verifyXpath("message", "success");
	}
	@Test
	public void receiverNameTest() throws Exception{
		addAddress(null,"13788889999","河北师范大学","河北省","石家庄市","裕华区");
		check.verifyXpath("code", "400");
	}
	
}
