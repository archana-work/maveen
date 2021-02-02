package com.ytp.mysql.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.ytp.mysql.demo.dao.ProductDao;
import com.ytp.mysql.demo.model.Product;



@RestController
@RequestMapping("/service")
public class Controller {
	@Autowired
	private ProductDao dao;

	@PostMapping("/serviceinfo")
	public String serviceinfo(@RequestBody List<Product> serviceinfo) {

		dao.saveAll(serviceinfo);
		return "information has been entered";
	}
	@GetMapping("/getInfo")
	public List<Product> getInfo(){
		return (List<Product>)dao.findAll();
	}

	@DeleteMapping("/deleteInfo")

	public List<Product> deleteInfo(){

		dao.deleteAll();
		return (List<Product>)dao.findAll();
	}

	@DeleteMapping("/delete/{id}")

	public Optional<Product> deleteProduct(@PathVariable("id") int id)
	{
		dao.deleteById(id);
		return null;
	}
//	@PutMapping("/updateinfo/{id}")
//	public ResponseEntity<?> update(@RequestBody Product product, @PathVariable Integer id) {
//	    try {
//	        Product existProduct = dao.get(id);
//	        dao.save(product);
//	        return new ResponseEntity<>(HttpStatus.OK);
//	    } catch (NoSuchElementException e) {
//	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//	    }      
//	}

}
