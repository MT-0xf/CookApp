package com.coockapp.infra;

import com.coockapp.model.UserRepository;
import com.coockapp.types.User;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.List;

@Component
@AllArgsConstructor
@Slf4j
public class UserRepositoryImpl implements UserRepository {
    @Autowired
    EntityManager entityManager;

    @Override
    public List<User> getUsers() {
        List<User> results = entityManager
                .createQuery("from User", User.class)
                .getResultList();

        return results;
    }
}
