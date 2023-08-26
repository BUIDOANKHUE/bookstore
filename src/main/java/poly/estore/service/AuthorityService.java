package poly.estore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import poly.estore.dao.AuthorityDAO;

@Service
public class AuthorityService {
	@Autowired
	AuthorityDAO dao;
}
