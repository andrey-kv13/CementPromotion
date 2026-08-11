package org.cementpromotion.adapter;

import org.cementpromotion.dto.Order;

import java.util.List;

public interface OrderFileAdapter {

    List<Order> read(String filePath);

}
