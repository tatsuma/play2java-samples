package services.impl;

import javax.inject.Inject;

import models.domains.User;
import models.mappers.UserMapper;
import services.UserService;

public class UserServiceImpl implements UserService {

    @Inject
    private UserMapper userMapper;

    public User getUser(long userId) {
        return userMapper.getUser(userId);
    }

}
