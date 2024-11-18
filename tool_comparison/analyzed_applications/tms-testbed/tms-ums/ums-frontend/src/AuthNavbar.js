import React, {Component} from 'react';
import {Navbar, Nav} from 'react-bootstrap';

/**
 * This is the navbar for authenticated users. It will only show the edit users
 * link if the logged in user is an admin or higher role.
 *
 * @author J.R. Diehl
 * @version 0.1
 */
class AuthNavbar extends Component {
    /**
     * Nav components for all users
     *
     * @author J.R. Diehl
     * @version 0.1
     * @returns {*}
     */
    renderUserNav() {
        if (this.props.keycloak.tokenParsed.realm_access.roles.includes("user")) {
            return (
                <>
                    <Nav.Link href='/'>Home</Nav.Link>
                    <Nav.Link href='profile'>Profile</Nav.Link>
                </>
            );
        }
        return null;
    }

    /**
     * Nav components for admins and higher
     *
     * @author J.R. Diehl
     * @version 0.1
     * @returns {*}
     */
    renderAdminNav() {
        if (this.props.keycloak.tokenParsed.realm_access.roles.includes("admin")
                || this.props.keycloak.tokenParsed.realm_access.roles.includes("superadmin")) {
            return (
                <Nav.Link href='/users'>Edit Users</Nav.Link>
            )
        }
        return null;
    }

    render() {
        return (
            <Navbar bg='dark' variant='dark' static='top'>
                <Navbar.Brand href='/'>User Management</Navbar.Brand>
                <Nav className='mr-auto'>
                    {this.renderUserNav()}
                    {this.renderAdminNav()}
                </Nav>
            </Navbar>
        );
    }
}

export default AuthNavbar;
