package jpa.laboratory.jpalab.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jpa.laboratory.jpalab.domain.Order;
import jpa.laboratory.jpalab.service.OrderService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/order")
public class OrderController {
    private final OrderService orderService;
    @Operation(summary = "주문 생성 요청", description = "주문 정보가 생성됩니다.", tags = { "OrderController" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "주문 정보 생성 성공",
                    content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "404", description = "존재하지 않는 리소스 접근",
                    content = @Content(mediaType = "application/json")),

    })
    @PostMapping("/create")
    public ResponseEntity<Long> createOrder(String productName){
        return new ResponseEntity<>(orderService.createOrder(productName), HttpStatus.OK);
    }

    @Operation(summary = "주문 조회 요청", description = "전체 주문 정보를 조회합니다.", tags = { "OrderController" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "주문 정보 조회 성공",
                    content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "404", description = "존재하지 않는 리소스 접근",
                    content = @Content(mediaType = "application/json")),

    })
    @GetMapping
    public ResponseEntity<List<Order>> findAll(){
        return new ResponseEntity<>(orderService.findAll(), HttpStatus.OK);
    }
}
