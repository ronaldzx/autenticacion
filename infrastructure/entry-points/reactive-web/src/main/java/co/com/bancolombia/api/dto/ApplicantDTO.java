package co.com.bancolombia.api.dto;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class ApplicantDTO {
    private String id;
    @NotBlank(message = "name can't be null or empty")
    private String name;
    @NotBlank(message = "lastName name can't be null or empty")
    private String lastName;
    private LocalDate birthDate;
    private String address;
    private String phone;
    @NotBlank(message = "emailAddress name can't be null or empty")
    @Email(message = "emailAddress must be a valid email", regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")
    private String emailAddress;
    @NotNull(message = "baseSalary can't be null")
    @DecimalMin(value = "0.0", inclusive = false, message = "baseSalary must be greater than 0")
    @DecimalMax(value = "15000000.0", message = "baseSalary must be less than or equal to 15000000")
    private BigDecimal baseSalary;
}