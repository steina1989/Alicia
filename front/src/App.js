import React, { Component } from 'react';
import Header from './header';
import Home from './routes/home';
import Course from './routes/course';
import Courses from './routes/courses';
import Grader from './routes/grader';
import NotFound from './routes/not-found';
import NewCourse from './routes/newcourse';
import { Route, Switch } from 'react-router-dom';
import './App.css';

class App extends Component {
  render() {
    return (
      <div>
        <Header />
        <div>
          <Switch>
            <Route exact path="/" component={Home} />
            {/* Cards of Courses */}
            <Route exact path="/courses/" component={Courses} />
            <Route exact path="/courses/new" component={NewCourse} />
            {/* Expandable list of assignments for specific course. 
                Extended rows contains forms for submission. */}
            <Route path="/course/:id" component={Course} />
            {/* Grading system for an assignment */}
            <Route path="/grade/:assignmentId/" component={Grader} />

            <Route component={NotFound} />
          </Switch>
        </div>
      </div>
    );
  }
}

export default App;
