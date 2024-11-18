import React, { Component } from 'react';
import { BrowserRouter, Route } from 'react-router-dom';
import Secured from './Secured';
import './App.css';
import Welcome from "./Welcome";

/**
 * This provides a router to the welcome page, profile view, and
 * edit users page. It is the application root.
 *
 * @author J.R. Diehl
 * @version 0.1
 */
class App extends Component {
    render() {
        return (
            <BrowserRouter>
              <div>
                <Route exact path="/" render={(props) =>
                    <Welcome />
                } />
                <Route path='/profile' render={(props) =>
                    <Secured />
                } />
                <Route path='/users' render={(props) =>
                    <Secured />
                } />
              </div>
            </BrowserRouter>
        );
    }
}
export default App;
