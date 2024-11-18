import React, { Component } from 'react';
import { withRouter } from 'react-router-dom';
import {Button} from 'react-bootstrap';

/**
 * This button will log the user out of the application.
 *
 * @author J.R. Diehl
 * @version 0.1
 */
class Logout extends Component {

    /**
     * Return to the welcome page and perform the log out from keycloak.
     */
    logout() {
        this.props.history.push('/');
        this.props.keycloak.logout();
    }

    render() {
        return (
            <Button variant='primary' onClick={ () => this.logout() }>
                Logout
            </Button>
        );
    }
}
export default withRouter(Logout);
