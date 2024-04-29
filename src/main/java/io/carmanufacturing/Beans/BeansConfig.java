package io.carmanufacturing.Beans;

import io.carmanufacturing.gateways.UserGateway;
import io.carmanufacturing.usecases.CreateUserUseCase;
import io.carmanufacturing.usecases.GetAllUsersUseCase;
import io.carmanufacturing.usecasesImpl.CreateUserUseCaseImpl;
import io.carmanufacturing.usecasesImpl.GetAllUsersUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansConfig {

    @Bean
    public CreateUserUseCase createUserUseCase(UserGateway userGateway) {
        return new CreateUserUseCaseImpl(userGateway);
    }

    @Bean
    public GetAllUsersUseCase getAllUsersUseCase(UserGateway userGateway) {
        return new GetAllUsersUseCaseImpl(userGateway);
    }

}
