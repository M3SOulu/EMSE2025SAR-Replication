import React, { Component } from 'react';
import './App.css';
import AppNavbar from "./AppNavbar";

/**
 * This is the welcome page. It is entirely unremarkable. Someone should make it better probably. Not me.
 *
 * @author J.R. Diehl
 * @version 0.1
 */
class Welcome extends Component {
    render() {
        return (
            <div className="Welcome">
                <AppNavbar keycloak={this.props.keycloak} authenticated={this.props.authenticated} />
                <h1 className='App-header'>
                    <p>Welcome to User Management!</p>
                </h1>
            </div>
        );
    }
}
export default Welcome;
