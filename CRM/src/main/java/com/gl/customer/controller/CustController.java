package com.gl.customer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gl.customer.entity.CustDetail;
import com.gl.customer.service.CustService;


@Controller
@RequestMapping("/customer")
public class CustController {

	@Autowired
	private CustService custService;

	// add mapping for "/list"

	@RequestMapping("/list")
	public String listCustomers(Model theModel) {

		// get Customers from db
		List<CustDetail> theCustomers = custService.findAll();

		// add to the spring model
		theModel.addAttribute("customer", theCustomers);

		return "list-Customers";
	}

	@RequestMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {

		// create model attribute to bind form data
		CustDetail theCustDetail = new CustDetail();

		theModel.addAttribute("CustDetail", theCustDetail);

		return "Customer-form";
	}

	@RequestMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("id") int theId, Model theModel) {

		// get the Customer from the service
		CustDetail theCustDetail = custService.findById(theId);

		// set Customer as a model attribute to pre-populate the form
		theModel.addAttribute("Customer", theCustDetail);

		// send over to our form
		return "Customer-form";
	}

	@PostMapping("/save")
	public String saveBook(@RequestParam("id") int id, @RequestParam("fname") String fname,@RequestParam("lname") String lname,
			@RequestParam("email") String email) {

		System.out.println(id);
		CustDetail theCustDetail;
		if (id != 0) {
			theCustDetail = custService.findById(id);
			theCustDetail.setFname(fname);
			theCustDetail.setLname(lname);
			theCustDetail.setEmail(email);
			
		} else
			theCustDetail = new CustDetail(id, fname, lname, email);
		// save the Customer
		custService.save(theCustDetail);

		// use a redirect to prevent duplicate submissions
		return "redirect:/customer/list";

	}

	@RequestMapping("/delete")
	public String delete(@RequestParam("Id") int theId) {

		// delete the Book
		custService.deleteById(theId);

		// redirect to /Books/list
		return "redirect:/customer/list";

	}

//	@RequestMapping("/search")
//	public String search(@RequestParam("name") String name, @RequestParam("author") String author, Model theModel) {
//
//		// check names, if both are empty then just give list of all Books
//
//		if (name.trim().isEmpty() && author.trim().isEmpty()) {
//			return "redirect:/books/list";
//		} else {
//			// else, search by first name and last name
//			List<Book> theBooks = bookService.searchBy(name, author);
//
//			// add to the spring model
//			theModel.addAttribute("Books", theBooks);
//
//			// send to list-Books
//			return "list-Books";
//		}

	}



