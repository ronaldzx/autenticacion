package co.com.bancolombia.model.applicant.gateways;

import co.com.bancolombia.model.applicant.Applicant;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ApplicantRepository {
    Mono<Applicant> save(Applicant task);

    Mono<Applicant> findByEmailAddress(String email);

    Flux<Applicant> findAll();

    Mono<Applicant> findById(String id);

    Mono<Void> deleteById(String id);
}
