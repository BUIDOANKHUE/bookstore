package poly.estore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import poly.estore.dao.RoleDAO;

@Service
public class RoleService {
	@Autowired
	RoleDAO dao;
}
