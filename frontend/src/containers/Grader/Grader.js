import React, { Component } from 'react';
import SplitterLayout from 'react-splitter-layout';

class Grading extends Component {
    constructor(props) {
        super(props);
        this.state = {
            bla: [],
        };
    }

    componentDidMount() {
        console.log(this.props.match.params.id, 'ehóóóóó');
    }

    render() {
        return (
            <SplitterLayout vertical percentage secondaryInitialSize={30}>
                <div>
                    <SplitterLayout percentage primaryIndex={1} secondaryInitialSize={20}>
                        <div>Upper left</div>
                        <div>
                            <SplitterLayout secondaryInitialSize={300}>
                                <div>middle</div>
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
