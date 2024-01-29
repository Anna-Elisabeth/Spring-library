package com.lbg.MyLibrary.Rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lbg.MyLibrary.Services.ItemService;
import com.lbg.MyLibrary.domain.Item;

@RequestMapping("/item")
@RestController
public class ItemController {

	@Autowired
	private ItemService service;

	@PostMapping("/create")
	public ResponseEntity<Item> createItem(@RequestBody Item newItem) {
		return this.service.createItem(newItem);

	}

	@GetMapping("/get")
	public List<Item> getItems() {
		return this.service.getItems();
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<Item> getItem(@PathVariable int id) {
		return this.service.getItem(id);

	}

	@PatchMapping("/patch/{id}")
	public ResponseEntity<Item> patchItem(@PathVariable int id, @RequestBody Item updatedItem) {

		return this.service.patchItem(id, updatedItem);

	}

	@DeleteMapping("/delete/{id}")
	public boolean deleteItem(@PathVariable int id)

	{
		return this.service.deleteItem(id);

	}

	@PutMapping("/put/{id}")
	public ResponseEntity<Item> updateItem(@PathVariable int id, @RequestBody Item newItem) {
		return this.service.updateItem(id, newItem);

	}

}
