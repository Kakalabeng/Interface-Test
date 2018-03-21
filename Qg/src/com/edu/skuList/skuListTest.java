package com.edu.skuList;

import static org.testng.Assert.assertEquals;

import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import com.apitest.check.util.Checker;
import com.apitest.core.HttpUtils;
import com.apitest.demo.SkuListTest;

import net.sf.json.JSONObject;

public class skuListTest {
	Checker check;
	String subUrl = "/common/skuList/";
	String result=null;

	public String skuList() throws Exception {
		 result = HttpUtils.get(subUrl);
		check = new Checker(result);
		return result;
	}
	
	public String skuListById(String goodsId) throws Exception {
	
		Map map = new HashMap();
		map.put("goodsId", goodsId);
		String result = HttpUtils.get(subUrl,map);
		check = new Checker(result);
		return result;
	}

	@Test
	public void skuListAll() throws Exception {
		result = skuList();
		check.verifyXpath("message", "success");
	}

	@Test
	public void skuListById1() throws Exception {
		result=this.skuListById("1");
		check.verifyXpath("message", "success");
	}
	
	@Test
	public void skuListById2() throws Exception {
		String goodsId=URLEncoder.encode("\"12345678900786\"","UTF-8");
		 result=this.skuListById(goodsId);
		check.verifyXpath("message", "Failed");
	}
	
	@Test
	public void skuListById3() throws Exception {
		String goodsId=URLEncoder.encode("\"9999\"","UTF-8");
		 result=this.skuListById(goodsId);
		check.verifyXpath("message", "Failed");
	}
	
	@Test
	public void skuListById4() throws Exception {
		String goodsId=URLEncoder.encode("\"1\"","UTF-8");
		 result=this.skuListById(goodsId);
		check.verifyXpath("message", "Failed");
	}
}
