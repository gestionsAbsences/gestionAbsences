import React, { Component } from 'react';

import '../../Bootstrap/dist/css/sb-admin-2.css'
import './modifmotdepasse.css';
//import { nav, btn } from 'react-bootstrap';

// import logohelp from '../../Medias/Aide.jpg';

class ModifMotDePasse extends Component {
  render() {
    return (
      <div className="">
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
                                          <input className="form-control" placeholder="Adresse mail" name="email" type="email" autofocus />
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
          </div>    );
  }
}

export default ModifMotDePasse;
