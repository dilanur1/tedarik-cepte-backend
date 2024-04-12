package com.tedarik_cepte.repository;

import com.tedarik_cepte.models.Cart;
import com.tedarik_cepte.models.CartProduct;
import com.tedarik_cepte.models.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartProductRepository extends CrudRepository<CartProduct, Long> {

    CartProduct findByCartAndProduct(Cart cart, Product product);

    @Query(value = "SELECT product_id FROM cart_product WHERE cart_id = :cart_id", nativeQuery = true)
    List<Long> getProductIdByCartId(@Param("cart_id") Long cart_id);

    @Query(value = "SELECT quantity FROM cart_product WHERE cart_id = :cart_id AND product_id = :product_id", nativeQuery = true)
    Double getQuantityByUserAndProductId(@Param("cart_id") Long cart_id,
                                         @Param("product_id") Long product_id);

    @Query(value = "UPDATE cart_product SET quantity = :quantity WHERE cart_id = :cart_id AND product_id = :product_id", nativeQuery = true)
    void updateQuantity(@Param("cart_id") Long cart_id,
                        @Param("product_id") Long product_id,
                        @Param("quantity") Double quantity);

    @Query(value = "SELECT * FROM cart_product WHERE cart_id = :cart_id", nativeQuery = true)
    List<CartProduct> findByCartId(Long cart_id);
}
