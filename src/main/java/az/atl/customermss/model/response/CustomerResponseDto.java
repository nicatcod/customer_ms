package az.atl.customermss.model.response;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldNameConstants;

import java.math.BigDecimal;

import static lombok.AccessLevel.PRIVATE;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldNameConstants(level = PRIVATE)
public class CustomerResponseDto {
    Long id;
    String fullName;
    Integer age;
    String pin;
    BigDecimal balance;
}
