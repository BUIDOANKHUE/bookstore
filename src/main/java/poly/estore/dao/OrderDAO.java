package poly.estore.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import poly.estore.entity.Order;

public interface OrderDAO extends JpaRepository<Order, Long> {

}
