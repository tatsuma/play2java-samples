package services.impl;

import javax.inject.Inject;

import models.domains.Admin;
import models.mappers.AdminMapper;
import services.AdminService;

public class AdminServiceImpl implements AdminService {

    @Inject
    private AdminMapper adminMapper;

    public Admin getUser(long userId) {
        return adminMapper.getUser(userId);
    }

}
