package com.wipro.shoppingms.controller;

import com.wipro.shoppingms.entity.Customer;
import com.wipro.shoppingms.entity.LineItem;
import com.wipro.shoppingms.entity.Product;
import com.wipro.shoppingms.service.ShoppingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/shopping")
public class ShoppingController {

    @Autowired
    private ShoppingService service;

    @GetMapping("/profile")
    public String addProfile(Model model){
        Customer customer = new Customer();
        model.addAttribute("customer", customer);
        return "add-profile";
    }

    @PostMapping("/options")
    public String  profileOptions(@ModelAttribute("customer") Customer customer){
        service.createCustomer(customer);
        return "profile-options";
    }

    @GetMapping("/options")
    public String  showProfileOptions(){
        return "profile-options";
    }

//    @GetMapping("/add-product")
//    public String showAddProduct(Model model){
//        Product product = new Product();
//        model.addAttribute("product", product);
//        return "add-product";
//    }

//    @PostMapping("/add-product")
//    public String addProduct(@ModelAttribute("product") Product product){
//        service.addProduct(product);
//        return "redirect:/api/shopping/options";
//    }

//    @GetMapping("/view-products")
//    public String showViewProducts(Model model){
//        List<Product> products = service.viewProducts();
//        model.addAttribute("products", products);
//        return "view-products";
//    }

    @GetMapping("/view-cart")
    public String showViewCart(Model model){
        List<LineItem> items = service.getCartItems();
        int size = items.size();
        model.addAttribute("size", size);
        model.addAttribute("items", items);
        return "view-cart";
    }

    @GetMapping("/update-cart")
    public String showUpdateCart(Model model){
        List<Product> products = service.viewProducts();
        model.addAttribute("products", products);
        LineItem item = new LineItem();
        model.addAttribute("item", item);
        return "update-cart";
    }

    @PostMapping("/update-cart")
    public String updateCart(@ModelAttribute("item") LineItem item){
        service.updateCart(item);
        return "redirect:/api/shopping/update-cart";
    }

    @GetMapping("/place-order")
    public String showPlaceOrder(Model model){
        model.addAttribute("orderId", service.getOrderId());
        return "order-placed";
    }

    @PostMapping("/place-order")
    public String placeOrder(){
        service.placeOrder();
        return "redirect:/api/shopping/options";
    }

    @GetMapping("/view-order")
    public String viewOrder(Model model){
        List<LineItem> items = service.getOrderItems();
        int size = items.size();
        model.addAttribute("size", size);
        model.addAttribute("items", items);
        return "view-order";
    }

    @GetMapping("/delete/{id}")
    public String removeCartItem(@PathVariable(value = "id") int id){
        service.removeCartItem(id);
        return "redirect:/api/shopping/view-cart";
    }


}