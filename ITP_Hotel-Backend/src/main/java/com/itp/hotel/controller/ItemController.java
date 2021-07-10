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
import com.itp.hotel.model.Item;
import com.itp.hotel.repository.ItemRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")

public class ItemController {
	
	@Autowired
    private ItemRepository itemRepository;

    @GetMapping("/item")
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }
    
    @GetMapping("/item/{item_code}")
    public ResponseEntity<Item> getItemById(@PathVariable(value = "item_code") Integer Item_Code)
        throws ResourceNotFoundException {
        Item item = itemRepository.findById(Item_Code)
          .orElseThrow(() -> new ResourceNotFoundException("Item not found for this id :: " + Item_Code));
        return ResponseEntity.ok().body(item);
    }
    
    @PostMapping("/item")
    public Item createItem(@Valid @RequestBody Item item) {
        return itemRepository.save(item);
    }
    
    @PutMapping("/item/{item_code}")
    public ResponseEntity<Item> updateItem(@PathVariable(value = "item_code") Integer Item_Code,
         @Valid @RequestBody Item itemDetails) throws ResourceNotFoundException {
        Item item = itemRepository.findById(Item_Code)
        .orElseThrow(() -> new ResourceNotFoundException("Item not found for this id :: " + Item_Code));

        item.setItemCode(itemDetails.getItemCode());
        item.setName(itemDetails.getName());
        item.setIt_Category(itemDetails.getIt_Category());
        item.setPrice(itemDetails.getPrice());
        item.setDate(itemDetails.getDate());
        
        item.setDescription(itemDetails.getDescription());
        item.setSupplier(itemDetails.getSupplier());
        final Item updatedItem = itemRepository.save(item);
        return ResponseEntity.ok(updatedItem);
    }
    
    @DeleteMapping("/item/{item_code}")
    public Map<String, Boolean> deleteItem(@PathVariable(value = "item_code") Integer Item_Code)
         throws ResourceNotFoundException {
        Item item = itemRepository.findById(Item_Code)
       .orElseThrow(() -> new ResourceNotFoundException("Item not found for this id :: " + Item_Code));

        itemRepository.delete(item);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

}
