import React, { Component } from 'react';
import SplitterLayout from 'react-splitter-layout';

class Grading extends Component {
    constructor(props) {
        super(props);
        this.state = {
            assignment: '',

        };
    }

    componentDidMount() {
        const courseId = this.props.match.params.courseId;
        const assignId = this.props.match.params.assignmentId;
        fetch(`/api/courses/${courseId}/assignments/${assignId}`)
            .then(resp => resp.json())
            .then((res) => {
                this.setState({ assignment: res });
                console.log('here here', res);
            });
    }

    render() {
        return (
            <SplitterLayout vertical percentage secondaryInitialSize={30}>
                <div>
                    <SplitterLayout percentage primaryIndex={1} secondaryInitialSize={20}>
                        <div>Upper left</div>
                        <div>
                            <SplitterLayout secondaryInitialSize={300}>
                                <div>Code</div>
                                <div>Upper right</div>
                            </SplitterLayout>
                        </div>
                    </SplitterLayout>
                </div>
                <div>Command line Pane</div>
            </SplitterLayout>
        );
    }


}

export default Grading;
