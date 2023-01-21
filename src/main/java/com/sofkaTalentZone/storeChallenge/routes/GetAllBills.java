package com.sofkaTalentZone.storeChallenge.routes;

import com.sofkaTalentZone.storeChallenge.model.BillDTO;
import com.sofkaTalentZone.storeChallenge.usecases.GetAllBillsUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springdoc.core.annotations.RouterOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import org.springframework.http.HttpStatus;


@Configuration
public class GetAllBills {

    @Bean
    @RouterOperation(path = "/bill/all", beanClass = GetAllBillsUseCase.class, beanMethod = "get", operation = @Operation(operationId = "getAllBillsRoute", summary = "Get All Bills",
            responses = {@ApiResponse(responseCode = "200", description = "Successful operation", content = @Content(schema = @Schema(implementation = BillDTO.class))),
                    @ApiResponse(responseCode = "404", description = "Not found")}))
    public RouterFunction<ServerResponse> getAllBillsRoute(GetAllBillsUseCase getAllUseCase){
        return route(GET("/bill/all"),
                request -> ServerResponse.status(HttpStatus.OK)
                        .body(BodyInserters.fromProducer(getAllUseCase.getAllBill(), BillDTO.class))
        );
    }
}
