package academy.digitallab.store.shopping.client;

import academy.digitallab.store.shopping.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "product-service")
@RequestMapping(value = "/products")
public interface ProductClient {
    @GetMapping("/{id}")
    ResponseEntity<Product> getProduct(@PathVariable("id") Long id);

    @PutMapping(value = "/{id}/stock")
    ResponseEntity<Product> updateStockProduct(@PathVariable  Long id, @RequestParam(name = "quantity", required = true) Double quantity);
}
