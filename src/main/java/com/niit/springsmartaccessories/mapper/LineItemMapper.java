package com.niit.springsmartaccessories.mapper;

import com.niit.springsmartaccessories.dto.LineItemDto;
import com.niit.springsmartaccessories.models.Cart;
import com.niit.springsmartaccessories.models.LineItem;
import com.niit.springsmartaccessories.models.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface LineItemMapper {

    LineItemMapper INSTANCE = Mappers.getMapper(LineItemMapper.class);

    @Mapping(target = "lineItemId", ignore = true)
    @Mapping(target = "quantity", source = "lineItemDto.quantity")
    @Mapping(target = "product", source = "product")
    @Mapping(target = "cart", source = "cart")
    LineItem map(LineItemDto lineItemDto, Product product, Cart cart);

    @Mapping(target = "productId", expression = "java(lineItem.getProduct().getProductId())")
    @Mapping(target = "cartId", expression = "java(lineItem.getCart().getCartId())")
    LineItemDto mapToDto(LineItem lineItem);

}
