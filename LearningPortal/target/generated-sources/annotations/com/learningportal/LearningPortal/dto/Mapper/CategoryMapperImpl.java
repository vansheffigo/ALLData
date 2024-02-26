package com.learningportal.LearningPortal.dto.Mapper;

import com.learningportal.LearningPortal.Entity.CategoryEntity;
import com.learningportal.LearningPortal.dto.Request.CategoryRequest;
import com.learningportal.LearningPortal.dto.Response.CategoryResponse;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-16T11:54:07+0530",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.36.0.v20231114-0937, environment: Java 17.0.10 (Eclipse Adoptium)"
)
@Component
public class CategoryMapperImpl implements CategoryMapper {

    @Override
    public CategoryEntity fromRequestToEntity(CategoryRequest courseRequest) {
        if ( courseRequest == null ) {
            return null;
        }

        CategoryEntity categoryEntity = new CategoryEntity();

        categoryEntity.setDescription( courseRequest.getDescription() );
        categoryEntity.setName( courseRequest.getName() );

        return categoryEntity;
    }

    @Override
    public CategoryResponse fromEntityTOResponse(CategoryEntity courseEntity) {
        if ( courseEntity == null ) {
            return null;
        }

        CategoryResponse categoryResponse = new CategoryResponse();

        return categoryResponse;
    }
}
