package uz.pdp.onlineshop.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import uz.pdp.onlineshop.dao.CategoryDao;
import uz.pdp.onlineshop.dao.ProductDao;

@Controller
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {

    private final ProductDao productDao;
    private final CategoryDao categoryDao;

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

    @GetMapping({"/get-form","/edit/{id}"})
    public String getForm(@PathVariable Integer id,Model m){

        if (id != null){
            m.addAttribute("id",id);
            m.addAttribute("categoryList");
            return "product-form";
        }else {
            m.addAttribute("categoryList",categoryDao.categoryList());
            return "product-form";
        }


    }
}
