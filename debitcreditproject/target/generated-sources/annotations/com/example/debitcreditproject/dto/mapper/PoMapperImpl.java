package com.example.debitcreditproject.dto.mapper;

import com.example.debitcreditproject.dto.request.PoRequest;
import com.example.debitcreditproject.dto.response.PoResponse;
import com.example.debitcreditproject.entity.PoEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-03-12T12:18:59+0530",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.36.0.v20231114-0937, environment: Java 17.0.10 (Eclipse Adoptium)"
)
@Component
public class PoMapperImpl implements PoMapper {

    @Override
    public PoEntity fromRequestToEntity(PoRequest poRequest) {
        if ( poRequest == null ) {
            return null;
        }

        PoEntity poEntity = new PoEntity();

        return poEntity;
    }

    @Override
    public PoResponse fromEntityToResponse(PoEntity poEntity) {
        if ( poEntity == null ) {
            return null;
        }

        PoResponse poResponse = new PoResponse();

        return poResponse;
    }
}
