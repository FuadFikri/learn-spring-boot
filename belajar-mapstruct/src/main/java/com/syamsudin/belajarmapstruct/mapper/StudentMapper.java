package com.syamsudin.belajarmapstruct.mapper;

import com.syamsudin.belajarmapstruct.dto.StudentDto;
import com.syamsudin.belajarmapstruct.entity.Status;
import com.syamsudin.belajarmapstruct.entity.Student;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.time.LocalDate;
import java.time.Period;

@Mapper(imports = Status.class, componentModel = "spring")
public interface StudentMapper {

    @Mapping(target = "password", ignore = true)
    @Mapping(target = "faculty", expression = "java( entity.getFaculty().toUpperCase() )")
    @Mapping(target = "age", expression = "java( getAge(entity.getBirthDate()))")
    @Mapping(target = "handphone", expression = "java(entity.getHandphone() != null ? entity.getHandphone() : \"N/A\")")
    @Mapping(target = "gpa", source = "gpa", qualifiedByName = "countGPA")
    @Mapping(target = "studentStatus", constant = "ACTIVE")
    StudentDto toDto(Student entity);

    @Named("countGPA")
    default Double getGPA(Double gpa) {
        return (gpa * 4) / 100;
    }

    default Integer getAge(LocalDate birthDate) {
        Period period = Period.between(LocalDate.now(), birthDate);
        return period.getYears();
    }
}
