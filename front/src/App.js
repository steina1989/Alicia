import React, { Component } from 'react';
import Header from './header';
import Home from './routes/home';
import Course from './routes/course';
import Courses from './routes/courses';
import Grader from './routes/grader';
import NotFound from './routes/not-found';
import { Route, Switch } from 'react-router-dom';
import './App.css';

class App extends Component {
  render() {
    return (
      <div className="main">
        <Header />
        <div className="App">
          <Switch>
            <Route exact path="/" component={Home} />
            {/* Cards of Courses */}
            <Route path="/courses/" component={Courses} />
            {/* List of assignments for specific course */}
            <Route path="/course/:id" component={Course} />
            {/* Assignment's content and post form */}
            <Route path="/assignment/:id" component={Courses} />

            {/* Grading system for an assignment */}
            <Route path="/grader/:assignmentId/" component={Grader} />

            <Route component={NotFound} />
          </Switch>
        </div>
      </div>
    );
  }
}

export default App;
