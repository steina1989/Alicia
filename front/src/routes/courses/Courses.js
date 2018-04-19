import React, { Component } from 'react';
import { withRouter } from 'react-router-dom';
import Api from '../../Api';
import CourseCard from '../../components/courseCard';
import './Courses.css';

class Courses extends Component {
  constructor(props) {
    super(props);
    this.onClickHandler = this.onClickHandler.bind(this);
  }

  state = {
    courses: [],
    error: false,
    loading: true
  };

  onClickHandler = id => {
    const { history } = this.props;
    history.push(`/course/${id}`);
  };

  componentDidMount = async () => {
    let response;
    try {
      response = await Api.get('courses');
    } catch (error) {
      this.setState({ error: true });
      return;
    }
    switch (response.status) {
      case 200:
        const courses = response.result._embedded.courses;
        this.setState({ courses, loading: false });
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
    const { courses, loading, error } = this.state;

    if (error) {
      return <p>Something went wrong.</p>;
    }
    if (loading) {
      return <p>Loading your courses...</p>;
    }
    const courseCards = courses.map(e => {
      return (
        <CourseCard
          key={e.id}
          id={e.id}
          identifier={e.identifier}
          name={e.name}
          onClickHandler={() => this.onClickHandler(e.id)}
          count={e.count}
        />
      );
    });
    return <div className="Courses">{courseCards}</div>;
  }
}

export default withRouter(Courses);
