package com.Bookstore.samulibookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.Bookstore.samulibookstore.domain.Book;
import com.Bookstore.samulibookstore.domain.BookRepository;

@Controller
public class BookController {
	
	@Autowired
	private BookRepository repository;
	
	@RequestMapping(value={"/", "/booklist"})
	public String bookStore(Model model) {
		model.addAttribute("books", repository.findAll());
		return "booklist";
	}
	
	@RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
	public String deleteBook(@PathVariable("id") Long bookId, Model model) {
		repository.deleteById(bookId);
		return "redirect:../booklist";
	}
	@RequestMapping(value="/edit/{id}")
	public String editBook(@PathVariable("id") long bookId, Model model) {
		model.addAttribute("book", repository.findById(bookId));
		//model.addAttribute("books", repository.findAll());
		return "addbook";
	}
	
	@RequestMapping(value="/add")
	public String addBook(Model model) {
		model.addAttribute("book", new Book());
		//model.addAttribute("books", repository.findAll());
		return "addbook";
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String saveBook(@ModelAttribute Book newbook, Model model) {
		repository.save(newbook);
		return "redirect:booklist";
	}

}
