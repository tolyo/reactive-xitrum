import React from 'react';
import 'whatwg-fetch';

export default class App extends React.Component {

  constructor(props) {
    super(props);
    this.state = { quote : {}, author: '', newQuote: '' };
  }

  handleSubmit(e) {
    e.preventDefault();
    fetch('quote', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(this.state)
    });
  }

  getQuote() {
    fetch('quote')
    .then((res) => {
      return res.json();
    })
    .then((json) => {
      this.setState({quote : json});
    });
  }

  componentWillMount() {
    this.getQuote();
  }

  render() {
    return (
      <div className='container' id='content'>
        <div className='starter-template'>
          <h1>{this.state.quote.author}</h1>
          <p>{this.state.quote.content}</p>
          <button type='button'
                  className='btn btn-primary'
                  onClick={
                    () => { this.getQuote(); }
                  }>
            Get quote
          </button>
        </div>

        <hr />

        <form onSubmit={ (e) => this.handleSubmit(e)} className='col-xs-12 col-md-6 col-lg-4'>

          <div className='form-group'>
            <label htmlFor='quote'>Author: </label>
            <input className='form-control'
                   type='text'
                   id='author'
                   value={this.state.author}
                   onChange={ (e) => this.setState({author: e.target.value}) } />
          </div>

          <div className='form-group'>
            <label htmlFor='quote'>New quote: </label>
            <input className='form-control'
                   type='text'
                   id='quote'
                   value={this.state.newQuote}
                   onChange={ (e) => this.setState({newQuote: e.target.value}) } />
          </div>
          <button type='submit'
                  className='btn btn-primary'>
            Submit
          </button>
        </form>

      </div>
    );
  }

}
