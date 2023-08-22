package com.mjc.school.service.aspect;

import com.mjc.school.service.dto.AuthorDtoReq;
import com.mjc.school.service.dto.NewsDtoReq;
import com.mjc.school.service.exeptions.InvaliDataException;
import com.mjc.school.service.exeptions.NotFoundException;
import com.mjc.school.service.validator.Validator;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ServiceAspect {


    @Before("@annotation(com.mjc.school.service.actions.ValAuthorId) && args(id)")
    public void validateAuthorId(Long id) throws InvaliDataException {
        Validator.validateAuthorId(id);
    }

    @Before("@annotation(com.mjc.school.service.actions.ValAuthorParam) && args(request)")
    public void validateAuthorDto(AuthorDtoReq request) throws NotFoundException, InvaliDataException {
        Validator.validateAuthorDto(request);

    }

    @Before("@annotation(com.mjc.school.service.actions.ValNewsId) && args(id)")
    public void validateNewsId(Long id) throws InvaliDataException {
        Validator.validateAuthorId(id);
    }

    @Before("@annotation(com.mjc.school.service.actions.ValNewsParam) && args(request)")
    public void validateNewsDto(NewsDtoReq request) throws NotFoundException, InvaliDataException {
        Validator.validateNewsDto(request);

    }
}