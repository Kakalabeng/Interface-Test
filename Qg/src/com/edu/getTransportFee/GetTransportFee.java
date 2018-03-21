package com.edu.getTransportFee;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.client.ClientProtocolException;
import org.testng.annotations.Test;

import com.apitest.check.util.Checker;
import com.apitest.core.Common;
import com.apitest.core.HttpUtils;
import com.edu.login.loginTest;

import net.sf.json.JSONObject;

public class GetTransportFee {
	Checker check;
	String result;
	String fee_url="/common/getTransportFee";
	loginTest login=new loginTest();
	public void getFee(Object id,Object addressDetail){
		Map map=new HashMap();
	    map.put("id", id);
	    map.put("addressDetail", addressDetail);
	    result = HttpUtils.get(fee_url,map);
	    System.out.println(result);
	    check= new Checker(result);

	}
	@Test
	public void getFeeTest() throws Exception{
		login.login("86", "20000000006", "netease123");
		getFee("1","河北省_石家庄市_裕华区");
		check.verifyXpath("message", "success");
	}
}
