package com.project2_stock_trading_server_using_g_rpc.project2_stock_trading_server_using_g_rpc.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project2_stock_trading_server_using_g_rpc.project2_stock_trading_server_using_g_rpc.model.Stock;
import com.project2_stock_trading_server_using_g_rpc.project2_stock_trading_server_using_g_rpc.repo.StockRepo;
import com.stock_trading.StockRequest;
import com.stock_trading.StockResponse;
import com.stock_trading.StockTradingServiceGrpc.StockTradingServiceImplBase;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@Service
@GrpcService
public class StockTradingServiceImpl extends StockTradingServiceImplBase {
    @Autowired
    private StockRepo stockRepo;
    @Override
    public void getStockPrice(StockRequest request,StreamObserver<StockResponse> response){
        // super.getStockPrice(request, response);
        String stockSymbol=request.getStockSymbol();
        Stock stock=stockRepo.findByStockSymbol(stockSymbol);
        StockResponse stockResponse=StockResponse.newBuilder()
        .setStockSymbol(stock.getStockSymbol())
        .setPrice(stock.getPrice())
        .setLastUpdated(stock.getLastUpdated().toString())
        .build();

        response.onNext(stockResponse);
        response.onCompleted();
    }
}
