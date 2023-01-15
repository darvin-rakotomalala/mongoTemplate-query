package com.poc.mapper;

import com.poc.common.mapper.DtoMapper;
import com.poc.model.domain.Tutorial;
import com.poc.model.dto.TutorialDTO;
import org.mapstruct.Mapper;

@Mapper
public interface TutorialMapper extends DtoMapper<TutorialDTO, Tutorial> {

}
