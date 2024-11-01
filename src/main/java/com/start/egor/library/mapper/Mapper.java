package com.start.egor.library.mapper;

import com.start.egor.library.dto.GenericDTO;
import com.start.egor.library.model.GenericModel;

import java.util.List;

public interface Mapper <E extends GenericModel, D extends GenericDTO> {
    E toEntity(D dto);
    D toDTO(E entity);

    List<E> toEntities(List<D> dtos);
    List<D> toDTOs(List<E> entities);
}
