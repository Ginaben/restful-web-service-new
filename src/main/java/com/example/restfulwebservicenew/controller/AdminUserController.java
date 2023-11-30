package com.example.restfulwebservicenew.controller;

import com.example.restfulwebservicenew.bean.AdminUser;
import com.example.restfulwebservicenew.bean.User;
import com.example.restfulwebservicenew.dao.UserDaoService;
import com.example.restfulwebservicenew.user.UserNotFoundException;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.beans.BeanUtils;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminUserController {
    private UserDaoService service;

    //의존성주입
    public AdminUserController(UserDaoService service) {
        this.service = service;
    }

    // /admin/user/{id}
    @GetMapping("/users/{id}")
    public MappingJacksonValue retrieveUser4Admin(@PathVariable int id) {
        User user = service.findOne(id);

        AdminUser adminUser = new AdminUser();

        if (user == null) {
            throw new UserNotFoundException(String.format("ID[%s] not found", id));
        } else {
//            adminUser.setName(user.getName());
            BeanUtils.copyProperties(user, adminUser);
        }

        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("id", "name", "ssn");
        FilterProvider filters = new SimpleFilterProvider().addFilter("UserInfo", filter);

        MappingJacksonValue mapping = new MappingJacksonValue(adminUser);
        mapping.setFilters(filters);

        return mapping;
    }



}
