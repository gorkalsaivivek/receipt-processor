package com.example.receipt_processor.utils;

import org.springframework.stereotype.Component;

import com.example.receipt_processor.Entity.ReceiptEntity;
import com.example.receipt_processor.dto.ReceiptDTO;

@Component
public class MapperUtils {

	public ReceiptEntity toEntity(ReceiptDTO receiptDTO) {
		
		ReceiptEntity receiptEntity=new ReceiptEntity();
		receiptEntity.setId(receiptDTO.getId());
		receiptEntity.setPoints(receiptDTO.getPoints());
		receiptEntity.setRetailer(receiptDTO.getRetailer());
			
		return receiptEntity;
		
		
	}
	
	

}
