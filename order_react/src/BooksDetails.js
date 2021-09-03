import React from 'react';

class BooksDetails extends React.Component {

    render() {
        return (
            (this.props.menu) ? (
                <div>
                    <label>Name</label>: {this.props.menu.name}<br />
                </div>)
                : (
                    <div>No Book Selected</div>
                )
        )
    }
}

export default BooksDetails;