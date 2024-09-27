package az.atl.customermss.dao.repository;

import az.atl.customermss.dao.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<CustomerEntity,Long> {


}
