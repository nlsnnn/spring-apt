package com.start.egor.library.service;

import com.start.egor.library.dto.RoleDTO;
import com.start.egor.library.dto.UserDTO;
import com.start.egor.library.mapper.GenericMapper;
import com.start.egor.library.model.User;
import com.start.egor.library.repository.GenericRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService extends GenericService<User, UserDTO> {
    public UserService(GenericRepository<User> repository,
                       GenericMapper<User, UserDTO> mapper) {
        super(repository, mapper);
    }

    @Override
    public UserDTO create(UserDTO newObject) {
        RoleDTO roleDTO = new RoleDTO();
        roleDTO.setId(1L);
        newObject.setRole(roleDTO);
        return mapper.toDTO(repository.save(mapper.toEntity(newObject)));
    }
}
