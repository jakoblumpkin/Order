import React from "react";
import { Link } from "react-router-dom";


class Menuitems extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            menuitems: []
        }
    }

    render() {
    return (
      <div className="App">
          <ul style={{listStyle: "none"}}>
          {this.props.Menu.map( (value, index) => {
              return (
                <li>Name: {value.name}        
                    Price: {value.price} 
                  <Link style={{paddingLeft: "20px"}}
                  to={"/details/"+ index}>See Details</Link>
                </li>    
              );
          })}
          </ul>
      </div>
    );
    }
}

export default Menuitems;