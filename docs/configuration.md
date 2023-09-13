![Logo](images/sweden-connect.png)

# SAML Identity Provider for BankID

[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)

-----

There are three distinct parts in configuring the BankID SAML IdP:

- Spring Boot configuration where features such as TLS, management ports, session handling, Redis,
logging levels and so on are configured. Read more about this at https://docs.spring.io/spring-boot/docs/current/reference/html/application-properties.html.

- SAML IdP configuration. This is described in the [Spring Security SAML Identity Provider](https://github.com/swedenconnect/saml-identity-provider) repository.

- BankID configuration. This is the BankID-specific configuration used by the BankID SAML IdP. See below for all possible settings.

Also check the [application.yml](https://github.com/swedenconnect/bankid-saml-idp/blob/main/bankid-idp/bankid-idp-backend/src/main/resources/application.yml) file for an example of how to configure the service.

<a name="bankid-application-configuration"></a>
## BankID Application Configuration

This section describes all settings that are specific for the BankID IdP-application. These settings
comprise of configuration for the BankID integration and integration against the [IdP-base](https://github.com/swedenconnect/saml-identity-provider).

| Property | Description | Type | Default value |
| :--- | :--- | :--- | :--- |
| `bankid.service-url` | The URL to the BankID API. | `String` | `https://appapi2.bankid.com/rp/v5.1` |
| `bankid.`<br />`server-root-certificate` | The root certificate of the BankID server TLS credential. | A `Resource` pointing at an X.509 certificate. | `classpath:bankid-trust-prod.crt` |
| `bankid.authn.*` | IdP Authentication configuration. See [Authentication Configuration](#authentication-configuration) below. | - | - |
| `bankid.qr-code.*` | See [QR Code Generation Configuration](#qr-code-generation-configuration) below. | - | - |
| TODO: more | - | - | - |

<a name="saml-idp-configuration"></a>
## SAML IdP Configuration

> TODO

<a name="spring-boot-configuration"></a>
## Spring Boot Configuration

> TODO

# Configuring session / lock management

## Module Selection

### Redis (recommended)

We have configured a customizer that extends the spring redis configuration to simplify TLS configuration

Application.yml
```yaml
session:
  module: redis # Select module
spring:
  redis:
    host: host for redis instance
    port: port for redis instance
    password: password for redis instance
    ssl: true 
    tls: # Configuration Extension
      p12KeyStorePath: path for keystore
      p12KeyStorePassword: password for keystore
      p12TrustStorePath: path for truststore
      p12TrustStorePassword: password for truststore
      enableHostnameVerification: true # If you want to verify certificate hostname or not
```
### In memory (Not recommended for production)
```yaml
session:
  module: memory
```

### Implement your own module

You can implement your own module, if you want to be able to use something else than redis, e.g. psql, mysql

To implement your own module, please see how we have configured the redis module in RedisSessionConfiguration.
The main takeaways is that you need to have an implementation for the following
- LockRepository
- SessionReader (you can use fallback implementation for spring session, but a direct read/write implementation is recommended)
- SessionWriter (you can use fallback implementation for spring session, but a direct read/write implementation is recommended)
- Spring Session Configuration

-----

Copyright &copy; 2023, [Myndigheten för digital förvaltning - Swedish Agency for Digital Government (DIGG)](http://www.digg.se). Licensed under version 2.0 of the [Apache License](http://www.apache.org/licenses/LICENSE-2.0).