package com.java22_spring_g_rpc.java22_spring_g_rpc.BankService;

import org.springframework.grpc.server.service.GrpcService;
import org.springframework.stereotype.Service;

import com.java22_spring_g_rpc.AccountBalance;
import com.java22_spring_g_rpc.AccountNumber;
import com.java22_spring_g_rpc.BankServiceGrpc.BankServiceImplBase;

import io.grpc.stub.StreamObserver;

@Service
@GrpcService
public class BankService extends BankServiceImplBase {

    @Override
    public void getAccountBalance(AccountNumber request, StreamObserver<AccountBalance> responseObserver) {
        // super.getAccountBalance(request, responseObserver);
        var accountNumber=request.getAccountNumber();
        var accountBalance=AccountBalance.newBuilder().setAccountNumber(accountNumber).setBalance(accountNumber*10).build();    
        responseObserver.onNext(accountBalance);
        responseObserver.onCompleted();
    }

}
