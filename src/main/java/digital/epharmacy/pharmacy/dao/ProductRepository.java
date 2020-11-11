package digital.epharmacy.pharmacy.dao;

import digital.epharmacy.pharmacy.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;


@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:3000", "https://epharmacy-online.herokuapp.com", "http://amahlathini.github.io/admin-dashboard", "http://vibekonnect.tech/admin-dashboard"})
public interface ProductRepository extends JpaRepository<Product, Long> {
    Page<Product> findByCategoryId(@RequestHeader("X-Total-Count") @RequestParam("id") Long id, Pageable pageable);
}
