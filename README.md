# How to use

## Spring Authorization Server

1. Clone the [Spring Authorization Server repo](https://github.com/spring-projects/spring-authorization-server).
2. Start the authorization service only (follow their docs).
3. Run the following:
   ```shell
    CLIENT_ID=messaging-client CLIENT_SECRET=secret ISSUER_URI=http://auth-server:9000 ./gradlew bootRun
    ```
4. Open http://127.0.0.1:8080 in a browser.
5. Log in with `user1` and `password`, and you should see a page saying `Hello Auth!`.

## GitLab

1. Configure a GitLab application and configure it with the following:
    ```text
    Callback URL: http://127.0.0.1:8080/login/oauth2/code/messaging-client-oidc
    Confidential: Yes
    Scopes: openid (Authenticate using OpenID Connect)
    ```
2. Run the following, replacing the placeholders accordingly:
   ```shell
    CLIENT_ID=<client_id> CLIENT_SECRET=<client_secret> ISSUER_URI=<gitlab_root_url> ./gradlew bootRun
    ```
3. Open http://127.0.0.1:8080 in a browser.
4. Log in with your GitLab credentials, and you should see a page saying `Hello Auth!` (you might need to authorize scopes first).

## KeyCloak

1. Start KeyCloak in Docker :
   ```shell
   docker run -p 9090:8080 --rm -it -e KEYCLOAK_USER=admin -e KEYCLOAK_PASSWORD=admin jboss/keycloak
   ```
2. Open http://localhost:9090/auth/admin in a browser.
3. Log in with `admin` and `admin`.
4. Create a client named `messaging-client`.
5. Set `Access Type` to `confidential`.
6. Add `http://127.0.0.1:8080/login/oauth2/code/messaging-client-oidc` to `Valid Redirect URIs`.
7. Create a user named `user1`.
8. Set that user's password to `password` (and uncheck `Temporary`).
9. Run the following, replacing the placeholders accordingly:
   ```shell
   CLIENT_ID=messaging-client CLIENT_SECRET=<client_secret> ISSUER_URI=http://localhost:9090/auth/realms/master ./gradlew bootRun
   ```
10. Open http://127.0.0.1:8080 in a browser.
11. Log in with `user1` and `password`, and you should see a page saying `Hello Auth!`.
