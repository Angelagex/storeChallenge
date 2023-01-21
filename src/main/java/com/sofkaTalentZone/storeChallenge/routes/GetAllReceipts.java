package com.sofkaTalentZone.storeChallenge.routes;

import com.sofkaTalentZone.storeChallenge.model.ReceiptDTO;
import com.sofkaTalentZone.storeChallenge.usecases.GetAllReceiptsUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springdoc.core.annotations.RouterOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class GetAllReceipts {

    @Bean
    @RouterOperation(path = "/receipt/all", beanClass = GetAllReceiptsUseCase.class, beanMethod = "get", operation = @Operation(operationId = "getAllReceiptsRoute", summary = "Get All Receipts",
            responses = {@ApiResponse(responseCode = "200", description = "Successful operation", content = @Content(schema = @Schema(implementation = ReceiptDTO.class))),
                    @ApiResponse(responseCode = "404", description = "Not found")}))
    public RouterFunction<ServerResponse> getAllReceiptsRoute(GetAllReceiptsUseCase getAllUseCase){
        return route(GET("/receipt/all"),
                request -> ServerResponse.status(HttpStatus.OK)
                        .body(BodyInserters.fromProducer(getAllUseCase.getAllReceipt(), ReceiptDTO.class))
        );
    }
}
