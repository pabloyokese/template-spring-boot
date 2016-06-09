package com.jp.youplace.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jp.youplace.domain.Item;
import com.jp.youplace.domain.ItemRepository;
import com.jp.youplace.service.IItemService;

@Service
public class ItemService implements IItemService {
	
	@Autowired
	ItemRepository itemRepository;
	
	@Override
	public List<Item> findAll() {
		return itemRepository.findAll();
	}

	@Override
	public Item findOne(Long id) {
		return itemRepository.findOne(id);
	}

	@Override
	public void save(Item role) {
		itemRepository.save(role);
	}

	@Override
	public Long count() {
		return itemRepository.count();
	}

	@Override
	public void delete(Item item) {
		itemRepository.delete(item);
	}

	@Override
	public void deleteById(Long id) {
		itemRepository.deleteById(id);
	}
	
}
