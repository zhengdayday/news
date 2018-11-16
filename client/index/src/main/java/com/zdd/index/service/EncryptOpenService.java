package com.zdd.index.service;

import com.zdd.common.result.SingleResult;
import com.zdd.common.utils.RSAUtils;
import com.zdd.index.request.KeyRequest;
import com.zdd.index.response.KeyResponse;
import com.zdd.index.response.RSAResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class EncryptOpenService{

    @Value("${rsa.publicKey}")
    private String publicKey;
    @Value("${rsa.privateKey}")
    private String privateKey;
    @Value("${api.encrypt.key}")
    private String key;

    public SingleResult<RSAResponse> getRSA() {
        RSAResponse response = RSAResponse.options()
                .setServerPublicKey(publicKey)
                .build();
        return SingleResult.buildSuccess(response);
    }

    public SingleResult<KeyResponse> getKey(KeyRequest request)throws Exception {
        String clientPublicKey = RSAUtils.privateDecrypt(request.getClientEncryptPublicKey(), RSAUtils.getPrivateKey(privateKey));
        String encryptKey = RSAUtils.publicEncrypt(key,RSAUtils.getPublicKey(clientPublicKey));
        KeyResponse response = KeyResponse.options()
                .setKey(encryptKey)
                .build();
        return SingleResult.buildSuccess(response);
    }
}
