package com.example.firstjunidemo.data;

import com.example.firstjunidemo.domain.Account;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account, Long> {

    Account findByName(String name);
}
