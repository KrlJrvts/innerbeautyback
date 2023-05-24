package com.example.innerbeautyback.domain.product.category;

import com.example.innerbeautyback.business.category.CategoryResponse;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface CategoryMapper {

    @Mapping(source = "id", target = "categoryId")
    @Mapping(source = "name", target = "categoryName")
    CategoryResponse toCategoryRequest(Category category);

    List<CategoryResponse> toCategoryRequests(List<Category> categories);

}