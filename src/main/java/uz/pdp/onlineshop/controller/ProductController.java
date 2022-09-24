package uz.pdp.onlineshop.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uz.pdp.onlineshop.dao.CategoryDao;
import uz.pdp.onlineshop.dao.MakerDao;
import uz.pdp.onlineshop.dao.ProductDao;
import uz.pdp.onlineshop.model.Product;

@Controller
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {

    private final ProductDao productDao;
    private final CategoryDao categoryDao;

    private final MakerDao makerDao;

    @GetMapping
    public String viewProduct(Model m){

        m.addAttribute("productList",productDao.getAllProduct());

        return "view-product";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Integer id){

        productDao.deleteProduct(id);

        return "redirect:/products";
    }

    @GetMapping("/edit/{id}")
    public String getForm(@PathVariable Integer id, Model m){

        m.addAttribute("id",id);
        m.addAttribute("categoryList",categoryDao.categoryList());
        m.addAttribute("makerList",makerDao.makerList());

        return "product-form";
    }

    @PostMapping
    public String addProduct(Product product, @RequestParam Integer id){

        if (product.getId() == null ){
         productDao.saveProduct(product);
        }else {
            productDao.editProduct(product);
        }

        return "redirect:/products";
    }

}


