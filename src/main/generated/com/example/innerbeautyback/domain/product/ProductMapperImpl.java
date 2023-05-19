package com.example.innerbeautyback.domain.product;

import com.example.innerbeautyback.business.products.ProductResponse;
import com.example.innerbeautyback.domain.product.bloodgroup.BloodGroup;
import com.example.innerbeautyback.domain.product.category.Category;
import com.example.innerbeautyback.domain.product.country.Country;
import com.example.innerbeautyback.domain.product.gender.Gender;
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
public class ProductMapperImpl implements ProductMapper {

    @Override
    public ProductResponse toDto(Product product) {
        if ( product == null ) {
            return null;
        }

        ProductResponse productResponse = new ProductResponse();

        productResponse.setProductAge( product.getAge() );
        productResponse.setProductDescription( product.getDescription() );
        productResponse.setProductAvailableAt( product.getAvailableAt() );
        productResponse.setProductPrice( product.getPrice() );
        productResponse.setProductStatus( product.getStatus() );
        productResponse.setCategoryName( productCategoryName( product ) );
        productResponse.setCountryName( productCountryName( product ) );
        productResponse.setGenderName( productGenderName( product ) );
        productResponse.setBloodgroupType( productBloodgroupType( product ) );
        productResponse.setImageData( ProductMapper.imageToImageData( product.getImage() ) );

        return productResponse;
    }

    @Override
    public List<ProductResponse> toProductResponse(List<Product> products) {
        if ( products == null ) {
            return null;
        }

        List<ProductResponse> list = new ArrayList<ProductResponse>( products.size() );
        for ( Product product : products ) {
            list.add( toDto( product ) );
        }

        return list;
    }

    private String productCategoryName(Product product) {
        if ( product == null ) {
            return null;
        }
        Category category = product.getCategory();
        if ( category == null ) {
            return null;
        }
        String name = category.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }

    private String productCountryName(Product product) {
        if ( product == null ) {
            return null;
        }
        Country country = product.getCountry();
        if ( country == null ) {
            return null;
        }
        String name = country.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }

    private String productGenderName(Product product) {
        if ( product == null ) {
            return null;
        }
        Gender gender = product.getGender();
        if ( gender == null ) {
            return null;
        }
        String name = gender.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }

    private String productBloodgroupType(Product product) {
        if ( product == null ) {
            return null;
        }
        BloodGroup bloodgroup = product.getBloodgroup();
        if ( bloodgroup == null ) {
            return null;
        }
        String type = bloodgroup.getType();
        if ( type == null ) {
            return null;
        }
        return type;
    }
}
