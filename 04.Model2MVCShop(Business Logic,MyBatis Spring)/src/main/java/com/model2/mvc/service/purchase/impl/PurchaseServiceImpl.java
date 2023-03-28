package com.model2.mvc.service.purchase.impl;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.model2.mvc.common.Search;
import com.model2.mvc.service.domain.Purchase;
import com.model2.mvc.service.purchase.PurchaseDao;
import com.model2.mvc.service.purchase.PurchaseService;


@Service("purchaseServiceImpl")
public class PurchaseServiceImpl implements PurchaseService {
	
	@Autowired
	@Qualifier("purchaseDaoImpl")
	private PurchaseDao purchaseDAO;
	
	public PurchaseServiceImpl() {
		System.out.println(this.getClass());
	}
	@Override
	public Purchase addPurchase(Purchase purchaseVO) throws Exception {
		// TODO Auto-generated method stub
		purchaseDAO.insertPurchase(purchaseVO);
		return purchaseVO;
	}//¿Ï·á

	@Override
	public Purchase getPurchase(int pur_no) throws Exception {
		// TODO Auto-generated method stub
		return purchaseDAO.findPurchase(pur_no);
		//return purchaseVO;
	}

	@Override
	public HashMap<String, Object> getPurchaseList(Search searchVO, String userId) throws Exception {
		return purchaseDAO.getPurchaseList(searchVO,userId);
	}

	@Override
	public HashMap<String, Object> getSaleList(Search searchVO) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Purchase updatePurchase(Purchase purchaseVO) throws Exception {
		// TODO Auto-generated method stub
		
		purchaseDAO.updatePurchase(purchaseVO);
		return purchaseVO;
	}

	@Override
	public void updateTranCode(Purchase purchaseVO) throws Exception {
		// TODO Auto-generated method stub
		purchaseDAO.updateTranCode(purchaseVO);
	}
	public void updateTranCodeByProd(int prodNo, Purchase purchaseVO) throws Exception {
		purchaseDAO.updateTranCodeByProd(prodNo,purchaseVO);
		
	}
}
