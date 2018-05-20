import React, { Component } from 'react';
import ReactMarkdown from 'react-markdown';
import { Link } from 'react-router-dom';
import Api from '../../Api';
import './Assignment.css';

export default class Assignment extends Component {
  constructor(props) {
    super(props);
    this.onFormSubmit = this.onFormSubmit.bind(this);
    this.onChange = this.onChange.bind(this);
  }
  state = {
    files: []
  };

  onChange = e => {
    this.setState({ files: e.target.files });
  };

  onFormSubmit = e => {
    e.preventDefault();
    const { files } = this.state;
    const { id } = this.props.assignment;
    for (let file of files) {
      Api.addAssignment(id, file);
    }
  };

  render() {
    const { assignment } = this.props;
    return (
      <div className="assignment">
        <h2>{assignment.name}</h2>
        <div className="questionDiv">
          <ReactMarkdown source={assignment.questionDescription} />
        </div>
        <form onSubmit={this.onFormSubmit}>
          <input type="file" onChange={this.onChange} multiple />
          <button type="submit">Senda inn lausn</button>
        </form>
        <Link to={`/grade/${assignment.id}`}>Fara yfir {assignment.title}</Link>
        <hr />
      </div>
    );
  }
}
