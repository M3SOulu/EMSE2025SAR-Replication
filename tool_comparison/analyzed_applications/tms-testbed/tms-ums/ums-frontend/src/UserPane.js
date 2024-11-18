import React, {Component} from 'react';
import UserInfo from "./UserInfo";
import {Tab} from "react-bootstrap";

/**
 * This renders a tab pane for a selected user in the
 * edit users view.
 *
 * @author J.R. Diehl
 * @version 0.1
 */
class UserPane extends Component {
    render() {
        return (
            <Tab.Pane eventKey={this.props.user}>
                <UserInfo keycloak={this.props.keycloak} nameToGet={this.props.user} />
            </Tab.Pane>
        );
    }
}

export default UserPane;
