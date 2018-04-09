import React, { Component } from 'react';
import Header from './Header/Header';
import Grader from './containers/Grader/Grader';
import { CourseTable, AssignmentTable } from './containers/Tables/Tables';
import CreateAssignment from './containers/CreateAssignment';

import { Route, Switch } from 'react-router-dom';
import './App.css';

class App extends Component {
  state = {
    loading: false,
    courses: [],
    assignments: [],
    courseId: null
  };

  selectCoursesHandler = () => {
    const api = process.env.REACT_APP_SERVICE_URL;
    console.log(`${api}/courses`);
    fetch(`${api}/courses`)
      .then(resp => resp.json())
      .then(res => {
        const courses = res._embedded.courses;
        this.setState({ courses });
      });
  };

  render() {
    console.log('courses:', this.state.courses);
    return (
      <div>
        <Header />
        <Switch>
          <Route exact path="/" render={Home} />
          <Route path="/about" render={About} />
          <Route path="/grader/:assignmentId/" component={Grader} />
          <Route
            path="/assignments"
            render={() => (
              <AssignmentTable
                assignments={this.state.assignments}
                openAssignmentHandler={this.openAssignmentHandler}
                courseId={this.state.courseId}
              />
            )}
          />
          {/* <Route
          path="/course/:courseId"
          component={Course}
          /> */}
          <Route
            path="/createAssignment/:courseId"
            component={CreateAssignment}
          />
        </Switch>
      </div>
    );
  }
}

const About = () => {
  return <div className="App">Um Verkefnið</div>;
};

const Home = () => {
  return <div className="App">Heim</div>;
};

export default App;
