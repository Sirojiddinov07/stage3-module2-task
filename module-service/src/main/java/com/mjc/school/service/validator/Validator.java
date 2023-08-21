package com.mjc.school.service.validator;

import com.mjc.school.service.dto.AuthorDtoReq;
import com.mjc.school.service.dto.NewsDtoReq;
import com.mjc.school.service.exeptions.ErrorCodes;
import com.mjc.school.service.exeptions.InvaliDataException;
import com.mjc.school.service.exeptions.NotFoundException;

public class Validator {

    public static final Integer MIN_AUTHOR_NAME = 5;

    public static final Integer MAX_AUTHOR_NAME = 30;
    public static final Integer MIN_TITLE_LENGTH = 5;
    public static final Integer MAX_TITLE_LENGTH = 30;
    public static final Integer MIN_CONTENT_LENGTH = 5;
    public static final Integer MAX_CONTENT_LENGTH = 255;
    public static final Long MAX_AUTHOR_ID = 20L;

    public static final String NEWS_ID = "News id";

    public static final String AUTHOR_ID = "Author id";
    public static final String AUTHOR = "Author";
    public static final String AUTHOR_NAME = "Author name";
    public static final String NEWS_TITLE = "News title";
    public static final String NEWS_CONTENT = "News content";

    private Validator(){}

    private static void validateNumber(Long id, String parameter) throws InvaliDataException {
        if (id == null || id < 1) {
            throw new InvaliDataException(
                    String.format(ErrorCodes.VALIDATE_NEGATIVE_OR_NULL_NUMBER.getMessage(), parameter, parameter, id));
        }
    }

    public static void validateNewsId(Long newsId) throws InvaliDataException {
        validateNumber(newsId, NEWS_ID);
    }

    public static void validateAuthorId(Long authorId) throws InvaliDataException {
        validateNumber(authorId, AUTHOR_ID);
    }

    public static void validateNewsDto(NewsDtoReq dtoRequest) throws NotFoundException, InvaliDataException {
        validateString(dtoRequest.getTitle(), NEWS_TITLE, MIN_TITLE_LENGTH,
                MAX_TITLE_LENGTH);
        validateString(dtoRequest.getContent(), NEWS_CONTENT,
                MIN_CONTENT_LENGTH, MAX_CONTENT_LENGTH);
    }

    public static void validateAuthorDto(AuthorDtoReq dtoRequest) throws NotFoundException, InvaliDataException {
        validateString(dtoRequest.getName(), AUTHOR_NAME, MIN_AUTHOR_NAME,
                MAX_AUTHOR_NAME);
    }

    private static void validateString(String value, String parameter, int minLength, int maxLength) throws NotFoundException, InvaliDataException {
        if (value == null) {
            throw new NotFoundException(
                    String.format(ErrorCodes.VALIDATE_STRING_NULL.getMessage(), parameter, parameter));
        }
        if (value.trim().length() < minLength || value.trim().length() > maxLength) {
            throw new InvaliDataException(String.format(
                    ErrorCodes.VALIDATE_STRING_LENGTH.getMessage(),
                    parameter,
                    minLength,
                    maxLength,
                    parameter,
                    value));
        }
    }
}
