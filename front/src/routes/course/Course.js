import React, { Component } from 'react';
import Assignment from '../../components/assignment';
import Button from '../../components/button';
import Api from '../../Api';
import './Course.css';

// To do: Use hrefs from backend.
export default class Course extends Component {
  state = {
    assignments: [],
    error: false,
    loading: true
  };

  componentDidMount = async () => {
    const { id } = this.props.match.params;
    let response;
    try {
      response = await Api.get(`courses/${id}/assignments`);
    } catch (error) {
      console.log(error);
      this.setState({ error: true });
      return;
    }
    console.log(response.status);
    switch (response.status) {
      case 200:
        const assignments = response.result._embedded.assignments;
        this.setState({ assignments, loading: false, error: false });
        break;
      case 400:
        this.setState({ error: true, loading: false });
        break;
      default:
        this.setState({ error: true, loading: false });
        break;
    }
  };

  render() {
    const { assignments, loading, error } = this.state;

    if (error) {
      return <p>Something went wrong.</p>;
    }
    if (loading) {
      return <p>Loading your assignments...</p>;
    }
    console.log(assignments);
    const assignmentElements = assignments.map(e => {
      return <Assignment key={e.id} assignment={e} />;
    });
    return (
      <div className="course App">
        <Button
          className="course_button"
          onClick={this.createAssignmentHandler}
        >
          Stofna nýtt verkefni
        </Button>
        {assignmentElements}
      </div>
    );
  }
}
