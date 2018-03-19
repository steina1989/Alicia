/* eslint-disable */
import React, { Component } from 'react';
import Header from './Header';
import axios from 'axios';

class Home extends Component {

    constructor(props) {
        super(props);
        this.state = {
            courses: [],
        };
    }

    componentDidMount() {
        console.log('didmount');
        axios.get('/api/courses')
            .then((res) => {
                const courses = res.data._embedded.courses;
                this.setState({ courses });
            }).catch(err => console.log(err));
    }


    render() {
        console.log('ERrr í heome');
        return (
            <div>
                <Header />;
                <h1>Home.js</h1>
            </div>
        );
    }
}

export default Home;
