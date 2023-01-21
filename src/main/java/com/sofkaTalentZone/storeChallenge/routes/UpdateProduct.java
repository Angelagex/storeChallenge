package com.sofkaTalentZone.storeChallenge.routes;

import com.sofkaTalentZone.storeChallenge.model.ProductDTO;
import com.sofkaTalentZone.storeChallenge.usecases.UpdateProductUseCase;
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
public class UpdateProduct {

    @Bean
    @RouterOperation(path = "/product/update", beanClass = UpdateProductUseCase.class, beanMethod = "post", operation = @Operation(operationId = "updateProductRoute", summary = "Update A Product",
            responses = {@ApiResponse(responseCode = "200", description = "Successful operation", content = @Content(schema = @Schema(implementation = ProductDTO.class))),
                    @ApiResponse(responseCode = "404", description = "Not found")}))
    public RouterFunction<ServerResponse> updateProductRouter(UpdateProductUseCase updateProductUseCase){

        return route(PUT("product/update").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(ProductDTO.class)
                        .flatMap(productDTO -> updateProductUseCase.saveProduct(productDTO))
                        .flatMap(result ->
                                ServerResponse.status( result.getName()!=null ? HttpStatus.CREATED : HttpStatus.NOT_FOUND)
                                        .contentType(MediaType.APPLICATION_JSON)
                                        .bodyValue(result)));
    }
}
