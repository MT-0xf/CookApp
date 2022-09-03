package com.coockapp.resolvers;

import com.coockapp.infra.UserRepositoryImpl;
import com.coockapp.types.User;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class UserQueryResolver implements GraphQLQueryResolver {
    private final UserRepositoryImpl userRepositoryImpl;

    public UserQueryResolver(UserRepositoryImpl userRepositoryImpl) {
        this.userRepositoryImpl = userRepositoryImpl;
    }

    public List<User> getUsers() {
        return this.userRepositoryImpl.getUsers();
    }
}
