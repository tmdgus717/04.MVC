package com.model2.mvc.service.purchase.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.model2.mvc.common.Search;
import com.model2.mvc.service.domain.Product;
import com.model2.mvc.service.domain.Purchase;
import com.model2.mvc.service.domain.User;
import com.model2.mvc.service.purchase.PurchaseService;


@RunWith(SpringJUnit4ClassRunner.class) //meta�����͸� ���� wiring(����,DI) �� ��ü ����ü ����
@ContextConfiguration(locations = { "classpath:config/commonservice.xml" }) //commonservice.xml����
public class PurchaseServiceTest {
	/*
	 *	FileName :  ProductServiceTest.java
	 * �� JUnit4 (Test Framework) �� Spring Framework ���� Test( Unit Test)
	 * �� Spring �� JUnit 4�� ���� ���� Ŭ������ ���� ������ ��� ���� �׽�Ʈ �ڵ带 �ۼ� �� �� �ִ�.
	 * �� @RunWith : Meta-data �� ���� wiring(����,DI) �� ��ü ����ü ����
	 * �� @ContextConfiguration : Meta-data location ����
	 * �� @Test : �׽�Ʈ ���� �ҽ� ����
	 */
	@Autowired
	@Qualifier("purchaseServiceImpl")//productServiceImpl ����
	private PurchaseService purchaseService;
	
	//@Test
	public void testAddPurchase() throws Exception {
		
		Purchase purchase = new Purchase();
		User user = new User(); 
		user.setUserId("testUserId");
		user.setUserName("testUserName");
		user.setPassword("testPasswd");
		user.setSsn("1111112222222");
		user.setPhone("111-2222-3333");
		user.setAddr("��⵵");
		user.setEmail("test@test.com");
		
		Product prod = new Product(); 
		prod.setProdNo(10000);
		prod.setProdName("testProductName");
		prod.setProdDetail("testPordDetail");
		prod.setManuDate("20230215");
		prod.setPrice(1000);
		prod.setFileName("testFileName");
		
		purchase.setBuyer(user);
		purchase.setPurchaseProd(prod);
		purchase.setPaymentOption("1");
		purchase.setReceiverName("test");
		purchase.setReceiverPhone("111-2222-3333");
		purchase.setDivyAddr("anyang");
		purchase.setDivyRequest("faster");
		purchase.setTranCode("1");
		purchase.setDivyDate("20230215");
		
		purchase = purchaseService.addPurchase(purchase);
		System.out.println(purchase);
	}
	//@Test
	public void testGetPurchase() throws Exception {
		
		Purchase purchase = new Purchase();
		purchase = purchaseService.getPurchase(10031);
		//==> console Ȯ��
		System.out.println(purchase);	
	}
	
	//@Test
	public HashMap<String, Object> testGetPurchaseList(Search searchVO,String a) throws Exception{
		return null;
		
	}
}
