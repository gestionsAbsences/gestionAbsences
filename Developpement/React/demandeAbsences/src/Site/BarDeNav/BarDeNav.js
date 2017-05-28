import React, { Component } from 'react';

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
                  <span className="glyphicon glyphicon-home"></span> Accueil
                </h4>
              </a>
            </div>
          </div>
          <div className="panel panel-default">
            <div className="panel-heading">
              <a data-toggle="collapse" data-parent="#accordion" href="#collapse1">
                <h4 className="panel-title">
                  <span className="glyphicon glyphicon-user"></span> Absence
                </h4>
              </a>
            </div>
            <div id="collapse1" className="panel-collapse collapse">
              <div className="panel-body">
                <table className="table">
                  <tbody>
                    <tr>
                      <a href="/nouvelledemnade">
                        <td className="btn btn-block tdbar">
                          Nouvelle demande
                        </td>
                      </a>
                    </tr>
                    <tr>
                      <a href="/declareabsence">
                        <td className="btn btn-block tdbar">
                          Déclaration d'absence{/*'*/}
                        </td>
                      </a>
                    </tr>
                    <tr>
                      <a href="/reliquatconges">
                        <td className="btn btn-block tdbar">
                          Reliquat de congés
                        </td>
                      </a>
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
                  <span className="glyphicon glyphicon-calendar"></span> Calendrier
                </h4>
              </a>
            </div>
            <div id="collapse2" className="panel-collapse collapse">
              <div className="panel-body">
                <table className="table">
                  <tbody>
                    <tr>
                      <a href="/moncalendrier">
                        <td className="btn btn-block tdbar">
                          Mon calendrier
                        </td>
                      </a>
                    </tr>
                    <tr>
                      <a href="/calendrierequipe">
                        <td className="btn btn-block tdbar">
                          Calendrier d'équipe{/*'*/}
                        </td>
                      </a>
                    </tr>
                    <tr>
                      <a href="/calendrierentreprise">
                        <td className="btn btn-block tdbar">
                          Calendrier du personnel
                        </td>
                      </a>
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
                  <span className="glyphicon glyphicon-file"></span> Gestion
                </h4>
              </a>
            </div>
            <div id="collapse3" className="panel-collapse collapse">
              <div className="panel-body">
                <table className="table">
                  <tbody>
                    <tr>
                      <a href="/gestionpersonnel">
                        <td className="btn btn-block tdbar">
                          Gestion du personnel
                        </td>
                      </a>
                    </tr>
                    <tr>
                      <a href="/gestionequipe">
                        <td className="btn btn-block tdbar">
                          Gestion d'équipe{/*'*/}
                        </td>
                      </a>
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
                  <span className="glyphicon glyphicon-question-sign"></span> Aide
                </h4>
              </a>
            </div>
            <div id="collapse4" className="panel-collapse collapse">
              <div className="panel-body">
                <table className="table">
                  <tbody>
                    <tr>
                      <a href="/aide">
                        <td className="btn btn-block tdbar">
                          Aide
                        </td>
                      </a>
                    </tr>
                    <tr>
                      <a href="/apropos">
                        <td className="btn btn-block tdbar">
                          A propos
                        </td>
                      </a>
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
                  <span className="glyphicon glyphicon-off"></span> Session
                </h4>
              </a>
            </div>
            <div id="collapse5" className="panel-collapse collapse">
              <div className="panel-body">
                <table className="table">
                  <tbody>
                    <tr>
                      <a href="/deconnexion">
                        <td className="btn btn-block tdbar">
                          Déconnexion
                        </td>
                      </a>
                    </tr>
                    <tr>
                      <a href="/modifmotdepasse">
                        <td className="btn btn-block tdbar">
                          Modifier mot de passe
                        </td>
                      </a>
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
