import React, { Component } from 'react';
import {Form, Card, Row, Col, Container} from 'react-bootstrap';
import UpdateProfileButton from "./UpdateProfileButton";

/**
 * This is basically the same as the LoggedInUserInfo class, except
 * that it gets info from backend API calls rather than keycloak directly,
 * and it does not feature the change password or logout features. It is used
 * in the edit users view.
 *
 * @author J.R. Diehl
 * @version 0.1
 */
class UserInfo extends Component {

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
            state: "",
            zip: "",
            institution: "",
            newPassword: "",
        };
        const http = new XMLHttpRequest();
        http.open('GET', 'http://ums-backend.myicpc.live:80/userinfo/userByUsername/' + this.props.nameToGet);
        http.setRequestHeader("Authorization", "Bearer " + this.props.keycloak.token);
        http.onreadystatechange = (event) => {
            const resp = JSON.parse(http.response);
            this.setState({
                id: resp.id,
                username: resp.username,
                firstName: resp.firstName,
                lastName: resp.lastName,
                email: resp.email,
                preferred_prog_lang: resp.attributes == null ? null: resp.attributes.preferred_prog_lang[0],
                teacher_level: resp.attributes == null ? null: resp.attributes.teacher_level[0],
                address1: resp.attributes == null ? null: resp.attributes['Address 1'][0],
                address2: resp.attributes == null ? null: resp.attributes['Address 2'][0],
                city: resp.attributes == null ? null: resp.attributes.City[0],
                state: resp.attributes == null ? null: resp.attributes.State[0],
                zip: resp.attributes == null ? null: resp.attributes.Zip[0],
                institution: resp.attributes == null ? null: resp.attributes.Institution[0],
            });
        };
        http.send();
        const http2 = new XMLHttpRequest();
        http2.open('GET', 'http://ums-backend.myicpc.live:80/userinfo/userRoles/' + this.props.nameToGet);
        http2.setRequestHeader("Authorization", "Bearer " + this.props.keycloak.token);
        http2.onreadystatechange = (event) => {
            const resp = JSON.parse(http2.response);
            this.setState({
                isAdmin: (resp.includes("admin") || resp.includes("superadmin")),
            });
        };
        http2.send();
    }

    render() {
        return (
            <Container fluid={true}>
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
                    <br/>
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
                                            <option></option>
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
                                            <option></option>
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
                    <br/>
                    <Col>
                        <Card style={{ width: '22rem' }} className='text-black'>
                            <Card.Body>
                                <Card.Title>Profile Actions</Card.Title>
                                <Form>
                                    <Form.Check type='checkbox'
                                                checked={this.state.isAdmin}
                                                name='isAdmin'
                                                label='Is Admin'
                                                disabled={
                                                    !(this.props.keycloak.tokenParsed.realm_access.roles.includes("admin") ||
                                                        this.props.keycloak.tokenParsed.realm_access.roles.includes("superadmin"))
                                                }
                                                onChange={(event) => {this.handleChange(event)}}/>
                                </Form>
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
                                }
                                roles={
                                    [
                                        {
                                            name: (this.state.isAdmin) ? "admin" : null,
                                        }
                                    ]
                                }/>
                            </Card.Body>
                        </Card>
                    </Col>
                </Row>
                <br/>
            </Container>
        );
    }

    handleChange(event) {
        const name = event.target.name;
        const value = event.target.value;
        this.setState({
            [name]: value,
        });
    }
}
export default UserInfo;
