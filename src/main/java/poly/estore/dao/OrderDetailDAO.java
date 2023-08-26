package poly.estore.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import poly.estore.entity.OrderDetail;

public interface OrderDetailDAO extends JpaRepository<OrderDetail, Long> {

}
