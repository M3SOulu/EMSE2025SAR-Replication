package edu.baylor.ecs.qms.security;

import edu.baylor.ecs.qms.model.Person;
import edu.baylor.ecs.qms.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class SecurityAuditorAware implements AuditorAware<Long> {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public Optional<Long> getCurrentAuditor() {

//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//
//        if (authentication == null || !authentication.isAuthenticated()) {
//            return Optional.empty();
//        }
//
//        return Optional.of(((MyCustomUser) authentication.getPrincipal()).getId());
        Person user = personRepository.findById((long) 0).orElse(null);
        if(user == null) {
            return Optional.empty();
        } else {
            return Optional.of(user.getId());
        }
    }
}
