import React, {Component} from 'react';
import {Nav} from "react-bootstrap";

/**
 * This renders a tab to select a specific user in the
 * edit users view.
 *
 * @author J.R. Diehl
 * @version 0.1
 */
class UserListTab extends Component {
    render() {
        return (
            <Nav.Item>
                <Nav.Link eventKey={this.props.user}>{this.props.user}</Nav.Link>
            </Nav.Item>
        );
    }
}

export default UserListTab;
