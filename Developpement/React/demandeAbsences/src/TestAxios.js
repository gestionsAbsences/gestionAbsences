import React, { Component } from 'react';

import axios from 'axios'


class TestAxios extends Component {

  constructor(props) {
      super(props);
      this.state = {
          types: []
      }
  }

  componentDidMount() {
    console.log("Coucou");
       axios.get('http://localhost:8080/type/listeTypeAbsence/')
          .then(res => {
              console.log(res.data);
              this.setState({types: res.data});
      });
  }

  creerService() {
    axios.post('http://localhost:8080/type/creerTypeAbsence/', {"nom": "TestReact"})
      .then(res => {
        console.log("Resultat du POST : " + res);
      });
  }

  render() {
console.log(this.state);
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



        <div className="marge"></div>
      </div>
    );
  }
}

export default TestAxios;
