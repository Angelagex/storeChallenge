package com.sofkaTalentZone.storeChallenge.routes;
import com.sofkaTalentZone.storeChallenge.model.BillDTO;
import com.sofkaTalentZone.storeChallenge.usecases.SaveBillUseCase;
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
public class SaveBill {

    @Bean
    @RouterOperation(path = "/bill/save", beanClass = SaveBillUseCase.class, beanMethod = "post", operation = @Operation(operationId = "saveBillRoute", summary = "Save A Bill",
            responses = {@ApiResponse(responseCode = "200", description = "Successful operation", content = @Content(schema = @Schema(implementation = BillDTO.class))),
                    @ApiResponse(responseCode = "404", description = "Not found")}))
    public RouterFunction<ServerResponse> saveBillRoute(SaveBillUseCase saveUseCase){
        return route(POST("/bill/save").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(BillDTO.class)
                        .flatMap((BillDTO dto1) -> saveUseCase.saveBill(dto1))
                        .flatMap( dto -> ServerResponse.status(HttpStatus.CREATED)
                                .contentType(MediaType.APPLICATION_JSON).bodyValue(dto))
        );
    }
}
