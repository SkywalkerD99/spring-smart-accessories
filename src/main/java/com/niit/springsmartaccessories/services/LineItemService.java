package com.niit.springsmartaccessories.services;

import com.niit.springsmartaccessories.dto.LineItemDto;
import com.niit.springsmartaccessories.exceptions.CartNotFoundException;
import com.niit.springsmartaccessories.exceptions.ProductNotFoundException;
import com.niit.springsmartaccessories.mapper.LineItemMapper;
import com.niit.springsmartaccessories.models.Cart;
import com.niit.springsmartaccessories.models.LineItem;
import com.niit.springsmartaccessories.models.Product;
import com.niit.springsmartaccessories.repositories.CartRepository;
import com.niit.springsmartaccessories.repositories.LineItemRepository;
import com.niit.springsmartaccessories.repositories.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class LineItemService {

    private final LineItemRepository lineItemRepository;
    private final CartRepository cartRepository;
    private final ProductRepository productRepository;
    private final LineItemMapper lineItemMapper;

    public LineItemService(LineItemRepository lineItemRepository, CartRepository cartRepository, ProductRepository productRepository, LineItemMapper lineItemMapper) {
        this.lineItemRepository = lineItemRepository;
        this.cartRepository = cartRepository;
        this.productRepository = productRepository;
        this.lineItemMapper = lineItemMapper;
    }

    public void save(LineItemDto lineItemDto) {
        Product product = productRepository.findById(lineItemDto.getProductId())
                .orElseThrow(() -> new ProductNotFoundException(lineItemDto.getProductId() + ""));
        Cart cart = cartRepository.findById(lineItemDto.getCartId())
                .orElseThrow(() -> new CartNotFoundException(lineItemDto.getCartId() + ""));
        LineItem lineItem = lineItemMapper.map(lineItemDto, product, cart);
        lineItemRepository.save(lineItem);
    }

}
