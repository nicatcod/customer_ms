package az.atl.customermss.controller;

import az.atl.customermss.model.request.SaveCustomerDto;
import az.atl.customermss.model.response.CustomerResponseDto;
import az.atl.customermss.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("api/v1/customers")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponseDto> getCustomerById(@PathVariable Long id) {
        return ResponseEntity.status(OK).body(customerService.getCustomerById(id));
    }

    @PostMapping
    public ResponseEntity<Void> saveCustomer(@RequestBody SaveCustomerDto dto) {
        customerService.saveCustomer(dto);
        return ResponseEntity.status(CREATED).build();
    }

    @PostMapping("reduce/{id}")
    public ResponseEntity<Void> getCustomerById(@PathVariable Long id, @RequestParam BigDecimal totalAmount) {
        customerService.reduceBalance(id, totalAmount);
        return ResponseEntity.status(NO_CONTENT).build();
    }
}
