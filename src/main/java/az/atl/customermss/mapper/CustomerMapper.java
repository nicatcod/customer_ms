package az.atl.customermss.mapper;

import az.atl.customermss.dao.entity.CustomerEntity;
import az.atl.customermss.model.request.SaveCustomerDto;
import az.atl.customermss.model.response.CustomerResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE )
public interface CustomerMapper {

    CustomerMapper CUSTOMER_MAPPER = Mappers.getMapper(CustomerMapper.class);

    CustomerResponseDto buildCustomerResponse(CustomerEntity entity);
@Mapping(target = "id",ignore = true)
    CustomerEntity buildCustomerEntity(SaveCustomerDto dto);
}
