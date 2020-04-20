/**
 * 
 */
package com.ss.training.lms;

import com.ss.training.book.Book;

import com.ss.training.publisher.Publisher;
import com.ss.training.author.Author;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.Arrays;
import java.util.HashSet;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.FileNotFoundException;
import java.lang.IllegalArgumentException;

/**
 * @author nrdxp
 *
 */
public class LMS {

	private static void writeBooks(Set<Book> books) {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("books.txt"))) {
			oos.writeObject(books);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private static Set<Book> readBooks(Set<Book> books) {
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("books.txt"))) {
			books = (HashSet<Book>) ois.readObject();
		} catch (Exception ex) {
			writeBooks(books);
			return books;
		}

		return books;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Set<Book> books = new HashSet<>();

		books = readBooks(books);

		switch (args[0]) {
		case "new":
			if (args.length < 5) {
				throw new IllegalArgumentException(
						"'new' command requires 'book name', 'author name', 'publisher name', and 'publisher address'");
			}
			Author author = new Author(args[2]);
			Publisher publisher = new Publisher(args[3], args[4]);
			Book book = new Book(args[1], publisher, author);

			books.add(book);
			writeBooks(books);
			break;
		case "list":
			books.stream().forEach(item -> System.out.println(item + "\n"));
			break;
		case "delete":
			switch (args[1]) {
			case "-p":
				if (args.length < 3) {
					throw new IllegalArgumentException("'delete -p' requires a publisher's name");
				}
				String pub = args[2];
				books = books.stream().filter(item -> !pub.equals(item.getPublisher().getName()))
						.collect(Collectors.toCollection(HashSet::new));
				writeBooks(books);
				break;
			case "-a":
				if (args.length < 3) {
					throw new IllegalArgumentException("'delete -a' requires an author's name");
				}
				String auth = args[2];
				books = books.stream().filter(item -> !auth.equals(item.getAuthor().getName()))
						.collect(Collectors.toCollection(HashSet::new));
				writeBooks(books);
				break;
			default:
				if (args.length < 2) {
					throw new IllegalArgumentException("'delete' requires a book name");
				}
				String name = args[1];
				books = books.stream().filter(item -> !name.equals(item.getName()))
						.collect(Collectors.toCollection(HashSet::new));
				writeBooks(books);
				break;
			}
			break;
		case "update":
			switch (args[1]) {
			case "-p":
				if (args.length < 4) {
					throw new IllegalArgumentException("'update -p' requires a current and updated publisher name");
				}
				switch (args[2]) {
				case "-a":
					if (args.length < 5) {
						throw new IllegalArgumentException(
								"'update -p -a' requires a current publisher name and an updated publisher address");
					}
					books.stream().forEach(item -> {
						if (item.getPublisher().getName().equals(args[3]))
							item.getPublisher().setAddress(args[4]);
					});
					writeBooks(books);
					break;
				default:
					books.stream().forEach(item -> {
						if (item.getPublisher().getName().equals(args[2]))
							item.getPublisher().setName(args[3]);
					});
					writeBooks(books);
				}
				break;
			case "-a":
				if (args.length < 3) {
					throw new IllegalArgumentException("'update -a' requires current and updated author's name");
				}
				books.stream().forEach(item -> {
					if (item.getAuthor().getName().equals(args[2]))
						item.getAuthor().setName(args[3]);
				});
				writeBooks(books);
				break;
			default:
				if (args.length < 2) {
					throw new IllegalArgumentException("'update requires a current and new book name");
				}
				books.stream().forEach(item -> {
					if (item.getName().equals(args[1]))
						item.setName(args[2]);
				});
				writeBooks(books);
				break;
			}
			break;
		default:
			System.out.println("Library Management System usage:" + "\n\t new name author publisher address"
					+ "\n\t list" + "\n\t delete [-p|-a] name" + "\n\t update [-p [-a]|-a] current new");
		}
	}
}
