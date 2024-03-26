package com.example.debitcreditproject.dto.mapper;

import com.example.debitcreditproject.dto.request.GrnRequest;
import com.example.debitcreditproject.dto.response.GrnResponse;
import com.example.debitcreditproject.entity.GrnEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-03-12T11:35:57+0530",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.36.0.v20231114-0937, environment: Java 17.0.10 (Eclipse Adoptium)"
)
@Component
public class GrnMapperImpl implements GrnMapper {

    @Override
    public GrnEntity fromRequestToEntity(GrnRequest grnRequest) {
        if ( grnRequest == null ) {
            return null;
        }

        GrnEntity grnEntity = new GrnEntity();

        return grnEntity;
    }

    @Override
    public GrnResponse fromEntityToResponse(GrnEntity grnEntity) {
        if ( grnEntity == null ) {
            return null;
        }

        GrnResponse grnResponse = new GrnResponse();

        return grnResponse;
    }
}
