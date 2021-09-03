import './App.css';
import React from 'react';

class Menuitems extends React.Component {
    render() {
        return (
            <div style={{ cursor: "pointer" }} className="menuSummary" onClick={() => { this.props.bookClicked(this.props.menu) }}>
                <b>{this.props.menu.name}</b>
            </div>
        );
    }
}

export default Menuitems;
