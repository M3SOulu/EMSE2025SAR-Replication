import React, { Component } from 'react';
import Keycloak from 'keycloak-js';
import LoggedInUserInfo from "./LoggedInUserInfo";
import AppNavbar from "./AppNavbar";
import history from './History';
import EditUsers from "./EditUsers";

/**
 * This will be the parent for all of the application's secured components.
 * Depending on the path, it will render either the profile view or the
 * edit users view.
 *
 * @author J.R. Diehl
 * @version 0.1
 */
class Secured extends Component {
    constructor(props) {
        super(props);
        this.state = {
            keycloak: null,
            authenticated: false,
        }
    }

    /**
     * When the component loads, initialize keycloak.
     *
     * @author J.R. Diehl
     * @version 0.1
     */
    componentDidMount() {
        const keycloak = Keycloak('keycloak.json');
        keycloak.init({onLoad: 'login-required'}).success((authenticated) => {
            this.setState({
                keycloak: keycloak,
                authenticated: authenticated,
            })
        }).error(() => {
            this.setState({
                keycloak: null,
                authenticated: false,
            });
        });
    }

    /**
     * Decide whether to render the profile view or the edit users view
     * based on the path.
     *
     * @author J.R. Diehl
     * @version 0.1
     * @returns {*}
     */
    renderPage() {
        if (history.location.pathname === "/profile") {
            return (
                <>
                    <AppNavbar keycloak={this.state.keycloak} authenticated={this.state.authenticated} />
                    <div className='App-header'>
                        <LoggedInUserInfo keycloak={this.state.keycloak} />
                    </div>
                </>
            );
        } else if (history.location.pathname === "/users") {
            return (
                <>
                    <AppNavbar keycloak={this.state.keycloak} authenticated={this.state.authenticated} />
                    <div className='App-header'>
                        <EditUsers keycloak={this.state.keycloak} authenticated={this.state.authenticated} />
                    </div>
                </>
            )
        }
        return null;
    }

    render() {
        if (this.state.keycloak) {
            if (this.state.authenticated) {
                return (
                    <div>
                        {this.renderPage()}
                    </div>
                );
            } else return (<div>Unable to authenticate!</div>)
        }
        return (
            <div>Initializing Keycloak...</div>
        );
    }
}
export default Secured;
