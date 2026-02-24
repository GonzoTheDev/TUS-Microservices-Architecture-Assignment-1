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

        // Customer 1
        Customer c1 = new Customer();
        c1.setName("John Murphy");
        c1.setEmail("john.murphy@example.com");
        c1.setMobileNumber("+353 86 111 1111");
        c1 = customerRepository.save(c1);

        Accounts a1 = new Accounts();
        a1.setCustomer(c1);
        a1.setAccountType("SAVINGS");
        a1.setBranchAddress("Dublin 1");
        a1.setOpenedDate(LocalDate.now().minusDays(45));
        a1.setStatus(AccountStatus.ACTIVE);
        accountsRepository.save(a1);

        Accounts a2 = new Accounts();
        a2.setCustomer(c1);
        a2.setAccountType("CURRENT");
        a2.setBranchAddress("Dublin 2");
        a2.setOpenedDate(LocalDate.now().minusDays(12));
        a2.setStatus(AccountStatus.ACTIVE);
        accountsRepository.save(a2);

        // Customer 2
        Customer c2 = new Customer();
        c2.setName("Mary O'Brien");
        c2.setEmail("mary.obrien@example.com");
        c2.setMobileNumber("+353 87 222 2222");
        c2 = customerRepository.save(c2);

        Accounts a3 = new Accounts();
        a3.setCustomer(c2);
        a3.setAccountType("SAVINGS");
        a3.setBranchAddress("Cork City");
        a3.setOpenedDate(LocalDate.now().minusDays(90));
        a3.setStatus(AccountStatus.ACTIVE);
        accountsRepository.save(a3);

        // Customer 3
        Customer c3 = new Customer();
        c3.setName("Patrick Kelly");
        c3.setEmail("patrick.kelly@example.com");
        c3.setMobileNumber("+353 85 333 3333");
        c3 = customerRepository.save(c3);

        Accounts a4 = new Accounts();
        a4.setCustomer(c3);
        a4.setAccountType("CURRENT");
        a4.setBranchAddress("Galway");
        a4.setOpenedDate(LocalDate.now().minusDays(20));
        a4.setStatus(AccountStatus.FROZEN);
        accountsRepository.save(a4);

        // Customer 4
        Customer c4 = new Customer();
        c4.setName("Sarah Byrne");
        c4.setEmail("sarah.byrne@example.com");
        c4.setMobileNumber("+353 83 444 4444");
        c4 = customerRepository.save(c4);

        Accounts a5 = new Accounts();
        a5.setCustomer(c4);
        a5.setAccountType("SAVINGS");
        a5.setBranchAddress("Limerick");
        a5.setOpenedDate(LocalDate.now().minusDays(60));
        a5.setStatus(AccountStatus.ACTIVE);
        accountsRepository.save(a5);

        // Customer 5
        Customer c5 = new Customer();
        c5.setName("David Walsh");
        c5.setEmail("david.walsh@example.com");
        c5.setMobileNumber("+353 89 555 5555");
        c5 = customerRepository.save(c5);

        Accounts a6 = new Accounts();
        a6.setCustomer(c5);
        a6.setAccountType("CURRENT");
        a6.setBranchAddress("Waterford");
        a6.setOpenedDate(LocalDate.now().minusDays(8));
        a6.setStatus(AccountStatus.ACTIVE);
        accountsRepository.save(a6);

        // Customer 6
        Customer c6 = new Customer();
        c6.setName("Aoife Ryan");
        c6.setEmail("aoife.ryan@example.com");
        c6.setMobileNumber("+353 87 666 6666");
        c6 = customerRepository.save(c6);

        Accounts a7 = new Accounts();
        a7.setCustomer(c6);
        a7.setAccountType("SAVINGS");
        a7.setBranchAddress("Kilkenny");
        a7.setOpenedDate(LocalDate.now().minusDays(120));
        a7.setStatus(AccountStatus.FROZEN);
        accountsRepository.save(a7);

        // Customer 7
        Customer c7 = new Customer();
        c7.setName("Michael Nolan");
        c7.setEmail("michael.nolan@example.com");
        c7.setMobileNumber("+353 86 777 7777");
        c7 = customerRepository.save(c7);

        Accounts a8 = new Accounts();
        a8.setCustomer(c7);
        a8.setAccountType("CURRENT");
        a8.setBranchAddress("Dublin 4");
        a8.setOpenedDate(LocalDate.now().minusDays(15));
        a8.setStatus(AccountStatus.ACTIVE);
        accountsRepository.save(a8);

        // Customer 8
        Customer c8 = new Customer();
        c8.setName("Laura Healy");
        c8.setEmail("laura.healy@example.com");
        c8.setMobileNumber("+353 85 888 8888");
        c8 = customerRepository.save(c8);

        Accounts a9 = new Accounts();
        a9.setCustomer(c8);
        a9.setAccountType("SAVINGS");
        a9.setBranchAddress("Sligo");
        a9.setOpenedDate(LocalDate.now().minusDays(200));
        a9.setStatus(AccountStatus.ACTIVE);
        accountsRepository.save(a9);

        // Customer 9
        Customer c9 = new Customer();
        c9.setName("Brian Fitzgerald");
        c9.setEmail("brian.fitzgerald@example.com");
        c9.setMobileNumber("+353 83 999 9999");
        c9 = customerRepository.save(c9);

        Accounts a10 = new Accounts();
        a10.setCustomer(c9);
        a10.setAccountType("CURRENT");
        a10.setBranchAddress("Wexford");
        a10.setOpenedDate(LocalDate.now().minusDays(5));
        a10.setStatus(AccountStatus.ACTIVE);
        accountsRepository.save(a10);

        // Customer 10
        Customer c10 = new Customer();
        c10.setName("Niamh Collins");
        c10.setEmail("niamh.collins@example.com");
        c10.setMobileNumber("+353 89 101 0101");
        c10 = customerRepository.save(c10);

        Accounts a11 = new Accounts();
        a11.setCustomer(c10);
        a11.setAccountType("SAVINGS");
        a11.setBranchAddress("Dundalk");
        a11.setOpenedDate(LocalDate.now().minusDays(35));
        a11.setStatus(AccountStatus.ACTIVE);
        accountsRepository.save(a11);
    }
}
