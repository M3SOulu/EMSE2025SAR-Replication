import React, {Component} from 'react';
import {Row, Col, Tab, Nav} from 'react-bootstrap';
import UserListTab from "./UserListTab";
import UserPane from "./UserPane";

/**
 * This is the edit users page, which allows admins and above
 * to make changes to the profile information of other users.
 * Any personal data that could be changed in the profile view for a
 * user can be changed, except that an admin cannot set a new password
 * for any user in this view. Additionally, users can be promoted to
 * admin level here (they cannot be demoted from this view though).
 *
 * @author J.R. Diehl
 * @version 0.1
 */
class EditUsers extends Component {
    constructor(props) {
        super(props);
        this.state = {
            names: []
        };
    }

    /**
     * After the component mounts, get the list of all usernames from the backend.
     *
     * @author J.R. Diehl
     * @version 0.1
     */
    componentDidMount() {
        const http = new XMLHttpRequest();
        http.open('GET', 'http://ums-backend.myicpc.live:80/userinfo/usernames');
        http.setRequestHeader("Authorization", "Bearer " + this.props.keycloak.token);
        http.onload = (event) => {
            const resp = JSON.parse(http.response);
            this.setState({
                names: resp,
            });
        };
        http.send();
    }

    render() {
        let users = this.state.names.map((item, id) =>
            <UserListTab key={id} user={item}/>
        );
        let userPanes = this.state.names.map((item, id) =>
            <UserPane key={id} keycloak={this.props.keycloak} user={item}/>
        );
        return (
            <Tab.Container defaultActiveKey={this.state.names[0]}>
                <Row>
                    <Col xl={2}>
                        <br/>
                        <Nav variant='pills' className='flex-column'>
                            {users}
                        </Nav>
                    </Col>
                    <Col xl={10}>
                        <Tab.Content>
                            {userPanes}
                        </Tab.Content>
                    </Col>
                </Row>
            </Tab.Container>
        );
    }
}

export default EditUsers;
