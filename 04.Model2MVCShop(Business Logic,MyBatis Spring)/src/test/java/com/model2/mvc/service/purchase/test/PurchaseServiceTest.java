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


@RunWith(SpringJUnit4ClassRunner.class) //meta데이터를 통한 wiring(생성,DI) 할 객체 구현체 지정
@ContextConfiguration(locations = { "classpath:config/commonservice.xml" }) //commonservice.xml실행
public class PurchaseServiceTest {
	/*
	 *	FileName :  ProductServiceTest.java
	 * ㅇ JUnit4 (Test Framework) 과 Spring Framework 통합 Test( Unit Test)
	 * ㅇ Spring 은 JUnit 4를 위한 지원 클래스를 통해 스프링 기반 통합 테스트 코드를 작성 할 수 있다.
	 * ㅇ @RunWith : Meta-data 를 통한 wiring(생성,DI) 할 객체 구현체 지정
	 * ㅇ @ContextConfiguration : Meta-data location 지정
	 * ㅇ @Test : 테스트 실행 소스 지정
	 */
	@Autowired
	@Qualifier("purchaseServiceImpl")//productServiceImpl 생성
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
		user.setAddr("경기도");
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
		//==> console 확인
		System.out.println(purchase);	
	}
	
	//@Test
	public HashMap<String, Object> testGetPurchaseList(Search searchVO,String a) throws Exception{
		return null;
		
	}
}
