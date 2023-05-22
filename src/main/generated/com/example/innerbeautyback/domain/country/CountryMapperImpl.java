package com.example.innerbeautyback.domain.country;

import com.example.innerbeautyback.business.country.CountryResponse;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-22T10:33:30+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 18.0.2.1 (Oracle Corporation)"
)
@Component
public class CountryMapperImpl implements CountryMapper {

    @Override
    public CountryResponse toDto(Country country) {
        if ( country == null ) {
            return null;
        }

        CountryResponse countryResponse = new CountryResponse();

        countryResponse.setCountryId( country.getId() );
        countryResponse.setCountryName( country.getName() );

        return countryResponse;
    }

    @Override
    public List<CountryResponse> toDtos(List<Country> countries) {
        if ( countries == null ) {
            return null;
        }

        List<CountryResponse> list = new ArrayList<CountryResponse>( countries.size() );
        for ( Country country : countries ) {
            list.add( toDto( country ) );
        }

        return list;
    }
}
