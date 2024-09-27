package az.atl.customermss.service.servicelmpl;

import az.atl.customermss.dao.entity.CustomerEntity;
import az.atl.customermss.dao.repository.CustomerRepository;
import az.atl.customermss.model.request.SaveCustomerDto;
import az.atl.customermss.model.response.CustomerResponseDto;
import az.atl.customermss.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static az.atl.customermss.mapper.CustomerMapper.CUSTOMER_MAPPER;

@Service
@RequiredArgsConstructor

public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    @Override
    public void saveCustomer(SaveCustomerDto dto) {
        var entity = CUSTOMER_MAPPER.buildCustomerEntity(dto);
        customerRepository.save(entity);

    }


    @Override
    public CustomerResponseDto getCustomerById(Long id) {
        var entity = fetchCustomerIfExist(id);
        return CUSTOMER_MAPPER.buildCustomerResponse(entity);

    }

    @Override
    public void reduceBalance(Long id, BigDecimal totalAmount) {
        var entity = fetchCustomerIfExist(id);
        var updatedBalance = entity.getBalance().subtract(totalAmount);
        entity.setBalance(updatedBalance);
        customerRepository.save(entity);
    }

    private CustomerEntity fetchCustomerIfExist(Long id) {
        return customerRepository.findById(id).orElseThrow(
                () -> new RuntimeException("CUSTOMER_NOT_FOND"));

    }
    @Scheduled(cron = "0 0 9 * * ?")
    public void sendBirthdayWishes() {
        List<CustomerEntity> customers = getAllCustomers();
        LocalDate today = LocalDate.now();

        for (CustomerEntity customer : customers) {
            if (customer.getBirthDate() != null &&
                    customer.getBirthDate().getDayOfMonth() == today.getDayOfMonth() &&
                    customer.getBirthDate().getMonth() == today.getMonth()) {
                System.out.println("Təbrik edirik, " + customer.getFullName() + "! Ad gününüz mübarək!");
            }
        }
    }

    public List<CustomerEntity> getAllCustomers() {
        return customerRepository.findAll();
    }
}
