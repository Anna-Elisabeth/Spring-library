package com.lbg.MyLibrary.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String title;

	private String author;

	private Integer publicationDate;

	private boolean checkedIn;

	@JsonBackReference
	@ManyToOne
	private Person person;

	public Item() {
		super();
		checkedIn = true;
	}

	public boolean isCheckedIn() {
		return checkedIn;
	}

	public void setCheckedIn(boolean checkedIn) {
		this.checkedIn = checkedIn;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Integer getPublicationDate() {
		return publicationDate;
	}

	public void setPublicationDate(Integer publicationDate) {
		this.publicationDate = publicationDate;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", title=" + title + ", author=" + author + ", publicationDate=" + publicationDate
				+ ", checkedIn=" + checkedIn + ", person=" + person + "]";
	}

}
