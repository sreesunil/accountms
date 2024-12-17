package com.tekarch.accountms.Services;

import com.tekarch.accountms.Models.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "user-service", url = "http://localhost:8080/api/users")
public interface UserClient {

    @GetMapping("/{userId}")
    User getUserById(@PathVariable("userId") Long userId);
}
