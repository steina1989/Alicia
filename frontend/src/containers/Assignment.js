import React, { Component } from 'react';
import { post } from 'axios';
import ReactMarkdown from 'react-markdown';

/**
 * Sýnir heiti á verkefni og skilafrest.
 * Hægt að expanda með props.detailed til að sjá verkefnalýsingu
 * og "senda inn lausn"- takka.
 *
 */

class Assignment extends Component {
    constructor(props) {
        super(props);
        this.state = {
            details: false,
            file: null,
        };
    }

    fileUpload = (file) => {
        console.log(file);
        const url = '/api/answers';
        const formData = new FormData();
        formData.append('sourceCode', file);
        const config = {
            headers: {
                'content-type': 'multipart/form-data',
            },
        };
        return post(url, formData, config);
    };

    onChange = (e) => {
        this.setState({ file: e.target.files[0] });
    };

    onFormSubmit = (e) => {
        e.preventDefault();
        this.fileUpload(this.state.file).then((response) => {
            console.log(response.data);
        });
    };

    onDetails = () => {
        const newState = !this.state.details;
        this.setState({ details: newState });
    }

    render() {
        const { name, questionDescription, returnDate } = this.props.assignment;
        if (!this.state.details) {
            return (
                <div onClick={this.onDetails}>
                    <p>{name}</p>
                    <p>Skil:{returnDate}</p>
                </div>
            );
        }

        return (
            <div>
                <div onClick={this.onDetails}>
                    <p>{name}</p>
                    <p>Skil:{returnDate}</p>
                </div>
                <ReactMarkdown source={questionDescription} />
                <form onSubmit={this.onFormSubmit}>
                    <input type="file" />
                    <button type="submit" onChange={this.onChange}>Upload</button>
                </form>
            </div>

        );
    }


 }


export default Assignment;
