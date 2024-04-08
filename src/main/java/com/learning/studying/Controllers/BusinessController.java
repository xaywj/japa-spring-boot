package com.learning.studying.Controllers;


import com.learning.studying.Models.Business;
import com.learning.studying.Repository.BusinessRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/business")
public class BusinessController {
    private final BusinessRepository businessRepository;

    public BusinessController(BusinessRepository businessRepository) {
        this.businessRepository = businessRepository;
    }

    public List<Business> all(){
        return this.businessRepository.findAll();
    }
    public Business create(Business business){
        return this.businessRepository.save(business);
    }
    public Business view(Long id){
        return this.businessRepository.getById(id);
    }
    public Business update(Long id, Business business){
        return this.businessRepository.getById(id);
    }
    public String delete(Long id){
        return "delete by id=> "+id;
//        return this.businessRepository.deleteById(Long id);
    }


}
