import React from 'react';
import 'whatwg-fetch';

export default class App extends React.Component {

  constructor(props) {
    super(props);
    this.state = { quote : {} };
  }

  getQuote() {
    fetch('quote')
    .then((res) => {
      return res.json();
    })
    .then((json) => {
      this.setState({quote : json})
     });
  }

  componentWillMount() {
    this.getQuote();
  }

  render() {
    return (
      <div className="container" id="content">
        <div className="starter-template">
          <h1>{this.state.quote.author}</h1>
          <p>{this.state.quote.content}</p>
          <button type="button" className="btn btn-primary" onClick={()=>{this.getQuote()}}>Get quote</button>
        </div>
      </div>
    );
  }

}