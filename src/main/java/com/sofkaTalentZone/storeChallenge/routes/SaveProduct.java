package com.sofkaTalentZone.storeChallenge.routes;

import com.sofkaTalentZone.storeChallenge.model.ProductDTO;
import com.sofkaTalentZone.storeChallenge.usecases.SaveProductUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springdoc.core.annotations.RouterOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;


@Configuration
public class SaveProduct {

    @Bean
    @RouterOperation(path = "/product/save", beanClass = SaveProductUseCase.class, beanMethod = "post", operation = @Operation(operationId = "saveProductRoute", summary = "Save A Product",
            responses = {@ApiResponse(responseCode = "200", description = "Successful operation", content = @Content(schema = @Schema(implementation = ProductDTO.class))),
                    @ApiResponse(responseCode = "404", description = "Not found")}))
    public RouterFunction<ServerResponse> saveProductRoute(SaveProductUseCase saveUseCase){
        return route(POST("/product/save").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(ProductDTO.class)
                        .flatMap(saveUseCase::saveProduct)
                        .flatMap( dto -> ServerResponse.status(HttpStatus.CREATED)
                                .contentType(MediaType.APPLICATION_JSON).bodyValue(dto))
        );
    }
}
