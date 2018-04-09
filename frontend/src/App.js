
import React, { Component } from 'react';
import { Route, Switch } from 'react-router-dom';

import Header from './components/Header';
import Grader from './containers/Grader/Grader';
import { CourseTable, AssignmentTable } from './containers/Tables/Tables';
import CreateAssignment from './containers/CreateAssignment';
import './App.css';

class App extends Component {
    state = { loading: false,
        courses: [],
        assignments: [],
        courseId: null,
    };

    selectCoursesHandler = () => {
        fetch('api/courses')
            .then(resp => resp.json())
            .then((res) => {
                const courses = res._embedded.courses;
                this.setState({ courses });
            });
    }

    openCourseHandler = (id) => {
        fetch(`api/courses/${id}/assignments`)
            .then(resp => resp.json())
            .then((res) => {
                const assignments = res._embedded.assignments;
                this.setState({ assignments });
                this.setState({ courseId: id });
            });
    }

    openAssignmentHandler = () => {

    }

    render() {
        return (
            <div>
                <Header courseHandler={this.selectCoursesHandler} />
                <Switch>
                    <Route exact path="/" render={() => <h2> Velkomin </h2>} />
                    <Route path="/about" render={() => <p>Um Verkefnið </p>} />
                    <Route path="/grader/:assignmentId/" component={Grader} />
                    <Route
                        path="/assignments"
                        render={() => (
                            <AssignmentTable
                                assignments={this.state.assignments}
                                openAssignmentHandler={this.openAssignmentHandler}
                                courseId={this.state.courseId} />)} />
                    <Route
                        path="/course"
                        render={() => (
                            <CourseTable
                                courses={this.state.courses}
                                openCourseHandler={this.openCourseHandler} />)} />
                    <Route
                        path="/createAssignment/:courseId"
                        component={CreateAssignment} />
                </Switch>
            </div>
        );
    }
}

export default App;
