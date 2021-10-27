package com.niit.springsmartaccessories.services;

import com.niit.springsmartaccessories.dto.ShipOrderDto;
import com.niit.springsmartaccessories.exceptions.CartNotFoundException;
import com.niit.springsmartaccessories.mapper.ShipOrderMapper;
import com.niit.springsmartaccessories.models.Cart;
import com.niit.springsmartaccessories.models.ShipOrder;
import com.niit.springsmartaccessories.repositories.CartRepository;
import com.niit.springsmartaccessories.repositories.ShipOrderRepository;
import org.springframework.stereotype.Service;

@Service
public class ShipOrderService {

    private final ShipOrderRepository shipOrderRepository;
    private final CartRepository cartRepository;
    private final ShipOrderMapper shipOrderMapper;

    public ShipOrderService(ShipOrderRepository shipOrderRepository, CartRepository cartRepository, ShipOrderMapper shipOrderMapper) {
        this.shipOrderRepository = shipOrderRepository;
        this.cartRepository = cartRepository;
        this.shipOrderMapper = shipOrderMapper;
    }

    public void createShipOrder(ShipOrderDto shipOrderDto) {
        Cart cart = cartRepository.findById(shipOrderDto.getCartId())
                .orElseThrow(() -> new CartNotFoundException(shipOrderDto.getCartId() + ""));
        ShipOrder shipOrder = shipOrderMapper.map(shipOrderDto, cart);
        shipOrderRepository.save(shipOrder);
    }
}
