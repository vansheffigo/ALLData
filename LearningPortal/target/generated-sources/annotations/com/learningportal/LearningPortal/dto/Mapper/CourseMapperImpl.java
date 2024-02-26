package com.learningportal.LearningPortal.dto.Mapper;

import com.learningportal.LearningPortal.Entity.CoursesEntity;
import com.learningportal.LearningPortal.dto.Request.CourseRequest;
import com.learningportal.LearningPortal.dto.Response.CourseResponse;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-16T12:49:22+0530",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.36.0.v20231114-0937, environment: Java 17.0.10 (Eclipse Adoptium)"
)
@Component
public class CourseMapperImpl implements CourseMapper {

    @Override
    public CoursesEntity fromRequestToEntity(CourseRequest courseRequest) {
        if ( courseRequest == null ) {
            return null;
        }

        CoursesEntity coursesEntity = new CoursesEntity();

        coursesEntity.setTitle( courseRequest.getTitle() );

        return coursesEntity;
    }

    @Override
    public CourseResponse fromEntityTOResponse(CoursesEntity courseEntity) {
        if ( courseEntity == null ) {
            return null;
        }

        CourseResponse courseResponse = new CourseResponse();

        courseResponse.setId( courseEntity.getId() );
        courseResponse.setTitle( courseEntity.getTitle() );

        return courseResponse;
    }
}
