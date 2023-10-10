
package com.org.tr.auth;


public class JwtConfig {
    
    public static final String LLAVE_SECRETA = "alguna.clave.secreta.12345678";
    //statica quiere decir que es un atriuto de la clase no del objeto
    
    //con esta firmamos el token
    public static final String RSA_PRIVADA = "-----BEGIN RSA PRIVATE KEY-----\n" +
"MIIEogIBAAKCAQEAokJMzlFnO7mrZzBvbMsFNnWoDIWBHWtEySObk7F6YXxU4XeE\n" +
"bxObSTB7Cbo9ysylbe51YsTG0Vtzuv5tvj2pUmyEishsG4HvbQg0Kddziwh/Lv5K\n" +
"yOihYvaldziamWo0qMVCmMVGWFmx6eXtLJ5xz0pPBPCNaTfBvdplbYAg2un2rWba\n" +
"YI+tCCKGYJYGeZvJhZlLIbzYVSL3i1U6l1acNHpSoIMtg+ungqZ2HIAFz9p0DoB6\n" +
"QjirU0Nrz8TB2mNBs/989L1fDjKMZU6100AJCAuyz/RhVXrBcbyOMNyPyytIfoPa\n" +
"bqJxqF3v0tHehekb3okFQj56Bl02k7RlHB3DhQIDAQABAoIBAC3KZiCHiompYTzS\n" +
"x289cDApTg6Skph50ESvPtWUbYQbcVzbvM0YDGfAPcjF/XBBBqKafBgujilBFMz9\n" +
"xny8rA8tvs3nt9KffbEYcpgoTFw9Pp9FdldyhzEFiDa4C7El7sx+NsgkTDDcxz/J\n" +
"+n/wCxBD2T78n/vEl3F7s8oOMbd1gkhNCmTYXsAklp6jqzr/gy5Gd1q6WoyRTd3h\n" +
"Nj99QYK0lfR0N82opCJCfo1V7y18eVpZ6yh69zEsz0JNczfaQsxzxRMG+JkXf8X6\n" +
"gjES3iSf2reHvIdoXNepTQFkYEWzoMD4N6NzliIPVfRDAVFsNq+cSJ3hwpXI5sxo\n" +
"/A4XajUCgYEA138HXGcPgVgLFCqbq3BzGxvqQoREcu5+F9Z46cHNUugexoaD33jd\n" +
"TutDRnBTu98fdjhVokT7cawjzNcixHnwno27f2qdnZzPkgOEiVvRfoaDtw5N1vxB\n" +
"XwTH99w9LpuYgWxQkTOCrNaZ21mAzOayjnhEgw7aa/TfLj54i6bKzy8CgYEAwMGr\n" +
"riwtjk1QOkKR3gl+opE/cq4x6TOZK/UK/OAQD9CSL0eFFITwVyOtT3ucKcfRzgCk\n" +
"tjXSYvfOWd9csQzS/kzcpFHNUgRwL046ScLXA6eN1Wx9qlkoDSW1+PhLQVJKFtTz\n" +
"pd0Go2WZ8i4WmA8rlptIAeMTqBcCJHDdVSxby4sCgYA1hyk166evUkZWOQs395Ov\n" +
"/SwgX6h8//60PyMDtY8h8+SJHaquHOCkFM4+NfKmrRKsk+u5hfcLUl4GKL5LHZsG\n" +
"V2Bmkv4Zw3TP6S3HzNXp3tHi65usNjaquo5NZBiSdjXYmCYfGzNvaVMIaGAVBYz+\n" +
"1KL4Bv18aXPykbPxxHmGIwKBgChZom2wc8zhJFU90DkxtZ+kVirUikAt+/d2sVkk\n" +
"MliNKbzZ9OLJvWIQZtxHnPYmDSZZfiFifOsYwsqPdmDdtWFkh5+iPB/aK/3LG2qL\n" +
"beUm8wrlTh0V0suFxGUc3OwMpNPIukRTU2tq/mHzAenM6yv4z4cNmPTL9DfapIqK\n" +
"4aBnAoGAYJ0iwd8FHu3PezGaXKNW4RUOTsDP/ynqsV03QkxdF49IAbsV0I+64KEp\n" +
"U1e5pcD4/93JVFMvek1/xGnYPFCwZ2d1wj7r1qjeBfaF/DpLaUKiKGs+f/H9zqFW\n" +
"JYxwu4VH2S7uKly66zPz5gyTcTbBW+Kvkt9r5w7lvmzIxJB+Mbg=\n" +
"-----END RSA PRIVATE KEY-----";
    
    //con esta verificamos la firma del token
    public static final String RSA_PUBLICA = "-----BEGIN PUBLIC KEY-----\n" +
"MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAokJMzlFnO7mrZzBvbMsF\n" +
"NnWoDIWBHWtEySObk7F6YXxU4XeEbxObSTB7Cbo9ysylbe51YsTG0Vtzuv5tvj2p\n" +
"UmyEishsG4HvbQg0Kddziwh/Lv5KyOihYvaldziamWo0qMVCmMVGWFmx6eXtLJ5x\n" +
"z0pPBPCNaTfBvdplbYAg2un2rWbaYI+tCCKGYJYGeZvJhZlLIbzYVSL3i1U6l1ac\n" +
"NHpSoIMtg+ungqZ2HIAFz9p0DoB6QjirU0Nrz8TB2mNBs/989L1fDjKMZU6100AJ\n" +
"CAuyz/RhVXrBcbyOMNyPyytIfoPabqJxqF3v0tHehekb3okFQj56Bl02k7RlHB3D\n" +
"hQIDAQAB\n" +
"-----END PUBLIC KEY-----";
}
