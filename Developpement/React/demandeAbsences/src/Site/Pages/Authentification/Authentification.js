import React, { Component } from 'react';

// import axios from 'axios';

import './authentification.css';

// let userEmail="steven.merrill@entreprise.com";

class Authentification extends Component {

  constructor(props){
      super(props); // Récupère le Props du parent
      this.props=props;
      this.state={ // Définition des propriétés du State
        userEmail: '',
        pass: '',
        email: '',
        password: '',
        nom: '',
        prenom: '',
        matricule: '',
        role: ''
      };
      this.handleEmailChange = this.handleEmailChange.bind(this);
      this.handlePassChange = this.handlePassChange.bind(this);
      this.handleSubmit = this.handleSubmit.bind(this);
  }

  handleEmailChange = (event) => {
    this.setState({userEmail: event.target.value,});
  }

  handlePassChange = (event) => {
    this.setState({pass: event.target.value,});
  }

  handleSubmit(event) {
      event.preventDefault();

      //  axios
      //   .get('/user/getUser?email='+this.state.userEmail) // Type GET paramétré avec l'email.
      //   .then(res => {
      //       this.setState({ // Incorpore les données dans le State
      //         nom: res.data[0].employeDto.nom,
      //         prenom: res.data[0].employeDto.prenom,
      //         matricule: res.data[0].employeDto.matricule,
      //         email: res.data[0].employeDto.email,
      //         password: res.data[0].employeDto.password,
      //         role: res.data[0].employeDto.role
      //     });
      //     // if (this.state.userEmail===this.state.email && this.state.pass===this.state.password) {
      //     if (this.state.userEmail===this.state.email) {
      //       this.props.transferUserEmail(this.state.email);
      //       console.log("UserMail : "+this.state.email);
      //     }
      //   })
      //   .catch((error) => {
      //       console.log("Axios : Problème d'accès à la ressource /user/getUser?email=" + this.state.userEmail + ".");
      //       console.log(this.state);
      // });

      this.setState({
        email: this.state.userEmail,
        pass: this.state.pass
      });
    }

  componentDidMount () {
    console.log("DidMount : ");
    console.log(this.state.userEmail);
  }

  render() {
    return (
      <div className="col-md-4 col-md-offset-4">
      <div className="voffsetauth">&nbsp;</div> {/* Sert à créer un décalage vers le bas voir le CSS */}
        <div className="login-panel panel panel-default">
          <div className="panel-heading">
            <h3 className="panel-title">Authentification</h3>
          </div>
          <div className="panel-body">
            <form role="form" action="" onSubmit={this.handleSubmit}>
              <fieldset>
                <div className="form-group">
                  <input className="form-control" placeholder="Adresse mail" name="email" type="email" value={this.state.userEmail} autoFocus onChange={this.handleEmailChange}></input>
                </div>
                <div className="form-group">
                  <input className="form-control" placeholder="Mot de passe" name="password" type="password" value={this.state.pass} onChange={this.handlePassChange}></input>
                </div>
                <input className="btn btn-primary btn-block" type="submit" value="Se connecter" />
              </fieldset>
            </form>
          </div>
        </div>
        <div className="VOffSetBasPages">&nbsp;</div>   {/*13   Cosmétique Ajout d'une marge en dessous des boutons réglable via le css VOffSetBasPages */}   {/*13   fin */}
      </div>
    );
  }
}

export default Authentification;
