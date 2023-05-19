package com.example.innerbeautyback.domain.product.category;

import com.example.innerbeautyback.business.category.CategoryRequest;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface CategoryMapper {

    @Mapping(source = "id", target = "categoryId")
    @Mapping(source = "name", target = "categoryName")
    CategoryRequest toCategoryRequest(Category category);

    List<CategoryRequest> toCategoryRequests(List<Category> categories);

}