package com.tus.accounts.mapper;

import com.tus.accounts.dto.CustomerDto;
import com.tus.accounts.dto.request.CreateCustomerRequest;
import com.tus.accounts.dto.request.UpdateCustomerRequest;
import com.tus.accounts.entity.Customer;

public final class CustomerMapper {

    private CustomerMapper() {}

    public static Customer toEntity(CreateCustomerRequest req) {
        Customer c = new Customer();
        c.setName(req.getName());
        c.setEmail(req.getEmail());
        c.setMobileNumber(req.getMobileNumber());
        return c;
    }

    public static void updateEntity(Customer c, UpdateCustomerRequest req) {
        c.setName(req.getName());
        c.setEmail(req.getEmail());
        c.setMobileNumber(req.getMobileNumber());
    }

    public static CustomerDto toDto(Customer c) {
        return new CustomerDto(
                c.getCustomerId(),
                c.getName(),
                c.getEmail(),
                c.getMobileNumber(),
                c.getCreatedAt(),
                c.getUpdatedAt(),
                c.getAccounts() == null ? 0 : c.getAccounts().size()
        );
    }
}
