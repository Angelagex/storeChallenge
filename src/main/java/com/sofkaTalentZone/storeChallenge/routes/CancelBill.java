package com.sofkaTalentZone.storeChallenge.routes;

import com.sofkaTalentZone.storeChallenge.usecases.DeleteBillUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springdoc.core.annotations.RouterOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class CancelBill {

    @Bean
    @RouterOperation(path = "/bill/delete/{id}", beanClass = DeleteBillUseCase.class, beanMethod = "delete", operation = @Operation(operationId = "deleteBillRoute", summary = "Delete Bill By Id",
            parameters = {@Parameter(in = ParameterIn.PATH, name = "id", description = "Bill Id")},
            responses = {@ApiResponse(responseCode = "204", description = "No content"),
                    @ApiResponse(responseCode = "404", description = "Not found")}))
    public RouterFunction<ServerResponse> deleteBillRoute(DeleteBillUseCase deleteUseCase){
        return route(DELETE("/bill/delete/{id}").and(accept(MediaType.APPLICATION_JSON)),
                request -> ServerResponse.status(HttpStatus.NO_CONTENT)
                        .body(BodyInserters.fromProducer(deleteUseCase.deleteById(request.pathVariable("id")), Void.class))
        );
    }
}
