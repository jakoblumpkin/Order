import './App.css';
import React from 'react';
import Menuitems from './Menuitems';
import BookDetails from './BooksDetails';


class App extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      menuitems: [],
      selectedMenu: null
    }
  }

  componentDidMount() {
    fetch('/menu/menuitems')
      .then(res => res.json())
      .then(menu => {
        console.log(menu);
        this.setState({ menuitems: menu });
      })
      .catch((error) => {
        console.log("failed to load menu");
        alert(error);
      })
  }

  updateDetails = (menu) => {
    this.setState({ selectedMenu: menu });
  }

  render() {
    return (
      <div className="App">
        <h1>Menu</h1>
        <ol>
          {this.state.menuitems.map(
            (value, index) => {
              return (
                <li><Menuitems menu={value} bookClicked={this.updateDetails} index={index} /></li>
              );
            }
          )}
        </ol>
        <div> <BookDetails menu={this.state.selectedMenu} /></div>
      </div>
    );
  }
}

export default App;
