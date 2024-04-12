package com.tedarik_cepte.services;

import com.tedarik_cepte.models.CartProduct;
import com.tedarik_cepte.models.Order;
import com.tedarik_cepte.models.OrderItem;
import com.tedarik_cepte.models.User;
import com.tedarik_cepte.repository.CartProductRepository;
import com.tedarik_cepte.repository.CartRepository;
import com.tedarik_cepte.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CartProductRepository cartProductRepository;

    @Autowired
    private CartRepository cartRepository;

    public Order addOrder(User user, Double totalPrice, String status) {

        Long user_id = user.getUser_id();
        Long cart_id = cartRepository.getCartIdByUserId(user_id);
        System.out.println("********************CART_İD: " + cart_id);
        List<CartProduct> cartProducts = cartProductRepository.findByCartId(cart_id);

        Order order = new Order();
        order.setUser(user);

        List<OrderItem> orderItems = new ArrayList<>();
        for (CartProduct cartProduct: cartProducts) {
            OrderItem orderItem = new OrderItem();
            orderItem.setOrder(order);
            orderItem.setProduct(cartProduct.getProduct());
            orderItem.setQuantity(cartProduct.getQuantity());
            orderItems.add(orderItem);
        }
        order.setOrderItems(orderItems);
        order.setTotal_price(totalPrice);
        order.setOrder_date(new Date());
        order.setStatus(status);

        orderRepository.save(order);
        cartProductRepository.deleteAll(cartProducts);

        return order;
    }
}
