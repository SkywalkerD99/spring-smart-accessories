package com.niit.springsmartaccessories.controllers;

import com.niit.springsmartaccessories.dto.ShipOrderDto;
import com.niit.springsmartaccessories.services.ShipOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.security.RolesAllowed;

@Controller
@RequestMapping("/shipOrders")
public class ShipOrderController {

    @Autowired
    private ShipOrderService shipOrderService;

    @RolesAllowed("ADMIN")
    @PostMapping("/create")
    public void createShipOrder(@RequestBody ShipOrderDto shipOrderDto) {
        shipOrderService.createShipOrder(shipOrderDto);
    }

}
