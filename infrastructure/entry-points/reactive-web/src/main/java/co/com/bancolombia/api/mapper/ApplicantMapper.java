package co.com.bancolombia.api.mapper;

import co.com.bancolombia.api.dto.ApplicantDTO;
import co.com.bancolombia.model.applicant.Applicant;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ApplicantMapper {
    Applicant toApplicant (ApplicantDTO applicantDTO);

    ApplicantDTO toApplicantDTO(Applicant applicant);
}
