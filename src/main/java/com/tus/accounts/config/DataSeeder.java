package com.tus.accounts.config;

import com.tus.accounts.entity.AccountStatus;
import com.tus.accounts.entity.Accounts;
import com.tus.accounts.entity.Customer;
import com.tus.accounts.repository.AccountsRepository;
import com.tus.accounts.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@RequiredArgsConstructor
public class DataSeeder implements CommandLineRunner {

    private final CustomerRepository customerRepository;
    private final AccountsRepository accountsRepository;

    @Override
    public void run(String... args) {
        if (customerRepository.count() > 0) return;

        Customer c1 = new Customer();
        c1.setName("Shane Buckley");
        c1.setEmail("shane@example.com");
        c1.setMobileNumber("+353 86 000 0000");
        c1 = customerRepository.save(c1);

        Accounts a1 = new Accounts();
        a1.setCustomer(c1);
        a1.setAccountType("SAVINGS");
        a1.setBranchAddress("Dublin 1");
        a1.setOpenedDate(LocalDate.now().minusDays(10));
        a1.setStatus(AccountStatus.ACTIVE);
        accountsRepository.save(a1);

        Accounts a2 = new Accounts();
        a2.setCustomer(c1);
        a2.setAccountType("CURRENT");
        a2.setBranchAddress("Dublin 2");
        a2.setOpenedDate(LocalDate.now().minusDays(3));
        a2.setStatus(AccountStatus.FROZEN);
        accountsRepository.save(a2);

        Customer c2 = new Customer();
        c2.setName("Grace Buckley");
        c2.setEmail("grace@example.com");
        c2.setMobileNumber("+353 87 000 0000");
        c2 = customerRepository.save(c2);

        Accounts a3 = new Accounts();
        a3.setCustomer(c2);
        a3.setAccountType("SAVINGS");
        a3.setBranchAddress("Dublin 3");
        a3.setOpenedDate(LocalDate.now().minusDays(30));
        a3.setStatus(AccountStatus.ACTIVE);
        accountsRepository.save(a3);
    }
}
