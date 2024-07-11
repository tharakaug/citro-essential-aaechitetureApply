package org.example.model;

import org.example.entity.Order;
import org.example.entity.OrderDetail;

import java.io.Serializable;
import java.util.List;

public class PlaceOrderDTO implements Serializable {
    private Order order;
    private List<OrderDetail> odList;
}
