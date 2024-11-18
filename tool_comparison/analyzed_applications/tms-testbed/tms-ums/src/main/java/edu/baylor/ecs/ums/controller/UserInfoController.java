package edu.baylor.ecs.ums.controller;

import edu.baylor.ecs.ums.entity.Role;
import edu.baylor.ecs.ums.entity.User;
import edu.baylor.ecs.ums.service.UserAccessService;
import org.jboss.resteasy.annotations.ResponseObject;
import org.keycloak.KeycloakPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import javax.annotation.security.RolesAllowed;
import java.util.stream.Collectors;

/**
 * This is the REST controller for the UMS backend. It exposes a variety
 * of endpoints which allow access to basic CRUD for keycloak users, as
 * well as other more fine-grained features.
 *
 * @author J.R. Diehl
 * @version 0.1
 */
@RestController
@RequestMapping("/userinfo")
public class UserInfoController {

    @Autowired
    private UserAccessService userAccessService;

    @GetMapping(path = "/users")
    //@PreAuthorize("hasAnyAuthority(ROLE_admin', 'ROLE_superadmin')")
    @RolesAllowed({"ROLE_admin","ROLE_superadmin"})
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userAccessService.getUsers());
    }

    @GetMapping(path = "/usernames")
    //@PreAuthorize("hasAnyAuthority('ROLE_admin', 'ROLE_superadmin')")
    @RolesAllowed({"ROLE_admin", "ROLE_superadmin"})
    public ResponseEntity<List<String>> getAllUsernames() {
        return ResponseEntity.ok(userAccessService.getUsers()
                .stream()
                .map(User::getUsername)
                .collect(Collectors.toList()));
    }

    @GetMapping(path = "/userRoles/{username}")
    //@PreAuthorize("hasAnyAuthority('ROLE_user', 'ROLE_admin', 'ROLE_superadmin')")
    @RolesAllowed({"ROLE_user","ROLE_admin","ROLE_superadmin"})
    public ResponseEntity<List<String>> getUserRoles(@PathVariable String username) {
        return ResponseEntity.ok(userAccessService.getUserRoleNames(username));
    }

    @GetMapping(path = "/validId/{id}")
    //@PreAuthorize("hasAnyAuthority('ROLE_user', 'ROLE_admin', 'ROLE_superadmin')")
    @RolesAllowed({"ROLE_user","ROLE_admin","ROLE_superadmin"})
    public ResponseEntity<Boolean> isValidId(@PathVariable String id) {
        return ResponseEntity.ok(userAccessService.getUsers()
                .stream()
                .anyMatch(x -> x.getId().equals(id)));
    }

    @GetMapping(path = "/emailInUse/{email}")
    //@PreAuthorize("hasAnyAuthority('ROLE_user', 'ROLE_admin', 'ROLE_superadmin')")
    @RolesAllowed({"ROLE_user","ROLE_admin","ROLE_superadmin"})
    public ResponseEntity<String> isEmailInUse(@PathVariable String email) {
        List<User> users = userAccessService.getUsers();
        return ResponseEntity.ok(users
                .stream()
                .filter(x -> email.equals(x.getEmail()))
                .findFirst().orElse(new User()).getId());
    }

    @GetMapping(path = "/userById/{id}")
    //@PreAuthorize("hasAnyAuthority('ROLE_user', 'ROLE_admin', 'ROLE_superadmin')")
    @RolesAllowed({"ROLE_user","ROLE_admin","ROLE_superadmin"})
    public ResponseEntity<User> getUserById(@PathVariable String id) {
        List<User> users = userAccessService.getUsers();
        return ResponseEntity.ok(users
                .stream()
                .filter(x -> id.equals(x.getId()))
                .findFirst().orElse(null));
    }

    @GetMapping(path = "/userByUsername/{username}")
    //@PreAuthorize("hasAnyAuthority('ROLE_user', 'ROLE_admin', 'ROLE_superadmin')")
    @RolesAllowed({"ROLE_user","ROLE_admin","ROLE_superadmin"})
    public ResponseEntity<User> getUserByUsername(@PathVariable String username) {
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication auth = context.getAuthentication();
        List<User> users = userAccessService.getUsers();
        return ResponseEntity.ok(users
                .stream()
                .filter(x -> username.equals(x.getUsername()))
                .findFirst().orElse(null));
    }

    @PostMapping(path = "/addUser")
    //@PreAuthorize("hasAnyAuthority('ROLE_admin', 'ROLE_superadmin')")
    @RolesAllowed({"ROLE_admin","ROLE_superadmin"})
    public ResponseEntity<User> addNewUser(@RequestBody User user) {
        return ResponseEntity.ok(userAccessService.addNewUser(user));
    }

    @PostMapping(path = "/addUserRoles/{username}")
    //@PreAuthorize("hasAnyAuthority('ROLE_admin', 'ROLE_superadmin')")
    @RolesAllowed({"ROLE_admin","ROLE_superadmin"})
    public ResponseEntity<List<Role>> addUserRoles(@PathVariable String username, @RequestBody Role[] roles) {
        return ResponseEntity.ok(userAccessService.addUserRoles(username, roles));
    }

    @PutMapping(path = "/updateUser")
    //@PreAuthorize("hasAnyAuthority('ROLE_user', 'ROLE_admin', 'ROLE_superadmin')")
    @RolesAllowed({"ROLE_user","ROLE_admin","ROLE_superadmin"})
    public ResponseEntity<String> updateUser(@RequestBody User user) {
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication auth = context.getAuthentication();
        KeycloakPrincipal principal = (KeycloakPrincipal) auth.getPrincipal();

        if (user.getUsername().equals(principal.getName())
                || auth.getAuthorities()
                    .stream()
                    .anyMatch(x -> x.getAuthority().equals("ROLE_admin")
                        || (x.getAuthority().equals("ROLE_superadmin")))) {
            userAccessService.updateUser(user);
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.status(403).body("Forbidden");
    }

    @PutMapping(path = "/changePassword/{id}")
    //@PreAuthorize("hasAnyAuthority('ROLE_user', 'ROLE_admin', 'ROLE_superadmin')")
    @RolesAllowed({"ROLE_user","ROLE_admin","ROLE_superadmin"})
    public ResponseEntity<String> changePassword(@PathVariable String id, @RequestBody String newPassword) {
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication auth = context.getAuthentication();
        KeycloakPrincipal principal = (KeycloakPrincipal) auth.getPrincipal();

        User user = userAccessService.getUsers()
                .stream()
                .filter(x -> x.getUsername().equals(principal.getName()))
                .findFirst().orElse(null);

        if (user == null) {
            return ResponseEntity.status(404).body("No such user");
        }

        if (user.getId().equals(id)
                || auth.getAuthorities()
                .stream()
                .anyMatch(x -> x.getAuthority().equals("ROLE_admin")
                        || (x.getAuthority().equals("ROLE_superadmin")))) {
            userAccessService.changeUserPassword(id, newPassword);
            return ResponseEntity.ok("Password changed successfully!");
        }

        return ResponseEntity.status(403).body("Forbidden");
    }

    @DeleteMapping(path = "/deleteUser/{id}")
    //@PreAuthorize("hasAnyAuthority('ROLE_admin', 'ROLE_superadmin')")
    @RolesAllowed({"ROLE_admin","ROLE_superadmin"})
    public ResponseEntity<String> removeUser(@PathVariable String id) {
        if (userAccessService.getUsers().stream().noneMatch(x -> id.equals(x.getId()))) {
            return ResponseEntity.status(404).body("No user with that id");
        }
        userAccessService.removeUser(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(path = "/deleteUserByUsername/{username}")
    //@PreAuthorize("hasAnyAuthority('ROLE_admin', 'ROLE_superadmin')")
    @RolesAllowed({"ROLE_admin","ROLE_superadmin"})
    public ResponseEntity<String> removeUserByUsername(@PathVariable String username) {
        String id = userAccessService.getUsers()
                .stream()
                .filter(x -> username.equals(x.getUsername()))
                .findFirst().orElse(new User()).getId();
        if (id == null) {
            return ResponseEntity.notFound().build();
        }
        userAccessService.removeUser(id);
        return ResponseEntity.noContent().build();
    }

}
