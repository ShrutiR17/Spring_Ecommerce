package com.example.ecommerce;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@org.springframework.stereotype.Controller
public class Controller {

    @Autowired
    Repository repo;

    @RequestMapping("/saveProduct")
    @ResponseBody
    public Optional<Ecomentity> add(@RequestParam String productId,String productName,String description,String quantity,String price,String type)
    {
        Ecomentity obj=new Ecomentity();
        obj.setProductId(productId);
        obj.setProductName(productName);
        obj.setDescription(description);
        obj.setQuantity(quantity);
        obj.setPrice(price);
        obj.setType(type);
        repo.save(obj);

        return repo.findById(productId);
    }

    @RequestMapping("/getByType")
    @ResponseBody
    public Optional<Ecomentity> get(@RequestParam String type)
    {
        return repo.findById(type);
    }

    @RequestMapping("/deleteProduct")
    @ResponseBody
    public Optional<Ecomentity> del(@RequestParam String productId)
    {
        repo.deleteById(productId);
        return repo.findById(productId);
    }

    @RequestMapping("/getAllProduct")
    @ResponseBody
    public List<Ecomentity> getall()
    {
        return repo.findAll();
    }

    @RequestMapping("/getProduct")
    @ResponseBody
    public Optional<Ecomentity> getid(@RequestParam String productId)
    {
        return repo.findById(productId);
    }
}

