package co.com.bancolombia.r2dbc;

import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

// TODO: This file is just an example, you should delete or modify it
public interface ApplicantReactiveRepository extends ReactiveCrudRepository<Object, String>, ReactiveQueryByExampleExecutor<Object> {

}
