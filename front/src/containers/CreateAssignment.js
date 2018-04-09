import React, { Component } from 'react';
import SplitterLayout from 'react-splitter-layout';
import ReactMarkdown from 'react-markdown';

class CreateAssignment extends Component {
  constructor(props) {
    super(props);
    this.state = {
      input: ''
    };
  }

  componentDidMount() {
    // const courseId = this.props.match.params.courseId;
  }

  handleInput = event => {
    this.setState({ input: event.target.value });
  };

  render() {
    return (
      <SplitterLayout>
        <div>
          <textarea
            rows={20}
            style={{ width: '100%' }}
            onChange={this.handleInput}
          />
        </div>
        <ReactMarkdown source={this.state.input} />
      </SplitterLayout>
    );
  }
}

export default CreateAssignment;
