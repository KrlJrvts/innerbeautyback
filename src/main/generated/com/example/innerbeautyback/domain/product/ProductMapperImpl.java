package com.example.innerbeautyback.domain.product;

import com.example.innerbeautyback.business.Status;
import com.example.innerbeautyback.business.products.Dtos.ProductRequest;
import com.example.innerbeautyback.business.products.Dtos.ProductResponse;
import com.example.innerbeautyback.domain.country.Country;
import com.example.innerbeautyback.domain.product.bloodgroup.BloodGroup;
import com.example.innerbeautyback.domain.product.category.Category;
import com.example.innerbeautyback.domain.product.gender.Gender;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-24T14:14:38+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 19.0.2 (Oracle Corporation)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public ProductResponse toDto(Product product) {
        if ( product == null ) {
            return null;
        }

        ProductResponse productResponse = new ProductResponse();

        productResponse.setProductId( product.getId() );
        productResponse.setProductAge( product.getAge() );
        productResponse.setProductDescription( product.getDescription() );
        productResponse.setProductAvailableAt( product.getAvailableAt() );
        productResponse.setProductPrice( product.getPrice() );
        productResponse.setGenderName( productGenderName( product ) );
        productResponse.setBloodgroupType( productBloodgroupType( product ) );
        productResponse.setCountryName( productCountryName( product ) );
        productResponse.setImageData( ProductMapper.imageToImageData( product.getImage() ) );

        return productResponse;
    }

    @Override
    public Product toAddProduct(ProductRequest productRequest) {
        if ( productRequest == null ) {
            return null;
        }

        Product product = new Product();

        product.setCategory( productRequestToCategory( productRequest ) );
        product.setCountry( productRequestToCountry( productRequest ) );
        product.setBloodgroup( productRequestToBloodGroup( productRequest ) );
        product.setGender( productRequestToGender( productRequest ) );
        product.setAge( productRequest.getProductAge() );
        product.setDescription( productRequest.getProductDescription() );
        product.setAvailableAt( productRequest.getProductAvailableAt() );
        product.setPrice( productRequest.getProductPrice() );
        product.setImage( ProductMapper.imageDataToImage( productRequest.getProductImage() ) );

        product.setStatus( Status.ACTIVE.getLetter( );

            return product;
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

        protected Category productRequestToCategory(ProductRequest productRequest) {
            if ( productRequest == null ) {
                return null;
            }

            Category category = new Category();

            category.setId( productRequest.getProductCategoryId() );

            return category;
        }

        protected Country productRequestToCountry(ProductRequest productRequest) {
            if ( productRequest == null ) {
                return null;
            }

            Country country = new Country();

            country.setId( productRequest.getProductCountryId() );

            return country;
        }

        protected BloodGroup productRequestToBloodGroup(ProductRequest productRequest) {
            if ( productRequest == null ) {
                return null;
            }

            BloodGroup bloodGroup = new BloodGroup();

            bloodGroup.setId( productRequest.getProductBloodgroupId() );

            return bloodGroup;
        }

        protected Gender productRequestToGender(ProductRequest productRequest) {
            if ( productRequest == null ) {
                return null;
            }

            Gender gender = new Gender();

            gender.setId( productRequest.getProductGenderId() );

            return gender;
        }
    }
