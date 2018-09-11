package org.lanqiao.dao;


import org.lanqiao.entity.Admin;

import java.util.List;

public interface AdminDao {
    public List<Admin> checkAdmin(Admin admin);
}
