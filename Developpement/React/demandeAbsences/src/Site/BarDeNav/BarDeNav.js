    import React, { Component } from 'react';
    import '../Bootstrap/dist/css/sb-admin-2.css'
    import './bardenav.css';

    class BarDeNav extends Component {
      render() {
        return (
          <div className="bardenav">
            <div className="marge"></div>
            <div className="affix col-md-2 panel-group" id="accordion">
              <div className="panel panel-default">
                  <div className="panel-heading">
                      <h4 className="panel-title">
                          <a data-toggle="collapse" data-parent="#accordion" href="#collapseOne">
                          <span className="glyphicon glyphicon-home"></span>Accueil</a>
                      </h4>
                  </div>
              </div>

              <div className="panel panel-default">
                  <div className="panel-heading">
                      <h4 className="panel-title">
                          <a data-toggle="collapse" data-parent="#accordion" href="#collapseTwo">
                          <span className="glyphicon glyphicon-th"></span>Absence</a>
                      </h4>
                  </div>
                  <div id="collapseTwo" className="panel-collapse collapse">
                      <div className="panel-body">
                          <table className="table">
                            <tbody>
                              <tr>
                                  <td>
                                      <a href="#">Nouvelle demande</a>
                                  </td>
                              </tr>
                              <tr>
                                  <td>
                                      <a href="#">Déclaration d'absence</a>
                                  </td>
                              </tr>
                              <tr>
                                  <td>
                                      <a href="#">Reliquat de congés</a>
                                  </td>
                              </tr>
                             </tbody>
                          </table>
                      </div>
                  </div>
              </div>
              <div className="panel panel-default">
                  <div className="panel-heading">
                      <h4 className="panel-title">
                          <a data-toggle="collapse" data-parent="#accordion" href="#collapseThree">
                          <span className="glyphicon glyphicon-user">
                          </span>Calendrier</a>
                      </h4>
                  </div>
                  <div id="collapseThree" className="panel-collapse collapse">
                      <div className="panel-body">
                          <table className="table">
                            <tbody>
                              <tr>
                                  <td>
                                      <a href="#">Mon calendrier</a>
                                  </td>
                              </tr>
                              <tr>
                                  <td>
                                      <a href="#">Calendrier d'équipe</a>
                                  </td>
                              </tr>
                              <tr>
                                  <td>
                                      <a href="#">Calendrier du personnel</a>
                                  </td>
                              </tr>
                             </tbody>
                          </table>
                      </div>
                  </div>
              </div>
              <div className="panel panel-default">
                  <div className="panel-heading">
                      <h4 className="panel-title">
                          <a data-toggle="collapse" data-parent="#accordion" href="#collapseFour">
                          <span className="glyphicon glyphicon-file"></span>Gestion</a>
                      </h4>
                  </div>
                  <div id="collapseFour" className="panel-collapse collapse">
                      <div className="panel-body">
                          <table className="table">
                            <tbody>
                              <tr>
                                  <td>
                                      <span className="glyphicon glyphicon-usd"></span>
                                      <a href="#">Gestion du personnel</a>
                                  </td>
                              </tr>
                              <tr>
                                  <td>
                                      <span className="glyphicon glyphicon-user"></span>
                                      <a href="#">Gestion d'équipe</a>
                                  </td>
                              </tr>
                             </tbody>
                          </table>
                      </div>
                  </div>
              </div>
              <div className="panel panel-default">
                  <div className="panel-heading">
                      <h4 className="panel-title">
                          <a data-toggle="collapse" data-parent="#accordion" href="#collapseOne">
                          <span className="glyphicon glyphicon-home"></span>Aide</a>
                      </h4>
                  </div>
              </div>
              <div className="panel panel-default">
                  <div className="panel-heading">
                      <h4 className="panel-title">
                          <a data-toggle="collapse" data-parent="#accordion" href="#collapseOne">
                          <span className="glyphicon glyphicon-home"></span>Déconnexion</a>
                      </h4>
                  </div>
              </div>
            </div>
          </div>
        );
      }
    }

    export default BarDeNav;
