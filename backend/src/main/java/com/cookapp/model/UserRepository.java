package com.cookapp.model;

import com.cookapp.types.User;
import java.util.List;

public interface UserRepository {
    List<User> getUsers();
}
