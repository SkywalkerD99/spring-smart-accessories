package com.niit.springsmartaccessories.mapper;

import com.niit.springsmartaccessories.dto.ShipOrderDto;
import com.niit.springsmartaccessories.models.Cart;
import com.niit.springsmartaccessories.models.ShipOrder;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface ShipOrderMapper {

    ShipOrderMapper INSTANCE = Mappers.getMapper(ShipOrderMapper.class);

    @Mapping(target = "shipOrderId", ignore = true)
    @Mapping(target = "deliveryDate", source = "shipOrderDto.deliveryDate")
    @Mapping(target = "cart", source = "cart")
    ShipOrder map(ShipOrderDto shipOrderDto, Cart cart);

    @Mapping(target = "cartId", expression = "java(shipOrder.getCart().getCartId())")
    ShipOrderDto mapToDto(ShipOrder shipOrder);

}
