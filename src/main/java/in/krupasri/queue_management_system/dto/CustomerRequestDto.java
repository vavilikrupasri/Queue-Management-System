package in.krupasri.queue_management_system.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class CustomerRequestDto {

    @NotBlank(message = "Name is required")
    private String name;

    @Pattern(
            regexp = "\\d{10}",
            message = "Phone number must be exactly 10 digits"
    )
    private String phoneNumber;

    public CustomerRequestDto() {
    }

    public CustomerRequestDto(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
