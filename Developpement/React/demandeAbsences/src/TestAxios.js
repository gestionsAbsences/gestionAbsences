import React, { Component } from 'react';

import axios from 'axios'

class TestAxios extends Component {

// START test du LifeCycle
  getDefaultProps() {
    console.log('get default props');
    console.log(this.state);
  }

  getInitialState() {
    console.log('get initial state');
    console.log(this.state);
  }

  componentWillMount() {
    console.log('will mount');
    console.log(this.state);
  }

  // render() {console.log('render'); console.log(this.state);}
  componentDidMount() {
    console.log('did mount');
    console.log(this.state);
  }

  componentWillReceiveProps() {
    console.log('will receive props');
    console.log(this.state);
  }

  // shouldComponentUpdate() {console.log('should update'); console.log(this.state); return true;}
  componentWillUpdate() {
    console.log('will update');
    console.log(this.state);
  }

  componentDidUpdate() {
    console.log('did update');
    console.log(this.state);
  }

  componentWillUnmount() {
    console.log('will unmount');
    console.log(this.state);
  }
  // END test du LifeCycle

  constructor(props) {
      super(props);
      this.state = {
          types: []
      }
  }



  var config = {
          auth: {
              username: 'bruker',
              password: 'passord'
          }
      };
      axios.get('/emp/getEmploye/', param).then(function (response) {
          console.log(response)
      }.bind(this)).catch(function (response) {
          console.log(response)
      }.bind(this))



  componentDidMount() {
       axios.get('/type/listeTypeAbsence/')
          .then(res => {
              console.log(res.data);
              this.setState({types: res.data});
      });
  }

  creerService() {
    axios.post('/type/creerTypeAbsence/', {"nom": "TestReact"})
      .then(res => {
        console.log("Resultat du POST : " + res);
      });
  }

  render() {
    return (
      <div>
        <a href="#" onClick={this.creerService}>
          click
        </a>
        <ul>
        {
              this.state.types.map(
                (type, i) =>
                <li key={i}>
                  {type.nom}
                </li>
              )
        }
        </ul>
      </div>
    );
  }
}

export default TestAxios;
