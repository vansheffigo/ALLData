package com.example.debitcreditproject.dto.mapper;

import com.example.debitcreditproject.dto.request.VendorRequest;
import com.example.debitcreditproject.dto.response.VendorResponse;
import com.example.debitcreditproject.entity.VendorEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-03-12T11:35:57+0530",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.36.0.v20231114-0937, environment: Java 17.0.10 (Eclipse Adoptium)"
)
@Component
public class VendorMapperImpl implements VendorMapper {

    @Override
    public VendorEntity fromRequestToEntity(VendorRequest vendorRequest) {
        if ( vendorRequest == null ) {
            return null;
        }

        VendorEntity vendorEntity = new VendorEntity();

        return vendorEntity;
    }

    @Override
    public VendorResponse fromEntityToResponse(VendorEntity vendorEntity) {
        if ( vendorEntity == null ) {
            return null;
        }

        VendorResponse vendorResponse = new VendorResponse();

        return vendorResponse;
    }
}
