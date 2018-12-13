# POS Application

Point-Of-Sales Application development.

  - This application is a REST API for the POS application under development.
  - Application is written on Java Spring Boot.
  - Built with gradle.
  - Uses Oauth2 as the security implementation.

## OAuth2 

OAuth2 has several grant types with which a authentication is provided. For this application Resource owner password credentials grant has been used.

> With this type of authorization, the credentials (and thus the password) are sent to the client and then to the authorization server. It is therefore imperative that there is absolute trust between these two entities. It is mainly used when the client has been developed by the same authority as the authorization server.

This grant type is viable only because both the Client Application and the REST API is both designed by us.

## Initial Setup

### Role based Authentication

The DB structure is designed to handle role based authentication provided by OAuth2 and Spring Security.

`User > Role > Authorities.` 

> User has one role, and Role has many Authorities. [Authorities are considered as Role in context with Spring security. Can be a bit tricky]

### DB for Authentication 

  - Insert values into authorities, the value for the 'authority' column should should be capitalized, and should always start with 'ROLE_' [Spring security need as such].
  - The authorities should be handled by the developers.
  - Roles can have multiple Authorities. Role can have multiple authorities. Mapped table is 'roles_authorities'.
  - Insert values into roles and role_authorities accordingly.
  - Add a user, and give the relevant role.
  - Password is not encrypted yet. Can be done later on.
  
### OAuth Client

Client Application is considered as the client in the OAuth2 realm. We add client details which is required by the Authorization Server.

```sh
INSERT INTO `oauth_client_details` (`client_id`, `scope`, `authorized_grant_types`, `authorities`, `autoapprove`) VALUES ('mobile_api_client', 'read', 'password,refresh_token', 'ROLE_CLIENT', 'true');
```

> NOTE : Can have several clients with different grant types as well.

### OAuth2 Authentication Process.

Once the user is created with the relevant role. User can now be authorized by the Authorization Server. To get authenticated the client has to call the /ouath/token endpoint (which is specified by the oauth2 specification)

```sh
http://localhost:8080/oauth/token?grant_type=password&client_id=mobile_api_client&scope=read&auth_type=mobile&username=lahiru&password=lahiru
```

The above URL is to be called to get authentication. It is a POST method. Upon successful authentication, following result can be obtained.

```sh
{
    "access_token": "6ace35c4-23cf-44c8-86ac-665cab0d2901",
    "token_type": "bearer",
    "refresh_token": "cb5f440b-ab1c-42b4-a3e1-a8544fb8a13c",
    "expires_in": 43199,
    "scope": "read"
}
```

The access_token needs to be saved by the client application, because to access the REST API endpoints, needs access_token. 

In POSTMAN, REST API can be accessed via providing the http header as `Authorization` and it's value as `Bearer <access_token>`. Adding Java annotation @PreAuthorize ("hasRole('ROLE_ONE')"), specific roles (in our case authorities) can be given to controller level methods. So that only the users with the relevant roles can access the given controller method.
