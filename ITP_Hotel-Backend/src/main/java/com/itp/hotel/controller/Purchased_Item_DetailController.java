package com.itp.hotel.controller;

import java.util.HashMap;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.itp.hotel.exception.ResourceNotFoundException;
import com.itp.hotel.model.PurchasedItemDetail;

import com.itp.hotel.repository.PurchasedItemDetailRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")

public class Purchased_Item_DetailController {
	
	@Autowired
    private PurchasedItemDetailRepository purchased_item_detailRepository;

    @GetMapping("/purchased_item_detail")
    public List<PurchasedItemDetail> getAllPurchasedItemDetails() {
        return purchased_item_detailRepository.findAll();
    }
    
    @GetMapping("/purchased_item_detail/{invoice_no}")
    public ResponseEntity<PurchasedItemDetail> getPurchasedItemDetailById(@PathVariable(value = "invoice_no") Integer Invoice_No)
        throws ResourceNotFoundException {
        PurchasedItemDetail purchased_item_detail = purchased_item_detailRepository.findById(Invoice_No)
          .orElseThrow(() -> new ResourceNotFoundException("Purchased Item Detail not found for this id :: " + Invoice_No));
        return ResponseEntity.ok().body(purchased_item_detail);
    }
    
    @PostMapping("/purchased_item_detail")
    public PurchasedItemDetail createPurchasedItemDetail(@Valid @RequestBody PurchasedItemDetail purchased_item_detail) {
        return purchased_item_detailRepository.save(purchased_item_detail);
    }
    
   @PutMapping("/purchased_item_detail/{invoice_no}")
    public ResponseEntity<PurchasedItemDetail> updatePurchasedItemDetail(@PathVariable(value = "invoice_no") Integer Invoice_No,
         @Valid @RequestBody PurchasedItemDetail purchased_item_detailDetails) throws ResourceNotFoundException {
        PurchasedItemDetail purchased_item_detail = purchased_item_detailRepository.findById(Invoice_No)
        .orElseThrow(() -> new ResourceNotFoundException("Purchased Item Detail not found for this id :: " + Invoice_No));

       purchased_item_detail.setInvoiceNo(purchased_item_detailDetails.getInvoiceNo());
       purchased_item_detail.setSid(purchased_item_detailDetails.getSid());
       purchased_item_detail.setItemCode(purchased_item_detailDetails.getItemCode());
       purchased_item_detail.setItemName(purchased_item_detailDetails.getItemName());
       purchased_item_detail.setdescription(purchased_item_detailDetails.getdescription());
       purchased_item_detail.setPayment(purchased_item_detailDetails.getPayment());
       purchased_item_detail.setDate(purchased_item_detailDetails.getDate());
       purchased_item_detail.setIt_Category(purchased_item_detailDetails.getIt_Category());
       //purchased_item_detail.setUnit_Price(purchased_item_detailDetails.getUnit_Price());
       //purchased_item_detail.setQuantity(purchased_item_detailDetails.getQuantity());
       final PurchasedItemDetail updatedPurchased_Item_Detail = purchased_item_detailRepository.save(purchased_item_detail);
       return ResponseEntity.ok(updatedPurchased_Item_Detail);
    }
    @DeleteMapping("/purchased_item_detail/{invoice_no}")
    public Map<String, Boolean> deletePurchasedItemDetail(@PathVariable(value = "invoice_no") Integer Invoice_No)
         throws ResourceNotFoundException {
        PurchasedItemDetail purchased_item_detail = purchased_item_detailRepository.findById(Invoice_No)
       .orElseThrow(() -> new ResourceNotFoundException("Purchased Item Detail not found for this id :: " + Invoice_No));

        purchased_item_detailRepository.delete(purchased_item_detail);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

}
