package digital.epharmacy.pharmacy.config;

import digital.epharmacy.pharmacy.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.util.Collection;

@ControllerAdvice
public class CustomJSONHeaderResponse implements ResponseBodyAdvice<Product> {

    @Autowired
    private Product product;

    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        return false;
    }

    @Override
    public Product beforeBodyWrite(Product product, MethodParameter returnType, MediaType selectedContentType,
                                   Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest request,
                                   ServerHttpResponse response) {

        response.getHeaders().add("X-Total-Count", String.valueOf(product.getUnitsInStock()));
        return product;
    }
}
