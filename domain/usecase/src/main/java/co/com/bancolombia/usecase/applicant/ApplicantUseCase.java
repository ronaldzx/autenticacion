package co.com.bancolombia.usecase.applicant;

import co.com.bancolombia.model.applicant.Applicant;
import co.com.bancolombia.model.applicant.exception.EmailAlreadyExistsException;
import co.com.bancolombia.model.applicant.gateways.ApplicantRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class ApplicantUseCase {

    private final ApplicantRepository applicantRepository;

    public Mono<Applicant> saveApplicant(Applicant applicant){
        return applicantRepository.findByEmailAddress(applicant.getEmailAddress())
                .flatMap(exists ->
                        Mono.<Applicant>error(new EmailAlreadyExistsException("Email already exists"))
                ).switchIfEmpty(applicantRepository.save(applicant));
    }

}
