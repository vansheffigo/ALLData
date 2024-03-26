package com.example.debitcreditproject.dto.mapper;

import com.example.debitcreditproject.dto.request.MaterialRequest;
import com.example.debitcreditproject.dto.response.MaterialResponse;
import com.example.debitcreditproject.entity.MaterialEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-03-12T11:35:57+0530",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.36.0.v20231114-0937, environment: Java 17.0.10 (Eclipse Adoptium)"
)
@Component
public class MaterialMapperImpl implements MaterialMapper {

    @Override
    public MaterialEntity fromRequestToEntity(MaterialRequest materialRequest) {
        if ( materialRequest == null ) {
            return null;
        }

        MaterialEntity materialEntity = new MaterialEntity();

        return materialEntity;
    }

    @Override
    public MaterialResponse fromEntityToResponse(MaterialEntity materialEntity) {
        if ( materialEntity == null ) {
            return null;
        }

        MaterialResponse materialResponse = new MaterialResponse();

        return materialResponse;
    }
}
