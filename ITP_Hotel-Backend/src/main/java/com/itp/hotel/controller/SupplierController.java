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
import com.itp.hotel.model.Supplier;
import com.itp.hotel.repository.SupplierRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")


public class SupplierController {
	
	@Autowired
    private SupplierRepository supplierRepository;

    @GetMapping("/supplier")
    public List<Supplier> getAllSuppliers() {
        return supplierRepository.findAll();
    }
    
    @GetMapping("/supplier/{sid}")
    public ResponseEntity<Supplier> getSupplierById(@PathVariable(value = "sid") Integer SId)
        throws ResourceNotFoundException {
        Supplier supplier = supplierRepository.findById(SId)
          .orElseThrow(() -> new ResourceNotFoundException("Supplier not found for this id :: " + SId));
        return ResponseEntity.ok().body(supplier);
    }
    
    @PostMapping("/supplier")
    public Supplier createSupplier(@Valid @RequestBody Supplier supplier) {
        return supplierRepository.save(supplier);
    }
    
    @PutMapping("/supplier/{sid}")
    public ResponseEntity<Supplier> updateSupplier(@PathVariable(value = "sid") Integer SId,
         @Valid @RequestBody Supplier supplierDetails) throws ResourceNotFoundException {
        Supplier supplier = supplierRepository.findById(SId)
        .orElseThrow(() -> new ResourceNotFoundException("Supplier not found for this id :: " + SId));

        supplier.setSid(supplierDetails.getSid());
        supplier.setName(supplierDetails.getName());
        supplier.setCategory(supplierDetails.getCategory());
        supplier.setEmail(supplierDetails.getEmail());
        supplier.setPhone(supplierDetails.getPhone());
        supplier.setNic(supplierDetails.getNic());
        supplier.setPassword(supplierDetails.getPassword());
        final Supplier updatedSupplier = supplierRepository.save(supplier);
        return ResponseEntity.ok(updatedSupplier);
    }
    
    @DeleteMapping("/supplier/{sid}")
    public Map<String, Boolean> deleteSupplier(@PathVariable(value = "sid") Integer SId)
         throws ResourceNotFoundException {
        Supplier supplier = supplierRepository.findById(SId)
       .orElseThrow(() -> new ResourceNotFoundException("Supplier not found for this id :: " + SId));

        supplierRepository.delete(supplier);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

}
