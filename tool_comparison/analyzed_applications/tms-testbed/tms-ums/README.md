# User Management (UMS)
The User Management system handles the management of users for the teacher-exam project. Imagine that.
This readme will provide a guide for you to understand what this microservice
does, how it does it, and how you can deploy it on your own.


## What It Does: UMS-Frontend
The UMS-Frontend provides the interface for a user to view and make changes to their account within the 
teacher-exam project, and if they are an admin it also allows them to view and edit other 
users, even elevating them to admin privileges.

## How It Does It: UMS-Frontend
Authentication and authorization are handled via keycloak, as is user registration.
Admins cannot create user accounts; however, it is trivially easy for a new user to register, 
so this should not be a significant issue.

If you want a more in-depth understanding of how the frontend works, check out the
React code and documentation.

## How to Run It: UMS-Frontend
First, you will need to verify that the backend URLs point to where you expect to 
run your backend. In the future this should be extracted to a config file, but it
isn't at the moment so you'll have to make do with what you've got. Go through and
find all of the http requests and change the URLs to what you expect them to be for
your backend.

Then, you'll need to set up keycloak. The purpose of this guide isn't to walk you
through how to set up keycloak, so you're on your own for that. However, you can 
use the provided realm-export.json to quickly import the UserManagement realm
so that you don't need to start from scratch. Make sure your keycloak server is accessible
to all of the microservices you plan to run.

Now that keycloak is set up, log in to the admin console and go to the 'ums-frontend' client.
Then, navigate to 'Installation' and select the 'Keycloak OIDC JSON' option to download it.
Put this downloaded keycloak.json in the ums-frontend/public directory (overwrite the existing one).
This will take care of your config for the keycloak-js adapter.

Now, you can run npm start to run the frontend in development mode. Of course, now
you'll need to get the backend running.

## What It Does: UMS-Backend
The UMS-Backend provides CRUD operations and more fine-grained access to various
attributes and aspects of your keycloak users. It is secured by keycloak so that
an access token with at least a user role is required to access any of its endpoints.

## How It Does It: UMS-Backend
The backend runs as a spring boot application secured through the keycloak java adapter
and the spring-security api. It follows a simple application-controller-service
structure. To learn more about how it works, check out the code and read the documentation.

## How to Run It: UMS-Backend
Like you did with the frontend, you will need to change a few URLs. This time, though,
you're replacing my keycloak server with your own. Go through the code and the application.yml
file and make sure you update all references to my keycloak server to use yours instead.

Now, you just need to run two commands and you should be good to go:

###`mvn clean install`

###`mvn clean spring-boot:run`
