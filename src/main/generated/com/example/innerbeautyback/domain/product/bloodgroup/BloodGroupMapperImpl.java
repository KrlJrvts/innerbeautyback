package com.example.innerbeautyback.domain.product.bloodgroup;

import com.example.innerbeautyback.business.bloodgroup.BloodGroupResponse;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-06-01T09:10:04+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 19.0.2 (Oracle Corporation)"
)
@Component
public class BloodGroupMapperImpl implements BloodGroupMapper {

    @Override
    public BloodGroupResponse toBloodGroupRequest(BloodGroup bloodGroup) {
        if ( bloodGroup == null ) {
            return null;
        }

        BloodGroupResponse bloodGroupResponse = new BloodGroupResponse();

        bloodGroupResponse.setBloodGroupTypeId( bloodGroup.getId() );
        bloodGroupResponse.setBloodGroupTypeName( bloodGroup.getType() );

        return bloodGroupResponse;
    }

    @Override
    public List<BloodGroupResponse> toBloodgroupRequests(List<BloodGroup> bloodGroups) {
        if ( bloodGroups == null ) {
            return null;
        }

        List<BloodGroupResponse> list = new ArrayList<BloodGroupResponse>( bloodGroups.size() );
        for ( BloodGroup bloodGroup : bloodGroups ) {
            list.add( toBloodGroupRequest( bloodGroup ) );
        }

        return list;
    }
}
