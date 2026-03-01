package com.practice_grpc.practice_grpc.Service;

import org.springframework.grpc.server.service.GrpcService;
import org.springframework.stereotype.Service;

import com.practice_grpc.BankAc;
import com.practice_grpc.BankAcNo;
import com.practice_grpc.BankAcServiceGrpc.BankAcServiceImplBase;

import io.grpc.stub.StreamObserver;

@Service
@GrpcService
public class BankService extends BankAcServiceImplBase {

    @Override
    public void getAcInfo(BankAcNo request, StreamObserver<BankAc> responseObserver) {
        var bankAcNo=request.getAccNo();
        var bankAc=BankAc.newBuilder().setAcName("Hello").setAccNo(bankAcNo).build();
        responseObserver.onNext(bankAc);
        responseObserver.onCompleted();
    }
    
}
