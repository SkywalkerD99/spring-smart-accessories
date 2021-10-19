package com.niit.springsmartaccessories.mapper;

import com.niit.springsmartaccessories.dto.ProductDto;
import com.niit.springsmartaccessories.models.Category;
import com.niit.springsmartaccessories.models.Product;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    @Mapping(target = "productId", ignore = true)
    @Mapping(target = "productName", source = "productDto.name")
    @Mapping(target = "description", source = "productDto.description")
    @Mapping(target = "unitPrice", source = "productDto.price")
    @Mapping(target = "stock", source = "productDto.stock")
    @Mapping(target = "category", source = "category")
    Product map(ProductDto productDto, Category category);

    @Mapping(target = "categoryId", expression = "java(product.getCategory().getCategoryId())")
    ProductDto mapToDto(Product product);
}
