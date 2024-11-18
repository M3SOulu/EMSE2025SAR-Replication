# Deployment Guide

## EMS backend

1. run `mvn clean install`
2. copy `.jar` to server
3. on the server run `java -jar build/ems.jar`
4. ems runs on port `9001`
5. CMS backend

## CMS backend

1. run `mvn clean install`
2. copy `.jar` to server
3. on the server run `java -jar build/ems.jar`
4. ems runs on port `9002`

## EMS / CMS frontend

```
cd ems-client
ng build
cd dist
```

Copy content of the `dist` to desired place on the server and use following sample of NGINX configuration to point the path to files.

```
server {
        listen 80;
        listen [::]:80;

        server_name example.com;

        location / {
             proxy_pass http://localhost:9001/;
             proxy_set_header X-Forwarded-For $proxy_add_x_forwarded_for;
             proxy_set_header X-Forwarded-Proto $scheme;
             proxy_set_header X-Forwarded-Port $server_port;
        }
}
```

## EMS / CMS database

1. PostgreSQL 9.1.
2. Create schema `ems`, `cms` resp.
3. Specify URL in `application.yaml` of the database
4. Schema is create on the application startup if not created

