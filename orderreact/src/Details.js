import React from "react";


class Details extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            menu: {}
        }
    }
    componentDidMount() {
        let selectedMenu = this.props.menus[this.props.match.params.id];
        console.log(selectedMenu.name);
        this.setState({ menu: selectedMenu });
    }


    render() {
        return(
            <>
            <h1>{this.state.menu.name}</h1>
              <p>Category: {this.state.menu.category}</p>
              <p>Description: {this.state.menu.description}</p>
              <p>Number of Available: {this.state.menu.numAvailable}</p>
            </>
        );
    }
}

export default Details;