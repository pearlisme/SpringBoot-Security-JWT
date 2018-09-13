package com.pearl.springbootjwt.Controller;

import com.pearl.springbootjwt.model.JwtUser;
import com.pearl.springbootjwt.security.JwtGenerator;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/token")
public class TokenController {

    private JwtGenerator jwtGenerator;

    public TokenController(JwtGenerator jwtGenerator) {
        this.jwtGenerator = jwtGenerator;
    }

    @PostMapping
    public String generate(@RequestBody final JwtUser jwtUser){

      return jwtGenerator.generate(jwtUser);

    }

    @GetMapping("/{userName}")
    public String generate(@PathVariable final String username){

        JwtGenerator jwtGenerator = new JwtGenerator();

//        jwtGenerator.generate(username);

        return null;

    }
}
