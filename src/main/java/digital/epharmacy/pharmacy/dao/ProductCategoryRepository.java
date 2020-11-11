package digital.epharmacy.pharmacy.dao;

import digital.epharmacy.pharmacy.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = {"http://localhost:4200", "http://localhost", "https://epharmacy-online.herokuapp.com", "https://vibekonnect.tech/admin-dashboard/", "https://vibekonnect.tech/admin-dashboard/"})
@RepositoryRestResource(collectionResourceRel = "productCategory", path = "product-category")
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {
}