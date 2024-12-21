package org.ism.repositories;

import org.ism.core.IRepository;
import org.ism.entities.Admin;

public interface IAdminRepository extends IRepository<Admin> {
    Admin findByLogin(String login);
}
