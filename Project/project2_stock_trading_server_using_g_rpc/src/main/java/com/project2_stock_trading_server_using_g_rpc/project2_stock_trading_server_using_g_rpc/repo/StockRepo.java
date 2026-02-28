package com.project2_stock_trading_server_using_g_rpc.project2_stock_trading_server_using_g_rpc.repo;



import org.springframework.data.jpa.repository.JpaRepository;

import com.project2_stock_trading_server_using_g_rpc.project2_stock_trading_server_using_g_rpc.model.Stock;

public interface StockRepo extends JpaRepository<Stock,Integer> {
    Stock findByStockSymbol(String stockSymbol);
}
