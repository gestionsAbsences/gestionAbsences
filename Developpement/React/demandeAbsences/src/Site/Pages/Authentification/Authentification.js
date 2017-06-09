import React, { Component } from 'react';

// import '../../Bootstrap/dist/css/sb-admin-2.css'
import './authentification.css';

class Authentification extends Component {
  render() {
    return (
      <div className="col-md-4 col-md-offset-4">
        <div className="voffset">&nbsp;</div>   {/*5   Cosmétique Ajout d'une marge au dessus du contenu du formulaire réglable via le css voffsethaut */}{/*5   fin */}
        <div className="login-panel panel panel-default">
          <div className="panel-heading">
            <h3 className="panel-title">Authentification</h3>
          </div>
          <div className="panel-body">
            <form role="form">
              <fieldset>
                <div className="form-group">
                  <input className="form-control" placeholder="Adresse mail" name="email" type="email" autoFocus></input>
                </div>
                <div className="form-group">
                  <input className="form-control" placeholder="Mot de passe" name="password" type="password" value=""></input>
                </div>
                <a href="index.html" className="btn btn-primary btn-block">Se connecter</a>
              </fieldset>
            </form>
          </div>
        </div>
      </div>
    );
  }
}

export default Authentification;
