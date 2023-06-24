package com.ecommerce.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.entity.PurchaseReport;
import com.ecommerce.respository.PurchaseRepository;

@Service
public class PurchaseReportService {

	@Autowired
	private PurchaseRepository purchaseRepo;
	
	public List<PurchaseReport> getAllPurchaseReport() {
		List<PurchaseReport> purchaseReports = purchaseRepo.findAll();
		return purchaseReports;
	}

	public List<PurchaseReport> getReportCategory(String category) {
		List<PurchaseReport> purchaseReports = purchaseRepo.findAllByCategory(category);
		return purchaseReports;
	}

	public List<PurchaseReport> getReportDate(String date) throws ParseException {
		List<PurchaseReport> purchaseReports = purchaseRepo.findAllByDate(new SimpleDateFormat("yyyy-MM-dd").parse(date));
		return purchaseReports;
	}
	
}
