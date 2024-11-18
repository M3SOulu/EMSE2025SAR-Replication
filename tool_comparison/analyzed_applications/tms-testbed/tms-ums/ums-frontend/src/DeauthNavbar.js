import React, {Component} from 'react';
import {Navbar, Nav} from 'react-bootstrap';

/**
 * This is the navbar for unauthenticated users.
 * It shows a link to the welcome page and a link to the profile
 * view, which will force them to login if clicked.
 *
 * @author J.R. Diehl
 * @version 0.1
 */
class DeauthNavbar extends Component {
    render() {
        return (
            <Navbar bg='dark' variant='dark' static='top'>
                <Navbar.Brand href='/'>User Management</Navbar.Brand>
                <Nav className='mr-auto'>
                    <Nav.Link href='/'>Home</Nav.Link>
                    <Nav.Link href='profile'>Profile</Nav.Link>
                </Nav>
            </Navbar>
        );
    }
}

export default DeauthNavbar;
