package co.com.bancolombia.r2dbc;

import co.com.bancolombia.model.applicant.Applicant;
import co.com.bancolombia.r2dbc.entity.ApplicantEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.data.domain.Example;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ApplicantReactiveRepositoryAdapterTest {
    // TODO: change four you own tests

    @InjectMocks
    ApplicantReactiveRepositoryAdapter repositoryAdapter;

    @Mock
    ApplicantReactiveRepository repository;

    @Mock
    ObjectMapper mapper;

    private final ApplicantEntity applicantEntity = ApplicantEntity.builder()
            .id("1")
            .name("Ronald Danilo")
            .lastName("Barba Carrión")
            .birthDate(LocalDate.of(1996, 2, 14))
            .address("Urb San Pedro Trujillo")
            .phone("922184349")
            .emailAddress("ronalddanilo90@hotmail.com")
            .baseSalary(new BigDecimal("150000.00"))
            .build();
    private final Applicant applicant = Applicant.builder()
            .id("1")
            .name("Ronald Danilo")
            .lastName("Barba Carrión")
            .birthDate(LocalDate.of(1996, 2, 14))
            .address("Urb San Pedro Trujillo")
            .phone("922184349")
            .emailAddress("ronalddanilo90@hotmail.com")
            .baseSalary(new BigDecimal("4000.00"))
            .build();

    @Test
    void mustFindValueById() {

        when(mapper.map(applicantEntity, ApplicantEntity.class)).thenReturn(applicantEntity);
        when(repository.findById("1")).thenReturn(Mono.just(applicantEntity));

        Mono<Applicant> result = repositoryAdapter.findById("1");

        StepVerifier.create(result)
                .expectNextMatches(value -> value.getId().equals("1") && value.getName().equals("Ronald Danilo"))
                .verifyComplete();
    }

    @Test
    void mustFindAllValues() {
        when(repository.findAll()).thenReturn(Flux.just(applicantEntity));
        when(mapper.map(applicantEntity, ApplicantEntity.class)).thenReturn(applicantEntity);

        Flux<Applicant> result = repositoryAdapter.findAll();

        StepVerifier.create(result)
                .expectNext(applicant)
                .verifyComplete();
    }

    @Test
    void mustSaveValue() {
        when(repository.save(applicantEntity)).thenReturn(Mono.just(applicantEntity));
        when(mapper.map(applicantEntity, ApplicantEntity.class)).thenReturn(applicantEntity);

        Mono<Applicant> result = repositoryAdapter.save(applicant);

        StepVerifier.create(result)
                .expectNext(applicant)
                .verifyComplete();
    }
}