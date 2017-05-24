import React, { Component } from 'react';

import '../../Bootstrap/dist/css/sb-admin-2.css'
import './authentification.css';

class Authentification extends Component {
  render() {
    return (
<<<<<<< HEAD
      <div className="">
              <div className="">
=======
      <div className="container">
              <div className="row">
>>>>>>> master
                  <div className="col-md-4 col-md-offset-4">
                      <div className="login-panel panel panel-default">
                          <div className="panel-heading">
                              <h3 className="panel-title">Authentification</h3>
                          </div>
                          <div className="panel-body">
                              <form role="form">
                                  <fieldset>
                                      <div className="form-group">
<<<<<<< HEAD
                                          <input className="form-control" placeholder="Adresse mail" name="email" type="email" autoFocus></input>
                                      </div>
                                      <div className="form-group">
                                          <input className="form-control" placeholder="Mot de passe" name="password" type="password" value=""></input>
=======
                                          <input className="form-control" placeholder="E-mail" name="email" type="email" autofocus />
                                      </div>
                                      <div className="form-group">
                                          <input className="form-control" placeholder="Mot de passe" name="password" type="password" value="" />
>>>>>>> master
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
