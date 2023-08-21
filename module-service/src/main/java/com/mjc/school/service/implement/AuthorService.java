package com.mjc.school.service.implement;

import com.mjc.school.repository.BaseRepository;
import com.mjc.school.repository.model.AuthorModel;
import com.mjc.school.service.BaseService;
import com.mjc.school.service.actions.ValAuthorId;
import com.mjc.school.service.actions.ValAuthorParam;
import com.mjc.school.service.dto.AuthorDtoReq;
import com.mjc.school.service.dto.AuthorDtoRes;
import com.mjc.school.service.exeptions.ErrorCodes;
import com.mjc.school.service.exeptions.NotFoundException;
import com.mjc.school.service.map.CustomAuthorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public abstract class AuthorService implements BaseService<AuthorDtoRes, AuthorDtoRes> {

    public static final String AUTHOR = "Author";

    private final BaseRepository<AuthorModel, Long> authorRepository;

    @Autowired
     public AuthorService(BaseRepository<AuthorModel, Long> authorRepository) {
        this.authorRepository = authorRepository;
     }

     @Override
     public List<AuthorDtoRes> readAll() {
        return authorRepository.readAll().stream().map(CustomAuthorMapper.INSTANCE::toAuthorDtoResponse).toList();

     }

    @Override
     @ValAuthorId
    public AuthorDtoRes readById(Long id) throws NotFoundException {
        Optional<AuthorModel> authorModel = authorRepository.readById(id);
        if (authorModel.isPresent()) {
            return CustomAuthorMapper.INSTANCE.toAuthorDtoResponse(authorModel.get());
         }
         throw new NotFoundException(
                 String.format(ErrorCodes.NOT_FOUND_DATA.getMessage(), AUTHOR, id));
     }

     @Override
     @ValAuthorParam
     public AuthorDtoRes create(AuthorDtoRes createRequest) {
         return CustomAuthorMapper.INSTANCE.toAuthorDtoResponse(
                 authorRepository.create(CustomAuthorMapper.INSTANCE.toAuthorModel(createRequest)));
     }

     @Override
     @ValAuthorParam
     public AuthorDtoRes update(AuthorDtoRes updateRequest) throws NotFoundException {
         if(authorRepository.existById(updateRequest.getId())){
             AuthorModel updateAuthor = authorRepository.update(CustomAuthorMapper.INSTANCE.toAuthorModel(updateRequest));
             return CustomAuthorMapper.INSTANCE.toAuthorDtoResponse(updateAuthor);
        }
         throw new NotFoundException(
                 String.format(ErrorCodes.NOT_FOUND_DATA.getMessage(), AUTHOR, updateRequest.getId()));
     }
     @Override
     @ValAuthorId
     public boolean deleteById(Long id) throws NotFoundException {
         if(authorRepository.existById(id)){
             return authorRepository.deleteById(id);
         }
        throw new NotFoundException(
                String.format(ErrorCodes.NOT_FOUND_DATA.getMessage(), AUTHOR, id));
    }
}
