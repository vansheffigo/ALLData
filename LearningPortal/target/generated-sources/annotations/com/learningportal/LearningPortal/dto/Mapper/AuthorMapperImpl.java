package com.learningportal.LearningPortal.dto.Mapper;

import com.learningportal.LearningPortal.Entity.AuthorEntity;
import com.learningportal.LearningPortal.dto.Request.AuthorRequest;
import com.learningportal.LearningPortal.dto.Response.AuthorResponse;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-16T11:54:07+0530",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.36.0.v20231114-0937, environment: Java 17.0.10 (Eclipse Adoptium)"
)
@Component
public class AuthorMapperImpl implements AuthorMapper {

    @Override
    public AuthorEntity fromRequestToEntity(AuthorRequest authorRequest) {
        if ( authorRequest == null ) {
            return null;
        }

        AuthorEntity authorEntity = new AuthorEntity();

        authorEntity.setCourse( authorRequest.getCourse() );
        authorEntity.setName( authorRequest.getName() );

        return authorEntity;
    }

    @Override
    public AuthorResponse fromEntityToResponse(AuthorEntity authorEntity) {
        if ( authorEntity == null ) {
            return null;
        }

        AuthorResponse authorResponse = new AuthorResponse();

        authorResponse.setCourse( authorEntity.getCourse() );
        authorResponse.setId( authorEntity.getId() );
        authorResponse.setName( authorEntity.getName() );

        return authorResponse;
    }
}
