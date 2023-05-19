package com.example.innerbeautyback.domain.product.category;

import com.example.innerbeautyback.business.category.CategoryRequest;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-19T15:46:31+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 18.0.2.1 (Oracle Corporation)"
)
@Component
public class CategoryMapperImpl implements CategoryMapper {

    @Override
    public CategoryRequest toCategoryRequest(Category category) {
        if ( category == null ) {
            return null;
        }

        CategoryRequest categoryRequest = new CategoryRequest();

        categoryRequest.setCategoryId( category.getId() );
        categoryRequest.setCategoryName( category.getName() );

        return categoryRequest;
    }

    @Override
    public List<CategoryRequest> toCategoryRequests(List<Category> categories) {
        if ( categories == null ) {
            return null;
        }

        List<CategoryRequest> list = new ArrayList<CategoryRequest>( categories.size() );
        for ( Category category : categories ) {
            list.add( toCategoryRequest( category ) );
        }

        return list;
    }
}
