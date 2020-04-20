package com.ss.training.book;

import com.ss.training.author.Author;
import com.ss.training.publisher.Publisher;

public class Book implements java.io.Serializable {

	private static final long serialVersionUID = -3772808633731368395L;

	private int id;
	private String name;

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Publisher getPublisher() {
		return publisher;
	}

	public Author getAuthor() {
		return author;
	}

	public void setName(String name) {
		this.name = name;
	}

	private Publisher publisher;
	private Author author;

	public Book(String name, Publisher publisher, Author author) {
		this.name = name;
		this.publisher = publisher;
		this.author = author;
		this.id = this.hashCode();
	}

	@Override
	public String toString() {
		return "Title: " + name + "\nAuthor: " + author.toString() + "\nPublisher: " + publisher.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((publisher == null) ? 0 : publisher.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Book))
			return false;
		Book other = (Book) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (publisher == null) {
			if (other.publisher != null)
				return false;
		} else if (!publisher.equals(other.publisher))
			return false;
		return true;
	}

}
