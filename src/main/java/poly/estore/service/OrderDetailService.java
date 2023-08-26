package poly.estore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import poly.estore.dao.OrderDetailDAO;
import poly.estore.entity.OrderDetail;

@Service
public class OrderDetailService {
	@Autowired
	OrderDetailDAO dao;

	public void create(OrderDetail detail) {
		dao.save(detail);
	}
}
