package com.cookapp.repository;

import com.cookapp.types.User;
import java.util.List;

public interface UserRepository {
    List<User> getUsers();
}
