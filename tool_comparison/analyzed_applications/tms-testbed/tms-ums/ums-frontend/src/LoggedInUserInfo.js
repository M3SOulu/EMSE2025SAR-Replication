import React, { Component } from 'react';
import {Form, Card, Row, Col} from 'react-bootstrap';
import UpdateProfileButton from "./UpdateProfileButton";
import Logout from "./Logout";
import ChangePasswordButton from "./ChangePasswordButton";

/**
 * This is the profile view for the logged in user. It will display
 * and allow the user to change their account details, address, and teacher
 * info. It will also allow the user to change their password and log out
 * from the system.
 *
 * @author J.R. Diehl
 * @version 0.1
 */
class LoggedInUserInfo extends Component {

    constructor(props) {
        super(props);
        this.state = {
            username: "",
            firstName: "",
            lastName: "",
            email: "",
            id: "",
            preferred_prog_lang: "",
            teacher_level: 1,
            address1: "",
            address2: "",
            city: "",
            state: "TX",
            zip: "",
            institution: "",
            newPassword: "",
        };
        // Get the user info from keycloak
        this.props.keycloak.loadUserInfo().success(userInfo => {
            this.setState({
                id: userInfo.sub,
                username: userInfo.preferred_username,
                firstName: userInfo.given_name,
                lastName: userInfo.family_name,
                email: userInfo.email,
                preferred_prog_lang: userInfo.preferred_prog_lang,
                teacher_level: userInfo.teacher_level,
                address1: userInfo.address1,
                address2: userInfo.address2,
                city: userInfo.city,
                state: userInfo.state,
                zip: userInfo.zip,
                institution: userInfo.institution,
            });
        });
    }

