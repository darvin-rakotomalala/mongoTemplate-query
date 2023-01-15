package com.poc.constraint.validation;

import com.poc.exception.ErrorsEnum;
import com.poc.model.dto.TutorialDTO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class TutorialValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return TutorialDTO.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        TutorialDTO tutorialDTO = (TutorialDTO) target;
        if (StringUtils.isEmpty(tutorialDTO.getTitle())) {
            errors.rejectValue("title", "title.value.empty", ErrorsEnum.ERR_MCS_TUTORIAL_TITLE_EMPTY.getErrorMessage());
        }
    }

}
