package edu.baylor.ecs.ums.service;

import edu.baylor.ecs.ums.entity.Role;
import edu.baylor.ecs.ums.entity.User;
import edu.baylor.ecs.ums.controller.UserInfoController;
import org.keycloak.OAuth2Constants;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.keycloak.admin.client.resource.RealmResource;
import org.keycloak.admin.client.resource.UserResource;
import org.keycloak.admin.client.resource.UsersResource;
import org.keycloak.representations.idm.RoleRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/**
 * This service interfaces with keycloak to provide access to the functions
 * needed by the {@link UserInfoController}.
 * In future versions, all service functions should be shifted away from the restTemplate
 * structure and move towards the keycloak admin api as seen in
 * {@link UserInfoController#addUserRoles(String, Role[])}.
 *
 * @author J.R. Diehl
 * @version 0.1
 */
@Service
public class UserAccessService {

    private static final String keycloakEndpoint = "http://ec2-3-87-186-137.compute-1.amazonaws.com:8080/auth/admin/realms/UserManagement/users";

    private static final String keycloakBaseURL = "http://ec2-3-87-186-137.compute-1.amazonaws.com:8080/auth";
    private static final String keycloakRealm = "UserManagement";
    private static final String keycloakClient = "ums-backend";
    private static final String keycloakClientSecret = "d5e5f5b5-cab2-46ae-a0dc-f081dfb8bc08";

    @Autowired
    private OAuth2RestTemplate restTemplate;

    public List<User> getUsers() {
        ResponseEntity<User[]> response = restTemplate.getForEntity(keycloakEndpoint, User[].class);
        if (response.getBody() == null) {
            return null;
        }
        return Arrays.asList(response.getBody());
    }

    public User addNewUser(User user) {
        ResponseEntity<User> response = restTemplate.postForEntity(keycloakEndpoint, user, User.class);
        return response.getBody();
    }

    public void updateUser(User user) {
        restTemplate.put(keycloakEndpoint + "/" + user.getId(), user);
    }

    public void removeUser(String id) {
        restTemplate.delete(keycloakEndpoint + "/" + id);
    }

    public void changeUserPassword(String id, String newPassword) {
        Map<String, Object> request = new HashMap<>();
        request.put("type", "password");
        request.put("temporary", false);
        request.put("value", newPassword);
        restTemplate.put(keycloakEndpoint + "/" + id + "/reset-password", request);
    }

    public List<String> getUserRoleNames(String username) {
        String id = getUsers()
                .stream()
                .filter(x -> x.getUsername().equals(username))
                .findFirst().orElse(new User()).getId();
        ResponseEntity<Role[]> roles = restTemplate
                .getForEntity(keycloakEndpoint + "/" + id + "/role-mappings/realm",
                        Role[].class);
        if (roles.getBody() == null) {
            return null;
        }
        return Arrays.asList(roles.getBody()).stream().map(Role::getName).collect(Collectors.toList());
    }

    public List<Role> addUserRoles(String username, Role[] roles) {
        Keycloak keycloak = KeycloakBuilder.builder() //
                .serverUrl(keycloakBaseURL) //
                .realm(keycloakRealm) //
                .grantType(OAuth2Constants.CLIENT_CREDENTIALS) //
                .clientId(keycloakClient) //
                .clientSecret(keycloakClientSecret)
                .build();
        RealmResource realmResource = keycloak.realm(keycloakRealm);
        UsersResource usersResource = realmResource.users();
        UserResource userResource = usersResource.get(usersResource
                .list()
                .stream()
                .filter(x -> x.getUsername().equals(username))
                .findFirst().orElse(new UserRepresentation()).getId());
        if (userResource == null) {
            return null;
        }
        List<Role> rolesAdded = new ArrayList<>();
        for (RoleRepresentation roleRepresentation : userResource.roles().realmLevel().listAvailable()) {
            for (Role role : roles) {
                if (role.getName().equals(roleRepresentation.getName())) {
                    userResource.roles().realmLevel().add(Arrays.asList(roleRepresentation));
                    rolesAdded.add(role);
                }
            }
        }
        return rolesAdded;
    }

}
