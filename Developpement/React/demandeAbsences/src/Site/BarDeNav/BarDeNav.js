import React, { Component } from 'react';

import '../Bootstrap/dist/css/sb-admin-2.css'
import './bardenav.css';

class BarDeNav extends Component {
  render() {
    return (
      <div className="bardenav">
        <div className="voffsetnav">&nbsp;</div>
        <div className="affix col-md-2 panel-group" id="accordion">
          <div className="panel panel-default">
              <div className="panel-heading">
                  <a href="/accueil">
                      <h4 className="panel-title">
                          <span className="glyphicon glyphicon-home"></span>Accueil
                      </h4>
                  </a>
              </div>
          </div>

          <div className="panel panel-default">
              <div className="panel-heading">
                  <a data-toggle="collapse" data-parent="#accordion" href="#collapse1">
                      <h4 className="panel-title">
                          <span className="glyphicon glyphicon-th"></span>Absence
                      </h4>
                  </a>
              </div>
              <div id="collapse1" className="panel-collapse collapse">
                  <div className="panel-body">
                      <table className="table">
                        <tbody>
                          <tr>
                              <td className="tdbar">
                                  <a href="/nouvelledemnade">Nouvelle demande</a>
                              </td>
                          </tr>
                          <tr>
                              <td className="tdbar">
                                  <a href="/declareabsence">Déclaration d'absence</a>   {/*'*/}
                              </td>
                          </tr>
                          <tr>
                              <td className="tdbar">
                                  <a href="/reliquatconges">Reliquat de congés</a>
                              </td>
                          </tr>
                         </tbody>
                      </table>
                  </div>
              </div>
          </div>
          <div className="panel panel-default">
              <div className="panel-heading">
                  <a data-toggle="collapse" data-parent="#accordion" href="#collapse2">
                      <h4 className="panel-title">
                          <span className="glyphicon glyphicon-user">
                          </span>Calendrier
                      </h4>
                  </a>
              </div>
              <div id="collapse2" className="panel-collapse collapse">
                  <div className="panel-body">
                      <table className="table">
                        <tbody>
                          <tr>
                              <td className="tdbar">
                                  <a href="/moncalendrier">Mon calendrier</a>
                              </td>
                          </tr>
                          <tr>
                              <td className="tdbar">
                                  <a href="/calendrierequipe">Calendrier d'équipe</a>   {/*'*/}
                              </td>
                          </tr>
                          <tr>
                              <td className="tdbar">
                                  <a href="/calendrierpersonnel">Calendrier du personnel</a>
                              </td>
                          </tr>
                         </tbody>
                      </table>
                  </div>
              </div>
          </div>
          <div className="panel panel-default">
              <div className="panel-heading">
                  <a data-toggle="collapse" data-parent="#accordion" href="#collapse3">
                      <h4 className="panel-title">
                          <span className="glyphicon glyphicon-file"></span>Gestion
                      </h4>
                  </a>
              </div>

              <div id="collapse3" className="panel-collapse collapse">
                  <div className="panel-body">
                      <table className="table">
                        <tbody>
                          <tr>
                              <td className="tdbar">
                                  <a href="/gestionpersonnel"><span className="glyphicon glyphicon-usd"></span>
                                  Gestion du personnel</a>
                              </td>
                          </tr>
                          <tr>
                              <td className="tdbar">
                                  <a href="/gestionequipe"><span className="glyphicon glyphicon-user"></span>
                                  Gestion d'équipe</a>   {/*'*/}
                              </td>
                          </tr>
                         </tbody>
                      </table>
                  </div>
              </div>
          </div>

          <div className="panel panel-default">
              <div className="panel-heading">
                  <a data-toggle="collapse" data-parent="#accordion" href="#collapse4">
                      <h4 className="panel-title">
                          <span className="glyphicon glyphicon-home"></span>Aide
                      </h4>
                  </a>
              </div>

              <div id="collapse4" className="panel-collapse collapse">
                  <div className="panel-body">
                      <table className="table">
                        <tbody>
                          <tr>
                              <td className="tdbar">
                                  <a href="/aide"><span className="glyphicon glyphicon-usd"></span>
                                  Aide</a>
                              </td>
                          </tr>
                          <tr>
                              <td className="tdbar">
                                  <a href="/apropos"><span className="glyphicon glyphicon-user"></span>
                                  A propos</a>
                              </td>
                          </tr>
                         </tbody>
                      </table>
                  </div>
              </div>
          </div>

          <div className="panel panel-default">
              <div className="panel-heading">
                  <a data-toggle="collapse" data-parent="#accordion" href="#collapse5">
                      <h4 className="panel-title">
                          <span className="glyphicon glyphicon-home"></span>Session
                      </h4>
                  </a>
              </div>

              <div id="collapse5" className="panel-collapse collapse">
                  <div className="panel-body">
                      <table className="table">
                        <tbody>
                          <tr>
                              <td className="tdbar">
                                  <a href="/deconnexion"><span className="glyphicon glyphicon-usd"></span>
                                  Déconnexion</a>
                              </td>
                          </tr>
                          <tr>
                              <td className="tdbar">
                                  <a href="/modifmotdepasse"><span className="glyphicon glyphicon-user"></span>
                                  Modification de votre mot de passe</a>
                              </td>
                          </tr>
                         </tbody>
                      </table>
                  </div>
              </div>
          </div>

        </div>
      </div>
    );
  }
}

export default BarDeNav;
