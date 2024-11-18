import React, { Component } from 'react';
import {Button} from 'react-bootstrap';

/**
 * This button will send updated user profile details to the backend
 * so that they will be saved.
 *
 * @author J.R. Diehl
 * @version 0.1
 */
class UpdateProfileButton extends Component {

    constructor(props) {
        super(props);
        this.state = { response: null };
    }

    /**
     * On a click, make a PUT request to the backend to persist the user details
     * to keycloak.
     *
     * @author J.R. Diehl
     * @version 0.1
     */
    handleClick = () => {
        fetch('http://ums-backend.myicpc.live:80/userinfo/updateUser', {
            method: "PUT",
            headers: {
                "Content-Type": "application/json",
                "Authorization": "Bearer " + this.props.keycloak.token,
            },
            body: JSON.stringify(this.props.profileData),
        }).then(response => {
            if (response.status === 200)
                return response.json();
            else
                return { status: response.status, message: response.statusText }
        }).then(json => this.setState((state, props) => ({
            response: JSON.stringify(json, null, 2)
        }))).catch(err => {
            this.setState((state, props) => ({ response: err.toString() }))
        });

        fetch('http://ums-backend.myicpc.live:80/userinfo/addUserRoles/' + this.props.profileData.username, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
                'Authorization': 'Bearer ' + this.props.keycloak.token,
            },
            body: JSON.stringify(this.props.roles),
        }).then(response => {
            if (response.status === 200) {
                return response.json();
            } else {
                return { status: response.status, message: response.statusText }
            }
        }).then(json => this.setState((state, props) => ({
            response: JSON.stringify(json, null, 2)
        }))).catch(err => {
            this.setState((state, props) => ({ response: err.toString() }))
        });

        alert('Profile Updated!');
    };

    render() {
        return (
            <div className="UpdateProfileButton">
                <Button variant='primary' onClick={this.handleClick}>Update Profile</Button>
            </div>
        );
    }
}

export default UpdateProfileButton;
