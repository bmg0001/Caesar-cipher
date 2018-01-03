# 카이사르 암호화

[![ES Network](http://i65.tinypic.com/ohib11.png)](http://krl.kr)

  - 카이사르 암호화 지원
  - 카이사르 복호화 지원

# 사용방법

```java
Crypto cry = new Crypto("암호화 또는 복호화 할 문자열");
cry.Setup("을 통해서도 문자열 설정 가능");

String ENC = cry.ENC(Key); //Key 는 정수형만 가능 0~2^31 , 암호화
String DEC = cry.DEC(Key); //Key 는 정수형만 가능 0~2^31 , 복호화
```

License
----

MIT
