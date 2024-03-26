package com.example.debitcreditproject.dto.mapper;

import com.example.debitcreditproject.dto.request.InvoiceRequest;
import com.example.debitcreditproject.dto.response.InvoiceResponse;
import com.example.debitcreditproject.entity.InvoiceEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-03-12T16:11:29+0530",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.36.0.v20231114-0937, environment: Java 17.0.10 (Eclipse Adoptium)"
)
@Component
public class InvoiceMapperImpl implements InvoiceMapper {

    @Override
    public InvoiceEntity fromRequestToEntity(InvoiceRequest invoiceRequest) {
        if ( invoiceRequest == null ) {
            return null;
        }

        InvoiceEntity invoiceEntity = new InvoiceEntity();

        return invoiceEntity;
    }

    @Override
    public InvoiceResponse fromEntityToResponse(InvoiceEntity invoiceEntity) {
        if ( invoiceEntity == null ) {
            return null;
        }

        InvoiceResponse invoiceResponse = new InvoiceResponse();

        return invoiceResponse;
    }
}
