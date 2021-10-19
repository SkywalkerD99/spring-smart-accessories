package com.niit.springsmartaccessories.mapper;

import com.niit.springsmartaccessories.dto.CartDto;
import com.niit.springsmartaccessories.models.Cart;
import com.niit.springsmartaccessories.models.User;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface CartMapper {

    CartMapper INSTANCE  = Mappers.getMapper(CartMapper.class);

    @Mapping(target = "cartId", ignore = true)
    @Mapping(target = "active", source = "cartDto.active")
    @Mapping(target = "user", source = "user")
    Cart map(CartDto cartDto, User user);

    @Mapping(target = "userId", expression = "java(cart.getUser().getUserId())")
    CartDto mapToDto(Cart cart);

}
