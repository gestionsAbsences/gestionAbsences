import React, { Component } from 'react';

import '../../Bootstrap/dist/css/sb-admin-2.css'
import './authentification.css';
//import { nav, btn } from 'react-bootstrap';

class Authentification extends Component {
  render() {
    return (
      <div className="container">
              <div className="row">
                  <div className="col-md-4 col-md-offset-4">
                      <div className="login-panel panel panel-default">
                          <div className="panel-heading">
                              <h3 className="panel-title">Authentification</h3>
                          </div>
                          <div className="panel-body">
                              <form role="form">
                                  <fieldset>
                                      <div className="form-group">
                                          <input className="form-control" placeholder="E-mail" name="email" type="email" autofocus />
                                      </div>
                                      <div className="form-group">
                                          <input className="form-control" placeholder="Mot de passe" name="password" type="password" value="" />
                                      </div>
                                      <div className="checkbox">
                                          <label>
                                              <input name="remember" type="checkbox" value="Remember Me" />Se souvenir de moi
                                          </label>
                                      </div>
                                      <a href="index.html" className="btn btn-lg btn-success btn-block">Se connecter</a>
                                  </fieldset>
                              </form>
                          </div>
                      </div>
                  </div>
              </div>
          </div>    );
  }
}

export default Authentification;
