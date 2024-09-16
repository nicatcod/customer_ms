package az.atl.customermss.dao.entity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

import static jakarta.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PRIVATE;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = PRIVATE)
@Table(name = "customers")
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    Long id;

    String fullName;
    Integer age;
    String pin;
    BigDecimal balance;
}
