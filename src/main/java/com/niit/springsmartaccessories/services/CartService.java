package com.niit.springsmartaccessories.services;

import com.niit.springsmartaccessories.dto.CartDto;
import com.niit.springsmartaccessories.exceptions.UserNotFoundException;
import com.niit.springsmartaccessories.mapper.CartMapper;
import com.niit.springsmartaccessories.models.Cart;
import com.niit.springsmartaccessories.models.User;
import com.niit.springsmartaccessories.repositories.CartRepository;
import com.niit.springsmartaccessories.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {

    private final CartRepository cartRepository;
    private final UserRepository userRepository;
    private final CartMapper cartMapper;

    @Autowired
    public CartService(CartRepository cartRepository, UserRepository userRepository, CartMapper cartMapper) {
        this.cartRepository = cartRepository;
        this.userRepository = userRepository;
        this.cartMapper = cartMapper;
    }

    public void save(CartDto cartDto) {
        User user = userRepository.findById(cartDto.getUserId())
                .orElseThrow(() -> new UserNotFoundException(cartDto.getUserId() + ""));
        Cart cart = cartMapper.map(cartDto, user);
        cartRepository.save(cart);

    }
}
