package com.edu.ordersSubmit;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.testng.annotations.Test;

import com.apitest.check.util.Checker;
import com.apitest.core.Common;
import com.apitest.core.HttpUtils;

import net.sf.json.JSONObject;

public class OrdersSubmitTest {
	Checker check;
	String result;
	public void OrderSubmit(Object receiverName,Object cellPhone
			,Object addressDetail,Object province,Object city,Object area,Object fee) throws ClientProtocolException, IOException{
		JSONObject sub=new JSONObject();
		sub.element("skuIds","2,3");
		sub.element("skuNumbers","1,1");
		sub.element("stockIds","74966312,74966313");
		sub.element("receiverName",receiverName);
		sub.element("cellPhone",cellPhone);
		sub.element("addressDetail",addressDetail);
		sub.element("province",province);
		sub.element("city",city);
		sub.element("area",area);
		sub.element("voiceStatus",0);
		sub.element("needInvoice",0);
		sub.element("invoiceHead","");
		sub.element("transportFee",fee);
		sub.element("logisticsCompanyId",1);
		sub.element("accessSource","noSource");
		sub.element("skuIds","2");
		sub.element("accessDevice",0);
		result=HttpUtils.post("/fgadmin/orders/submit",sub,Common.getCookie());
		check= new Checker(result);
	}
	@Test
	public void submitTest() throws Exception{
		OrderSubmit("张三","12615813537","1 栋 3 单元","浙江省","杭州市","滨江区",0);
		check.verifyXpath("message", "success");
	}
	
}
