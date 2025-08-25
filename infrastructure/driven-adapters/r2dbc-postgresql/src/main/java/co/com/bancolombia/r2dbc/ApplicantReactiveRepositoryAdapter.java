package co.com.bancolombia.r2dbc;

import co.com.bancolombia.model.applicant.Applicant;
import co.com.bancolombia.model.applicant.gateways.ApplicantRepository;
import co.com.bancolombia.r2dbc.entity.ApplicantEntity;
import co.com.bancolombia.r2dbc.helper.ReactiveAdapterOperations;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.support.CallbackPreferringPlatformTransactionManager;
import reactor.core.publisher.Mono;

@Repository
public class ApplicantReactiveRepositoryAdapter extends ReactiveAdapterOperations<
        Applicant,
        ApplicantEntity,
        String,
        ApplicantReactiveRepository
> implements ApplicantRepository {
    public ApplicantReactiveRepositoryAdapter(ApplicantReactiveRepository repository, ObjectMapper mapper) {
        /**
         *  Could be use mapper.mapBuilder if your domain model implement builder pattern
         *  super(repository, mapper, d -> mapper.mapBuilder(d,ObjectModel.ObjectModelBuilder.class).build());
         *  Or using mapper.map with the class of the object model
         */
        super(repository, mapper, d -> mapper.map(d, Applicant.class/* change for domain model */));
    }

    @Override
    public Mono<Applicant> findByEmailAddress(String email) {
        return repository.findByEmailAddress(email).map(entity -> mapper.map(entity, Applicant.class));
    }

    @Override
    public Mono<Void> deleteById(String id) {
        return super.repository.deleteById(id);
    }
}
