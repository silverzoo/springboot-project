```java
package com.elice.controller;

import org.springframework.security.crypto.keygen.BytesKeyGenerator;
import org.springframework.security.crypto.keygen.KeyGenerators;
import org.springframework.security.crypto.keygen.StringKeyGenerator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.Base64;

@RestController
public class KeyGenerationController {

    //지시사항을 참고하여 코드를 작성해 보세요
    @GetMapping("/generate/string")
    public String generateStringKey(@RequestParam(defaultValue = "8") int length) {
        StringKeyGenerator stringKey = KeyGenerators.string();
        String key = stringKey.generateKey();

        // 생성된 키를 필요한 길이만큼 잘라냄 
        return key.substring(0, Math.min(key.length(), length));
    }
    @GetMapping("/generate/bytes")
    public String generateBytesKey(@RequestParam(defaultValue = "16") int length) {
        BytesKeyGenerator bytesKey = KeyGenerators.shared(length);
        byte[] keyBytes = bytesKey.generateKey();
        
        // 생성된 바이트 배열을 Base64로 인코딩
        return Base64.getEncoder().encodeToString(keyBytes);
    }
}
```