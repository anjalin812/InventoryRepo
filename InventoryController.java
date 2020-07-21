package com.inventory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.entity.InventoryEntity;
import com.inventory.service.InventoryService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
public class InventoryController {
	
	@Autowired
	private InventoryService inventoryService;
	
	@PostMapping("/addInventoryProduct")
	public InventoryEntity addInventoryProduct(@RequestBody	InventoryEntity inventoryEntity) {
		
		return inventoryService.saveInventoryEntity(inventoryEntity);
		
	}
	
	@PostMapping("/addInventoryProducts")
	public List<InventoryEntity> addInventoryProducts(@RequestBody	List<InventoryEntity> inventoryEntityproducts) {
		
		return inventoryService.saveInventoryEntityProducts(inventoryEntityproducts);
		
	}
	
	@GetMapping("/inventoryProduct/{productId}")
	public InventoryEntity findProductById(@PathVariable Integer productId) {
		
		return inventoryService.getInventoryProductById(productId);
		
	}
	
	@GetMapping("/inventoryProducts")
	public List<InventoryEntity> findInventorydProducts() {
		
		return inventoryService.getInventoryProducts();
		
	}
	
	@PutMapping("/updateInventoryProduct/{productId}")
	public InventoryEntity updateInventoryProduct(@PathVariable Integer productId, @RequestBody InventoryEntity inventoryEntity) {
		
		return inventoryService.updateInventoryEntity(productId,inventoryEntity);
		
	}
	
	@DeleteMapping("/delete/{productId}")
	public String deleteInventoryProduct(@PathVariable Integer productId) {
		
		return inventoryService.deleteInventoryProduct(productId);
		
	}

}
