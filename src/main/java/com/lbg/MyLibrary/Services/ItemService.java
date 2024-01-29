package com.lbg.MyLibrary.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.lbg.MyLibrary.Repos.ItemRepo;
import com.lbg.MyLibrary.domain.Item;

@Service
public class ItemService {

	private ItemRepo repo;

	public ItemService(ItemRepo repo) {
		super();
		this.repo = repo;
	}

	public ResponseEntity<Item> createItem(Item newItem) {
		Item created = this.repo.save(newItem);

		return new ResponseEntity<Item>(created, HttpStatus.CREATED);
	}

	public List<Item> getItems() {
		return this.repo.findAll();
	}

	public ResponseEntity<Item> getItem(int id) {

		Optional<Item> found = this.repo.findById(id);

		if (found.isEmpty()) { // checks if it's found an item
			return new ResponseEntity<Item>(HttpStatus.NOT_FOUND);
		}

		// attempts to pull the item out of the box
		Item body = found.get();

		return ResponseEntity.ok(body);

	}

//	@PatchMapping("/patch/{id}")
	public ResponseEntity<Item> patchItem(int id, Item updatedItem) {

		// returns a box that might have an item in it
		Optional<Item> found = this.repo.findById(id);

		if (found.isEmpty()) { // checks if it's found an item
			return new ResponseEntity<Item>(HttpStatus.NOT_FOUND);
		}

		// attempts to pull the contents out of the box
		Item existing = found.get();

		if (updatedItem.getTitle() != null) {
			existing.setTitle(updatedItem.getTitle());
		}

		if (updatedItem.getAuthor() != null) {
			existing.setAuthor(updatedItem.getAuthor());
		}

		if (updatedItem.getPublicationDate() != null) {
			existing.setPublicationDate(updatedItem.getPublicationDate());
		}

		if (updatedItem.getPerson() != null) {
			existing.setPerson(updatedItem.getPerson());
		}

		Item updated = this.repo.save(existing);

		return ResponseEntity.ok(updated);

	}

	public boolean deleteItem(int id) {

		this.repo.deleteById(id);

		return !this.repo.existsById(id);

	}

//	@PutMapping("/put/{id}")
	public ResponseEntity<Item> updateItem(int id, Item newItem) {

		// returns a box that might have an item in it
		Optional<Item> found = this.repo.findById(id);

		if (found.isEmpty()) { // checks if it's found an item
			return new ResponseEntity<Item>(HttpStatus.NOT_FOUND);
		}

		// attempts to pull the contents out of the box
		Item existing = found.get();

		existing.setTitle(newItem.getTitle());

		existing.setAuthor(newItem.getAuthor());

		existing.setPublicationDate(newItem.getPublicationDate());

		existing.setPerson(newItem.getPerson());

		Item updated = this.repo.save(existing);

		return ResponseEntity.ok(updated);

	}

}
