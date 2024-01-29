package com.lbg.MyLibrary.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.lbg.MyLibrary.Repos.PersonRepo;
import com.lbg.MyLibrary.domain.Person;

@Service
public class PersonService {

	private PersonRepo repo;

	public PersonService(PersonRepo repo) {
		super();
		this.repo = repo;

	}

	public ResponseEntity<Person> createPerson(Person newPerson) {
		Person created = this.repo.save(newPerson);

		return new ResponseEntity<Person>(created, HttpStatus.CREATED);
	}

	public List<Person> getPeople() {
		return this.repo.findAll();
	}

	public ResponseEntity<Person> getPerson(int id) {

		Optional<Person> found = this.repo.findById(id);

		if (found.isEmpty()) { // checks if it's found a person
			return new ResponseEntity<Person>(HttpStatus.NOT_FOUND);
		}

		// attempts to pull the person out of the box
		Person body = found.get();

		return ResponseEntity.ok(body);

	}

//	patch
	public ResponseEntity<Person> patchPerson(int id, Person updatedPerson) {

		// returns a box that might have a person in it
		Optional<Person> found = this.repo.findById(id);

		if (found.isEmpty()) { // checks if it's found a person
			return new ResponseEntity<Person>(HttpStatus.NOT_FOUND);
		}

		// attempts to pull the contents out of the box
		Person existing = found.get();

		if (updatedPerson.getFirstName() != null) {
			existing.setFirstName(updatedPerson.getFirstName());
		}

		if (updatedPerson.getSurname() != null) {
			existing.setSurname(updatedPerson.getSurname());
		}

		if (updatedPerson.getPostcode() != null) {
			existing.setPostcode(updatedPerson.getPostcode());
		}

		Person updated = this.repo.save(existing);

		return ResponseEntity.ok(updated);

	}

	public boolean deletePerson(int id) {

		this.repo.deleteById(id);

		return !this.repo.existsById(id);

	}

//	@PutMapping("/put/{id}")
	public ResponseEntity<Person> updatePerson(int id, Person newPerson) {

		// returns a box that might have a person in it
		Optional<Person> found = this.repo.findById(id);

		if (found.isEmpty()) { // checks if it's found a person
			return new ResponseEntity<Person>(HttpStatus.NOT_FOUND);
		}

		// attempts to pull the contents out of the box
		Person existing = found.get();

		existing.setFirstName(newPerson.getFirstName());

		existing.setSurname(newPerson.getSurname());

		existing.setPostcode(newPerson.getPostcode());

		Person updated = this.repo.save(existing);

		return ResponseEntity.ok(updated);

	}

}
