package com.coockapp.model;

import com.coockapp.types.User;
import java.util.List;

public interface UserRepository {
    List<User> getUsers();
}
