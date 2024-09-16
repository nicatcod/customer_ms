package az.atl.customermss.service;

import az.atl.customermss.model.request.SaveCustomerDto;
import az.atl.customermss.model.response.CustomerResponseDto;

import java.math.BigDecimal;

public interface CustomerService {
    void saveCustomer(SaveCustomerDto dto);
    CustomerResponseDto getCustomerById(Long id);

    void reduceBalance(Long id, BigDecimal totalAmount);
}
