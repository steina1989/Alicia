/**
 * This is our front page. It lists all the courses.
 */

import React, { Component } from 'react';
import { BrowserRouter as Router, Route } from 'react-router-dom';
import Header from './components/Header';
import Grader from './containers/Grader/Grader';
import './App.css';

class App extends Component {
    state = { loading: false };

    componentDidMount() {
        fetch('/api/courses')
            .then(resp => resp.json())
            .then(res => console.log('here here', res));
    }

    render() {
        return (
            <Router>
                <div className="App">
                    <Header />
                    <Route path="/grader/:id" component={Grader} />
                </div>
            </Router>
        );
    }
}

export default App;
