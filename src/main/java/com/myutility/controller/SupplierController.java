package com.myutility.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.myutility.service.SupplierService;

@Controller
public class SupplierController {

  private SupplierService supplierService;

  public SupplierController(SupplierService supplierService) {
    this.supplierService = supplierService;
  }

  @RequestMapping(value = "/suppliers", method = RequestMethod.GET)
  public String viewSuppliers(Model model) {

    return "supplier/view";
  }



}
