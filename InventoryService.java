package com.inventory.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.entity.InventoryEntity;
import com.inventory.repository.InventoryRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class InventoryService {

	@Autowired
	private InventoryRepository inventoryRepository;

	public InventoryEntity saveInventoryEntity(InventoryEntity inventoryEntity) {

		return inventoryRepository.save(inventoryEntity);    	
	}

	public List<InventoryEntity> saveInventoryEntityProducts(List<InventoryEntity> inventoryProductsList) {

		return inventoryRepository.saveAll(inventoryProductsList);    	
	}
	
	public List<InventoryEntity> getInventoryProducts() {

		return inventoryRepository.findAll();    	
	}
	
	public InventoryEntity getInventoryProductById(int productId) {

		return inventoryRepository.findById(productId).orElse(null);    	
	}	
		
	public String deleteInventoryProduct (int prodcustId) {
		
		inventoryRepository.deleteById(prodcustId);
		
		return "Invetnory prodcut is removed" + prodcustId;
		
	}
	
	public InventoryEntity updateInventoryEntity(int productId,InventoryEntity inventoryEntity) {
		InventoryEntity existingInvProduct = inventoryRepository.findById(productId).orElse(null);
		
		existingInvProduct.setProductName(inventoryEntity.getProductName());
		existingInvProduct.setProductCount(inventoryEntity.getproductCount());
		
		return inventoryRepository.save(existingInvProduct);
		
		
	}
}
