package com.learningportal.LearningPortal.dto.Mapper;

import com.learningportal.LearningPortal.Entity.AdminEntity;
import com.learningportal.LearningPortal.dto.Request.AdminRequest;
import com.learningportal.LearningPortal.dto.Response.AdminResponse;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-16T11:54:11+0530",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.36.0.v20231114-0937, environment: Java 17.0.10 (Eclipse Adoptium)"
)
@Component
public class AdminMapperImpl implements AdminMapper {

    @Override
    public AdminEntity fromRequestToEntity(AdminRequest adminRequest) {
        if ( adminRequest == null ) {
            return null;
        }

        AdminEntity adminEntity = new AdminEntity();

        adminEntity.setEmail( adminRequest.getEmail() );
        adminEntity.setName( adminRequest.getName() );
        adminEntity.setPassword( adminRequest.getPassword() );

        return adminEntity;
    }

    @Override
    public AdminResponse fromEntityToResponse(AdminEntity adminEntity) {
        if ( adminEntity == null ) {
            return null;
        }

        AdminResponse adminResponse = new AdminResponse();

        adminResponse.setAdmin_id( adminEntity.getAdmin_id() );
        adminResponse.setEmail( adminEntity.getEmail() );
        adminResponse.setName( adminEntity.getName() );
        adminResponse.setPassword( adminEntity.getPassword() );

        return adminResponse;
    }
}
