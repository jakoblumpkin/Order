import './App.css';
import {
  BrowserRouter as Router,
  Switch,
  Route
} from "react-router-dom";
import Menuitems from './Menuitems';
import React, { useState } from 'react';
import Details from './Details';

class App extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
        menuitems: []
    }
}

  componentDidMount() {
    fetch('/menu/menuitems')
    .then(res => res.json())
    .then(menu => {
        console.log(menu);
        this.setState({ menuitems: menu});
    })
    .catch((error) => {
        console.log("failed to load menu");
        alert(error);
    })
}
  render() {
  return (
    <div className="App">
      <h1>Menu</h1>
      <Router>
        <Switch>
            <Route exact path="/"><Menuitems Menu={this.state.menuitems}/></Route>
            <Route exact path="/details/:id" component={(props) => <Details menus={this.state.menuitems} {...props}/>} />
        </Switch>
      </Router>
    </div>
  );
  }
}

export default App;
