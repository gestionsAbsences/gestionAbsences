import React, { Component } from 'react';

// import '../../Bootstrap/dist/css/sb-admin-2.css'
import './modifmotdepasse.css';

class ModifMotDePasse extends Component {
  render() {
    return (
      <div className="">
        <div className="voffset">&nbsp;</div>   {/*5   Cosmétique Ajout d'une marge au dessus du contenu du formulaire réglable via le css voffsethaut */}{/*5   fin */}
        <div className="">
          <div className="col-md-4 col-md-offset-4">
            <div className="login-panel panel panel-default">
              <div className="panel-heading">
                <h3 className="panel-title">Modification de votre mot de passe</h3>
              </div>
              <div className="panel-body">
                <form role="form">
                  <fieldset>
                    <div className="form-group">
                      <input className="form-control" placeholder="Adresse mail" name="email" type="email" />
                    </div>
                    <div className="form-group">
                      <input className="form-control" placeholder="Mot de passe actuel" name="password" type="password" value="" />
                    </div>
                    <div className="form-group">
                      <input className="form-control" placeholder="Nouveau mot de passe" name="newpassword" type="password" value="" />
                    </div>
                    <div className="form-group">
                      <input className="form-control" placeholder="Confirmation du mot de passe" name="confirmpassword" type="password" value="" />
                    </div>
                    <a href="index.html" className="btn btn-primary btn-block">Se connecter</a>
                  </fieldset>
                </form>
              </div>
            </div>
          </div>
        </div>
      </div>
    );
  }
}

export default ModifMotDePasse;
