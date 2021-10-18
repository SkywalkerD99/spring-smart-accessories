package com.niit.springsmartaccessories.controllers;

import com.niit.springsmartaccessories.dto.LineItemDto;
import com.niit.springsmartaccessories.services.LineItemService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lineItems")
public class LineItemController {

    private final LineItemService lineItemService;

    public LineItemController(LineItemService lineItemService) {
        this.lineItemService = lineItemService;
    }

    @PostMapping("/create")
    public void createLineItem(@RequestBody LineItemDto lineItemDto){
        lineItemService.save(lineItemDto);
    }

}
