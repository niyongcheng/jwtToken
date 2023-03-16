package com.herbalife.is.jwtdemo.config;

import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.openssl.PEMDecryptorProvider;
import org.bouncycastle.openssl.PEMEncryptedKeyPair;
import org.bouncycastle.openssl.PEMKeyPair;
import org.bouncycastle.openssl.PEMParser;
import org.bouncycastle.openssl.jcajce.JcaPEMKeyConverter;
import org.bouncycastle.openssl.jcajce.JcePEMDecryptorProviderBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import java.io.FileReader;
import java.io.IOException;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.RSAPrivateCrtKeySpec;


@Configuration
public class RSAKey {

    private static final String pemKeyPath = "classpath:privateKey.pem";
    private static final String uatpemKeyPath = "classpath:privatekeyuat.pem";
    private static final String prodpemKeyPath = "classpath:privatekeyprod.pem";
    private static final String localpemKeyPath = "classpath:key-2048.pem";
    private static final String algorithm = "RSA";


    @Bean("qaPrivateKey")
    public PrivateKey getPrivateKey(ResourceLoader resourceLoader) throws IOException, NoSuchAlgorithmException, InvalidKeySpecException {
        Resource resource = resourceLoader.getResource(pemKeyPath);

        Security.addProvider(new BouncyCastleProvider());
        String password = "123456";

        PEMParser pemParser = new PEMParser(new FileReader(resource.getFile()));
        Object object = pemParser.readObject();
        JcaPEMKeyConverter converter = new JcaPEMKeyConverter().setProvider("BC");

        KeyPair keyPair;
        if (object instanceof PEMEncryptedKeyPair) {
            PEMEncryptedKeyPair ckp = (PEMEncryptedKeyPair) object;
            PEMDecryptorProvider decProv = new JcePEMDecryptorProviderBuilder().build(password.toCharArray());
            keyPair = converter.getKeyPair(ckp.decryptKeyPair(decProv));
        } else {
            PEMKeyPair ukp = (PEMKeyPair) object;
            keyPair = converter.getKeyPair(ukp);
        }

        // RSA
        KeyFactory keyFac = KeyFactory.getInstance("RSA");
        RSAPrivateCrtKeySpec privateKey = keyFac.getKeySpec(keyPair.getPrivate(), RSAPrivateCrtKeySpec.class);

        return keyFac.generatePrivate(privateKey);
    }

    @Bean("localPrivateKey")
    public PrivateKey getlocalPrivateKey(ResourceLoader resourceLoader) throws IOException, NoSuchAlgorithmException, InvalidKeySpecException {
        Resource resource = resourceLoader.getResource(localpemKeyPath);

        Security.addProvider(new BouncyCastleProvider());
        String password = "";

        PEMParser pemParser = new PEMParser(new FileReader(resource.getFile()));
        Object object = pemParser.readObject();
        JcaPEMKeyConverter converter = new JcaPEMKeyConverter().setProvider("BC");

        KeyPair keyPair;
        if (object instanceof PEMEncryptedKeyPair) {
            PEMEncryptedKeyPair ckp = (PEMEncryptedKeyPair) object;
            PEMDecryptorProvider decProv = new JcePEMDecryptorProviderBuilder().build(password.toCharArray());
            keyPair = converter.getKeyPair(ckp.decryptKeyPair(decProv));
        } else if(object instanceof PrivateKeyInfo){
            PrivateKeyInfo privateKeyInfo = (PrivateKeyInfo) object;

            //in this case return privateKey directly
            JcaPEMKeyConverter jcaPEMKeyConverter = new JcaPEMKeyConverter();
            return jcaPEMKeyConverter.getPrivateKey(privateKeyInfo);
        }
        else {
            PEMKeyPair ukp = (PEMKeyPair) object;
            keyPair = converter.getKeyPair(ukp);
        }

        // RSA
        KeyFactory keyFac = KeyFactory.getInstance("RSA");
        RSAPrivateCrtKeySpec privateKey = keyFac.getKeySpec(keyPair.getPrivate(), RSAPrivateCrtKeySpec.class);

        return keyFac.generatePrivate(privateKey);
    }

    @Bean("uatPrivateKey")
    public PrivateKey getUATPrivateKey(ResourceLoader resourceLoader) throws IOException, NoSuchAlgorithmException, InvalidKeySpecException {
        Resource resource = resourceLoader.getResource(uatpemKeyPath);

        Security.addProvider(new BouncyCastleProvider());
        String password = "";

        PEMParser pemParser = new PEMParser(new FileReader(resource.getFile()));
        Object object = pemParser.readObject();
        JcaPEMKeyConverter converter = new JcaPEMKeyConverter().setProvider("BC");

        KeyPair keyPair;
        if (object instanceof PEMEncryptedKeyPair) {
            PEMEncryptedKeyPair ckp = (PEMEncryptedKeyPair) object;
            PEMDecryptorProvider decProv = new JcePEMDecryptorProviderBuilder().build(password.toCharArray());
            keyPair = converter.getKeyPair(ckp.decryptKeyPair(decProv));
        } else {
            PEMKeyPair ukp = (PEMKeyPair) object;
            keyPair = converter.getKeyPair(ukp);
        }

        // RSA
        KeyFactory keyFac = KeyFactory.getInstance("RSA");
        RSAPrivateCrtKeySpec privateKey = keyFac.getKeySpec(keyPair.getPrivate(), RSAPrivateCrtKeySpec.class);

        return keyFac.generatePrivate(privateKey);
    }

    @Bean("prodPrivateKey")
    public PrivateKey getProdPrivateKey(ResourceLoader resourceLoader) throws IOException, NoSuchAlgorithmException, InvalidKeySpecException {
        Resource resource = resourceLoader.getResource(prodpemKeyPath);

        Security.addProvider(new BouncyCastleProvider());
        String password = "";

        PEMParser pemParser = new PEMParser(new FileReader(resource.getFile()));
        Object object = pemParser.readObject();
        JcaPEMKeyConverter converter = new JcaPEMKeyConverter().setProvider("BC");

        KeyPair keyPair;
        if (object instanceof PEMEncryptedKeyPair) {
            PEMEncryptedKeyPair ckp = (PEMEncryptedKeyPair) object;
            PEMDecryptorProvider decProv = new JcePEMDecryptorProviderBuilder().build(password.toCharArray());
            keyPair = converter.getKeyPair(ckp.decryptKeyPair(decProv));
        } else {
            PEMKeyPair ukp = (PEMKeyPair) object;
            keyPair = converter.getKeyPair(ukp);
        }

        // RSA
        KeyFactory keyFac = KeyFactory.getInstance("RSA");
        RSAPrivateCrtKeySpec privateKey = keyFac.getKeySpec(keyPair.getPrivate(), RSAPrivateCrtKeySpec.class);

        return keyFac.generatePrivate(privateKey);
    }

}
