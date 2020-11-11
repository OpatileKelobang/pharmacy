package digital.epharmacy.pharmacy.config;

import digital.epharmacy.pharmacy.entity.Product;
import org.hibernate.mapping.Collection;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.util.List;
@ControllerAdvice
public class JSONResponseAdvisor implements ResponseBodyAdvice<List<Product>> {
    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        return Collection.class.isAssignableFrom(methodParameter.getParameterType());
    }

    @Override
    public List<Product> beforeBodyWrite(List<Product> products, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        serverHttpResponse.getHeaders().add("X-Total-Count", String.valueOf(products.size()));
        return products;
    }
}