    render() {
        return (
            <div>
                <br/>
                <Row>
                    <Col>
                        <Card style={{ width: '22rem' }} className='text-black' >
                            <Card.Body>
                                <Card.Title>Account Info</Card.Title>
                                <Form className="UserInfo">
                                    <Form.Group>
                                        <Form.Label>ID</Form.Label>
                                        <Form.Control value={this.state.id} name='id' type='text' readOnly />
                                    </Form.Group>
                                    <Form.Group onChange={(event) => {this.handleChange(event)}}>
                                        <Form.Label>Username</Form.Label>
                                        <Form.Control value={this.state.username} name='username' type='text' />
                                    </Form.Group>
                                    <Form.Group onChange={(event) => {this.handleChange(event)}}>
                                        <Form.Label>First Name</Form.Label>
                                        <Form.Control value={this.state.firstName} name='firstName' type='text' />
                                    </Form.Group>
                                    <Form.Group onChange={(event) => {this.handleChange(event)}}>
                                        <Form.Label>Last Name</Form.Label>
                                        <Form.Control value={this.state.lastName} name='lastName' type='text' />
                                    </Form.Group>
                                    <Form.Group onChange={(event) => {this.handleChange(event)}}>
                                        <Form.Label>Email</Form.Label>
                                        <Form.Control value={this.state.email} name='email' type='text' />
                                    </Form.Group>
                                </Form>
                            </Card.Body>
                        </Card>
                    </Col>
                    <Col>
                        <Card style={{ width: '22rem' }} className='text-black'>
                            <Card.Body>
                                <Card.Title>Address</Card.Title>
                                <Form className="AddressInfo">
                                    <Form.Group onChange={(event) => {this.handleChange(event)}}>
                                        <Form.Label>Address 1</Form.Label>
                                        <Form.Control value={this.state.address1} name='address1' type='text' />
                                    </Form.Group>
                                    <Form.Group onChange={(event) => {this.handleChange(event)}}>
                                        <Form.Label>Address 2</Form.Label>
                                        <Form.Control value={this.state.address2} name='address2' type='text' />
                                    </Form.Group>
                                    <Form.Group onChange={(event) => {this.handleChange(event)}}>
                                        <Form.Label>City</Form.Label>
                                        <Form.Control value={this.state.city} name='city' type='text' />
                                    </Form.Group>
                                    <Form.Group onChange={(event) => {this.handleChange(event)}}>
                                        <Form.Label>State</Form.Label>
                                        <Form.Control value={this.state.state} name='state' as='select'>
                                            <option>AL</option>
                                            <option>AK</option>
                                            <option>AZ</option>
                                            <option>AR</option>
                                            <option>CA</option>
                                            <option>CO</option>
                                            <option>CT</option>
                                            <option>DE</option>
                                            <option>FL</option>
                                            <option>GA</option>
                                            <option>HI</option>
                                            <option>ID</option>
                                            <option>IL</option>
                                            <option>IN</option>
                                            <option>IA</option>
                                            <option>KS</option>
                                            <option>KY</option>
                                            <option>LA</option>
                                            <option>ME</option>
                                            <option>MD</option>
                                            <option>MA</option>
                                            <option>MI</option>
                                            <option>MN</option>
                                            <option>MS</option>
                                            <option>MO</option>
                                            <option>MT</option>
                                            <option>NE</option>
                                            <option>NV</option>
                                            <option>NH</option>
                                            <option>NJ</option>
                                            <option>NM</option>
                                            <option>NY</option>
                                            <option>NC</option>
                                            <option>ND</option>
                                            <option>OH</option>
                                            <option>OK</option>
                                            <option>OR</option>
                                            <option>PA</option>
                                            <option>RI</option>
                                            <option>SC</option>
                                            <option>SD</option>
                                            <option>TN</option>
                                            <option>TX</option>
                                            <option>UT</option>
                                            <option>VT</option>
                                            <option>VA</option>
                                            <option>WA</option>
                                            <option>WV</option>
                                            <option>WI</option>
                                            <option>WY</option>
                                        </Form.Control>
                                    </Form.Group>
                                    <Form.Group onChange={(event) => {this.handleChange(event)}}>
                                        <Form.Label>ZIP</Form.Label>
                                        <Form.Control value={this.state.zip} name='zip' type='text' />
                                    </Form.Group>
                                </Form>
                            </Card.Body>
                        </Card>
                    </Col>
                </Row>
                <br/>
                <Row>
                    <Col>
                        <Card style={{ width: '22rem' }} className='text-black'>
                            <Card.Body>
                                <Card.Title>Teacher Info</Card.Title>
                                <Form className="AddressInfo">
                                    <Form.Group onChange={(event) => {this.handleChange(event)}}>
                                        <Form.Label>Institution</Form.Label>
                                        <Form.Control value={this.state.institution} name='institution' type='text' />
                                    </Form.Group>
                                    <Form.Group onChange={(event) => {this.handleChange(event)}}>
                                        <Form.Label>Preferred Programming Language</Form.Label>
                                        <Form.Control value={this.state.preferred_prog_lang} name='preferred_prog_lang' as='select'>
                                            <option>Java</option>
                                            <option>C++</option>
                                        </Form.Control>
                                    </Form.Group>
                                    <Form.Group onChange={(event) => {this.handleChange(event)}}>
                                        <Form.Label>Teacher Level</Form.Label>
                                        <Form.Control value={this.state.teacher_level} name='teacher_level' type='number' max='5' min={'1'} />
                                    </Form.Group>
                                </Form>
                            </Card.Body>
                        </Card>
                    </Col>
                    <Col>
                        <Card style={{ width: '22rem' }} className='text-black'>
                            <Card.Body>
                                <Card.Title>Profile Actions</Card.Title>
                                <Form className="ChangePassword">
                                    <Form.Group onChange={(event) => {this.handleChange(event)}}>
                                        <Form.Label>New Password</Form.Label>
                                        <Form.Control value={this.state.newPassword} name='newPassword' type='password' />
                                    </Form.Group>
                                </Form>
                                <ChangePasswordButton keycloak={this.props.keycloak} id={this.state.id} newPassword={this.state.newPassword} />
                                <div className='small-break'/>
                                <UpdateProfileButton keycloak={this.props.keycloak} profileData={
                                    {
                                        id: this.state.id,
                                        username: this.state.username,
                                        firstName: this.state.firstName,
                                        lastName: this.state.lastName,
                                        email: this.state.email,
                                        attributes: {
                                            "preferred_prog_lang": [
                                                this.state.preferred_prog_lang
                                            ],
                                            "teacher_level": [
                                                this.state.teacher_level
                                            ],
                                            "Address 1": [
                                                this.state.address1
                                            ],
                                            "Address 2": [
                                                this.state.address2
                                            ],
                                            "City": [
                                                this.state.city
                                            ],
                                            "State": [
                                                this.state.state
                                            ],
                                            "Zip": [
                                                this.state.zip
                                            ],
                                            "Institution": [
                                                this.state.institution
                                            ]
                                        }
                                    }
                                } />
                                <div className='small-break' />
                                <Logout keycloak={this.props.keycloak} />
                            </Card.Body>
                        </Card>
                    </Col>
                </Row>
                <br/>
            </div>
        );
    }

    /**
     * This will update the state whenever a form control is changed.
     *
     * @author J.R. Diehl
     * @version 0.1
     * @param event
     */
    handleChange(event) {
        const name = event.target.name;
        const value = event.target.value;
        this.setState({
            [name]: value,
        });
    }
}
export default LoggedInUserInfo;
