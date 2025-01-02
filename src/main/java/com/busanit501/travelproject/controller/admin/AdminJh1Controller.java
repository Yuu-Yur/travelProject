package com.busanit501.travelproject.controller.admin;

import com.busanit501.travelproject.dto.ProductJh1DTO;
import com.busanit501.travelproject.service.admin.AdminJh1Service;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminJh1Controller {

  private final AdminJh1Service adminService;

  @GetMapping("/product/register")
  public String registerProduct() {
    return "admin/registerProduct_jh1";
  }

  @GetMapping("/product/edit/{productNo}")
  public String editProduct(@PathVariable("productNo") @ModelAttribute("productNo") Long productNo, Model model) {
    ProductJh1DTO productDTO = adminService.getProductTmp(productNo);
    model.addAttribute("productDTO", productDTO);
    return "admin/registerProduct_jh1";
  }

  @GetMapping("/product/list")
  public String listProduct() {
    return "admin/listProduct_jh1";
  }

  @GetMapping("/location/list")
  public String listLocation() { return "admin/listLocation_jh1"; }

  @GetMapping("/member/list")
  public String listMembers() { return "admin/listMembers_jh1"; }

}