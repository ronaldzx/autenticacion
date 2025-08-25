package co.com.bancolombia.api;

import co.com.bancolombia.api.dto.ApplicantDTO;
import co.com.bancolombia.api.exception.validator.ValidatorHandler;
import co.com.bancolombia.api.mapper.ApplicantMapper;
import co.com.bancolombia.usecase.applicant.ApplicantUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class Handler {
    private final ApplicantUseCase applicantUseCase;
    private final ApplicantMapper applicantMapper;
    private final ValidatorHandler validatorHandler;

    public Mono<ServerResponse> listenSaveApplicant(ServerRequest serverRequest) {
        return serverRequest.bodyToMono(ApplicantDTO.class)
                .doOnNext(validatorHandler::validate)
                .map(applicantMapper::toApplicant)
                .flatMap(applicantUseCase::saveApplicant)
                .flatMap(savedApplicant -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .bodyValue(savedApplicant));
    }

    public Mono<ServerResponse> listenGETOtherUseCase(ServerRequest serverRequest) {
        // useCase2.logic();
        return ServerResponse.ok().bodyValue("");
    }

    public Mono<ServerResponse> listenPOSTUseCase(ServerRequest serverRequest) {
        // useCase.logic();
        return ServerResponse.ok().bodyValue("");
    }
}