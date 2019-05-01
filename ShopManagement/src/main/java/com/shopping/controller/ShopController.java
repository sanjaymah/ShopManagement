package com.shopping.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.shopping.dao.ShopRepository;
import com.shopping.model.Shop;
import com.shopping.service.ShopService;

@Controller
public class ShopController {

	@Autowired
	private ShopRepository shoprepository;

	@Autowired
	private ShopService shopservice;

	private ArrayList shopModelList;

	private List shoplist = null;

	@GetMapping(value = "/")
	public String shophome(Model model) {

		shopModelList = new ArrayList();
		//System.out.println("q is = " + q);
		shoplist = shopservice.findShops();

		System.out.println("findShops ****** " + shoplist);
		System.out.println("shoplist.size() ****** " + shoplist.size());
		model.addAttribute("shops", shoplist);   
		System.out.println("shoprepository.findAll() ****** " + shoprepository.findAll());
		return "index";

	}

	@PostMapping(value = "/")
	public String addShop(@RequestParam("name") String name,
			@RequestParam("category") String category,
			@RequestParam("address") String address,
			@RequestParam("owner") String owner, Model model) {
		shopservice.addAShop(name, category,address,owner);
		System.out.println("Added shop ...." + "name = " + name + ",category = " + category + ", address = " + address + ", owner = " + owner);
		return "redirect:/";
	}

	@PostMapping(value = "/delete")
	public String deleteShop(@RequestParam("name") String name,
			@RequestParam("id") Long id) {
		shopservice.deleteAShop(name, id);
		System.out.println("shop named = " + name + "was removed from our database. ");
		return "redirect:/";

	}

	/*
	@PostMapping(value = "/genkey")
	public String genkey(@RequestParam("name") String name,
			@RequestParam("category") String category,
			@RequestParam("address") String address,
			@RequestParam("owner") String owner,
			Model model) {
		shopservice.getGeneratedKey(name, category, address,owner);
		System.out.println("name = " + name + ", category = " +  category + ", address = " + address + " , owner = " + owner);
		return "redirect:/";
	}*/

}