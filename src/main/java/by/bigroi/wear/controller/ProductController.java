package by.bigroi.wear.controller;

import by.bigroi.wear.model.catalog.Catalog;
import by.bigroi.wear.model.product.Product;
import by.bigroi.wear.model.response.ResponseMessage;
import by.bigroi.wear.service.user.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.transaction.Transactional;
import java.util.List;

@Controller
public class ProductController {

    String collectionName;
    Product productInfo;
    List<Product> productsList;
    List<Catalog> catalogsList;

    @Autowired
    private ProductService productService;

    @PostMapping("/products")
    public @ResponseBody ResponseMessage productsList(@RequestBody Catalog catalog){
        ResponseMessage msg = new ResponseMessage();
        collectionName = catalog.getCollection();
        catalogsList =  productService.getCatalogs(catalog.getCollection());
        productsList = productService.getProductsFromCatalogAndCollection(catalog.getCollection(), catalog.getName());
        if(catalogsList == null || productsList == null){
            msg.setMessage("Products or catalogs didn't get from database");
        } else {
            msg.setMessage("Products and catalogs get from database successfully");
        }
        return msg;
    }

    @GetMapping("/products/products")
    public String productsPage(Model model){
        model.addAttribute("collName", collectionName);
        model.addAttribute("catalogsList", catalogsList);
        model.addAttribute("productsList", productsList);
        return "/products/products";
    }

    @PostMapping("/productPage")
    public @ResponseBody ResponseMessage getProduct(@RequestBody Product product){
        ResponseMessage msg = new ResponseMessage();
        productInfo = productService.getProductByID(product.getId());
        msg.setMessage("Product data get from database successfully");
        return msg;
    }

    @GetMapping("/products/productPage")
    public String productPage(Model model){
        model.addAttribute("product", productInfo);
        model.addAttribute("colorList", productService.getColors(productInfo.getId()));
        model.addAttribute("sizeList", productService.getSizes(productInfo.getId()));
        return "/products/productPage";
    }
}
