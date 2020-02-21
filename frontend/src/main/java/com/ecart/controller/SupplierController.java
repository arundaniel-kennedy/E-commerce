package com.ecart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ecart.dao.SupplierDAO;
import com.ecart.model.Supplier;


@Controller

public class SupplierController {
	@Autowired
	SupplierDAO supplierDAO;
	
	boolean flag = true;

	@RequestMapping("/Supplier")
	public String showSupplier(Model m) {
		List<Supplier> listSupplier = supplierDAO.getSupplier();
		m.addAttribute("listSupplier", listSupplier);

		for (Supplier supplier : listSupplier) {
			System.out.println(supplier.getSupplierName() + ",");
		}
		flag = false;
		return "Supplier";
	}

	@RequestMapping(value = "/InsertSupplier", method = RequestMethod.POST)
	public String insertSupplierData(@RequestParam("suppliername") String suppliername, @RequestParam("supplierlocation") String supplierlocation,
			Model m) {
		Supplier supplier = new Supplier();
		supplier.setSupplierName(suppliername);
		supplier.setSupplierLocation(supplierlocation);

		supplierDAO.addSupplier(supplier);

		List<Supplier> listSupplier = supplierDAO.getSupplier();
		m.addAttribute("listSuppliers", listSupplier);
		flag = false;
		return "Supplier";
	}

	@RequestMapping("/deleteSupplier/{supplierId}")
	public String deleteSupplier(@PathVariable("supplierId") int supplierId,Model m)
	{
		Supplier supplier=supplierDAO.getSupplier(supplierId);
		
		supplierDAO.deleteSupplier(supplier);
		
		List<Supplier> listSupplier=supplierDAO.getSupplier();
		m.addAttribute("listSupplier",listSupplier);
		flag=false;
		return "Supplier";
	}

	@RequestMapping("/updateSupplier/{supplierId}")
	public String updateSupplier(@PathVariable("supplierId") int supplierId,Model m)
	{
		Supplier supplier=supplierDAO.getSupplier(supplierId);
		
		
		List<Supplier> listSupplier=supplierDAO.getSupplier();
		m.addAttribute("listSupplier",listSupplier);
		m.addAttribute("SupplierInfo",supplier);
		
		return "UpdateSupplier";
	}
	
	@RequestMapping(value="/UpdateSupplier",method=RequestMethod.POST)
	public String updateCategoryInDB(@RequestParam("supplierid") int supplierId,@RequestParam("supplierName") String supplierName,
			@RequestParam("supplierLocation") String supplierlocation,Model m)
	{
		Supplier supplier=supplierDAO.getSupplier(supplierId);
		supplier.setSupplierName(supplierName);
		supplier.setSupplierLocation(supplierlocation);
		
		supplierDAO.updateSuppplier(supplier);
		
		List<Supplier> listSupplier=supplierDAO.getSupplier();
		m.addAttribute("listSupplier",listSupplier);
		
		return "Supplier";
	}


}
