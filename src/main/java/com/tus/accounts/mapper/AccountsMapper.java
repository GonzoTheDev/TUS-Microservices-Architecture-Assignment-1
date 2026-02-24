package com.tus.accounts.mapper;

import com.tus.accounts.dto.AccountDto;
import com.tus.accounts.dto.request.CreateAccountRequest;
import com.tus.accounts.dto.request.UpdateAccountRequest;
import com.tus.accounts.entity.Accounts;
import com.tus.accounts.entity.Customer;

public final class AccountsMapper {

    private AccountsMapper() {}

    public static Accounts toEntity(CreateAccountRequest req, Customer customer) {
        Accounts a = new Accounts();
        a.setCustomer(customer);
        a.setAccountType(req.getAccountType());
        a.setBranchAddress(req.getBranchAddress());
        a.setOpenedDate(req.getOpenedDate());
        a.setStatus(req.getStatus());
        return a;
    }

    public static void updateEntity(Accounts a, UpdateAccountRequest req) {
        a.setAccountType(req.getAccountType());
        a.setBranchAddress(req.getBranchAddress());
        a.setOpenedDate(req.getOpenedDate());
        a.setStatus(req.getStatus());
    }

    public static AccountDto toDto(Accounts a) {
        return new AccountDto(
                a.getAccountNumber(),
                a.getCustomer() == null ? null : a.getCustomer().getCustomerId(),
                a.getAccountType(),
                a.getBranchAddress(),
                a.getOpenedDate(),
                a.getStatus(),
                a.getCreatedAt(),
                a.getUpdatedAt()
        );
    }
}
