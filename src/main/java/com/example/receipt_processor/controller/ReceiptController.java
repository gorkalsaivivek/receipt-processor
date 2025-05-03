package com.example.receipt_processor.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.receipt_processor.dto.ReceiptDTO;
import com.example.receipt_processor.service.ReceiptService;

@RestController
public class ReceiptController {
	
	@Autowired
	ReceiptService receiptService;
	
	@PostMapping(path="/receipts/process")
	public ResponseEntity<ReceiptDTO> postReceipt(@RequestBody ReceiptDTO receiptDTO) {
		
		int points=receiptService.calculatePoints(receiptDTO);
		receiptDTO.setPoints(points);
		
		receiptDTO.setId(receiptService.createID());
		
		receiptService.saveReceipt(receiptDTO);
		
		return ResponseEntity.ok(receiptDTO);
		
		
	}
	
	@GetMapping("/receipts/{id}/points")
	public ResponseEntity<Map<String, Integer>> getPointsByReceiptId(@PathVariable("id") String id) {
        Integer points = receiptService.retrievePointsByID(id);

        if (points == null) {
            return ResponseEntity.notFound().build();
        }

        Map<String, Integer> response = new HashMap<>();
        response.put("points", points);
        return ResponseEntity.ok(response);
    }

}
