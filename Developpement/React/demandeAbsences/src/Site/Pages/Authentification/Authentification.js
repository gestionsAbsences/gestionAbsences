import React, { Component } from 'react';

import axios from 'axios';

import './authentification.css';

class Authentification extends Component {

  constructor(props){
      super(props); // Récupère le Props du parent
      this.props=props;
      this.state={ // Définition des propriétés du State
        isHidden: true,
        emailSaisi: '',
        passwordSaisi: '',
        emailAuthentifie: '',
        passwordAuthentifie: ''
      };
  }

  handleEmailChange = (event) => {
    this.setState({
      emailSaisi: event.target.value,
      isHidden: true
    });
  }

  handlePassChange = (event) => {
    this.setState({
      passwordSaisi: event.target.value,
      isHidden: true
    });
  }

  handleSubmit(event) {
      event.preventDefault();
      this.setState({
        emailAuthentifie: this.state.emailSaisi,
        passwordAuthentifie: this.state.passwordSaisi
      });
    }

  componentDidMount () {
    console.log("DidMount : ");
    console.log(this.state.emailSaisi);
  }

  login = (event) => {
      event.preventDefault();
      const self = this;
      let email = this.state.emailSaisi;
      let password = this.state.passwordSaisi;

      //Requête HTTP destinée au Back
      axios.post(`/login?email=${email}&password=${password}`)
          .then(function (response) {
              axios.get("user/authUser")
                  .then(function (response) {
                      if (response.data != null) {
                          self.props.getUser(response.data);
                      }
                      self.props.retourAccueil();
                  })
                  .catch(function (erreur) {
                      self.setState({
                          isHidden: false // Visibilité du Pop
                      })
                  })
          })
          .catch(function (erreur) {
              self.setState({
                  isHidden: false // Visibilité du Pop
              })
          })
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
                  <input className="form-control" placeholder="Adresse mail" name="email" type="email" value={this.state.emailSaisi} autoFocus onChange={this.handleEmailChange}></input>
                </div>
                <div className="form-group">
                  <input className="form-control" placeholder="Mot de passe" name="password" type="password" value={this.state.passwordSaisi} onChange={this.handlePassChange}></input>
                </div>
                <input className="btn btn-primary btn-block" type="submit" value="Se connecter" onClick={this.login} />
              </fieldset>
            </form>
          </div>
        </div>
        <div className="VOffSetBasPages">&nbsp;</div>{/*13   Cosmétique Ajout d'une marge en dessous des boutons réglable via le css VOffSetBasPages */}   {/*13   fin */}
        <div className="authPopup panel panel-default" hidden={this.state.isHidden}>
                <p><b>Problème de connexion : </b>Informations de connexion erronées.
                <br />Veuillez vérifier l'exactitude de vos informations de session.</p>{/*'*/}
        </div>
      </div>
    );
  }
}

export default Authentification;
